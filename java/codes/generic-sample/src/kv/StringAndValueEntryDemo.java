package kv;

public class StringAndValueEntryDemo {
	 
    public static void main(String[] args) {
 
        // (Emp Number, Employee Name)
        // V = String (Employee Name)
        StringAndValueEntry<String> entry = new StringAndValueEntry<String>("E001", "Tom");
 
        String empNumber = entry.getKey();
 
        String empName = entry.getValue();
 
        System.out.println("Emp Number = " + empNumber);
        System.out.println("Emp Name = " + empName);
 
    }
 
}
