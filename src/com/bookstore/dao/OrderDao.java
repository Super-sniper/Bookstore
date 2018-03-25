package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Orders;

public interface OrderDao {

	void add(Orders o);

	Orders find(String id);

	/**
	 * @param state
	 * @return
	 * state:true=�ѷ���
	 * state:false=δ����
	 */
	List<Orders> getAll(boolean state);
	
	/*
	 * �����û��ҳ����ж���
	 */
	List<Orders> getAllByUserID(String id);
	
   void update(String id,boolean state);
}