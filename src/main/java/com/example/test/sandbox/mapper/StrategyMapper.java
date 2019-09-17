package com.example.test.sandbox.mapper;

import com.example.test.sandbox.domian.StrategyDo;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@Repository
public interface StrategyMapper extends BaseMapper<StrategyDo> {

    /**
     * 所有查询
     *
     * @param strategyDO
     * @return
     */
    StrategyDo selectAll(StrategyDo strategyDO);


    /**
     * 新增策略
     *
     * @param strategyDO
     * @return
     */

    int insertStrategy(StrategyDo strategyDO);

    /**
     * 分页
     *
     * @return
     */

    List<StrategyDo> listStrategy();

    List<StrategyDo> listByCondition(StrategyDo strategyDO);


}
