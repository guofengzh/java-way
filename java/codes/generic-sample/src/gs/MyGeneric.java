package gs;

public class MyGeneric<T> {

	private T tobject;

	public MyGeneric(Class<T> tclass) throws InstantiationException, IllegalAccessException {

		this.tobject = (T) tclass.newInstance();

	}

	public T getTObject() {
		return this.tobject;
	}
}