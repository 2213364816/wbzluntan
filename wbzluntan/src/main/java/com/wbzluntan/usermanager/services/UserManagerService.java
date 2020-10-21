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
	
//	��¼
	public Userinfo checkLogin(Userinfo user) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
//		����û�������
		cc.andUsernameEqualTo(user.getUsername());
//		�����������
		cc.andEmailEqualTo(user.getEmail());
//		�����������
		cc.andUserpwdEqualTo(user.getUserpwd());
//		��ѯ
		List<Userinfo> list = userMapper.selectByExample(example);
//		�жϵ�¼�ɹ����
		if(list.size() > 0) {
//			��¼�ɹ� �����û���ϸ��Ϣ
			return  list.get(0);
		}
		
		else {
//			��¼ʧ��
			return null;
		}
	}
	
//	ע��
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
//	��������
	public boolean checkUsername(String username) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
		cc.andUsernameEqualTo(username);
		List<Userinfo> list = userMapper.selectByExample(example);
		return list.size() == 0;
	}
//	��������
	public boolean checkEmail(String email) {
		UserinfoExample example = new UserinfoExample();
		Criteria cc = example.createCriteria();
		cc.andUsernameEqualTo(email);
		List<Userinfo> list = userMapper.selectByExample(example);
		return list.size() == 0;	
	}
//�ж������ʽ
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
	
////	�޸�����
//	public boolean modUserinfo(Userinfo user) {
////		UserinfoExample example = new UserinfoExample();
////		Criteria cc = example.createCriteria();
////		
////		cc.andUsernameEqualTo(user.getUsername());
////		cc.andUseridNotEqualTo(user.getUserid());
////		List<Userinfo> list = userMapper.selectByExample(example);
////		if(list.size() > 0) {
////			//���ֲ��Ϸ�
////			return false;
////		}
//		int i = userMapper.updateByPrimaryKeySelective(user);
//		return i > 0;
//	}
//��̬��ѯ
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
//��������
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
	
	//ע��2
		public boolean addUser(Userinfo user) {
			userMapper.insert(user);
			return true;
		}
		
		//��ҳ��ѯ������Ϣ
		public PageInfo<Userinfo> searchToolinfo(Userinfo cond, int pageNum, int pageSize){
			UserinfoExample example = new UserinfoExample();
			Criteria cc = example.createCriteria();
			if(null!=cond.getUsername()&&!"".equals(cond.getUsername())) {
	        	cc.andUsernameEqualTo(cond.getUsername());
	        }
	        //������ҳ���
	        PageHelper.startPage(pageNum, pageSize);
	        //ʵʩ��ѯ
	        List<Userinfo> list = userMapper.selectByExample(example);
	        
	        return new PageInfo<Userinfo>(list);
	        
		}
	//�޸�
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
