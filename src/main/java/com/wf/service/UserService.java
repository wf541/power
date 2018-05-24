package com.wf.service;


import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserService {


	String register(Reg reg);



	void creatVip(Vip vip);


	Vip findVip(Long id);

	void creatAddress(Address address);

	void updateAddress(Address address);

	List<Address> findAddress(Long id);

	Address findOne(Long id);



	void changePwd(String pwd1, Long id);



	List<Address> findprovinces();



	List<Address> findcitys();



	List<Address> findareas();



	List<Commodity> findCommodity();



	Commodity findDetails(Long id);



	List<Order> findVipOrder(Long id);



	Order findXiaofei(Long id);



	void del(Long id);



	void addCar(Long id, Long userId);



	List<Car> findAllCar(Long userid);



	void addCount(Long id);



	Car findOneCar(Long id);



	void jianCount(Long id);






	void delCom(List<Long> commodityId);



	void createOrder(Long addressId, List<Long> orderId);

	
}
