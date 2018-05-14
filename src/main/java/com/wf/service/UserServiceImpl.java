package com.wf.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wf.dao.UserDao;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;
@Service
public class UserServiceImpl implements UserService {
	
	private UserDao userDao;
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDao userDao,BCryptPasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public void register(Reg reg) {
		String userName = reg.getUserName();
		String password = reg.getPassword();
		//弄成密文注入
		reg.setEncode(passwordEncoder.encode(password));
		System.out.println(userName);
		userDao.create(reg);
		System.out.println(password);
	}


	@Override
	public Reg findSearch(Reg reg) {
		Reg test = userDao.findSearch(reg);
		System.out.println("service:"+test);
		return test;
	}


	@Override
	public void creatVip(Vip vip) {
		userDao.creatVip(vip);		
	}


	@Override
	public Login findSearch(Login login) {
		// TODO Auto-generated method stub
		return userDao.findSearch(login);
	}

}
