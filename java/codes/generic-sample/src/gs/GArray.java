package gs;

import java.lang.reflect.Array;

public class GArray<T> {

	private Class<T> tclass;

	private T[] myArray;

	public GArray(Class<T> tclass) {
		this.tclass = tclass;

		final int size = 10;
		myArray = (T[]) Array.newInstance(tclass, size);
	}

	public T[] getMyArray() {
		return this.myArray;
	}

}