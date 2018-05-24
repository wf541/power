package com.wf.dao;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserDao {

	int create(Reg reg);

	Reg findReg(String userName);
	
	Login findSearch(String username);

	

	List<Commodity> findCommodity();

	Commodity findDetails(Long id);

	

	



	void delCom(List<Long> commodityId);



	
}
