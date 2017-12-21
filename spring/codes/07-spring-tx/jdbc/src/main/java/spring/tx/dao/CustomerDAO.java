package spring.tx.dao;

import java.util.List;

import spring.tx.model.Customer;

public interface CustomerDAO {

	public void create(Customer customer);

	public List<Customer> getCustomers();
}