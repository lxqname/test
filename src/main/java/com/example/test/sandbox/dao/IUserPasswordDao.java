package com.example.test.sandbox.dao;

import com.example.test.sandbox.entity.UserPassword;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author 86151
 */
@Repository
public interface IUserPasswordDao {
    /**
     * 根据用户id查询密码集合
     * @param userId
     * @return
     */
    List<UserPassword> listUserPassword(int userId);

}
