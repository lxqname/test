package com.example.test.sandbox.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;

public class Rule {
    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 首次登陆是否强制修改密码  1 开启 0 关闭  默认1
     */
    private String ruleName;

    /**
     * 是否开启密码生存周期，1 开启 0 关闭 默认1
     */
    private Integer ruleStatus;

    /**
     * 新密码不允许与旧密码重复的设置  不允许与之前多少次重复 默认 1
     */
    private Integer ruleCycle;

    /**
     * 新密码不允许与旧密码重复的设置 1 开启 0 关闭 默认1
     */
    private Integer ruleForce;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRuleName() {
        return ruleName;
    }

    public void setRuleName(String ruleName) {
        this.ruleName = ruleName;
    }

    public Integer getRuleStatus() {
        return ruleStatus;
    }

    public void setRuleStatus(Integer ruleStatus) {
        this.ruleStatus = ruleStatus;
    }

    public Integer getRuleCycle() {
        return ruleCycle;
    }

    public void setRuleCycle(Integer ruleCycle) {
        this.ruleCycle = ruleCycle;
    }

    public Integer getRuleForce() {
        return ruleForce;
    }

    public void setRuleForce(Integer ruleForce) {
        this.ruleForce = ruleForce;
    }

    @Override
    public String toString() {
        return "RuleVo{" +
                "id=" + id +
                ", ruleName=" + ruleName +
                ", ruleStatus=" + ruleStatus +
                ", ruleCycle=" + ruleCycle +
                ", ruleForce=" + ruleForce +
                "}";
    }
}
