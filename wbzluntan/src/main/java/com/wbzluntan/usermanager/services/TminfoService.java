package com.wbzluntan.usermanager.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.wbzluntan.usermanager.dao.TminfoMapper;
import com.wbzluntan.usermanager.entity.Tminfo;
import com.wbzluntan.usermanager.entity.TminfoExample;
import com.wbzluntan.usermanager.entity.TminfoExample.Criteria;

@Service
public class TminfoService {
	
	@Autowired
	private TminfoMapper tminfoMapper;
	
	public boolean addtm(Tminfo tm) {
		tminfoMapper.insert(tm);
		return true;
	}
	
	public PageInfo<Tminfo> searchTminfo(Tminfo tm,int pageNum,int pageSize){
		TminfoExample example = new TminfoExample();
		Criteria cc = example.createCriteria();
		cc.andUsernameEqualTo(tm.getUsername());
		PageHelper.startPage(pageNum, pageSize);
		List<Tminfo> list = tminfoMapper.selectByExample(example);
		return new PageInfo<Tminfo>(list);
	}
}
