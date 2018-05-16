package com.wf.service;


import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.wf.dao.UserDao;
import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;
@Service
public class UserServiceImpl implements UserService,UserDetailsService {
	
	private UserDao userDao;
//	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	public UserServiceImpl(UserDao userDao) {
		this.userDao = userDao;
//		this.passwordEncoder = passwordEncoder;,BCryptPasswordEncoder passwordEncoder
	}


	@Override
	public void register(Reg reg) {
		String userName = reg.getUserName();
		String password = reg.getPassword();
		//弄成密文注入
//		reg.setEncode(passwordEncoder.encode(password));
		reg.setEncode(password);
		userDao.create(reg);
	}


	@Override
	public Reg findSearch(Reg reg) {
		Reg test = userDao.findSearch(reg);
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


	@Override
	public Vip findVip(Long id) {
		// TODO Auto-generated method stub
		return userDao.findVip(id);
	}


	@Override
	public void creatAddress(Address address) {
		// TODO Auto-generated method stub
		userDao.creatAddress(address);
	}


	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		userDao.updateAddress(address);
	}


	@Override
	public List<Address> findAddress(Long id) {
		// TODO Auto-generated method stub
		
		return userDao.findAddress(id);
	}


	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = userDao.findSearch(username);
		System.out.println("--- loadUserByUsername login: " + login + ", " + username);
		if (login == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(login); 
		System.out.println("--- loadUserByUsername " + userDetailsImpl);
		return userDetailsImpl;
	}

}

class UserDetailsImpl extends org.springframework.security.core.userdetails.User {

	private static final long serialVersionUID = 1L;
	
	private Login login;

	public Login getLogin() {
		return login;
	}

	public UserDetailsImpl(Login login) {
		super(login.getUserName(),login.getEncode(),
				Arrays.asList(new SimpleGrantedAuthority("ROLE_USER")));
		this.login = login;
	}

	@Override
	public String toString() {
		return "UserDetailsImpl [login=" + login + "]";
	}
	
	
}
