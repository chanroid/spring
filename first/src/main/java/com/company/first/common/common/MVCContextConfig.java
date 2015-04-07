package com.company.first.common.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.BeanNameViewResolver;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
import org.springframework.web.servlet.view.JstlView;
import org.springframework.web.servlet.view.json.MappingJacksonJsonView;

import com.company.first.common.logger.LoggerInterceptor;

/**
 * MVC 설정용 클래스. 이 클래스는 스프링의 servlet-context.xml 의 역할을 대신한다.
 */
@Configuration

//mvc:annotation-driven
@EnableWebMvc

//task:annotation-driven
@EnableAsync

//context:component-scan
@ComponentScan(basePackages = "com.company.first", excludeFilters = @ComponentScan.Filter(Configuration.class))
public class MVCContextConfig extends WebMvcConfigurerAdapter {

	@Bean
	public ViewResolver viewResolver() {
		// UrlBasedViewResolver resolver = new UrlBasedViewResolver();
		InternalResourceViewResolver resolver = new InternalResourceViewResolver();
		resolver.setPrefix("/WEB-INF/jsp/first");
		resolver.setSuffix(".jsp");
		resolver.setOrder(0);
		resolver.setViewClass(JstlView.class);
		return resolver;
	}
	
	@Bean
	public BeanNameViewResolver beanNameResolver() {
		BeanNameViewResolver resolver = new BeanNameViewResolver();
		resolver.setOrder(0);
		return resolver;
	}
	
	@Bean
	public MappingJacksonJsonView jsonView() {
		MappingJacksonJsonView jsonView = new MappingJacksonJsonView();
		return jsonView;
	}

	/**
	 * 인터셉터 추가
	 */
	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(new LoggerInterceptor());
	}
}
