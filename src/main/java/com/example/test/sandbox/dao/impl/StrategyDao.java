package com.example.test.sandbox.dao.impl;

import com.example.test.sandbox.dao.IRuleDao;
import com.example.test.sandbox.dao.IStrategyDao;
import com.example.test.sandbox.domian.StrategyDo;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.Strategy;
import com.example.test.sandbox.mapper.StrategyMapper;
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
    IRuleDao roleDao;

    @Override
    public Strategy getByStrategyId(String strategyId) {
        StrategyDo strategyDo = new StrategyDo();
        strategyDo.setStrategyId(strategyId);
        //根据策略id查询策略
        StrategyDo strategyDo1 = strategyMapper.selectAll(strategyDo);
        //根据id查询规则集合
        List<Rule> list = roleDao.findByStrategyId(strategyDo1.getId());
        Strategy strategy = new Strategy();
        strategy.setId(strategyDo1.getId());
        strategy.setRules(list);
        return strategy;
    }

    @Override
    public Strategy insertStrategy(Strategy strategy) {
        StrategyDo strategyDo = new StrategyDo();
        BeanUtils.copyProperties(strategy,strategyDo);
        //添加策略
        int insert = strategyMapper.insert(strategyDo);
        //查询刚添加的策略
        StrategyDo strategyDo1 = strategyMapper.selectAll(strategyDo);
        BeanUtils.copyProperties(strategyDo1,strategy);
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


}
