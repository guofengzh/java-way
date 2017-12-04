package kv;

public class GenericInterfaceImpl<G> implements GenericInterface<G>{
	 
	   private G something;
	    
	   @Override
	   public G doSomething() {
	       return something;
	   }
	 
}