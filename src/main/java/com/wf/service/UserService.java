package com.wf.service;


import com.wf.entity.Reg;

public interface UserService {


	void register(Reg reg);

	Reg findSearch(Reg reg);
	
}
