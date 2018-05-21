package com.wf.dao.mabaties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.dao.UserDao;
import com.wf.dao.mabaties.mappers.UserMapper;
import com.wf.entity.Address;
import com.wf.entity.Commodity;
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
	public int create(Reg reg) {
		
		return userMapper.create(reg);
	}

	@Override
	public Reg findReg(String userName) {
		// TODO Auto-generated method stub
		Reg test = userMapper.findReg(userName);
		return test;
	}


	@Override
	public void creatVip(Vip vip) {
		userMapper.creatVip(vip);		
	}


	@Override
	public Vip findVip(Long id) {
		// TODO Auto-generated method stub
		return userMapper.findSearch2(id);
	}

	@Override
	public void updateAddress(Address address) {
		// TODO Auto-generated method stub
		userMapper.updateAddress(address);
	}

	@Override
	public void creatAddress(Address address) {
		// TODO Auto-generated method stub
		userMapper.creatAddress(address);
	}

	@Override
	public List<Address> findAddress(Long id) {
		// TODO Auto-generated method stub
		
		return userMapper.findAddress(id);
	}

	@Override
	public Login findSearch(String username) {
		// TODO Auto-generated method stub
		return userMapper.findSearch1(username);
	}

	@Override
	public Address findOne(Long id) {
		// TODO Auto-generated method stub
		
		return userMapper.findOne(id);
	}

	@Override
	public void changePwd(String pwd1, Long id) {
		// TODO Auto-generated method stub
		userMapper.changePwd(pwd1,id);
	}

	@Override
	public List<Address> findAllAddress() {
		// TODO Auto-generated method stub
		return userMapper.findAllAddress();
	}

	@Override
	public List<Address> findprovinces() {
		// TODO Auto-generated method stub
		return userMapper.findprovinces();
	}

	@Override
	public List<Address> findcitys() {
		// TODO Auto-generated method stub
		return userMapper.findcitys();
	}

	@Override
	public List<Address> findareas() {
		// TODO Auto-generated method stub
		return userMapper.findareas();
	}

	@Override
	public List<Commodity> findCommodity() {
		// TODO Auto-generated method stub
		return userMapper.findCommodity();
	}

	@Override
	public Commodity findDetails(Long id) {
		// TODO Auto-generated method stub
		return userMapper.findDetails(id);
	}

	@Override
	public List<Address> findVipOrder(Long id) {
		// TODO Auto-generated method stub
		return userMapper.findVipOrder(id);
	}



}
