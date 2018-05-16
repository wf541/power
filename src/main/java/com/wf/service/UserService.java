package com.wf.service;


import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserService {


	void register(Reg reg);

	Reg findSearch(Reg reg);


	void creatVip(Vip vip);

	Login findSearch(Login login);

	Vip findVip(Long id);

	void creatAddress(Address address);

	void updateAddress(Address address);

	List<Address> findAddress(Long id);
	
}
