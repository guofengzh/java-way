package spring.tx.test;

import spring.tx.model.User;

public interface OuterBean {

	void testRequired(User user);
	
	void testRequiresNew(User user);

}
