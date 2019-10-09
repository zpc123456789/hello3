package com.atguigui.springboot.mapper;

import java.util.List;

//import org.apache.ibatis.annotations.Mapper;

import com.atguigui.springboot.bean.TAdmin;
//@Mapper  //组件注解
public interface TAdminMapper {
	List<TAdmin> getAdmins();
}
