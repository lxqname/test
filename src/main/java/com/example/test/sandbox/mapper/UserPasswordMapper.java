package com.example.test.sandbox.mapper;

import com.example.test.sandbox.domian.UserPasswordDo;
import com.example.test.sandbox.entity.UserPassword;
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
public interface UserPasswordMapper extends BaseMapper<UserPassword> {
    /**
     * 根据userid查询所有密码
     *
     * @param userId
     * @return
     */
    List<UserPasswordDo> listUserPassword(int userId);

}
