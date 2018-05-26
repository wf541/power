package com.wf.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.provisioning.UserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDeatilsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// 忽略对支付宝异步通知的CSRF token检查
				http.csrf().ignoringAntMatchers("/alipay/cb/async");
		// Fluent API
		http.authorizeRequests()
			.antMatchers("/admin/**").access("isFullyAuthenticated() and hasRole('ADMIN')")
			.antMatchers("/assets/**", "/login","/reg","/alipay/**").permitAll()
			.antMatchers("/**").authenticated()
			
			.and()
			.formLogin() // 使用表单登录
			.loginPage("/login")// 指定登录页面所在的地址
			.defaultSuccessUrl("/prolist")//默认登陆成功的页面
			
			.and()
			.rememberMe() // 记住我配置
			.tokenValiditySeconds(3 * 24 * 3600) // 有效期3天
			.userDetailsService(userDeatilsService);
	}
}
