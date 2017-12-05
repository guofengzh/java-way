package avic.training.framework;

import avic.training.api.AnInterface2;
import avic.training.api.MyObjectSuperClass;

public class Launcher {

	public static void main(String[] args) throws ClassNotFoundException, InstantiationException, IllegalAccessException {
	    ClassLoader parentClassLoader = MyClassLoader.class.getClassLoader();
	    MyClassLoader classLoader = new MyClassLoader(parentClassLoader);
	    Class<?> myObjectClass = classLoader.loadClass("avic.training.myproject.MyObject");

	    AnInterface2 object1 = (AnInterface2) myObjectClass.newInstance();
	    object1.print("Haha");

	    MyObjectSuperClass object2 = (MyObjectSuperClass) myObjectClass.newInstance();

	    //create new class loader so classes can be reloaded.
	    classLoader = new MyClassLoader(parentClassLoader);
	    myObjectClass = classLoader.loadClass("avic.training.myproject.MyObject");

	    object1 = (AnInterface2)       myObjectClass.newInstance();
	    object2 = (MyObjectSuperClass) myObjectClass.newInstance();
	}

}
