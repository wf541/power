package com.wf.dao.mabaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wf.entity.Car;

public interface CarMapper {
	void del(Long id);

	void addCar(@Param("commodityId") Long id,@Param("regId") Long userId);

	List<Car> findAllCar(Long userid);

	void addCount(Long id);

	Car findOneCar(Long id);

	void jianCount(Long id);
}
