package com.wbzluntan.controllers;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.pagehelper.PageInfo;
import com.wbzluntan.usermanager.entity.Userinfo;
import com.wbzluntan.usermanager.services.UserManagerService;


@RestController
public class UserManagerController {
	
	private static final String CURRENT_USER = "CURRENTUSER";
	@Autowired
	private UserManagerService service;
	
	@RequestMapping("/getcuruser")
	public Userinfo doGetCurrentUserinfo(HttpSession session) {
		return (Userinfo)session.getAttribute(CURRENT_USER);
	}
	
	@RequestMapping("/checkemail")
	public boolean doCheckEmail(Userinfo user) {
		return service.checkEmail(user.getEmail());
	}
	
	@RequestMapping("/checkname")
	public boolean doCheckName(Userinfo user) {
		return service.checkUsername(user.getUsername());
	}
	
	@RequestMapping("/reg")
	public boolean doReg(Userinfo user) {
		return service.addNewUser(user);
	}
	
	@RequestMapping("/login")
	public Userinfo doLogin(Userinfo user, HttpSession session) {
		Userinfo result = service.checkLogin(user);
		if(null != result) {
			session.setAttribute(CURRENT_USER, result);
			return result;
		}	
		else {
		return new Userinfo();
		}
	}
	
//	≈–∂œ” œ‰∏Ò Ω
	@RequestMapping("/rightemail")
	public boolean doRightEmail(Userinfo user) {
		return service.checkRightEmail(user.getEmail());
	}
	
	
////	–ﬁ∏ƒ√‹¬Î
//	@RequestMapping("/moduser")
//	public boolean doMod(Userinfo user) {
//		return service.modUserinfo(user);
//	}
//  ≤È—Ø
	@RequestMapping("/searchuser")
	public PageInfo<Userinfo> doSearch(Userinfo cond,int pageNum, int pageSize){
		return service.searchUserinfo(cond, pageNum, pageSize);
	}
	@RequestMapping("/forg")
	public boolean doforg(Userinfo user) {
		return service.forgetUser(user);
	}
	
	 @RequestMapping("/moduser")
	    boolean doModifyUser(Userinfo prod) {
	   	 return service.modProdinfo(prod);
	    }
	    @RequestMapping("/reg2")
	    public boolean doReg2(Userinfo user) {
	    	return service.addUser(user);
	    }


}
