package com.example.test.sandbox.mapper;

import com.example.test.sandbox.domian.UserStrategyDo;
import com.example.test.sandbox.entity.UserStrategy;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface UserStrategyMapper extends BaseMapper<UserStrategy> {
    /**
     * 根据userId查询所对应的UserStrategy
     * @param userId
     * @return
     */
    List<UserStrategyDo> selectByUserId(Integer userId);

    /**
     * 配置密码策略
     *
     * @param strategyId
     * @param userId
     * @return
     */
    int configureStrategy(@Param(value = "strategyId") int strategyId,
                          @Param(value = "userId") int userId);
}
