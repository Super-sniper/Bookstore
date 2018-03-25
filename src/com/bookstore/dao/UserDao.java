package com.bookstore.dao;

import com.bookstore.bean.User;

public interface UserDao {

	void add(User u);

	User findById(String id);

	User find(String username, String password);

}