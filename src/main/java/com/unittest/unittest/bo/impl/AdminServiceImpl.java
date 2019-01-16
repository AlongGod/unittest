package com.unittest.unittest.bo.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.ui.ModelMap;

import com.unittest.unittest.model.Admin;
import com.unittest.unittest.util.MD5Util;
import com.unittest.unittest.util.page.PageView;
import com.unittest.unittest.bo.AdminService;
import com.unittest.unittest.mapper.AdminMapper;
@Service(value="adminService")
public class AdminServiceImpl implements AdminService {
	@Resource
	private AdminMapper adminMapper;

	@Override
	public Admin adminLogin(String userName, String passWord) {
		passWord = MD5Util.MD5(passWord);
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("userName", userName);
		map.put("passWord", passWord);
		return adminMapper.userLogin(map);
	}
	
	@Override
	public ModelMap queryAdminMap(PageView pageView, Admin admin) {
		Map<Object, Object> map = new HashMap<Object, Object>();
		map.put("paging", pageView);
		map.put("t", admin);
		List<Admin> rows = adminMapper.queryPageMap(map);
		ModelMap modelMap = new ModelMap();
		modelMap.addAttribute("records", rows);
		modelMap.addAttribute("sEcho", pageView.getsEcho());
		modelMap.addAttribute("iTotalRecords", pageView.getRowCount());
		modelMap.addAttribute("iTotalDisplayRecords", pageView.getRowCount());
		modelMap.addAttribute("sStatus", "OK");
		return modelMap;
	}

	@Override
	public void insert(Admin admin) {
		adminMapper.insert(admin);
	}

	@Override
	public void update(Admin admin) {
		adminMapper.update(admin);
	}

	@Override
	public Admin getById(String id) {
		return adminMapper.getById(id);
	}

	@Override
	public void deleteById(String id) {
		adminMapper.deleteById(id);
	}
	
	@Override
	public void updatePwd(String passWd, String id) {
		Map<String,Object> map = new HashMap<String,Object>();
		map.put("passWd", passWd);
		map.put("id", id);
		adminMapper.updatePwd(map);
	}
}
