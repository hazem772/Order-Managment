package com.hazem.data;

import java.util.List;

import com.hazem.models.OrderModel;

public interface OrdersDataAccessInterface <T>{
	
	public T getById(long id);
	public List<T> getOrders();
	public List<T> searchOrders(String searchTerm); 
	public long addOne(T newOrder); 
	public boolean deleteOne(long id); 
	public T updateOne(long idToUpdate, T updateOrder); 

}
