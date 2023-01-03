package com.services;

import java.util.List;

import com.customerdto.Customer;
import com.dao.Customerdao;

public class CustomerServices {
	Customerdao dao=new Customerdao();
	
			//this method is for business logic
			public void insertCustomer(Customer customer) {
				
				String name = customer.getName();
				
				if(name.length()<=15) {
					dao.insert(customer);
				}else {
					System.out.println("please provide the name with 15 character");
				}
			}
			
			
			//update method for customer table
			public void updateCustomer(Customer customer) {
				dao.updateCustomer(customer);
			}
			
			
			//delete method for customer table
			public void deleteCustomer(Customer customer) {
				dao.deleteCustomer(customer);
			}
			
			
			//display method for customer table
			public List<Customer> displayCustomer()
			{
				return dao.displayCustomer();
			}
			

}
