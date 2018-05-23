package com.wf.dao;

import java.util.List;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserDao {

	int create(Reg reg);

	Reg findReg(String userName);


	void creatVip(Vip vip);


	Vip findVip(Long id);

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress(Long id);

	Login findSearch(String username);

	Address findOne(Long id);

	void changePwd(String pwd1, Long id);

	List<Address> findAllAddress();

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

}
