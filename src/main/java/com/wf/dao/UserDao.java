package com.wf.dao;

import com.wf.entity.Reg;

public interface UserDao {

	void create(Reg reg);

	Reg findSearch(Reg reg);

}
