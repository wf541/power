package com.wf.dao.mabaties.mappers;

import com.wf.entity.Reg;

public interface UserMapper {

	void create(Reg reg);

	Reg findSearch(Reg reg);
	
}
