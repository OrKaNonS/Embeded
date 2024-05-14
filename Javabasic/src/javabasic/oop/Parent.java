package javabasic.oop;


//Parent는 Grandparent를 상속받는다.
//Parent는 참조범위를 GrandParent의 메모리까지 확장(extends)한다.
//GrandParent의 생성자에 파라미터를 입력하면 기본생성자가 사라짐으로 기본생성자를 넣어주어야 한다.

public class Parent extends GrandParent {
	
	String name;
	int age;
	String job;

	Parent(){
		
	}
	
	
	
	Parent(String name, int age, String job){
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	
	@Override
	void say() {
		System.out.println("아버님이 말씀하셨다!");
	}

} // class