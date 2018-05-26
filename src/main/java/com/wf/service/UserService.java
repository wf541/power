package com.wf.service;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserService {

	String register(Reg reg);

	

	void delCom(List<Long> commodityId);

	

}
