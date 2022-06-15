package com.hazem;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.context.annotation.RequestScope;
import org.springframework.web.context.annotation.SessionScope;

import com.hazem.data.OrdersDataAccessInterface;
import com.hazem.data.OrdersDataService;
import com.hazem.data.OrdersDataServiceForRepository;
import com.hazem.models.OrderModel;
import com.hazem.services.OrdersBusinessService;
import com.hazem.services.OrdersBusinessServiceInterface;

import groovy.lang.Singleton;

@Configuration
public class SpringConfig {

	@Bean(name="ordersBusinessService" , initMethod = "init", destroyMethod = "destroy"     ) 
	@RequestScope
	public OrdersBusinessServiceInterface getOrdersBusiness() {
		return new OrdersBusinessService();
	}
	
	@Autowired
	DataSource dataSource;
	
	@Bean(name="ordersDAO") 
	@RequestScope
	public OrdersDataAccessInterface<OrderModel> getDataService() {
		return new OrdersDataServiceForRepository(dataSource);
		// return new OrdersDataService();
	}
}
