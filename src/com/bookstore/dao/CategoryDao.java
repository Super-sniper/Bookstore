package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Category;

public interface CategoryDao {

	void add(Category c);

	Category find(String id);

	List getAll();

}