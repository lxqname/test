package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IStrategyRuleDao;
import com.example.test.sandbox.domian.StrategyRuleDo;
import com.example.test.sandbox.entity.StrategyRule;
import com.example.test.sandbox.mapper.StrategyRuleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class StrategyRuleDao implements IStrategyRuleDao {

    @Autowired
    private StrategyRuleMapper strategyRuleMapper;

    @Override
    public List<StrategyRule> selectByStrategyId(Integer strategyId) {
        //根据策略id查询StrategyRuleDo集合
        List<StrategyRuleDo> strategyRuleDos = strategyRuleMapper.selectByStrategyId(strategyId);
        ArrayList<StrategyRule> strategyRules = new ArrayList<>();
        BeanUtils.copyProperties(strategyRuleDos,strategyRules);
        return strategyRules;
    }

    @Override
    public List<StrategyRule> addStrategyRule(Integer strategyId, Integer ruleId) {
        //添加策略，配置其规则
        Integer integer = strategyRuleMapper.addStrategyRule(strategyId, ruleId);
        //根据策略id查询StrategyRuleDo集合
        List<StrategyRuleDo> strategyRuleDos = strategyRuleMapper.selectByStrategyId(strategyId);
        List<StrategyRule> strategyRules = new ArrayList<>();
        BeanUtils.copyProperties(strategyRuleDos,strategyRules);
        return strategyRules;
    }
}
