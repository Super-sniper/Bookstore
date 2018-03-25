package com.bookstore.dao.impl;

import java.sql.Connection;
import java.util.List;
import java.util.Set;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import com.bookstore.bean.Book;
import com.bookstore.bean.OrderItems;
import com.bookstore.bean.Orders;
import com.bookstore.bean.User;
import com.bookstore.dao.OrderDao;
import com.bookstore.utils.JdbcUtils;

public class OederDaoImpl implements OrderDao {
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.OrderDao#add(com.bookstore.bean.Orders)
	 */
	@Override
	public void add(Orders o){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "insert into tb_orders(id,ordertime,state,price,tb_user_id) values(?,?,?,?,?)";
			Object params[] ={o.getId(),o.getOrdertime(),o.isState(),o.getPrice(),o.getUser().getId()};
			runner.update(conn, sql, params);
			
			Set<OrderItems> set = o.getOrderItems();
			sql = "insert into tb_orderitem(id,quantity,price,tb_book_id,tb_orders_id) values(?,?,?,?,?)";
			for(OrderItems item:set){
				params = new Object[]{item.getId(),item.getQuantity(),item.getPrice(),item.getBook().getId(),o.getId()};
				runner.update(conn, sql, params);
			}
			
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public void update(String id,boolean state){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "update tb_orders set state=? where id=?";
			Object params[]={state,id};
			runner.update(conn, sql, params);
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.OrderDao#find(java.lang.String)
	 */
	@Override
	public Orders find(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			
			//找出订单的信息
			String sql = "select * from tb_orders where id=?";
			Orders order = (Orders) runner.query(conn, sql, id, new BeanHandler(Orders.class));
			
			//找出订单中的订单项
			sql = "select * from tb_orderitem where tb_orders_id=?";
			List<OrderItems> items = (List<OrderItems>) runner.query(conn, sql,order.getId(), new BeanListHandler(OrderItems.class));
			order.getOrderItems().addAll(items);
			
			
			//找出每个订单项的信息
			for(OrderItems item:items){
				sql = "select b.* from tb_orderitem oi,tb_book b where oi.id=? and b.id=oi.tb_book_id";
				Book book = (Book)runner.query(conn, sql, item.getId(), new BeanHandler(Book.class));
				item.setBook(book);
			}
			
			//找出下单人的信息
			sql = "select u.* from tb_orders o,tb_user u where o.id=? and u.id=o.tb_user_id";
			User user = (User)runner.query(conn, sql, id, new BeanHandler(User.class));
			order.setUser(user);
			
			return order;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.dao.impl.OrderDao#getAll(boolean)
	 */
	@Override
	public List<Orders> getAll(boolean state){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_orders where state=?";
			List<Orders> orders = (List<Orders>)runner.query(conn, sql, state, new BeanListHandler(Orders.class));
			
			for(Orders order:orders){
				sql = "select u.* from tb_orders o,tb_user u where o.id=? and u.id=o.tb_user_id";
				User user = (User)runner.query(conn, sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);
			}
			
			return orders;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	
	public List<Orders> getAllByUserID(String id){
		try {
			Connection conn = JdbcUtils.getConnection();
			QueryRunner runner = new QueryRunner();
			String sql = "select * from tb_orders where tb_user_id=?";
			List<Orders> orders = (List<Orders>)runner.query(conn, sql, id, new BeanListHandler(Orders.class));
			
			for(Orders order:orders){
				sql = "select u.* from tb_orders o,tb_user u where o.id=? and u.id=o.tb_user_id";
				User user = (User)runner.query(conn, sql, order.getId(), new BeanHandler(User.class));
				order.setUser(user);
			}
			
			return orders;
		} catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
}
