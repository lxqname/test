package com.example.test.sandbox.service;

import com.example.test.sandbox.domian.StrategyDo;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.Strategy;


import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface IStrategyService extends IService<StrategyDo> {
    /**
     * 根据策略id查询其所有的规则
     * @param strategyId
     * @return
     */
    List<Rule> selectByStrategyId(Integer strategyId);

    /**
     * 新增密码策略
     *
     * @param strategyVo
     * @return
     */
    Strategy insertStrategy(Strategy strategyVo);


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

    /**
     * 通过userId获得策略
     * @param userId
     * @return
     */
    Strategy getByUserId(Integer userId);


}
