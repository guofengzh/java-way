class MyError extends Error {
	private static final long serialVersionUID = 1L;

	public MyError(String msg) {
		super(msg) ;
	}
}

public class ErrorEx {
	public static void main(String[] args) {
		method();
	}
	
	public static void method() {
		throw new MyError("Wrong argument") ;
	}
	
}

