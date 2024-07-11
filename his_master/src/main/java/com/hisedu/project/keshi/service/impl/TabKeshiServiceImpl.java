package com.hisedu.project.keshi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hisedu.project.keshi.domain.TabKeshi;
import com.hisedu.project.keshi.mapper.TabKeshiMapper;
import com.hisedu.project.keshi.service.ITabKeshiService;
import com.hisedu.project.system.mapper.SysNoticeMapper;

/**
 * 科室管理
 * @author Mr.J
 *
 */

@Service
public class TabKeshiServiceImpl implements ITabKeshiService{

	@Autowired
    private TabKeshiMapper keshiMapper;
	
	
	@Override
	public List<TabKeshi> selectTabKeshiList(TabKeshi tabKeshi) {
		
		List<TabKeshi> list = keshiMapper.selectTabKeshiList(tabKeshi);
		
		return list;
	}


	@Override
	public int insertTabKeshi(TabKeshi tabKeshi) {
		// TODO Auto-generated method stub
		return keshiMapper.insertTabKeshi(tabKeshi);
	}


	@Override
	public TabKeshi selectTabKeshiById(Long id) {
		// TODO Auto-generated method stub
		return keshiMapper.selectTabKeshiById(id);
	}


	@Override
	public int updateTabKeshi(TabKeshi tabKeshi) {
		// TODO Auto-generated method stub
		return keshiMapper.updateTabKeshi(tabKeshi);
	}


	@Override
	public int deleteTabKeshiById(Long id) {
		// TODO Auto-generated method stub
		return keshiMapper.deleteTabKeshiById(id);
	}

	
	
	
	
}
