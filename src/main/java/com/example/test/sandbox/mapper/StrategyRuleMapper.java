package com.example.test.sandbox.mapper;

import com.example.test.sandbox.domian.RuleDo;
import com.example.test.sandbox.domian.StrategyRuleDo;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.StrategyRule;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface StrategyRuleMapper extends BaseMapper<StrategyRule> {
    /**
     * 根据策略id查询其所有的策略规则对象集合
     * @param strategyId
     * @return
     */
    List<StrategyRuleDo> selectByStrategyId(Integer strategyId);

    /**
     * 新增策略，在策略和规则中间表中插入数据
     * @param strategyId
     * @param ruleId
     * @return
     */
    Integer addStrategyRule(Integer strategyId,Integer ruleId);

}
