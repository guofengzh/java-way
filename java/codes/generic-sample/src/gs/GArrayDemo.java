package gs;

public class GArrayDemo {

	public static void main(String[] args) {

		GArray<Integer> garray = new GArray<Integer>(Integer.class);

		Integer[] myArray = garray.getMyArray();

		myArray[0] = 1;
		myArray[2] = 0;
	}

}