package com.ruxi.sentinal4;


import com.alibaba.csp.sentinel.slots.block.RuleConstant;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRule;
import com.alibaba.csp.sentinel.slots.block.flow.FlowRuleManager;
import com.ruxi.sentinal4.controller.UserController;
import com.ruxi.sentinal4.service.UserServiceImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Sentinal4Application {

    public static void main(String[] args) {
        SpringApplication.run(Sentinal4Application.class, args);


    }

    private static void initFlowQpsRule() {
        List<FlowRule> rules = new ArrayList<>();

        FlowRule rule = new FlowRule(UserServiceImpl.RESOURCE_NAME_QUERY_USER_BY_NAME);

        rule.setCount(2);
        rule.setGrade(RuleConstant.FLOW_GRADE_QPS);
        rule.setLimitApp("default");
        rules.add(rule);
        FlowRuleManager.loadRules(rules);
    }

}
