package com.example.test.sandbox.dao;


import com.example.test.sandbox.entity.StrategyRule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IStrategyRuleDao  {
    /**
     * 根据策略id查询其所有的策略规则对象集合
     * @param strategyId
     * @return
     */
    List<StrategyRule> selectByStrategyId(Integer strategyId);

    /**
     * 新建策略与规则中间表
     * @param strategyId
     * @param ruleId
     * @return
     */
    List<StrategyRule> addStrategyRule(Integer strategyId,Integer ruleId);
}
