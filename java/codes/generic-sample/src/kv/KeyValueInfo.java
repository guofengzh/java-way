package kv;

public class KeyValueInfo<K, V, I> extends KeyValue<K, V> {
	 
    private I info;
 
    public KeyValueInfo(K key, V value) {
        super(key, value);
    }
 
    public KeyValueInfo(K key, V value, I info) {
        super(key, value);
        this.info = info;
    }
 
    public I getInfo() {
        return info;
    }
 
    public void setInfo(I info) {
        this.info = info;
    }
 
}