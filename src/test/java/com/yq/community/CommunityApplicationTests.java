package com.yq.community;

import com.yq.community.dao.DiscussPostMapper;
import com.yq.community.dao.UserMapper;
import com.yq.community.pojo.DiscussPost;
import com.yq.community.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.test.context.ContextConfiguration;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootTest
@ContextConfiguration(classes = CommunityApplication.class)
class CommunityApplicationTests implements ApplicationContextAware {

	private ApplicationContext applicationContext;

	@Autowired
	private UserMapper userMapper;

	@Autowired
	private SimpleDateFormat simpleDateFormat;

	@Autowired
	private DiscussPostMapper discussPostMapper;

	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		this.applicationContext = applicationContext;
	}

	@Test
	void test01(){
		SimpleDateFormat simpleDateFormat = applicationContext.getBean(SimpleDateFormat.class);
		System.out.println(simpleDateFormat.format(new Date()));
	}

	@Test
	void test02(){
		User user = new User();
		user.setUsername("YQ");
		user.setPassword("123456");
		user.setCreateTime(new Date());
		user.setSalt("abc");
		user.setEmail("123@outlook.com");
		user.setHeaderUrl("http://www.nowcoder.com/101.png");
		user.setStatus(1);
		user.setType(1);
		int rows = userMapper.insertUser(user);
		System.out.println(rows);
		System.out.println(user.getId());
	}

	@Test
	void test03(){
		int rows = discussPostMapper.selectDiscussPostRows(0);
		System.out.println(rows);
		List<DiscussPost> discussPosts = discussPostMapper.selectDiscussPost(0, 0, 1);
		System.out.println(discussPosts);
	}


}
