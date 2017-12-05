package avic.training.myproject;

import avic.training.api.AnInterface2;
import avic.training.api.MyObjectSuperClass;

public class MyObject extends MyObjectSuperClass implements AnInterface2{

	@Override
	public void print(String msg) {
		System.out.println("MyObject:" + msg) ;
	}

}
