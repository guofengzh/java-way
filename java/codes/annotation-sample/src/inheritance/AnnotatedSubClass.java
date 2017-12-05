package inheritance;

public class AnnotatedSubClass extends AnnotatedSuperClass
{

    @Override
    public void oneMethod(){
        
    }
    
    public static void main(String[] args) {
    	System.out.println( "is true: " + AnnotatedSuperClass.class.isAnnotationPresent( InheritedAnnotation.class ) );
    	System.out.println( "is true: " + AnnotatedSubClass.class.isAnnotationPresent( InheritedAnnotation.class ) );
    }
}