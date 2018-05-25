package com.wf.dao.mabaties;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.wf.dao.VipDao;
import com.wf.dao.mabaties.mappers.VipMapper;
import com.wf.entity.Address;
import com.wf.entity.Car;
import com.wf.entity.Commodity;
import com.wf.entity.Order;
import com.wf.entity.OrderItem;
import com.wf.entity.Vip;
@Repository

public class VipDaoImpl implements VipDao {
	
	private VipMapper vipMapper;
	
	
	public VipDaoImpl(VipMapper vipMapper) {
		super();
		this.vipMapper = vipMapper;
	}

	@Override
	public List<OrderItem> findVipOrder(Long id) {
		return vipMapper.findVipOrder(id);
	}

	@Override
	public OrderItem findXiaofei(Long id) {
		return vipMapper.findXiaofei(id);
	}

	@Override
	public Long createOrders(Long userId, Long addressId) {
		Order order = new Order();
		order.setRegId(userId);
		order.setAddressId(addressId);
		
		vipMapper.createOrders(order);
		return order.getId();
	}

	@Override
	public void createOrder(OrderItem orderItem) {
		vipMapper.createOrder(orderItem);
	}

	@Override
	public List<Car> searchCarId(List<Long> carId) {
		// TODO Auto-generated method stub
		return vipMapper.searchCarId(carId);
	}

	@Override
	public void creatVip(Vip vip) {
		vipMapper.creatVip(vip);	
	}

	@Override
	public Vip findVip(Long id) {
		return vipMapper.findSearch2(id);
	}

	@Override
	public void updateAddress(Address address) {
		vipMapper.updateAddress(address);
	}

	@Override
	public void creatAddress(Address address) {
		vipMapper.creatAddress(address);
	}

	@Override
	public List<Address> findAddress(Long id) {
		return vipMapper.findAddress(id);
	}

	@Override
	public Address findOne(Long id) {
		return vipMapper.findOne(id);
	}


	@Override
	public List<Address> findprovinces() {
		return vipMapper.findprovinces();
	}

	

	@Override
	public void changePwd(String pwd1, Long id) {
		vipMapper.changePwd(pwd1,id);
	}


	@Override
	public void delCom(Long carIde) {
		vipMapper.delCom(carIde);
	}

	

	

}
