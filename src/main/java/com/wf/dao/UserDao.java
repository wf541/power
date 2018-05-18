package com.wf.dao;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserDao {

	int create(Reg reg);

	Reg findReg(String userName);


	void creatVip(Vip vip);


	Vip findVip(Long id);

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress(Long id);

	Login findSearch(String username);

	Address findOne(Long id);

	void changePwd(String pwd1, Long id);

	List<Address> findAllAddress();

	List<Address> findprovinces();

	List<Address> findcitys();

	List<Address> findareas();

	List<Commodity> findCommodity();

	Commodity findDetails(Long id);

}
