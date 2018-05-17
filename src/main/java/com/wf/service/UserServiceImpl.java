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
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(UserDao userDao,BCryptPasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}


	@Override
	public String register(Reg reg) {
		//弄成密文注入
		reg.setEncode(passwordEncoder.encode(reg.getPassword()));
		//判断用户是否存在
		Reg tem = userDao.findReg(reg.getUserName());
		if(tem != null){
			return "The username has already existed";
		}
		else{
			int i = userDao.create(reg);
			if(i<1)
				return "error";
		}
		return "success";
	}




	@Override
	public void creatVip(Vip vip) {
		userDao.creatVip(vip);		
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
		if (login == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(login); 
		return userDetailsImpl;
	}


	@Override
	public Address findOne(Long id) {
		// TODO Auto-generated method stub
		
		return userDao.findOne(id);
	}


	@Override
	public void changePwd(String pwd1, Long id) {
		// TODO Auto-generated method stub
		pwd1 = passwordEncoder.encode(pwd1);
		userDao.changePwd(pwd1,id);
	}


	@Override
	public List<Address> findprovinces() {
		// TODO Auto-generated method stub
		return userDao.findprovinces();
	}


	@Override
	public List<Address> findcitys() {
		// TODO Auto-generated method stub
		return userDao.findcitys();
	}


	@Override
	public List<Address> findareas() {
		// TODO Auto-generated method stub
		return userDao.findareas();
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
