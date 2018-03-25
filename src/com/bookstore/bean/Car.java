package com.bookstore.bean;

import java.util.LinkedHashMap;
import java.util.Map;

public class Car {
	private Map<String,CarItem> map = new LinkedHashMap<String,CarItem>();
	private double price;
	
	
	public void add(Book book){
		CarItem item = map.get(book.getId());
		if(item==null){
			item = new CarItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(),item);
		}else{
			item.setQuantity(item.getQuantity()+1);
		}
		
	}
	
	public Map<String, CarItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CarItem> map) {
		this.map = map;
	}
	public double getPrice() {
		double totalPrice = 0;
		for(Map.Entry<String,CarItem> entry:map.entrySet()){
			totalPrice +=entry.getValue().getPrice();
		}
		this.price = totalPrice;
		return price;
	}

	
}
