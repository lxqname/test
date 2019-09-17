package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IRuleDao;
import com.example.test.sandbox.domian.RuleDo;
import com.example.test.sandbox.domian.StrategyRuleDo;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.mapper.RuleMapper;
import com.example.test.sandbox.mapper.StrategyRuleMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86151
 */
public class RuleDao implements IRuleDao {

    @Autowired
    private RuleMapper ruleMapper;

    @Autowired
    private StrategyRuleMapper strategyRuleMapper;

    @Override
    public Rule findByID(Integer id) {
        //根据规则id查询规则
        RuleDo ruleDo = ruleMapper.selectById(id);
        Rule rule = new Rule();
        BeanUtils.copyProperties(ruleDo,rule);
        return rule;
    }

    @Override
    public List<Rule> findByStrategyId(Integer id) {
        //根据策略的主键id查询所有StrategyRuleDo
        List<StrategyRuleDo> strategyRuleDos = strategyRuleMapper.selectByStrategyId(id);
        List<Rule> rules = new ArrayList<>();
        for (StrategyRuleDo item:strategyRuleDos) {
            //根据规则id查询规则
            Rule rule = findByID(item.getRuleId());
            //将规则添加到集合中
            rules.add(rule);
        }
        //返回规则集合
        return rules;
    }

    @Override
    public Rule addRule(Rule rule) {
        RuleDo ruleDo = new RuleDo();
        BeanUtils.copyProperties(rule,ruleDo);
        //添加规则
        Integer integer = ruleMapper.addRule(ruleDo);
        RuleDo ruleDo1 = ruleMapper.selectById(ruleDo.getId());
        BeanUtils.copyProperties(ruleDo1,rule);
        return rule;
    }
}
