package com.wf.service;

import java.util.List;

import com.wf.entity.Car;

public interface CarService {
	void del(Long id);

	void addCar(Long id, Long userId);

	List<Car> findAllCar(Long userid);

	void addCount(Long id);

	Car findOneCar(Long id);

	void jianCount(Long id);
}
