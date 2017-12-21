package spring.tx.dao;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.jdbc.core.JdbcTemplate;

import spring.tx.model.Customer;

public class CustomerDAOImpl implements CustomerDAO {

	private DataSource dataSource;

	public void setDataSource(DataSource dataSource) {
		this.dataSource = dataSource;
	}

	@Override
	public void create(Customer customer) {
		String queryCustomer = "insert into Customer (id, name) values (?,?)";
		String queryAddress = "insert into Address (id, address,country) values (?,?,?)";

		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);

		jdbcTemplate.update(queryCustomer, new Object[] { customer.getId(),customer.getName() });
		System.out.println("Inserted into Customer Table Successfully");
		jdbcTemplate.update(queryAddress, new Object[] { customer.getId(),
				customer.getAddress().getAddress(),
				customer.getAddress().getCountry() });
		System.out.println("Inserted into Address Table Successfully");
	}

	@Override
	public List<Customer> getCustomers() {
		String queryCustomer = "select id, name from Customer" ;
		JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource);
		List<Customer> customers = jdbcTemplate.query(queryCustomer, new CustomerMapper());
		return customers;
	}

}
