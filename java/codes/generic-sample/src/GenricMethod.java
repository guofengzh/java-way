import static java.lang.System.out ;

public class GenricMethod {
	public static void main(String[] args) {
		out.println(output(5, 5)) ;
		out.println(output(5.0, "5.0")) ;
		out.println(output("hahaha", 3)) ;
	}

	public static <T, U> U output( T a, U b) { 
		out.println(a + "") ; 
		return b ;
	} 	
}
