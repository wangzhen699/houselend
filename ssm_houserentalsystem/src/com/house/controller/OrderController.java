package com.house.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.entity.Order;
import com.house.entity.Page;
import com.house.entity.UserOrder;
import com.house.entity.UserOrderData;
import com.house.entity.Users;
import com.house.service.IHouserService;
import com.house.service.IOrderService;


@Controller
public class OrderController {

	@Autowired
	private IOrderService sevice;
	@Autowired
	private IHouserService houserService;

	@RequestMapping("/myorder")
	public String toOrderPage() {
		return "myorder.jsp";
	}
	
	@RequestMapping("/myhouseorder")
	public String toMyHouseOrderPage() {
		return "myhouseorder.jsp";
	}

	@RequestMapping("/updatepwd")
	public String toUpdatepwdPage() {
		return "updatepwd.jsp";
	}

	@RequestMapping("/addOrder")
	@ResponseBody
	public String addOrder(String id,HttpServletRequest request) {
		Users u = (Users) request.getSession().getAttribute("loginUser");
		try {
			Order order = new Order();
			order.sethID(Integer.parseInt(id));
			order.setOrderUser(u.getuNickName());
			order.setuID(u.getuID());
			order.setStatus(1);
			int huid = houserService.findHouseDetailsById(Integer.parseInt(id)).getUId();
 			order.setHuid(huid);
			Page p = new Page();
			p.setPage(0);
			p.setLimit(1000);
 			p.setuID(u.getuID());
			List<UserOrder> userOrders = sevice.getOrderByHId(Integer.parseInt(id));
			if(userOrders != null&&userOrders.size()>0) {
				return "NO";
			}
			int n = sevice.addOrder(order);
			if(n>0) {
				houserService.updateHouseStatus(1);
				return "OK";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

	@RequestMapping("/myOrderInfo")
	@ResponseBody
	public UserOrderData findAllOrder(int page,int limit,HttpServletRequest request){
		Page p = new Page();
		p.setPage((page - 1) * limit);
		p.setLimit(limit);
		Users u = (Users) request.getSession().getAttribute("loginUser");
		p.setuID(u.getuID());
		UserOrderData uod = new UserOrderData();
		List<UserOrder> order = sevice.findAllOrder(p);
		uod.setCode(0);
		uod.setCount(sevice.getOrderCountfk(u.getuID()));
		uod.setData(order);
		uod.setMsg("200");
		return  uod;
	}
	@RequestMapping("/myHouseOrderInfo")
	@ResponseBody
	public UserOrderData MyHouseOrderInfo(int page,int limit,HttpServletRequest request){
		Page p = new Page();
		p.setPage((page - 1) * limit);
		p.setLimit(limit);
		Users u = (Users) request.getSession().getAttribute("loginUser");
		p.setuID(u.getuID());
		UserOrderData uod = new UserOrderData();
		List<UserOrder> order = sevice.findMyHouseOrder(p);
		uod.setCode(0);
		uod.setCount(sevice.getOrderCountfz(u.getuID()));
		uod.setData(order);
		uod.setMsg("200");
		return  uod;
	}

	@RequestMapping("/deleteOrder")
	@ResponseBody
	public String deleteOrder(int oID) {
		int n = sevice.deleteOrder(oID);
		if(n>0)
			return "OK";
		return "FAIL";
	}
	@RequestMapping("/okOrder")
	@ResponseBody
	public String okOrder(int oID) {
		int n = sevice.okOrder(oID);
		if(n>0) {
			houserService.updateHouseStatus(2);
			return "OK";
		}
			
		return "FAIL";
	}
	@RequestMapping("/noOrder")
	@ResponseBody
	public String noOrder(int oID) {
		int n = sevice.noOrder(oID);
		if(n>0) {
			houserService.updateHouseStatus(3);
			return "OK";
		}
			
		return "FAIL";
	}
	@RequestMapping("/finshOrder")
	@ResponseBody
	public String finshOrder(int oID) {
		int n = sevice.finshOrder(oID);
		if(n>0) {
			houserService.updateHouseStatus(4);
			return "OK";
		}
		return "FAIL";
	}
	@RequestMapping("/restartOrder")
	@ResponseBody
	public String restartOrder(int oID) {
		int n = sevice.restartOrder(oID);
		if(n>0) {
			houserService.updateHouseStatus(1);
			return "OK";
		}
		return "FAIL";
	}
	
	@RequestMapping("/myinfo")
	public String myinfo() {
		return "myinfo.jsp";
	}

}
