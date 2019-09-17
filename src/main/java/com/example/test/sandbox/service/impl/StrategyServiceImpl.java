package com.example.test.sandbox.service.impl;

import com.example.test.sandbox.dao.IRuleDao;
import com.example.test.sandbox.dao.IStrategyDao;
import com.example.test.sandbox.dao.IStrategyRuleDao;
import com.example.test.sandbox.domian.StrategyDo;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.Strategy;
import com.example.test.sandbox.mapper.StrategyMapper;
import com.example.test.sandbox.service.IStrategyService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.test.sandbox.util.RandomUtil;
import com.example.test.sandbox.vo.StrategyVo;
import org.springframework.beans.BeanUtils;
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

    @Autowired
    private IStrategyRuleDao strategyRuleDao;


    @Override
    public List<Rule> selectByStrategyId(Integer strategyId) {
        //根据策略id查询规则集合
        return ruleDao.findByStrategyId(strategyId);
    }


    @Override
    public Strategy insertStrategy(StrategyVo strategyVo) {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyVo,strategy);
        //添加策略进数据库
        Strategy strategy1 = strategyDao.insertStrategy(strategy);
        List<Rule> rules = strategy.getRules();
        //把策略id和规则id添加到中间表中
        rules.forEach(item->strategyRuleDao.addStrategyRule(strategy.getId(),item.getId()));
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
    public List<Strategy> listByCondition(StrategyVo strategyVo) {
        Strategy strategy = new Strategy();
        BeanUtils.copyProperties(strategyVo,strategy);
        //模糊查询
        return strategyDao.listByCondition(strategy);
    }
}
