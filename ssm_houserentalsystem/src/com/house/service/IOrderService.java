package com.house.service;

import java.util.List;

import com.house.entity.Order;
import com.house.entity.Page;
import com.house.entity.UserOrder;

public interface IOrderService {
	/**
	 * 添加订单信息
	 * @param order
	 * @return
	 */
	public int addOrder(Order order);
	
	/**
	  * 查询所有订单信息
	  * @return
	  */
	 public List<UserOrder> findAllOrder(Page page);
	 public List<UserOrder> findMyHouseOrder(Page page);
	 
	 public int getOrderCountfz(int uID);
	 public int getOrderCountfk(int uID);
 	 /**
	  * 查询单个用户所有订单
	  * @return
	  */
	 public int getOrderCount(int uID);
	 /**
	  * 删除用户订单
	  * @param oID
	  * @return
	  */
	 public int deleteOrder(int oID);
	 
	 public int okOrder(int oID);
	 
	 public int noOrder(int oID);
	 
	 public int finshOrder(int oID);
	 
	 public List<UserOrder> getOrderByHId(int hId);

	public int restartOrder(int oID);
}
