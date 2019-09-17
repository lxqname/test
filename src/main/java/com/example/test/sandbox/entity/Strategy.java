package com.example.test.sandbox.entity;

import java.time.LocalDateTime;
import java.util.List;

public class Strategy {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private String strategyId;

    private String strategyName;

    /**
     * 策略状态  1 启用 0 禁用
     */
    private Integer strategyState;

    private LocalDateTime strategyCreatetime;

    private List<Rule> rules;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(String strategyId) {
        this.strategyId = strategyId;
    }

    public String getStrategyName() {
        return strategyName;
    }

    public void setStrategyName(String strategyName) {
        this.strategyName = strategyName;
    }

    public Integer getStrategyState() {
        return strategyState;
    }

    public void setStrategyState(Integer strategyState) {
        this.strategyState = strategyState;
    }

    public LocalDateTime getStrategyCreatetime() {
        return strategyCreatetime;
    }

    public void setStrategyCreatetime(LocalDateTime strategyCreatetime) {
        this.strategyCreatetime = strategyCreatetime;
    }

    public List<Rule> getRules() {
        return rules;
    }

    public void setRules(List<Rule> rules) {
        this.rules = rules;
    }

    @Override
    public String toString() {
        return "StrategyVo{" +
                "id=" + id +
                ", strategyId=" + strategyId +
                ", strategyName=" + strategyName +
                ", strategyState=" + strategyState +
                ", strategyCreatetime=" + strategyCreatetime +
                "}";
    }
}
