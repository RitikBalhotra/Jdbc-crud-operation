package com.dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.connection.CustomerConection;
import com.customerdto.Customer;

public class Customerdao {

	Connection connection;
	
	//insert method for the customer table
	public void insert(Customer customer)
	{
		
		//step-1 load the driver
		try {
		
		//step-2 create the connection
		connection=CustomerConection.getConnection();
		
		//step-3 create the statement
			Statement statement=connection.createStatement();
			
			String insert="insert into customer values("+customer.getId()+",'"
														+customer.getName()
														+"','"+customer.getMob()
														+"')";
			statement.execute(insert);
			
			System.out.println("Data inserted...!");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		
		
	}
	
		//update method for customer table
		public void updateCustomer(Customer customer)
		{
			connection = CustomerConection.getConnection();
			
			try {

				Statement statement = connection.createStatement();

				String update = "update customer set mobile = '"+customer.getMob()+"' where id ="+customer.getId()+"";
					
				statement.executeUpdate(update);

				System.out.println("Data updated..!");
				
				System.out.println("Mobile no is Updated :  new mobile no is "+customer.getMob());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					connection.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		
		
		//delete method for customer table
		public void  deleteCustomer(Customer customer)
				{
				connection = CustomerConection.getConnection();
				
				
				try {
					
					Statement statement =connection.createStatement();
					
					String delete = "delete from customer where id= "+customer.getId()+"";
					
					statement.executeUpdate(delete);
					
					System.out.println("Data deleted!!...");
					
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				finally {
					try {
						connection.close();
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
				
				
			// display method for customer detail
			public List<Customer> displayCustomer()
				{
					connection = CustomerConection.getConnection();
					
					Statement statement;
					try {
						statement = connection.createStatement();
						String select = "SELECT * FROM customer";
						
						ResultSet resultSet=statement.executeQuery(select);
						List<Customer> customers= new  ArrayList<Customer>();
						
						
					 while(resultSet.next())
					 {
						Customer customer =new Customer();
						
						customer.setId(resultSet.getInt("id"));
						customer.setName(resultSet.getNString("name"));
						customer.setMob(resultSet.getLong("mobile"));
						customers.add(customer); 
					 }
					 
					 return customers;
					} catch (SQLException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					return null;
					
					
				}

}
























