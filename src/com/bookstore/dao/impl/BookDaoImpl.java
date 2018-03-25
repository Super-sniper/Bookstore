package com.bookstore.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import com.bookstore.bean.Book;
import com.bookstore.bean.QueryResult;
import com.bookstore.dao.BookDao;
import com.bookstore.utils.JdbcUtils;


public class BookDaoImpl implements BookDao {
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.BookDao#add(com.bookstore.bean.Book)
	 */
	@Override
	public void add(Book b){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into tb_book(id,name,price,author,image,description,tb_category_id) values(?,?,?,?,?,?,?)";
			Object params[] = {b.getId(),b.getName(),b.getPrice(),b.getAuthor(),b.getImage(),b.getDescription(),b.getCategory().getId()};
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.BookDao#find(java.lang.String)
	 */
	@Override
	public Book find(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_book where id=?";
			return (Book) runner.query(conn, sql, id, new BeanHandler(Book.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private List<Book> getAll(int index,int pageSize,String where,Object param){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			if(where==null||where.trim().equals("")){
				String sql = "select * from tb_book limit ?,?";
				Object params[] = {index,pageSize};
				return (List<Book>) runner.query(conn, sql, params,new BeanListHandler(Book.class));
			}else{
				String sql = "select * from tb_book "+where+" limit ?,?";
				Object param1[] = {param,index,pageSize};
				return (List<Book>)runner.query(conn,sql, param1, new BeanListHandler(Book.class));
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	private int getPageTotalRecord(String where,Object param){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			if(where==null||where.trim().equals("")){
				String sql = "select count(*) from tb_book";
				return  ((Long)runner.query(conn, sql,new ScalarHandler())).intValue();
			}else{
				String sql = "select count(*) from tb_book "+where;

				return  ((Long)runner.query(conn,sql, param, new ScalarHandler())).intValue();
			}
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}


	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.BookDao#pageQuery(int, int, java.lang.String, java.lang.Object)
	 */
	@Override
	public QueryResult pageQuery(int index,int pageSize,String where,Object param){
		List list = getAll(index,pageSize,where,param);
		int totalRecord = getPageTotalRecord(where, param);
		QueryResult queryresult = new QueryResult();
		queryresult.setList(list);
		queryresult.setTotalRecord(totalRecord);
		return queryresult;
	}
	
	public List getAllBooks(){
		try{
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_book";
			return (List) runner.query(conn,sql,new  BeanListHandler(Book.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
