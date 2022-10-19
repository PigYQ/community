package com.yq.community.controller;

import com.yq.community.dao.DiscussPostMapper;
import com.yq.community.pojo.DiscussPost;
import com.yq.community.pojo.User;
import com.yq.community.service.DiscussPostService;
import com.yq.community.service.UserService;
import com.yq.community.util.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class HomeController {
    @Autowired
    private DiscussPostService discussPostService;

    @Autowired
    private UserService userService;

    @GetMapping("/index")
    public String index(Model model, Page page){
        page.setTotalRows(discussPostService.queryRows(0));
        page.setPath("/index");
        List<DiscussPost> discussPostList = discussPostService.queryDiscussPost(0, page.getPageNo(), page.getPageSize());
        List<Map<String, Object>> postAndUserList = new ArrayList<>();
        for (DiscussPost discussPost : discussPostList) {
            Map<String, Object> map = new HashMap<>();
            map.put("post",discussPost);
            User user = userService.queryById(discussPost.getUserId());
            map.put("user",user);
            postAndUserList.add(map);
        }
        model.addAttribute("postAndUserList",postAndUserList);
        return "/index";
    }
}
