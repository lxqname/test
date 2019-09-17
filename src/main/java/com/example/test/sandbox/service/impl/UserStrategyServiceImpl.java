package com.example.test.sandbox.service.impl;

import com.example.test.sandbox.dao.IUserStrategyDao;
import com.example.test.sandbox.entity.UserStrategy;
import com.example.test.sandbox.mapper.UserStrategyMapper;
import com.example.test.sandbox.service.IUserStrategyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@Service
public class UserStrategyServiceImpl extends ServiceImpl<UserStrategyMapper, UserStrategy> implements IUserStrategyService {

    @Autowired
    private IUserStrategyDao userStrategyDao;

    @Override
    public List<UserStrategy> selectByUserId(Integer userId) {
        //根据用户id查询其所有的策略
       return userStrategyDao.selectByUserId(userId);
    }

}
