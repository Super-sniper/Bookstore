package com.bookstore.service;

import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.Car;
import com.bookstore.bean.Category;
import com.bookstore.bean.Orders;
import com.bookstore.bean.PageBean;
import com.bookstore.bean.QueryInfo;
import com.bookstore.bean.User;

public interface BusinessService {

	/***************
	 * 提供分类相关的服务
	 ***************/
	void addCategory(Category c);

	Category findCategory(String id);

	List<Category> getAllCategory();

	/*****************
	 * 提供图书相关的服务
	 *****************/
	void addBook(Book book);

	Book findBook(String id);

	PageBean pageQuery(QueryInfo info);
	
	List getAllBook();

	/*****************
	 * 提供订单相关的服务
	 *****************/
	//用户的购物车产生订单，并保存数据
	void saveOrder(Car car, User user);

	Orders findOrder(String id);

	List<Orders> getAllOrder(boolean state);

	public List<Orders> getAllOrder(String id);
	
	void updateState(String id,boolean state);
	/****************
	 * 提供用户相关的服务
	 ****************/
	void addUser(User u);

	User findUser(String id);

	User findUser(String username, String password);

}