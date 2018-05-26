package com.wf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wf.dao.CarDao;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
@Service
@Transactional
public class CarServiceImpl implements CarService {
	private CarDao carDao;
@Autowired
	public CarServiceImpl(CarDao carDao) {
	super();
	this.carDao = carDao;
}

	@Override
	public void del(Long id) {
		carDao.del(id);
	}

	@Override
	public void addCar(Long id, Long userId) {
		carDao.addCar(id,userId);
	}

	@Override
	public List<Car> findAllCar(Long userid) {
		return carDao.findAllCar(userid);
	}

	@Override
	public void addCount(Long id) {
		carDao.addCount(id);
	}

	@Override
	public Car findOneCar(Long id) {
		return carDao.findOneCar(id);
	}

	@Override
	public void jianCount(Long id) {
		carDao.jianCount(id);
	}

	@Override
	public List<Commodity> findCommodity() {
		return carDao.findCommodity();
	}

}
