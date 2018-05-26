package com.wf.dao.mabaties;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.wf.dao.CarDao;
import com.wf.dao.mabaties.mappers.CarMapper;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
@Repository
public class CarDaoImpl implements CarDao {
private CarMapper carMapper;

@Autowired
	public CarDaoImpl(CarMapper carMapper) {
	super();
	this.carMapper = carMapper;
}

	@Override
	public void del(Long id) {
		carMapper.del(id);
	}

	@Override
	public void addCar(Long id, Long userId) {
		carMapper.addCar(id,  userId);
	}

	@Override
	public List<Car> findAllCar(Long userid) {
		return carMapper.findAllCar(userid);
	}

	@Override
	public void addCount(Long id) {
		carMapper.addCount(id);
	}

	@Override
	public Car findOneCar(Long id) {
		return carMapper.findOneCar(id);
	}

	@Override
	public void jianCount(Long id) {
		carMapper.jianCount(id);
	}

	
	
	@Override
	public List<Commodity> findCommodity() {
		return carMapper.findCommodity();
	}
}
