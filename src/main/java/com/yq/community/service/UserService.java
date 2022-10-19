package com.yq.community.service;

import com.yq.community.dao.UserMapper;
import com.yq.community.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    private UserMapper userMapper;

    public User queryById(int id){
        return userMapper.selectById(id);
    }

}
