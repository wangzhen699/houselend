package com.house.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.house.entity.Order;
import com.house.entity.Page;
import com.house.entity.UserOrder;

public interface OrderMapper {
	/**
	 *   添加房屋订单
	 * @param order
	 * @return
	 */
	 public int addOrder(Order order);
	 /**
	  * 查询所有订单信息
	  * @return
	  */
	 public List<UserOrder> findAllOrder(Page page);
	 
	 /**
	  * 查询我发布的房子的订单
	  * @return
	  */
	 public List<UserOrder> findMyHouseOrder(Page page);
	 /**
	  * 查询所有订单数
	  * @return
	  */
	 public int getOrderCount(int uID);
	 public int getOrderCountfz(int uID);
	 public int getOrderCountfk(int uID);
	 
	 public List<UserOrder> getOrderByHId(int hId);
	 /**
	  * 删除用户订单
	  * @param oID
	  * @return
	  */
	 public int deleteOrder(int oID);
	 
	 public int okOrder(int oID);
	 
	 public int noOrder(int oID);
	 
	 public int finshOrder(int oID);
	 
	 public int restartOrder(int oID);
	 
}
