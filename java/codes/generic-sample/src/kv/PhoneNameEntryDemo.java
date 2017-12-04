package kv;

public class PhoneNameEntryDemo {
	 
    public static void main(String[] args) {
 
        PhoneNameEntry entry = new PhoneNameEntry(12000111, "Tom");
 
        // Java understands that the return type is Integer.
        Integer phone = entry.getKey();
 
        // Java understands that the return type is String.
        String name = entry.getValue();
 
        System.out.println("Phone = " + phone + " / name = " + name);
 
    }
 
}