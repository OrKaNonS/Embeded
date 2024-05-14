package javabasic.oop;

public class Dog {
	
	String name;
	int age;
	String color;
	
	//기본생성자_밑에 파라미터 생성자가 있어서 기본생성자 안만들어짐
	Dog(){
		
		
	}
	
	//생성자
	Dog(String name){
		this.name = name;
	}
	
	//생성자
	Dog(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	//생성자
	Dog(String name, int age, String color){
		this.name = name;
		this.age = age;
		this.color = color;
	}
	
	
	@Override
	public String toString() {
		return this.name + "는 " + this.age + "살 " + this.color + " 입니다";
	}
	 
	

}
