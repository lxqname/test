package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IUserStrategyDao;
import com.example.test.sandbox.domian.UserStrategyDo;
import com.example.test.sandbox.entity.UserStrategy;
import com.example.test.sandbox.mapper.UserStrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class UserStrategyDao implements IUserStrategyDao {

    @Autowired
    private UserStrategyMapper userStrategyMapper;

    @Override
    public List<UserStrategy> selectByUserId(Integer userId) {
        //根据用户id查询用户策略表集合
        List<UserStrategyDo> userStrategyDos = userStrategyMapper.selectByUserId(userId);
        ArrayList<UserStrategy> userStrategies = new ArrayList<>();
        BeanUtils.copyProperties(userStrategyDos,userStrategies);
        return userStrategies;
    }

    @Override
    public List<UserStrategy> configureStrategy(int strategyId, int userId) {
        //配置用户和策略（在用户策略表中插入数据）
        userStrategyMapper.configureStrategy(strategyId, userId);
        //根据用户id查询用户策略表集合
        List<UserStrategyDo> userStrategyDos = userStrategyMapper.selectByUserId(userId);
        ArrayList<UserStrategy> userStrategies = new ArrayList<>();
        BeanUtils.copyProperties(userStrategyDos,userStrategies);
        return userStrategies;
    }
}
