package javabasic.oop.animal;

public class AbstractPlant implements ILife {
	
	String name;

	@Override
	public void breath() {
		System.out.println(name + "숨을 쉰다");

	}

	@Override
	public void growth() {
		System.out.println(name + "성장한다");

	}
	@Override
	public void light() {		
		System.out.println(name + "광합성을 한다");

	}

}

	
	
//	@Override
//	public void light() {
		