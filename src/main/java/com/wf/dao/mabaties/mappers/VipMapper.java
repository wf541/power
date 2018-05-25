package com.wf.dao.mabaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Order;
import com.wf.entity.OrderItem;
import com.wf.entity.Vip;

public interface VipMapper {
	void creatVip(Vip vip);

	Vip findSearch2(Long id);

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress(Long id);

	Address findOne(Long id);

	void changePwd(@Param("pwd1") String pwd1,@Param("id") Long id);


	List<Address> findprovinces();


	
	
	void createOrders(Order order);

	
	List<OrderItem> findVipOrder(Long id);

	OrderItem findXiaofei(Long id);

	List<Car> searchCarId(@Param("carId") List<Long> carId);

	void createOrder(OrderItem orderItem);


	void delCom(@Param("carId") Long carIde);


}
