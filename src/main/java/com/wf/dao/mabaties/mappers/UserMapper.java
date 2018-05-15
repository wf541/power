package com.wf.dao.mabaties.mappers;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserMapper {

	void create(Reg reg);

	Reg findSearch(String userName);
	
	Login findSearch1(String userName);


	void creatVip(Vip vip);

	Vip findSearch2(Long id);

	void updateAddress(Address address);

	void creatAddress();

	List<Address> findAddress();
	
}
