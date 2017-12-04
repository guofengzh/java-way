package kv;

public class KeyValueDemo {
	 
    public static void main(String[] args) {
 
        // Create KeyValue object.
        // Integer: Phone Number (K = Integer)
        // String: Name of User (V = String)
        KeyValue<Integer, String> entry = new KeyValue<Integer, String>(12000111, "Tom");
 
        // Java understands that the return type is a Integer
        // (K = Integer)
        Integer phone = entry.getKey();
 
        // Java understands that the return type is a String
        // (V = String).
        String name = entry.getValue();
 
        System.out.println("Phone = " + phone + " / name = " + name);
    }
 
}
