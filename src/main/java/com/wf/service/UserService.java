package com.wf.service;


import com.wf.entity.Login;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserService {


	void register(Reg reg);

	Reg findSearch(Reg reg);


	void creatVip(Vip vip);

	Login findSearch(Login login);

	Vip findSearch(Vip vip);
	
}
