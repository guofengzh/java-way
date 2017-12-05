import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class ObjectInstantiation {

	public static void main(String[] args) throws Exception {
		Class<Person> personClazz = (Class<Person>) Class.forName("ObjectInstantiation$Person") ;
		Constructor<Person> constructor = personClazz.getConstructor(new Class[]{String.class, int.class});
		AgeInf p = constructor.newInstance("John", 20);
		p.age() ;
		
		// 访问成员
		Field ageField = personClazz.getDeclaredField("age");
		ageField.setAccessible(true);
		ageField.setInt(p, 30);
		System.out.println(p);
		
		// 访问成员
		Method method = personClazz.getMethod("isGreatThan", new Class[]{int.class});		
		Object returnValue = method.invoke(p, 30);
		Boolean b = (Boolean)returnValue ;
		System.out.println(b);
	}

	public static interface AgeInf {
		int age();
	}

	public static class Person implements AgeInf {
		private String name;
		private int age;

		public Person(String name, int age) {
			super();
			this.name = name;
			this.age = age;
		}
		
		public boolean isGreatThan(int age) {
			return this.age > age ;
		}

		@Override
		public int age() {
			return 0;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", age=" + age + "]";
		}

	}
}
