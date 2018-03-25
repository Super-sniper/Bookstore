package com.bookstore.dao.impl;

import java.sql.Connection;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import com.bookstore.bean.Book;
import com.bookstore.bean.User;
import com.bookstore.dao.UserDao;
import com.bookstore.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.UserDao#add(com.bookstore.bean.User)
	 */
	@Override
	public void add(User u){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into tb_user(id,username,password,phone,cellphone,email,address) values(?,?,?,?,?,?,?)";
			Object params[] ={u.getId(),u.getUsername(),u.getPassword(),u.getPhone(),u.getCellphone(),u.getEmail(),u.getAddress()};
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.UserDao#findById(java.lang.String)
	 */
	@Override
	public User findById(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_user where id=?";
			return (User) runner.query(conn, sql, id, new BeanHandler(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.UserDao#find(java.lang.String, java.lang.String)
	 */
	@Override
	public User find(String username,String password){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_user where username=? and password=?";
			Object params[] = {username,password};
			return (User) runner.query(conn, sql, params, new BeanHandler(User.class));
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
