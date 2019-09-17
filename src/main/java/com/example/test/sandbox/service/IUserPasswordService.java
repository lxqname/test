package com.example.test.sandbox.service;

import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.UserPassword;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * <p>
 * 服务类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface IUserPasswordService extends IService<UserPassword> {
    /**
     * 修改密码不能和前n次重复
     *
     * @param password
     * @param userId
     * @return
     */
    boolean listUserPassword(String password, int userId,int n);

    /**
     * 根据用户id查询其限制密码的规则
     * @param userId
     * @return
     */
    List<Rule> selectByUserId(Integer userId);
}
