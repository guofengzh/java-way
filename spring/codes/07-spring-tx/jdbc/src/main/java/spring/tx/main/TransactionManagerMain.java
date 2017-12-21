package spring.tx.main;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import spring.tx.model.Address;
import spring.tx.model.Customer;
import spring.tx.service.CustomerManager;
import spring.tx.service.CustomerManagerImpl;
import spring.tx.utils.DbSetup;

public class TransactionManagerMain {
    public static final String DDL = "tx-derby-schema.sql";

	public static void main(String[] args) throws Exception {
		ClassPathXmlApplicationContext ctx = new ClassPathXmlApplicationContext("spring-tx-config.xml");
		
		DataSource dataSource = ctx.getBean(DataSource.class) ;
		DbSetup.runScript(dataSource, DDL);
		
		CustomerManager customerManager = ctx.getBean("customerManager", CustomerManagerImpl.class);

		Customer cust = createDummyCustomer();
		try {
		customerManager.createCustomer(cust);
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
		List<Customer> customers = customerManager.getCustomers() ;
		System.out.println(customers);

		ctx.close();
	}

	private static Customer createDummyCustomer() {
		Customer customer = new Customer();
		customer.setId(2);
		customer.setName("Pankaj");
		Address address = new Address();
		address.setId(2);
		address.setCountry("India");
		// setting value more than 20 chars, so that SQLException occurs
		address.setAddress("Albany Dr, San Jose, CA 95129");
		customer.setAddress(address);
		return customer;
	}
}
