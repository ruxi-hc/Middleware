package com.sentinal2.controller;

import com.alibaba.csp.sentinel.Sph;
import com.alibaba.csp.sentinel.SphO;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final String RESOURCE_NAME_QUERY_USER_BY_ID = "queryUserById";

    @RequestMapping("/get/{id}")
    public String queryUserByid(@PathVariable("id") String id) {

        if (SphO.entry(RESOURCE_NAME_QUERY_USER_BY_ID)) {

        }
    }

}
