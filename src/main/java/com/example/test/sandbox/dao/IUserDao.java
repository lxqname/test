package com.example.test.sandbox.dao;

import com.example.test.sandbox.domian.UserDo;
import com.example.test.sandbox.entity.User;
import org.apache.ibatis.annotations.Param;
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
     * @param username
     * @return
     */
    User updateLoginCount(String username);

    /**
     * 配置密码策略
     *
     * @param strategyId
     * @param userId
     * @return
     */
    boolean configureStrategy(int strategyId, int userId);

    /**
     * 修改账号信息
     * @param user
     * @return
     */
    User updateAll(User user);


    /**
     *  批量删除
     * @param checkedId
     * @return
     */
    int falseDelete(String[] checkedId);


}
