package com.example.test.sandbox.entity;
//-------------------------hello

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public class StrategyRule implements Serializable {

    private static final long serialVersionUID = 1L;


    private Integer id;

    private Integer ruleId;

    private Integer strategyId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleId() {
        return ruleId;
    }

    public void setRuleId(Integer ruleId) {
        this.ruleId = ruleId;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    @Override
    public String toString() {
        return "StrategyRuleVo{" +
                "id=" + id +
                ", ruleId=" + ruleId +
                ", strategyId=" + strategyId +
                "}";
    }
}
