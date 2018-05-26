package com.wf.dao;

import java.util.List;

import com.wf.entity.Car;
import com.wf.entity.Commodity;

public interface CarDao {
	void del(Long id);

	void addCar(Long id, Long userId);

	List<Car> findAllCar(Long userid);

	void addCount(Long id);

	Car findOneCar(Long id);

	void jianCount(Long id);

	
	List<Commodity> findCommodity();
}
