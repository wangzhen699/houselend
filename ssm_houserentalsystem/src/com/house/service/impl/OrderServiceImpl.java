package com.house.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.house.dao.OrderMapper;
import com.house.entity.Order;
import com.house.entity.Page;
import com.house.entity.UserOrder;
import com.house.service.IOrderService;

@Service
public class OrderServiceImpl implements IOrderService{

	@Autowired
	private OrderMapper mapper;
	
	@Override
	public int addOrder(Order order) {
		return mapper.addOrder(order);
	}

	@Override
	public List<UserOrder> findAllOrder(Page page) {
		return mapper.findAllOrder(page);
	}

	@Override
	public int getOrderCount(int uID) {
		return mapper.getOrderCount(uID);
	}

	@Override
	public int deleteOrder(int oID) {
		return mapper.deleteOrder(oID);
	}

	@Override
	public int okOrder(int oID) {
		// TODO Auto-generated method stub
		return mapper.okOrder(oID);
	}

	@Override
	public int noOrder(int oID) {
		// TODO Auto-generated method stub
		return mapper.noOrder(oID);
	}

	@Override
	public int finshOrder(int oID) {
		// TODO Auto-generated method stub
		return mapper.finshOrder(oID);
	}

	@Override
	public List<UserOrder> getOrderByHId(int hId) {
		// TODO Auto-generated method stub
		return mapper.getOrderByHId(hId);
	}

	@Override
	public List<UserOrder> findMyHouseOrder(Page page) {
		// TODO Auto-generated method stub
		return mapper.findMyHouseOrder(page);
	}

	@Override
	public int getOrderCountfz(int uID) {
		// TODO Auto-generated method stub
		return mapper.getOrderCountfz(uID);
	}

	@Override
	public int getOrderCountfk(int uID) {
		// TODO Auto-generated method stub
		return mapper.getOrderCountfk(uID);
	}

	@Override
	public int restartOrder(int oID) {
		// TODO Auto-generated method stub
		return mapper.restartOrder(oID);
	}

}
