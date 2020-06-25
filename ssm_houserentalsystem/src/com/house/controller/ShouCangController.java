package com.house.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.house.dao.HouseMapper;
import com.house.dao.ShoucangMapper;
import com.house.entity.House;
import com.house.entity.Page;
import com.house.entity.Shoucang;
import com.house.entity.ShoucangExample;
import com.house.entity.UserShoucangData;
import com.house.entity.ShoucangExample.Criteria;
import com.house.entity.Users;
import com.house.service.IHouserService;


@Controller
public class ShouCangController {

	@Autowired
	ShoucangMapper shoucangMapper;
	
	@Autowired
	HouseMapper houseMapper;

	@RequestMapping("/myshoucang")
	public String toShouCangPage() {
		return "myshoucang.jsp";
	}

	@RequestMapping("/addshoucang")
	@ResponseBody
	public String addShouCang(String id,HttpServletRequest request) {
		Users u = (Users) request.getSession().getAttribute("loginUser");
		try {
			if(u == null) {
				return "LOGIN";
			}

			ShoucangExample shoucangExample = new ShoucangExample();
			Criteria criteria = shoucangExample.createCriteria();
			criteria.andHidEqualTo(Integer.parseInt(id));
			criteria.andUidEqualTo(u.getuID());
			List<Shoucang> list = shoucangMapper.selectByExample(shoucangExample);
			if(list != null && list.size()>0) {
				return "HAS";
			}
			Shoucang shoucang = new Shoucang();
			shoucang.setHid(Integer.parseInt(id));
			shoucang.setUid(u.getuID());
			shoucang.setTime(new Date());
			int n = shoucangMapper.insert(shoucang);
			if(n>0) {
				return "OK";
			}
		} catch (NumberFormatException e) {
			e.printStackTrace();
		}
		return "FAIL";
	}

	@RequestMapping("/myshoucanginfo")
	@ResponseBody
	public UserShoucangData myshoucanginfo(int page,int limit,HttpServletRequest request){
		Users u = (Users) request.getSession().getAttribute("loginUser");
		UserShoucangData uod = new UserShoucangData();
		ShoucangExample shoucangExample = new ShoucangExample();
		Criteria criteria = shoucangExample.createCriteria();
		criteria.andUidEqualTo(u.getuID());
		List<Shoucang> list = shoucangMapper.selectByExample(shoucangExample);
		uod.setCount(list==null? 0:list.size());
		for(Shoucang shoucang:list) {
			House house = houseMapper.findHouseDetailsById(shoucang.getHid());
			shoucang.setCommunityName(house.getCommunityName());
			shoucang.setHouseAddress(house.gethouseAddress());
			shoucang.setHouseArea(house.getHouseArea());
			shoucang.setHouseDesc(house.getHouseDesc());
			shoucang.setHouseFloor(house.getHouseFloor());
			shoucang.setHouseLinkMan(house.getHouseLinkMan());
			shoucang.setHouseModel(house.getHouseModel());
			shoucang.setHouseOriented(house.getHouseOriented());
			shoucang.setHousePrice(house.getHousePrice());
			shoucang.setHouseType(house.getHouseType());
		}
		uod.setCode(0);
		uod.setData(list);
		uod.setMsg("200");
		return  uod;
	}

	@RequestMapping("/deleteShoucang")
	@ResponseBody
	public String deleteShoucang(int id) {
		int n = shoucangMapper.deleteByPrimaryKey(id);
		if(n>0)
			return "OK";
		return "FAIL";
	}
}
