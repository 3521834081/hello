package com.hisedu.project.jiaofei.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisedu.project.jiaofei.domain.TabJiaofei;
import com.hisedu.project.jiaofei.mapper.TabJiaofeiMapper;
import com.hisedu.project.jiaofei.service.ITabJiaofeiService;

@Service
public class TabJiaofeiServiceImpl implements ITabJiaofeiService{

	@Autowired
	private TabJiaofeiMapper tabJiaofeiMapper;
	
	@Override
	public List<TabJiaofei> selectTabJiaofeiList(TabJiaofei tabJiaofei) {
		// TODO Auto-generated method stub
		return tabJiaofeiMapper.selectTabJiaofeiList(tabJiaofei);
	}

	@Override
	public int insertTabJiaofei(TabJiaofei tabJiaofei) {
		// TODO Auto-generated method stub
		return tabJiaofeiMapper.insertTabJiaofei(tabJiaofei);
	}

	@Override
	public int deleteTabJiaofeiById(Long id) {
		// TODO Auto-generated method stub
		return tabJiaofeiMapper.deleteTabJiaofeiById(id);
	}

	@Override
	public int updateTabJiaofei(TabJiaofei tabJiaofei) {
		// TODO Auto-generated method stub
		return tabJiaofeiMapper.updateTabJiaofei(tabJiaofei);
	}

	
	
	
}
