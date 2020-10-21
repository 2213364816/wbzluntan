package com.wbzluntan.usermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wbzluntan.usermanager.dao.UserinfoMapper;
import com.wbzluntan.usermanager.entity.Userinfo;
import com.wbzluntan.usermanager.entity.UserinfoExample;
import com.wbzluntan.usermanager.entity.UserinfoExample.Criteria;


@Service
public class UserManagerService {

	@Autowired
	private UserinfoMapper userMapper;
	
//	登录
	public Userinfo checkLogin(Userinfo user) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
//		添加用户名条件
		cc.andUsernameEqualTo(user.getUsername());
//		添加邮箱条件
		cc.andEmailEqualTo(user.getEmail());
//		添加密码条件
		cc.andUserpwdEqualTo(user.getUserpwd());
//		查询
		List<Userinfo> list = userMapper.selectByExample(example);
//		判断登录成功与否
		if(list.size() > 0) {
//			登录成功 返回用户详细信息
			return  list.get(0);
		}
		
		else {
//			登录失败
			return null;
		}
	}
	
//	注册
	public boolean addNewUser(Userinfo user) {
		boolean isOK = checkUsername(user.getUsername());
		if(!isOK) {
			return false;
		}
		
		boolean OK = checkEmail(user.getEmail());
		if(!OK) {
			return false;
		}
		userMapper.insert(user);
		return true;
	}
//	查找名字
	public boolean checkUsername(String username) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
		cc.andUsernameEqualTo(username);
		List<Userinfo> list = userMapper.selectByExample(example);
		return list.size() == 0;
	}
//	查找邮箱
	public boolean checkEmail(String email) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
		cc.andUsernameEqualTo(email);
		List<Userinfo> list = userMapper.selectByExample(example);
		return list.size() == 0;	
	}
//判断邮箱格式
	public boolean checkRightEmail(String email) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
		cc.andUsernameEqualTo(email);
		if(email.matches("\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.com")){
			return true;
		}else{
			return false;
		}
	}
	
////	修改密码
//	public boolean modUserinfo(Userinfo user) {
////		UserinfoExample example = new UserinfoExample();
////		Criteria cc = example.createCriteria();
////		
////		cc.andUsernameEqualTo(user.getUsername());
////		cc.andUseridNotEqualTo(user.getUserid());
////		List<Userinfo> list = userMapper.selectByExample(example);
////		if(list.size() > 0) {
////			//名字不合法
////			return false;
////		}
//		int i = userMapper.updateByPrimaryKeySelective(user);
//		return i > 0;
//	}
//动态查询
	public PageInfo<Userinfo> searchUserinfo(Userinfo cond, int pageNum, int pageSize){
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
		if (null != cond.getUserid()) {
			cc.andUseridEqualTo(cond.getUserid());
		}
		if (null != cond.getUsername() && !"".equals(cond.getUsername())) {
			cc.andUsernameEqualTo(cond.getUsername());
		}
		if (null != cond.getEmail()) {
			cc.andEmailEqualTo(cond.getEmail());
		}
		if (null != cond.getUserpwd() && !"".equals(cond.getUserpwd())) {
			cc.andUserpwdEqualTo(cond.getUserpwd());
		}
		PageHelper.startPage(pageNum, pageSize);
		List<Userinfo> list = userMapper.selectByExample(example);
		return new PageInfo<Userinfo>(list);
	}
//忘记密码
	public boolean forgetUser(Userinfo user) {
//		boolean isOK = checkUsername(user.getUsername());
//		if(!isOK) {
//			return false;
//		}
//		
//		boolean OK = checkEmail(user.getEmail());
//		if(!OK) {
//			return false;
//		}
		userMapper.insert(user);
		return true;
	}
	
	//注册2
		public boolean addUser(Userinfo user) {
			userMapper.insert(user);
			return true;
		}
		
		//分页查询个人信息
		public PageInfo<Userinfo> searchToolinfo(Userinfo cond, int pageNum, int pageSize){
			UserinfoExample example = new UserinfoExample();
			Criteria cc = example.createCriteria();
			if(null!=cond.getUsername()&&!"".equals(cond.getUsername())) {
	        	cc.andUsernameEqualTo(cond.getUsername());
	        }
	        //启动分页插件
	        PageHelper.startPage(pageNum, pageSize);
	        //实施查询
	        List<Userinfo> list = userMapper.selectByExample(example);
	        
	        return new PageInfo<Userinfo>(list);
	        
		}
	//修改
		public boolean modProdinfo(Userinfo user) {
			UserinfoExample example = new UserinfoExample();
			Criteria cc = example.createCriteria();
			cc.andUsernameEqualTo(user.getUsername());
			List<Userinfo> list = userMapper.selectByExample(example);
			if(list.size()>0) {
				return false;
			}
			int i =userMapper.updateByPrimaryKeySelective(user);
			return i>0;
		}

	

}
