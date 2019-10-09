package com.atguigui.springboot.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.atguigui.springboot.bean.TAdmin;


public interface TAdminService {

	List<TAdmin> selectAdmin();
	

}
