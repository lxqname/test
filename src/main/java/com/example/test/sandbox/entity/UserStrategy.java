package com.example.test.sandbox.entity;
//-------------------------hello

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public class UserStrategy implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;

    private Integer strategyId;

    private Integer userId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getStrategyId() {
        return strategyId;
    }

    public void setStrategyId(Integer strategyId) {
        this.strategyId = strategyId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public String toString() {
        return "UserStrategyVo{" +
                "id=" + id +
                ", strategyId=" + strategyId +
                ", userId=" + userId +
                "}";
    }
}
