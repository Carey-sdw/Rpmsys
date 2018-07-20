package com.rpm;

import javax.sql.DataSource;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;

@Configuration//容器类
@EnableWebMvc//开启一些常用支持：静态资源处理, JSR303校验...常规项目运行不能开启   mvc
//并且需要继承WebMvcConfigurerAdapter
@ComponentScan("com.rpm")//开启注解扫描  全局
@PropertySource("classpath:jdbc.properties") // 引入外部属性文件到Environment  mybatis
@EnableTransactionManagement//开启事务  mybatis
@MapperScan("com.rpm.mapper")//扫描mapper  mybatis
public class AppConfig extends WebMvcConfigurerAdapter{
	@Bean // 负责将控制器方法返回的字符串映射到某个JSP
	public ViewResolver viewResolver() {
		/**
		 * 静态页面的路径配置
		 */
		InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
		viewResolver.setViewClass(JstlView.class); // 支持jsp及标准taglib
		// customers => /WEB-INF/jsp/customers.jsp
		// xyz => /WEB-INF/jsp/ + xyz + .jsp
		viewResolver.setPrefix("/WEB-INF/jsp/");
		viewResolver.setSuffix(".jsp");
		return viewResolver;
	}
	/**
	 * sessionFactory的获取
	 * @param dataSource
	 * @return
	 */
	@Bean
	public SqlSessionFactoryBean sqlSessionFactoryBean(DataSource dataSource) {
		SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
		factoryBean.setConfigLocation(new ClassPathResource("rpm-config.xml"));
		factoryBean.setDataSource(dataSource);
		return factoryBean;
	}
	/**
	 * 数据源的配置
	 * @param env
	 * @return
	 */
	@Bean                       // 依赖Environment
	public DataSource dataSource(Environment env) {
		DriverManagerDataSource ds = new DriverManagerDataSource();
		// env.getProperty("someKey") 获得属性值
		ds.setDriverClassName(env.getProperty("jdbc.driverClassName"));
		ds.setUrl(env.getProperty("jdbc.url"));
		ds.setUsername(env.getProperty("jdbc.username"));
		ds.setPassword(env.getProperty("jdbc.password"));
		return ds;
	}
	/**
	 * 事务的配置
	 * @param dataSource
	 * @return
	 */
	@Bean
	public PlatformTransactionManager transactionManager(DataSource dataSource) {
		DataSourceTransactionManager manager = new DataSourceTransactionManager();
		manager.setDataSource(dataSource);
		return manager;
	}
	/**
	 * 静态资源的配置
	 * @param registry
	 */
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		// /assets/css/app.css -> /WebContent/public/css/app.css
		// /assets/js/app.js -> /WebContent/public/js/app.js
		// /WebContent/public/
		registry.addResourceHandler("/assets/**").addResourceLocations("/public/");
		//扫描public下的文件，public与assets是映射关系
	}


}
