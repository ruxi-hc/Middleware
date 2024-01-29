package com.sentinal2.servoce;


import com.sentinal2.entity.User;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class UserServiceImpl implements UserService {

    @Override
    public List<User> getList() {
        ArrayList<User> userList = new ArrayList<>();
        userList.add(new User("1", "周慧敏", 18));
        userList.add(new User("2", "关之琳", 20));
        userList.add(new User("3", "王祖贤", 21));
        return userList;
    }
}
