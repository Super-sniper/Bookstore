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
	 * �ṩ������صķ���
	 ***************/
	void addCategory(Category c);

	Category findCategory(String id);

	List<Category> getAllCategory();

	/*****************
	 * �ṩͼ����صķ���
	 *****************/
	void addBook(Book book);

	Book findBook(String id);

	PageBean pageQuery(QueryInfo info);
	
	List getAllBook();

	/*****************
	 * �ṩ������صķ���
	 *****************/
	//�û��Ĺ��ﳵ��������������������
	void saveOrder(Car car, User user);

	Orders findOrder(String id);

	List<Orders> getAllOrder(boolean state);

	public List<Orders> getAllOrder(String id);
	
	void updateState(String id,boolean state);
	/****************
	 * �ṩ�û���صķ���
	 ****************/
	void addUser(User u);

	User findUser(String id);

	User findUser(String username, String password);

}