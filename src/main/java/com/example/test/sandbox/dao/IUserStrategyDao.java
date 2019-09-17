package com.example.test.sandbox.dao;

import com.example.test.sandbox.entity.UserStrategy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IUserStrategyDao {
    /**
     * 根据userId查询所对应的UserStrategy
     * @param userId
     * @return
     */
    List<UserStrategy> selectByUserId(Integer userId);
    /**
     * 配置密码策略
     *
     * @param strategyId
     * @param userId
     * @return
     */
    List<UserStrategy> configureStrategy( int strategyId, int userId);
}
