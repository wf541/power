package com.wf.dao;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.OrderItem;
import com.wf.entity.Vip;

public interface VipDao {
	List<OrderItem> findVipOrder(Long id);
	OrderItem findXiaofei(Long id);
	Long createOrders(Long userId, Long addressId);


	List<Car> searchCarId(List<Long> carId);

	void creatVip(Vip vip);
	Vip findVip(Long id);
	

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress(Long id);


	Address findOne(Long id);
	

	List<Address> findprovinces();

	

	
	void changePwd(String pwd1, Long id);
	void createOrder(OrderItem orderItem);
	void delCom(Long carIde);
}
