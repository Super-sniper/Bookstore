package com.bookstore.service.impl;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

import com.bookstore.bean.Book;
import com.bookstore.bean.Car;
import com.bookstore.bean.CarItem;
import com.bookstore.bean.Category;
import com.bookstore.bean.OrderItems;
import com.bookstore.bean.Orders;
import com.bookstore.bean.QueryInfo;
import com.bookstore.bean.QueryResult;
import com.bookstore.bean.User;
import com.bookstore.bean.PageBean;
import com.bookstore.dao.BookDao;
import com.bookstore.dao.CategoryDao;
import com.bookstore.dao.OrderDao;
import com.bookstore.dao.UserDao;
import com.bookstore.factory.DaoFactory;
import com.bookstore.service.BusinessService;

public class BusinessServiceImpl implements BusinessService {
	
	private CategoryDao cdao = DaoFactory.getInstance().createDao(CategoryDao.class);
	private BookDao bdao = DaoFactory.getInstance().createDao(BookDao.class);
	private OrderDao odao = DaoFactory.getInstance().createDao(OrderDao.class);
	private UserDao udao  = DaoFactory.getInstance().createDao(UserDao.class);
	
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#addCategory(com.bookstore.bean.Category)
	 */
	@Override
	public void addCategory(Category c){
		cdao.add(c);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#findCategory(java.lang.String)
	 */
	@Override
	public Category findCategory(String id){
		return cdao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#getAllCategory()
	 */
	@Override
	public List<Category> getAllCategory(){
		return cdao.getAll();
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#addBook(com.bookstore.bean.Book)
	 */
	@Override
	public void addBook(Book book){
		bdao.add(book);
	}
	
	@Override
	public List getAllBook(){
		return bdao.getAllBooks();
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#findBook(java.lang.String)
	 */
	@Override
	public Book findBook(String id){
		return bdao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#pageQuery(com.bookstore.bean.QueryInfo)
	 */
	@Override
	public PageBean pageQuery(QueryInfo info){
		QueryResult result = bdao.pageQuery(info.getStartIndex(), info.getPageSize(), info.getWhere(), info.getQueryvalue());
		PageBean pagebean = new PageBean();
		pagebean.setCurrentPage(info.getCurrentPage());
		pagebean.setList(result.getList());
		pagebean.setPageSize(info.getPageSize());
		pagebean.setTotalRecord(result.getTotalRecord());
		return pagebean;
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#saveOrder(com.bookstore.bean.Car, com.bookstore.bean.User)
	 */
	//用户的购物车产生订单，并保存数据
	@Override
	public void saveOrder(Car car,User user){
		Orders order = new Orders();
		order.setId(UUID.randomUUID().toString());
		order.setOrdertime(new Date());
		order.setPrice(car.getPrice());
		order.setUser(user);
		order.setState(false);
		
		//定义一个集合，用于保存所有订单项
		Set oitems = new HashSet();
		
		//用购物车的购物项生成订单项
		for(Map.Entry<String, CarItem> entry:car.getMap().entrySet()){
			CarItem citem = entry.getValue();
			OrderItems oitem = new OrderItems();
			
			oitem.setBook(citem.getBook());
			oitem.setId(UUID.randomUUID().toString());
			oitem.setPrice(citem.getPrice());
			oitem.setQuantity(citem.getQuantity());
			
			oitems.add(oitem);
		}
		order.setOrderItems(oitems);
		odao.add(order); 
	}
	
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#findOrder(java.lang.String)
	 */
	@Override
	public Orders findOrder(String id){
		return odao.find(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#getAllOrder(boolean)
	 */
	@Override
	public List<Orders> getAllOrder(boolean state){
		return odao.getAll(state);
	}
	
	public List<Orders> getAllOrder(String id){
		return odao.getAllByUserID(id);
	}
	
	public void updateState(String id,boolean state){
		odao.update(id, state);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#addUser(com.bookstore.bean.User)
	 */
	@Override
	public void addUser(User u){
		udao.add(u);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#findUser(java.lang.String)
	 */
	@Override
	public User findUser(String id){
		return udao.findById(id);
	}
	
	/* (non-Javadoc)
	 * @see com.bookstore.service.impl.BusinessService#findUser(java.lang.String, java.lang.String)
	 */
	@Override
	public User findUser(String username,String password){
		return udao.find(username, password);
	}
}
