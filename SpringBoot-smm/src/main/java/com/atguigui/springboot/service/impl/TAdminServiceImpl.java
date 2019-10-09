package com.atguigui.springboot.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.atguigui.springboot.bean.TAdmin;
import com.atguigui.springboot.mapper.TAdminMapper;
import com.atguigui.springboot.service.TAdminService;
@Service
public class TAdminServiceImpl implements TAdminService {
	
	@Autowired 
	TAdminMapper adminMapper;
	@Override
	public List<TAdmin> selectAdmin() {
		 
		return adminMapper.getAdmins();
		
	}

}
