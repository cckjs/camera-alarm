package com.young.java.config;

import java.io.IOException;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
@ComponentScan("com.isoftstone.paperetl.service.*.dao")
@PropertySource(name = "db", value = { "classpath:db/db.properties" })
@ImportResource("classpath:spring/mybatis.xml")
public class MyBatisConfig {

	@Bean
	public DataSource dataSource() {
		DriverManagerDataSource dataSource = new DriverManagerDataSource();
		try {
			ResourcePropertySource env = new ResourcePropertySource("resource",
					"classpath:db/db.properties");
			org.springframework.util.Assert.notNull(env, "数据库环境信息不可以为空");
			dataSource.setDriverClassName((String) env
					.getProperty("jdbc.driverClassName"));
			dataSource.setUrl((String) env.getProperty("jdbc.url"));
			dataSource.setUsername((String) env.getProperty("jdbc.username"));
			dataSource.setPassword((String) env.getProperty("jdbc.password"));
		} catch (IOException e) {
			throw new RuntimeException("读取数据库配置文件出�?");
		}
//		org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		return dataSource;
	}
}
