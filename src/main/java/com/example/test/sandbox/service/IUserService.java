package com.example.test.sandbox.service;

import com.example.test.sandbox.entity.User;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.sandbox.vo.UserVo;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface IUserService extends IService<User> {
    /**
     * 登入核对功能
     *
     * @param userVo
     * @return
     */
    User toCheckLogin(UserVo userVo);

    /**
     * 查看用户信息
     *
     * @param userVo
     * @return
     */
    User selectByUserName(UserVo userVo);

    /**
     * 注册用户
     *
     * @param userVo
     * @return
     */
    User addUser(UserVo userVo);

    /**
     * 判断用户名是否可用
     *
     * @param user
     * @return
     */
    User toCheckUserName(User user);

    /**
     * 判断电话号码是否可用
     *
     * @param user
     * @return
     */
    User toCheckPhone(User user);

    /**
     * 判断员工编号是否可用
     *
     * @param user
     * @return
     */
    User toCheckUserNumber(User user);

    /**
     * 记录登入次数
     *
     * @return
     */
    User updateLoginCount(String username);

}
