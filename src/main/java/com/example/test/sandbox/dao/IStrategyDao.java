package com.example.test.sandbox.dao;


import com.example.test.sandbox.entity.Strategy;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86151
 */
@Repository
public interface IStrategyDao {

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
     * 条件查询
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
