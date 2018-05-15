package com.wf.dao;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserDao {

	void create(Reg reg);

	Reg findSearch(Reg reg);


	void creatVip(Vip vip);

	Login findSearch(Login login);

	Vip findSearch(Vip vip);

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress();

}
