package com.example.test.sandbox.dao;

import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.Strategy;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStrategyDao {

    /**
     * 通过策略strategyId查询策略
     * @param strategyId
     * @return
     */
    Strategy getByStrategyId(String strategyId);


    /**
     * 新增密码策略
     *
     * @param strategy
     * @return
     */
    Strategy insertStrategy(Strategy strategy);


    /**
     * 通过策略名查询
     *
     * @param strategyName
     * @return
     */

    Strategy getByName(String strategyName);


    /**
     * 分页
     *
     * @return
     */

    List<Strategy> listStrategy();


    /**
     * 条件查询并分页
     *
     * @param strategy
     * @return
     */

    List<Strategy> listByCondition(Strategy strategy);
}
