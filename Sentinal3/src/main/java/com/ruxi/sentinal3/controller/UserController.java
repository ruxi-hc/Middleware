package com.ruxi.sentinal3.controller;

import com.alibaba.csp.sentinel.Sph;
import com.alibaba.csp.sentinel.SphO;
import com.alibaba.fastjson.JSON;
import com.ruxi.sentinal3.entity.User;
import org.json.JSONObject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/user")
public class UserController {

    public static final String RESOURCE_NAME_QUERY_USER_BY_ID = "queryUserById";

    @RequestMapping("/get/{id}")
    public String queryUserById(@PathVariable("id") String id){
        if (SphO.entry(RESOURCE_NAME_QUERY_USER_BY_ID)){
            try {
                return JSON.toJSONString(new User(id,"Tom",25));
            }   finally {
                SphO.exit();
            }
        } else {
            //资源访问阻止，被限流或被降级
            return "Resource is Block!!!";
        }
    }
}
