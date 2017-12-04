
public class TreeMap<Key extends Comparable<Key> ,Data>{ 
	
  public static interface Comparable<T> { 
	  public int compareTo(T arg); 
  } 
	
  public static class Entry<K,V> { 
     K key; 
     V value; 
     Entry<K,V> left = null; 
     Entry<K,V> right = null; 
     Entry<K,V> parent; 
  } ;
  
  private Entry<Key,Data> root = null; 
  
  public Entry<Key,Data> getEntry(Key key) { 
     Entry<Key,Data> p = root; 
     Key k = key; 
     while (p != null) { 
       int cmp = k. compareTo(p.key) ;  
       if (cmp == 0) 
         return p; 
       else if (cmp < 0) 
         p = p.left; 
       else  
         p = p.right;  
     } 
     return null; 
  } 
  public boolean containsKey(Key key) { 
     return getEntry(key) != null; 
  } 
}

class Person implements TreeMap.Comparable<Person> {
	private String name ;

	public Person(String name) {
		super();
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int compareTo(Person other) {
		return name.compareTo(other.name);
	}
}