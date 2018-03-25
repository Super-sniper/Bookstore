package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Orders;

public interface OrderDao {

	void add(Orders o);

	Orders find(String id);

	/**
	 * @param state
	 * @return
	 * state:true=已发货
	 * state:false=未发货
	 */
	List<Orders> getAll(boolean state);
	
	/*
	 * 根据用户找出所有订单
	 */
	List<Orders> getAllByUserID(String id);
	
   void update(String id,boolean state);
}