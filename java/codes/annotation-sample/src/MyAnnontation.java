import java.lang.annotation.*;

@Documented
@Inherited
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnontation {
	public enum Priority {
		LOW, MEDIUM, HIGH
	}

	public enum Status {
		STARTED, NOT_STARTED
	}

	String author() default "Yash";

	Priority priority() default Priority.LOW;

	Status status() default Status.NOT_STARTED;
}
