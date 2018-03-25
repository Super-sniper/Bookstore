package com.bookstore.dao.impl;

import java.sql.Connection;
import java.util.List;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bookstore.bean.Category;
import com.bookstore.dao.CategoryDao;
import com.bookstore.utils.JdbcUtils;

public class CategoryDaoImpl implements CategoryDao {
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.CategoryDao#add(com.bookstore.bean.Category)
	 */
	@Override
	public void add(Category c){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into tb_category(id,name,description) values(?,?,?)";
			Object params[] = {c.getId(),c.getName(),c.getDescription()};
			runner.update(conn,sql,params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.CategoryDao#find(java.lang.String)
	 */
	@Override
	public Category find(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_category where id=?";
			return (Category) runner.query(conn, sql, id,new BeanHandler(Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.CategoryDao#getAll()
	 */
	@Override
	public List<Category> getAll(){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_category";
			return (List) runner.query(conn, sql, new BeanListHandler(Category.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
}
