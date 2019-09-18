package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IRuleDao;
import com.example.test.sandbox.dao.IStrategyDao;
import com.example.test.sandbox.domian.StrategyDo;
import com.example.test.sandbox.domian.UserStrategyDo;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.Strategy;
import com.example.test.sandbox.mapper.StrategyMapper;
import com.example.test.sandbox.mapper.StrategyRuleMapper;
import com.example.test.sandbox.mapper.UserStrategyMapper;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 86151
 */
@Service
public class StrategyDao implements IStrategyDao {

    @Autowired
    StrategyMapper strategyMapper;

    @Autowired
    private StrategyRuleMapper strategyRuleMapper;


    @Autowired
    UserStrategyMapper userStrategyMapper;


    @Override
    public Strategy insertStrategy(Strategy strategy) {
        StrategyDo strategyDo = new StrategyDo();
        BeanUtils.copyProperties(strategy,strategyDo);
        //添加策略
        strategyMapper.insertStrategy(strategyDo);
        //查询刚添加的策略
        StrategyDo strategyDo1 = strategyMapper.selectAll(strategyDo);
        if(strategy.getRules()!=null){
            List<Rule> rules = strategy.getRules();
            //把策略id和规则id添加到中间表中
            rules.forEach(item->strategyRuleMapper.addStrategyRule(strategyDo1.getId(), item.getId()));
        }
        return strategy;
    }

    @Override
    public Strategy getByName(String strategyName) {
        StrategyDo strategyDo = new StrategyDo();
        strategyDo.setStrategyName(strategyName);
        //根据策略名查询策略
        StrategyDo strategyDo1 = strategyMapper.selectAll(strategyDo);
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyDo1,strategy);
        return strategy;
    }

    @Override
    public List<Strategy> listStrategy() {
        List<StrategyDo> strategyDos = strategyMapper.listStrategy();
        List<Strategy> strategies = new ArrayList<>();
        BeanUtils.copyProperties(strategyDos,strategies);
        return strategies;
    }

    @Override
    public List<Strategy> listByCondition(Strategy strategy) {
        StrategyDo strategyDo = new StrategyDo();
        BeanUtils.copyProperties(strategy,strategyDo);
        //模糊查询
        List<StrategyDo> strategyDos = strategyMapper.listByCondition(strategyDo);
        List<Strategy> strategies = new ArrayList<>();
        BeanUtils.copyProperties(strategyDos,strategies);
        return strategies;
    }

    @Override
    public Strategy getByUserId(Integer userId) {
        //根据userId查询用户策略实体集合
        List<UserStrategyDo> userStrategyDos = userStrategyMapper.selectByUserId(userId);
        StrategyDo strategyDo = new StrategyDo();
        strategyDo.setId(userStrategyDos.get(userStrategyDos.size() - 1).getStrategyId());
        StrategyDo strategyDo1 = strategyMapper.selectAll(strategyDo);
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyDo1,strategy);
        return strategy;
    }
}
