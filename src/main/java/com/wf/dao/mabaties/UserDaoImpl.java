package com.wf.dao.mabaties;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.dao.UserDao;
import com.wf.dao.mabaties.mappers.UserMapper;
import com.wf.entity.Reg;
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



}
