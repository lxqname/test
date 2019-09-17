package com.example.test.sandbox.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.test.sandbox.domian.RuleDo;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface RuleMapper extends BaseMapper<RuleDo> {
    /**
     * 根据id查询规则
     * @param id
     * @return
     */
    RuleDo selectById(Integer id);

    /**
     * 添加规则
     * @param ruleDo
     * @return
     */
    Integer addRule(RuleDo ruleDo);
}
