class MyRunTimeException extends RuntimeException {
	private static final long serialVersionUID = 1L;

	public MyRunTimeException(String msg) {
		super(msg) ;
	}
}

public class RuntimeEx {
	public static void main(String[] args) {
		method();
	}
	
	public static void method() {
		throw new MyRunTimeException("Wrong argument") ;
	}
	
}

