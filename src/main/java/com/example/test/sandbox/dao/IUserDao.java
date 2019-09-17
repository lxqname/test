package com.example.test.sandbox.dao;

import com.example.test.sandbox.entity.User;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserDao {
    /**
     * 登入核对功能
     *
     * @param user
     * @return
     */
    User toCheckLogin(User user);

    /**
     * 查看用户信息
     *
     * @param user
     * @return
     */
    User selectByUserName(User user);

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    User addUser(User user);

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
