package com.bookstore.dao;

import java.util.List;

import com.bookstore.bean.Book;
import com.bookstore.bean.QueryResult;

public interface BookDao {

	void add(Book b);

	Book find(String id);

	QueryResult pageQuery(int index, int pageSize, String where, Object param);

	List getAllBooks();
}