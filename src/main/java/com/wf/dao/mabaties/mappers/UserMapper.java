package com.wf.dao.mabaties.mappers;

import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserMapper {

	void create(Reg reg);

	Reg findSearch(String userName);
	
	Login findSearch1(String userName);


	void creatVip(Vip vip);
	
}
