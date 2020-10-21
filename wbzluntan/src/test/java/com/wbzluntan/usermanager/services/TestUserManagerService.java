package com.wbzluntan.usermanager.services;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.github.pagehelper.PageInfo;
import com.wbzluntan.usermanager.entity.Userinfo;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath:applicationContext.xml" })
public class TestUserManagerService {

	@Autowired
	private UserManagerService service;
	
	@Test
	public void testCheckUsername() {
		System.out.println(service.checkUsername("WBZ"));
	}

	
	@Test 
	public void testAddNewUser() { 
	boolean addNewUser =service.addNewUser(new Userinfo(0,"GYH","GYH@qq.com", "123"));
	System.out.println(addNewUser); 
	}
	
	@Test
	public void testCheckRightEmail() {
		System.out.println(service.checkRightEmail("gyh123@qq.com"));
	}
	
	@Test
	public void testSearchUserinfo() {
		PageInfo<Userinfo> pageinfo = service.searchUserinfo(new Userinfo(), 3, 3);
		System.out.println(pageinfo);
		System.out.println(pageinfo.getList());
		for (Userinfo user : pageinfo.getList()) {
			System.out.println(user);
		}
	}
}
