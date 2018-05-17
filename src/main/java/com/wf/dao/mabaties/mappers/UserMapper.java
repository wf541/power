package com.wf.dao.mabaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserMapper {

	int create(Reg reg);

	Reg findReg(String userName);
	
	Login findSearch1(String userName);


	void creatVip(Vip vip);

	Vip findSearch2(Long id);

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress(Long id);

	Address findOne(Long id);

	void changePwd(@Param("pwd1") String pwd1,@Param("id") Long id);
	
}
