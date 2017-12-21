package spring.tx.service;

import java.util.List;

import spring.tx.model.Customer;

public interface CustomerManager {
	public void createCustomer(Customer cust);
	public List<Customer> getCustomers();
}
