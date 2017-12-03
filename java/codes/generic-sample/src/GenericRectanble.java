
public class GenericRectanble<T extends Number> {
	private T height ;
	private T width ;
	
	public GenericRectanble(T h, T w ) {
		this.height = h ;
		this.width = w ;
	}
	
	public T getHeight() { return height ; } 
	
	public T area() {
		return height * width ;
	}
}
