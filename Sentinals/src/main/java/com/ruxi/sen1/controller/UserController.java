package com.ruxi.sen1.controller;

import com.alibaba.csp.sentinel.Entry;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.csp.sentinel.SphU;
import com.alibaba.csp.sentinel.Tracer;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.ruxi.sen1.entity.User;
import com.ruxi.sen1.servoce.UserService;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    //资源名称
    public static final String RESOURCE_NAME = "userList";

    public static final String RESOURCE_NAME_QUERY_USER_BY_ID = "queryUserById";

    @Resource
    private UserService userService;

    @RequestMapping("/list")
    public List<User> getUserList() {
        List<User> userList = null;
        Entry entry = null;

        try {
            entry = SphU.entry(RESOURCE_NAME);
            userList = userService.getList();
        } catch (BlockException e) {
            // 资源访问阻止，被限流或被降级
            return Collections.singletonList(new User("xxx", "资源访问被限流", 0));
        } catch (Exception e){
            Tracer.traceEntry(e,entry);
        } finally {
          if (entry != null){
              entry.exit();
          }
        }
        return userList;
    }

}
