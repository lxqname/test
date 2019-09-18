package com.example.test.sandbox.mapper;

import com.example.test.sandbox.domian.UserDo;
import com.example.test.sandbox.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
public interface UserMapper extends BaseMapper<User> {
    /**
     * 注册用户
     *
     * @param userDo
     * @return
     */
    Integer addUser(UserDo userDo);
    /**
     * 查询所有
     *
     * @param userDo
     * @return
     */
    UserDo selectAll(UserDo userDo);

    /**
     * 记录登入次数
     *
     * @param userDo
     * @return
     */
    Integer updateLoginCount(UserDo userDo);

    /**
     * 修改账号信息
     * @param userDo
     * @return
     */
    Integer updateAll(UserDo userDo);


    /**
     * @param checkedId
     * @return
     */
    int falseDelete(String[] checkedId);

}
