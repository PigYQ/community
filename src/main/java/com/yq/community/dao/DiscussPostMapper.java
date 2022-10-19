package com.yq.community.dao;

import com.yq.community.pojo.DiscussPost;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface DiscussPostMapper {

    List<DiscussPost> selectDiscussPost(int userId, int currentPage, int pageSize);

    int selectDiscussPostRows(@Param("userId") int userId);
}
