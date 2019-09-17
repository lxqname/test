package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IUserDao;
import com.example.test.sandbox.domian.UserDo;
import com.example.test.sandbox.entity.User;
import com.example.test.sandbox.mapper.UserMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDao implements IUserDao {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User toCheckLogin(User user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        //登入验证
        UserDo userDo1= userMapper.selectAll(userDo);
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }

    @Override
    public User selectByUserName(User user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        //根据用户名查询用户信息
        UserDo userDo1= userMapper.selectAll(userDo);
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }

    @Override
    public User addUser(User user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        //添加用户
        Integer integer = userMapper.addUser(userDo);
        //查询用户
        UserDo userDo1 = userMapper.selectAll(userDo);
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }

    @Override
    public User toCheckUserName(User user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        //用户名验证
        UserDo userDo1= userMapper.selectAll(userDo);
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }

    @Override
    public User toCheckPhone(User user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        //电话号码验证
        UserDo userDo1= userMapper.selectAll(userDo);
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }

    @Override
    public User toCheckUserNumber(User user) {
        UserDo userDo = new UserDo();
        BeanUtils.copyProperties(user,userDo);
        //员工编号验证
        UserDo userDo1= userMapper.selectAll(userDo);
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }

    @Override
    public User updateLoginCount(String username) {
        UserDo userDo = new UserDo();
        userDo.setUsername(username);
        //更新登入次数
        Integer integer = userMapper.updateLoginCount(userDo);
        //查询用户
        UserDo userDo1 = userMapper.selectAll(userDo);
        User user = new User();
        BeanUtils.copyProperties(userDo1,user);
        return user;
    }
}
