import java.util.HashMap;
import java.util.Map;
import java.util.List;

class Vehicle { }
class Car extends Vehicle { }

class Pair<X,Y> { 
	   private X first; 
	   private Y second; 
	   
	   public Pair(X first, Y second) {
		   this.first = first ;
		   this.second = second ;
	   }

	   public static < A , B ,X extends A ,Y extends B > B addToMap(Pair<X,Y> pair, Map< A , B > map) { 
	      return map.put(pair.first,pair.second); 
	   } 
}

public class ExtSup {
	   public static void main(String[] args) {  
	     Pair<String,Long> pair = new Pair<String,Long>("ABC",42L); 
	     Map<CharSequence, Number> map = new HashMap<CharSequence, Number>(); 
	     Number number = Pair .addToMap( pair ,map); 
	     System.out.println(number);
	   } 
	}
