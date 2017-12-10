package service;

import domain.Product;

public interface ProductService {
	Product add(Product product);
	Product get(long id);
	
	public static ProductService getService() {
		return ProductServiceImpl.getInstance() ;
	}
}
