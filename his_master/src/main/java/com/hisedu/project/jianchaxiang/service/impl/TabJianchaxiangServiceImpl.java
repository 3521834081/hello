package com.hisedu.project.jianchaxiang.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisedu.project.jianchaxiang.domain.TabJianchaxiang;
import com.hisedu.project.jianchaxiang.mapper.TabJianchaxiangMapper;
import com.hisedu.project.jianchaxiang.service.ITabJianchaxiangService;

@Service
public class TabJianchaxiangServiceImpl implements ITabJianchaxiangService{

	@Autowired
	private TabJianchaxiangMapper tabJianchaxiangMapper;
	
	
	@Override
	public List<TabJianchaxiang> selectTabJianchaxiang(TabJianchaxiang tabJianchaxiang) {
		// TODO Auto-generated method stub
		return tabJianchaxiangMapper.selectTabJianchaxiang(tabJianchaxiang);
	}


	@Override
	public int insertTabJianchaxiang(TabJianchaxiang tabJianchaxiang) {
		// TODO Auto-generated method stub
		return tabJianchaxiangMapper.insertTabJianchaxiang(tabJianchaxiang);
	}


	@Override
	public TabJianchaxiang selectTabJianchaxiangById(Long id) {
		// TODO Auto-generated method stub
		return tabJianchaxiangMapper.selectTabJianchaxiangById(id);
	}


	@Override
	public int updateTabJianchaxiang(TabJianchaxiang tabJianchaxiang) {
		// TODO Auto-generated method stub
		return tabJianchaxiangMapper.updateTabJianchaxiang(tabJianchaxiang);
	}


	@Override
	public int deleteTabJianchaxiangById(Long id) {
		// TODO Auto-generated method stub
		return tabJianchaxiangMapper.deleteTabJianchaxiangById(id);
	}


	
	
	
}
