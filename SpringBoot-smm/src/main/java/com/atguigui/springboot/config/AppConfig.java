package com.atguigui.springboot.config;

import java.sql.SQLException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.support.http.StatViewServlet;
import com.alibaba.druid.support.http.WebStatFilter;

@Configuration
public class AppConfig {
	@Value("${spring.datasource.username}")  //组件对象初始化时，可以给成员变量自动赋值（支持通过从properties文件中加载参数）
	String username;
	@Value("${spring.datasource.password}")
	String password;
	@Value("${spring.datasource.url}")
	String url;
	@Value("${spring.datasource.driver-class-name}")
	String driverClassName;
	@Bean
	public DruidDataSource getDruidDataSource() throws Exception {
		DruidDataSource dataSource = new DruidDataSource();
		//设置初始化参数
		dataSource.setUsername(username);
		dataSource.setPassword(password);
		dataSource.setUrl(url);
		dataSource.setDriverClassName(driverClassName);
		dataSource.setFilters("stat , wall");
		return dataSource;
	}
	
	// 配置Druid的监控
		// 1、配置一个管理后台的Servlet
		@Bean
		public ServletRegistrationBean statViewServlet() {
			ServletRegistrationBean bean = new ServletRegistrationBean(new StatViewServlet(), "/druid/*");
			Map<String, String> initParams = new HashMap<>();
			initParams.put("loginUsername", "admin");
			initParams.put("loginPassword", "123456");
			initParams.put("allow", "");// 默认就是允许所有访问
			initParams.put("deny", "192.168.17.21");// 拒绝哪个ip访问
			bean.setInitParameters(initParams);
			return bean;
		}

		// 2、配置一个web监控的filter
		@Bean
		public FilterRegistrationBean webStatFilter() {
			FilterRegistrationBean bean = new FilterRegistrationBean();
			bean.setFilter(new WebStatFilter());
			Map<String, String> initParams = new HashMap<>();
			initParams.put("exclusions", "*.js,*.css,*.jpg,/druid/*");// 排除过滤
			bean.setInitParameters(initParams);
			bean.setUrlPatterns(Arrays.asList("/*"));
			return bean;
		}

}

























































