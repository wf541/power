package com.wf.dao.mabaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.security.access.method.P;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserMapper {

	int create(Reg reg);

	Reg findReg(String userName);
	
	Login findSearch1(String userName);
	
	


	void delCom(List<Long> commodityId);


	
	
}
