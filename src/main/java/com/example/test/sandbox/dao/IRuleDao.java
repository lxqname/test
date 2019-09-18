package com.example.test.sandbox.dao;

import com.example.test.sandbox.entity.Rule;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IRuleDao {

    /**
     * 根据id查询规则
     * @param id
     * @return
     */
    Rule findByID(Integer id);

    /**
     * 根据策略id查询规则集合
     * @param id
     * @return
     */
    List<Rule> findByStrategyId(Integer id);


}
