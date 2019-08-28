package com.dao.demo;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.survey.dao.RoleDao;
import com.survey.dao.UserDao;
import com.survey.form.Role;
import com.survey.form.User;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "/applicationContext.xml")
public class UserDaoTest {
	@Resource(name = "userDao")
	public UserDao userDao;
	@Test
	public void test() {
		User user = new User();
		user.setName("999");
		user.setPassword("999");
		int a=userDao.save(user);
		System.out.println(a+"------------------------------------");
	}
	
	@Resource(name = "roleDao")
	public RoleDao roleDao;
	@Test
	public void testRole() throws Exception {
		System.out.println(roleDao);
	}

}
