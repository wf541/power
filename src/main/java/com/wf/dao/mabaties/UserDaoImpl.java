package com.wf.dao.mabaties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.dao.UserDao;
import com.wf.dao.mabaties.mappers.UserMapper;
import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
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
	public Login findSearch(String username) {
		// TODO Auto-generated method stub
		return userMapper.findSearch1(username);
	}

	
	
	

	@Override
	public void delCom(List<Long> commodityId) {
		// TODO Auto-generated method stub
		userMapper.delCom(commodityId);
	}


}
