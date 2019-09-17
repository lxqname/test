package com.example.test.sandbox.controller;


import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.User;
import com.example.test.sandbox.service.IUserPasswordService;
import com.example.test.sandbox.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/sandbox/user-password")
public class UserPasswordController {
    @Autowired
    private IUserPasswordService userPasswordService;
    @Autowired
    private IUserService userService;

    /**
     * 修改密码
     *
     * @param oldPassword
     * @param password
     * @param session
     * @return
     */
    @PostMapping("/updatePassword")
    public String updatePassword(String oldPassword, String password, int n,HttpSession session) {
        User user = (User) session.getAttribute("user");
        if (!user.getPassword().equals(oldPassword)) {
            return "旧密码不正确";
        }
        boolean flag = userPasswordService.listUserPassword(password, user.getId(), n);
        if (flag) {
            return "密码不能和前n次相同";
        }
        userService.updateLoginCount(user.getUsername());
        return "修改密码成功";
    }

    /**
     * 根据用户id返回其限制密码的规则
     * @param userId
     * @return
     */
    @PostMapping("/getRuleByUserId")
    public List<Rule> getRuleByUserId(Integer userId){
        return userPasswordService.selectByUserId(userId);
    }


}
