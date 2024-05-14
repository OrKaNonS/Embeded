package javabasic.oop.art;

public class AbstractArt implements IArt {

	
	String name;

	@Override
	public void Appreciate() {
		System.out.println(name + " 감상한다!");
	}
	
	@Override
	public void Picture() {
		System.out.println(name + " 그림을 그린다!");
	}
	
	@Override
	public void Play() {
		System.out.println(name + " 음악을 연주한다!");
	}
	
	@Override
	public void Act() {
		System.out.println(name + " 영화를 촬영한다!");
	}

}
