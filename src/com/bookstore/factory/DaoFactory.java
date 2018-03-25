package com.bookstore.factory;

import java.io.InputStream;
import java.util.Properties;



public class DaoFactory {
	private static Properties prop = new Properties();
	
	private DaoFactory(){
		try {
			InputStream in = DaoFactory.class.getClassLoader().getResourceAsStream("com/bookstore/factory/dao.properties");
			prop.load(in);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		}
	}
	private static final DaoFactory instance = new DaoFactory();
	public static DaoFactory getInstance(){
		return instance;
	}
	
	public <T> T createDao(Class<T> interfaceclass){
		try {
			String key = interfaceclass.getSimpleName();
			String classname = prop.getProperty(key);
			return (T) Class.forName(classname).newInstance();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			throw new RuntimeException(e);
		} 
	}
}
