
public class GenericRectanble<T extends Number> {
	private T height ;
	private T width ;
	
	public GenericRectanble(T h, T w ) {
		this.height = h ;
		this.width = w ;
	}
	
	public T getHeight() { return height ; } 
	
	public double area() {
		return height.doubleValue() * width.doubleValue() ;
	}
	
	public static void main(String[] args) {
		GenericRectanble<Integer> r = new GenericRectanble<>(5, 8) ;
		System.out.println(r.area());
	}
}
