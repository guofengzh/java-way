package kv;

public class MyUtils {
    // <K, V>: To say that this method has two parameters K, V
    // This method returns an object of type K.
    public static <K, V> K getKey(KeyValue<K, V> entry) {
        K key = entry.getKey();
        return key;
    }
 
    // <K, V>: To say that this method has two parameters K, V
    // Method returns an object of type V.
    public static <K, V> V getValue(KeyValue<K, V> entry) {
        V value = entry.getValue();
        return value;
    }
}
