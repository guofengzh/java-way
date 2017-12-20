package spring.tx.service;

import org.springframework.transaction.annotation.Transactional;

import spring.tx.dao.CustomerDAO;
import spring.tx.model.Customer;

public class CustomerManagerImpl implements CustomerManager {

	private CustomerDAO customerDAO;

	public void setCustomerDAO(CustomerDAO customerDAO) {
		this.customerDAO = customerDAO;
	}

	@Override
	@Transactional
	public void createCustomer(Customer cust) {
		customerDAO.create(cust);
	}

}
