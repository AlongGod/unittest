package com.unittest.unittest.mapper;

import java.util.List;
import java.util.Map;

import com.unittest.unittest.model.Admin;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface AdminMapper {

	Admin userLogin(Map<String, Object> map);
	
	List<Admin> queryPageMap(Map<Object, Object> map);

	void insert(Admin admin);

	void update(Admin admin);

	Admin getById(String id);

	void deleteById(String id);

	void updatePwd(Map<String, Object> map);
}
