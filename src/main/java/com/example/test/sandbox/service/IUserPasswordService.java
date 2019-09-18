package com.example.test.sandbox.service;

import com.example.test.sandbox.entity.UserPassword;
import com.baomidou.mybatisplus.extension.service.IService;



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
     * @param n
     * @return
     */
    boolean listUserPassword(String password, int userId,int n);

}
