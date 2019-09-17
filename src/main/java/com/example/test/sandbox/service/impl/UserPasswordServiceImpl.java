package com.example.test.sandbox.service.impl;

import com.example.test.sandbox.dao.IRuleDao;
import com.example.test.sandbox.dao.IUserPasswordDao;
import com.example.test.sandbox.dao.IUserStrategyDao;
import com.example.test.sandbox.entity.Rule;
import com.example.test.sandbox.entity.UserPassword;
import com.example.test.sandbox.entity.UserStrategy;
import com.example.test.sandbox.mapper.UserPasswordMapper;
import com.example.test.sandbox.service.IUserPasswordService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@Service
public class UserPasswordServiceImpl extends ServiceImpl<UserPasswordMapper, UserPassword> implements IUserPasswordService {

    @Autowired
    private IUserPasswordDao userPasswordDao;

    @Autowired
    private IUserStrategyDao userStrategyDao;


    @Autowired
    private IRuleDao ruleDao;

    @Override
    public boolean listUserPassword(String password, int userId,int n) {
        //根据用户id获得其密码表中的所有密码
        List<UserPassword> userPasswordList = userPasswordDao.listUserPassword(userId);
        //设置密码不能与前n次相同
        for (int i = userPasswordList.size(); i > userPasswordList.size() - n; i--) {
            if (password.equals(userPasswordList.get(i).getPassword())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public List<Rule> selectByUserId(Integer userId) {
        //根据用户id查询其所有的UserStrategy
        List<UserStrategy> userStrategies = userStrategyDao.selectByUserId(userId);
        //只要得到最终的UserStrategy（其他的已失效）
        UserStrategy userStrategy = userStrategies.get(userStrategies.size() - 1);
        //根据策略id查询其所有的Rule集合
        List<Rule> rules = ruleDao.findByStrategyId(userStrategy.getStrategyId());
        return rules;
    }
}
