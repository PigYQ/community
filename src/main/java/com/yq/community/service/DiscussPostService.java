package com.yq.community.service;

import com.yq.community.dao.DiscussPostMapper;
import com.yq.community.pojo.DiscussPost;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscussPostService {

    @Autowired
    private DiscussPostMapper discussPostMapper;

    public List<DiscussPost> queryDiscussPost(int userId, int pageNo, int pageSize){
        return discussPostMapper.selectDiscussPost(userId,pageNo,pageSize);
    }

    public int queryRows(int userId){
        return discussPostMapper.selectDiscussPostRows(userId);
    }
}
