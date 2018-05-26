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
import org.springframework.transaction.annotation.Transactional;

import com.wf.dao.UserDao;
import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;



@Service
@Transactional
public class UserServiceImpl implements UserService,UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	
	public UserServiceImpl(UserDao userDao,BCryptPasswordEncoder passwordEncoder) {
		this.userDao = userDao;
		this.passwordEncoder = passwordEncoder;
	}

//注册
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

	

//登录有关
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Login login = userDao.findSearch(username);
		if (login == null) {
			throw new UsernameNotFoundException(username);
		}
		UserDetailsImpl userDetailsImpl = new UserDetailsImpl(login); 
		return userDetailsImpl;
	}



//购物车


	@Override
	public void delCom(List<Long> commodityId) {
		// TODO Auto-generated method stub
		userDao.delCom(commodityId);
	}

}	
//登录有关
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
