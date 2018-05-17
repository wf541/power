package com.wf.service;


import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserService {


	String register(Reg reg);



	void creatVip(Vip vip);


	Vip findVip(Long id);

	void creatAddress(Address address);

	void updateAddress(Address address);

	List<Address> findAddress(Long id);

	Address findOne(Long id);



	void changePwd(String pwd1, Long id);



	List<Address> findprovinces();



	List<Address> findcitys();



	List<Address> findareas();

	
}
