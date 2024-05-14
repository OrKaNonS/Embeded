package javabasic.oop;

public class Child extends Parent {
	
	String name;
	int age;
	String job;
	
	
	Child(String name, int age, String job){
		super(name, age, job); // 생략 가능
		this.name = name;
		this.age = age;
		this.job = job;
	}
	
	
	@Override // 안써줘도 되나 혹 이름이 틀리거나 하면 오류표시로 알려주기 때문에 쓰는게 좋다.
	void say() {
		System.out.println("자식이 말씀하셨다!");
	}

}
