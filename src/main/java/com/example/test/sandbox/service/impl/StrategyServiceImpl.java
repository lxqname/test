package com.example.test.sandbox.service.impl;

import com.example.test.sandbox.dao.IRuleDao;
import com.example.test.sandbox.dao.IStrategyDao;
import com.example.test.sandbox.domian.StrategyDo;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.Strategy;
import com.example.test.sandbox.mapper.StrategyMapper;
import com.example.test.sandbox.service.IStrategyService;
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
public class StrategyServiceImpl extends ServiceImpl<StrategyMapper, StrategyDo> implements IStrategyService {

    @Autowired
    private IStrategyDao strategyDao;

    @Autowired
    private IRuleDao ruleDao;


    @Override
    public List<Rule> selectByStrategyId(Integer strategyId) {
        //根据策略id查询规则集合
        return ruleDao.findByStrategyId(strategyId);
    }


    @Override
    public Strategy insertStrategy(Strategy strategy) {
        Strategy strategy1 = strategyDao.insertStrategy(strategy);
        return strategy1;
    }

    @Override
    public Strategy getByName(String strategyName) {
        //根据策略名查询策略
        return strategyDao.getByName(strategyName);
    }



    @Override
    public List<Strategy> listStrategy() {
        return strategyDao.listStrategy();
    }


    @Override
    public List<Strategy> listByCondition(Strategy strategy) {
        //模糊查询
        return strategyDao.listByCondition(strategy);
    }

    @Override
    public Strategy getByUserId(Integer userId) {
        return strategyDao.getByUserId(userId);
    }
}
