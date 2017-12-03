class MyException extends Exception {
	private static final long serialVersionUID = 1L;

	public MyException(String msg) {
		super(msg) ;
	}
}

public class CheckedEx {
	public static void main(String[] args) {
		try {
			method();
		} catch (MyException e) {
			e.printStackTrace();
		}
	}
	
	public static void method() throws MyException {
		throw new MyException("Wrong argument") ;
	}
	
}

