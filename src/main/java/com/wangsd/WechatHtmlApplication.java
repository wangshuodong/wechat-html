package com.wangsd;

import com.wangsd.common.base.MyMapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication
@ServletComponentScan
//启注解事务管理
@EnableTransactionManagement  // 启注解事务管理，等同于xml配置方式的 <tx:annotation-driven />
@MapperScan(basePackages = "com.wangsd.web.dao", markerInterface = MyMapper.class)
public class WechatHtmlApplication extends SpringBootServletInitializer {

	/**
	 * 需要类似于web.xml的配置方式来启动spring上下文了
	 * 修改启动类，继承 SpringBootServletInitializer 并重写 configure 方法
	 * @param application
	 * @return
	 */
	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(WechatHtmlApplication.class);
	}

	public static void main(String[] args) {
		SpringApplication.run(WechatHtmlApplication.class, args);
	}
}
