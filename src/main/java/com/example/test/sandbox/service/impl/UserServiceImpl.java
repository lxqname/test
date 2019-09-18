package com.example.test.sandbox.service.impl;

import com.example.test.sandbox.dao.IUserDao;
import com.example.test.sandbox.domian.UserDo;
import com.example.test.sandbox.entity.User;
import com.example.test.sandbox.mapper.UserMapper;
import com.example.test.sandbox.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements IUserService {

    @Autowired
    private IUserDao userDao;

    @Override
    public User toCheckLogin(User user) {
        //登入验证
        return userDao.toCheckLogin(user);
    }

    @Override
    public User selectByUserName(User user) {
        //根据用户名查询用户
        return userDao.selectByUserName(user);
    }

    @Override
    public User addUser(User user) {
        //添加用户
        return userDao.addUser(user);
    }

    @Override
    public User toCheckUserName(User user) {
        //判断用户名是否存在
        return userDao.toCheckUserName(user);
    }

    @Override
    public User toCheckPhone(User user) {
        //判断电话号码是否存在
        return userDao.toCheckPhone(user);
    }

    @Override
    public User toCheckUserNumber(User user) {
        //判断员工编号是否存在
        return userDao.toCheckUserNumber(user);
    }

    @Override
    public User updateLoginCount(String username) {
        //更新登入次数
       return userDao.updateLoginCount(username);
    }

    @Override
    public boolean configureStrategy(int strategyId, int userId) {
        return userDao.configureStrategy(strategyId, userId);
    }

    @Override
    public User updateAll(User user) {
        //编辑用户
       return userDao.updateAll(user);
    }

    @Override
    public Integer falseDelete(String checkedId) {
        return userDao.falseDelete(checkedId.split(","));
    }
}
