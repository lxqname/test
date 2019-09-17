package com.example.test.sandbox.controller;


import com.example.test.sandbox.entity.Strategy;
import com.example.test.sandbox.service.IStrategyService;
import com.example.test.sandbox.util.RegixConstant;
import com.example.test.sandbox.vo.StrategyVo;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author jie
 * @since 2019-09-16
 */
@RestController
@RequestMapping("/sandbox/strategy")
public class StrategyController {

    @Autowired
    IStrategyService strategyService;
    /**
     * 策略名校验
     *
     * @param strategyName
     * @return
     */
    @GetMapping(value = "/checkStrategyName")
    public Object checkStrategyName(@RequestParam(value = "strategyName") String strategyName) {
        //非空校验
        if (StringUtils.isEmpty(strategyName) || strategyName.trim().length() <= 0) {
            return false;
        }
        //去左右空格
        strategyName = strategyName.trim();
        //长度校验
        if (strategyName.length() >= 2 && strategyName.length() <= 15 && strategyName.matches(RegixConstant.CN_NUMBER_LETTER)) {
            //唯一性校验
            Strategy result = strategyService.getByName(strategyName);
            if (ObjectUtils.isEmpty(result)) {
                //校验通过
                return true;
            }
            return "策略名已存在";
        }
        return false;
    }


    /**
     * 新增策略
     *
     * @param strategyVo
     * @return
     */
    @PostMapping(value = "/insert")
    public Strategy insertStrategy(@RequestBody StrategyVo strategyVo) {
        return strategyService.insertStrategy(strategyVo);
    }



    /**
     * 策略分页(仅显示启用状态的策略)
     *
     * @param pageNum
     * @param pageSize
     * @return
     */

    @GetMapping(value = "listStrategy")
    public PageInfo<Strategy> listStrategy(@RequestParam(value = "pageNum") int pageNum, @RequestParam(value = "pageSize") int pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Strategy> strategies = strategyService.listStrategy();
        PageInfo<Strategy> strategyPageInfo = new PageInfo<>(strategies);
        return strategyPageInfo;
    }

    /**
     * 条件查询并分页
     *
     * @param strategyName
     * @param strategyId
     * @return
     */

    @GetMapping(value = "listByCondition")
    public PageInfo<Strategy> listByCondition(@RequestParam(value = "strategyName") String strategyName,
                                                @RequestParam(value = "strategyId") String strategyId,
                                                @RequestParam(value = "pageNum") int pageNum,
                                                @RequestParam(value = "pageSize") int pageSize) {
        strategyName = strategyName == null ? "" : strategyName.trim();
        strategyId = strategyId == null ? "" : strategyId.trim();
        PageHelper.startPage(pageNum, pageSize);
        StrategyVo strategyVo = new StrategyVo();
        strategyVo.setStrategyName(strategyName);
        strategyVo.setStrategyId(strategyId);
        List<Strategy> strategies = strategyService.listByCondition(strategyVo);
        PageInfo<Strategy> strategyPageInfo = new PageInfo<>(strategies);
        return strategyPageInfo;
    }

}
