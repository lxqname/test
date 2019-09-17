package com.example.test.sandbox.service;

import com.example.test.sandbox.entity.UserStrategy;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface IUserStrategyService extends IService<UserStrategy> {
    /**
     * 根据userId查询所对应的策略Id
     * @param userId
     * @return
     */
    List<UserStrategy> selectByUserId(Integer userId);
}
