package com.ruxi.sen1;

import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.ruxi.sen1.controller.UserController;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SentinalsApplication {

    public static void main(String[] args) {
        SpringApplication.run(SentinalsApplication.class, args);
        //初始化限流规则
        initFlowQpsRule();
    }

    //定义了每秒最多接收2个请求
    private static void initFlowQpsRule() {

        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule(UserController.RESOURCE_NAME);
        // set limit qps to 2
        rule.setCount(2);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");

        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
