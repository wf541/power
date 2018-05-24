package com.wf.dao.mabaties.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Login;
import com.wf.entity.Order;
import com.wf.entity.Reg;
import com.wf.entity.Vip;

public interface UserMapper {

	int create(Reg reg);

	Reg findReg(String userName);
	
	Login findSearch1(String userName);


	void creatVip(Vip vip);

	Vip findSearch2(Long id);

	void updateAddress(Address address);

	void creatAddress(Address address);

	List<Address> findAddress(Long id);

	Address findOne(Long id);

	void changePwd(@Param("pwd1") String pwd1,@Param("id") Long id);

	List<Address> findAllAddress();

	List<Address> findprovinces();

	List<Address> findcitys();

	List<Address> findareas();

	List<Commodity> findCommodity();

	Commodity findDetails(Long id);

	List<Order> findVipOrder(Long id);

	Order findXiaofei(Long id);

	void del(Long id);

	void addCar(@Param("commodityId") Long id,@Param("regId") Long userId);

	List<Car> findAllCar(Long userid);

	void addCount(Long id);

	Car findOneCar(Long id);

	void jianCount(Long id);


	void delCom(List<Long> commodityId);

	void createOrder(@Param("addressId") Long addressId,@Param("orderId") List<Long> orderId);
	
}
