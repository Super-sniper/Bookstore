package com.bookstore.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	private static DataSource ds;
	private static ThreadLocal<Connection> tl = new ThreadLocal<Connection>();
	static{
		ds =  new ComboPooledDataSource();
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public static Connection getConnection(){
		try {
			Connection conn = tl.get();
			if(conn==null){
				conn = ds.getConnection();
				conn.setAutoCommit(false);
			}
			tl.set(conn);
			return conn;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static void startTransaction(){
		try {
			Connection conn = getConnection();
			conn.setAutoCommit(false);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void commitTransaction(){
		try {
			Connection conn = getConnection();
			if(conn!=null){
				conn.commit();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	
	public static void closeConn(){
		Connection conn =  null;
		try {
			 conn = getConnection();
			if(conn!=null){
				conn.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}finally{
				tl.remove();
		}
	}
	
}
