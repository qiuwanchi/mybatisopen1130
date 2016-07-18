package com.secoo.mapper;

import java.util.List;

import com.secoo.entity.Orders;

public interface OrdersMapper {

	public List<Orders> findAllOrders();
	
	public List<Orders> findAllOrdersResultMap();
	
}
