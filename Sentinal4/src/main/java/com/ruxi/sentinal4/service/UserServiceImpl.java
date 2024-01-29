package com.ruxi.sentinal4.service;



import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.ruxi.sentinal4.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    //资源名称
    public static final String RESOURCE_NAME_QUERY_USER_BY_NAME = "queryUserByUserName";

    //value是资源名称，是必填项。blockHandler填限流处理的方法名称
    @Override
    @SentinelResource(value = RESOURCE_NAME_QUERY_USER_BY_NAME,blockHandler = "queryUserByUserNameBlock")
    public User queryByUserName(String userName){
        return new User("0",userName,18);
    }

    public User queryUserByUserNameBlock(String userName, BlockException ex) {

        ex.printStackTrace();
        return new User("xxx","用户名称:{"+userName+"},资源访问被限流",0);
    }

}
