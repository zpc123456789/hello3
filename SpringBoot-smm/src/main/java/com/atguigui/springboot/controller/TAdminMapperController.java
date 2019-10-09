package com.atguigui.springboot.controller;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.atguigui.springboot.bean.TAdmin;
import com.atguigui.springboot.service.TAdminService;

@Controller
public class TAdminMapperController {
	@Autowired
	TAdminService adminService;
	@Autowired
	DataSource dataSource;
	
	@RequestMapping("/hello")
	public String toTAdmin() {	
		//List<TAdmin> list = adminService.selectAdmin();
		System.out.println("======1111=====");
		//System.out.println(list);
		System.out.println("======2222=====");
		System.out.println(dataSource.getClass());
		return "admin/admin";
	}

}














