package com.wf.dao.mabaties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.dao.UserDao;
import com.wf.dao.mabaties.mappers.UserMapper;
import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

import ch.qos.logback.core.net.SyslogOutputStream;
@Repository
public class UserDaoImpl implements UserDao {
	private UserMapper userMapper;
	
	@Autowired
	public UserDaoImpl(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public void create(Reg reg) {
		userMapper.create(reg);
	}

	@Override
	public Reg findSearch(Reg reg) {
		// TODO Auto-generated method stub
		Reg test = userMapper.findSearch(reg.getUserName());
		return test;
	}


	@Override
	public void creatVip(Vip vip) {
		userMapper.creatVip(vip);		
	}

	@Override
	public Login findSearch(Login login) {
		// TODO Auto-generated method stub
		return userMapper.findSearch1(login.getUserName());
	}

	@Override
	public Vip findSearch(Vip vip) {
		// TODO Auto-generated method stub
		return userMapper.findSearch2(vip.getId());
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		userMapper.updateAddress(address);
	}

	@Override
	public void creatAddress() {
		// TODO Auto-generated method stub
		userMapper.creatAddress();
	}

	@Override
	public List<Address> findAddress() {
		// TODO Auto-generated method stub
		
		return userMapper.findAddress();
	}



}
