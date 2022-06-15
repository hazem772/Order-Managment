package com.hazem.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.hazem.models.OrderEntity;

public interface OrdersRepositoryInterface extends CrudRepository<OrderEntity, Long> {

	 // use the CrudRepository class in Spring to do the data operations on mysql
	// already implies that we will use save, findall, findbyid, deletebyid etc.
	
	List<OrderEntity> findByProductNameContainingIgnoreCase(String searchTerm);
	
}
