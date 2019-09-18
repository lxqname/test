package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IUserPasswordDao;
import com.example.test.sandbox.domian.UserPasswordDo;
import com.example.test.sandbox.entity.UserPassword;
import com.example.test.sandbox.mapper.UserPasswordMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86151
 */
public class UserPasswordDao implements IUserPasswordDao {

    @Autowired
    private UserPasswordMapper userPasswordMapper;

    @Override
    public List<UserPassword> listUserPassword(int userId) {
        //根据用户id查询其密码集合
        List<UserPasswordDo> userPasswordDos = userPasswordMapper.listUserPassword(userId);
        ArrayList<UserPassword> userPasswords = new ArrayList<>();
        BeanUtils.copyProperties(userPasswordDos,userPasswords);
        return userPasswords;
    }
}
