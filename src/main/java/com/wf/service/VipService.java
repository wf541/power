package com.wf.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wf.entity.Address;
import com.wf.entity.Commodity;
import com.wf.entity.Order;
import com.wf.entity.OrderItem;
import com.wf.entity.Vip;
@Service
@Transactional
public interface VipService {
	List<OrderItem> findVipOrder(Long id);

	Order findXiaofei(Long id);
	
	void createOrders(Long userId, Long addressId, List<Long> carId);
	
	void creatVip(Vip vip);

	Vip findVip(Long id);
	

	void creatAddress(Address address);

	void updateAddress(Address address);

	List<Address> findAddress(Long id);

	Address findOne(Long id);
	
	void changePwd(String pwd1, Long id);

	List<Address> findprovinces();

	
	
	
}
