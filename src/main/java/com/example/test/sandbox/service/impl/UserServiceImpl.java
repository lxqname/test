package com.example.test.sandbox.service.impl;

import com.example.test.sandbox.dao.IUserDao;
import com.example.test.sandbox.entity.User;
import com.example.test.sandbox.mapper.UserMapper;
import com.example.test.sandbox.service.IUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.sandbox.vo.UserVo;
import org.springframework.beans.BeanUtils;
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
    public User toCheckLogin(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        //登入验证
        return userDao.toCheckLogin(user);
    }

    @Override
    public User selectByUserName(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
        //根据用户名查询用户
        return userDao.selectByUserName(user);
    }

    @Override
    public User addUser(UserVo userVo) {
        User user = new User();
        BeanUtils.copyProperties(userVo,user);
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
}
