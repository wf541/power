package com.wf.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wf.dao.VipDao;
import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Order;
import com.wf.entity.OrderItem;
import com.wf.entity.Vip;
@Service
@Transactional
public class VipServiceImpl implements VipService {
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	private VipDao vipDao;
	
	

	public VipServiceImpl(BCryptPasswordEncoder passwordEncoder, VipDao vipDao) {
		super();
		this.passwordEncoder = passwordEncoder;
		this.vipDao = vipDao;
	}

	@Override
	public List<OrderItem> findVipOrder(Long id) {
		return vipDao.findVipOrder(id);
	}

	@Override
	public OrderItem findXiaofei(Long id) {
		return vipDao.findXiaofei(id);
	}

	@Override
	public void createOrders(Long userId, Long addressId, List<Long> carId) {
		Long orderId = vipDao.createOrders(userId, addressId);
//		根据购物车id查出商品id，数量
		List<Car> cars = vipDao.searchCarId(carId);
		
		for(Car car:cars){
			OrderItem orderItem=new OrderItem();
			orderItem.setCounts(car.getCounts());
			orderItem.setCommodityId(car.getCommodityId());
			orderItem.setOrderId(orderId);
			vipDao.createOrder(orderItem);
		}
		
	}
	

	@Override
	public void creatVip(Vip vip) {
		vipDao.creatVip(vip);	
	}

	@Override
	public Vip findVip(Long id) {
		return vipDao.findVip(id);
	}

	@Override
	public void creatAddress(Address address) {
		vipDao.creatAddress(address);
	}

	@Override
	public void updateAddress(Address address) {
		vipDao.updateAddress(address);
	}

	@Override
	public List<Address> findAddress(Long id) {
		return vipDao.findAddress(id);
	}

	@Override
	public Address findOne(Long id) {
		return vipDao.findOne(id);
	}

	@Override
	public void changePwd(String pwd1, Long id) {
		pwd1 = passwordEncoder.encode(pwd1);
		vipDao.changePwd(pwd1,id);
	}

	@Override
	public List<Address> findprovinces() {
		return vipDao.findprovinces();
	}

	@Override
	public void delCom(List<Long> carId) {
		vipDao.delCom(carId);		
	}

	

}
