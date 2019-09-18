package com.example.test.sandbox.controller;


import com.example.test.sandbox.entity.User;
import com.example.test.sandbox.service.IUserService;
import com.example.test.sandbox.util.PasswordStrength;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Pattern;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@RestController
@RequestMapping("user")
public class UserController {

    Pattern pattern = Pattern.compile("[0-9]*");

    @Autowired
    private IUserService userService;

    @Autowired
    PasswordStrength passwordStrength;

    /**
     * 登入验证
     *
     * @param user
     * @param session
     * @return
     */
    @PostMapping("/toCheckLogin")
    public String toCheckLogin(@RequestBody User user, HttpSession session) {
        User user1 = userService.toCheckLogin(user);
        if (null!=user) {
            session.setAttribute("user1", user1);
            Integer loginCount = userService.selectByUserName(user1).getLoginCount();
            if (loginCount == 0) {
                return "updatePassword";
            }
            return "登入成功";
        }
        return "登入失败";
    }

    /**
     * 查看用户信息
     *
     * @param session
     * @return
     */
    @PostMapping("/selectUser")
    public User selectUser(HttpSession session) {
        User user = (User) session.getAttribute("user1");
        return userService.selectByUserName(user);
    }


    /**
     * 新增用户
     *
     * @param user
     * @return
     */
    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String register(@RequestBody User user) {
        User user1 = userService.addUser(user);
        if (null!=user1) {
            return "login";
        }
        return "register";
    }

    /**
     * 用户名是否可用
     *
     * @param userName
     * @return
     */
    @PostMapping("/toCheckUserName")
    public String toCheckUserName(String userName) {
        if (userName.length() <= 5 || userName.length() >= 15) {
            return "用户名长度为5-15个字符";
        }
        boolean matches = pattern.matcher(userName).matches();
        if (matches) {
            return "用户名不能为纯数字";
        }
        User user = new User();
        user.setUsername(userName);
        User user1 = userService.toCheckUserName(user);
        if (null!=user1) {
            return "用户名已存在";
        }
        return "用户名可用";
    }

    /**
     * 常规密码规则验证
     *
     * @param password
     * @return
     */
    @PostMapping("/toCheckPassword")
    public String toCheckPassword(String password) {
        if (password.length() < 6) {
            return "密码必须大于6个字符";
        }
        boolean[] flag = {false, false};
        for (int i = 0; i < password.length(); i++) {
            if (Character.isLowerCase(password.charAt(i))) {
                flag[0] = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                flag[1] = true;
            }
        }
        if (!(flag[0] && flag[1])) {
            return "密码必须含有大小写字母";
        }
        return "密码可用";
    }

    /**
     * 加强版密码规则验证
     *
     * @param password
     * @return
     */
    @PostMapping("/toCheckPasswordPlus")
    public String toCheckPasswordPlus(String password) {
        if (password.length() < 6) {
            return "密码必须大于等于6个字符";
        }
        //定义密码长度分数passwordLengthScore
        int passwordLengthScore;
        if (password.length() >= 6 || password.length() <= 7) {
            passwordLengthScore = 10;
        } else {
            passwordLengthScore = 25;
        }
        //定义密码字母分数passwordLetterScore
        int passwordLetterScore;
        boolean[] flag = {false, false};
        for (int i = 0; i < password.length(); i++) {
            if (Character.isUpperCase(password.charAt(i))) {
                flag[0] = true;
            }
            if (Character.isUpperCase(password.charAt(i))) {
                flag[1] = true;
            }
        }
        if (flag[0] && flag[1]) {
            passwordLetterScore = 25;
        } else if (flag[0] || flag[1]) {
            passwordLetterScore = 10;
        } else {
            return "密码必须含有字母";
        }

        //定义密码数字分数passwordNumberScore
        int passwordNumberScore;
        //定义数字个数
        int number = 0;
        for (int i = 0; i < password.length(); i++) {
            if (Character.isDigit(password.charAt(i))) {
                number++;
            }
        }
        if (number == 0) {
            passwordNumberScore = 0;
        } else if (number == 1 || number == 2) {
            passwordNumberScore = 10;
        } else {
            passwordNumberScore = 20;
        }
        //定义符号分数passwordSymbolScore
        int passwordSymbolScore;
        if (password.replaceAll("[A-Za-z0-9]", "").length() == 0) {
            passwordSymbolScore = 0;
        } else if (password.replaceAll("[A-Za-z0-9]", "").length() == 1) {
            passwordSymbolScore = 10;
        } else {
            passwordSymbolScore = 20;
        }

        //定义奖励分数
        int passwordRewordScore = 0;
        if (passwordLetterScore != 0 && number != 0) {
            passwordRewordScore = 2;
            if (passwordSymbolScore != 0) {
                passwordRewordScore = 5;
                if (passwordLetterScore == 25) {
                    passwordRewordScore = 10;
                }
            }
        }
        //定义密码所得总分x
        int x = passwordLengthScore + passwordLetterScore + passwordNumberScore + passwordSymbolScore + passwordRewordScore;
        return this.passwordStrength.getPasswordStrength(x);
    }


    /**
     * 判断手机号是否可用
     *
     * @param phone
     * @return
     */
    @PostMapping("/toCheckPhone")
    public String toCheckPhone(String phone) {
        if (phone.length() != 11 || !pattern.matcher(phone).matches()) {
            return "手机号必须是11位数字";
        }
        if (phone.charAt(0) != 1) {
            return "手机号必须1开头";
        }
        User user = new User();
        user.setPhone(phone);
        User user1 = userService.toCheckPhone(user);
        if (null!=user1) {
            return "手机号可用";
        }
        return "手机号已进行过注册";
    }


    /**
     * 判断员工编号可用
     *
     * @param userNumber
     * @return
     */
    @PostMapping("/toCheckUserNumber")
    public String toCheckUserNumber(String userNumber) {
        if (userNumber.length() < 3 || userNumber.length() > 10) {
            return "员工编号必须是3-10个字符";
        }
        String a = "[A-Za-z0-9]";
        if (userNumber.replaceAll(a, "").length() != 0) {
            return "员工编号不能有字母和数字之外的字符";
        }
        User user = new User();
        user.setUserNumber(userNumber);
        User user1 = userService.toCheckUserNumber(user);
        if (null!=user1) {
            return "员工编号可用";
        }
        return "员工编号以存在";
    }

    /**
     * 为用户配置策略
     * @param strategyId
     * @param userId
     * @return
     */
    @PostMapping("/configureStrategy")
    public String configureStrategy( int strategyId, int userId){
        boolean flag = userService.configureStrategy(strategyId, userId);
        if (flag){
            return "该用户配置密码策略成功";
        }
        return "该用户配置密码策略失败";
    }

    /**
     * 编辑用户信息
     * @param user
     * @return
     */
    @PostMapping("/updateAll")
    public User updateAll(User user){
       return userService.updateAll(user);
    }

    /**
     * 逻辑删除所选中人员的id
     */
    @RequestMapping("doFalseDelete")
    @ResponseBody
    public Map<String, Object> doFalseDelete(String checkedId){
        Map<String, Object> map=new HashMap<String, Object>();
        userService.falseDelete(checkedId);
        map.put("message", "删除成功");
        return map;
    }

}
