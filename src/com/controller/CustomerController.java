package com.controller;

import java.util.List;

import com.customerdto.Customer;
import com.services.CustomerServices;

public class CustomerController {

	public static void main(String[] args) {
		Customer customer=new Customer();
		
		CustomerServices customerservice= new CustomerServices();
		
		boolean b=true;
		while(b) {
			
		switch (4) {
		case 1: {
			customer.setId(44);
			customer.setName("Gourav");
			customer.setMob(937834381);
			customerservice.insertCustomer(customer);
		}break;
		case 2: {
			customer.setId(44);
			customer.setMob(888345765);
			customerservice.updateCustomer(customer);
		}break;
		
		
		//delete case
		case 3: {
			customer.setId(44);
			customerservice.deleteCustomer(customer);
		}break;
		
		
		//display case
		case 4: {
			List<Customer> customers= customerservice.displayCustomer();
			for(Customer customer2: customers)
			{
				System.out.println(customer2.getId());
				System.out.println( customer2.getName());
				System.out.println(customer2.getMob());
				System.out.println("======================");
			}
		}break;
		
		
		default:
			break;
		}
		b=false;
	}

	}

}
