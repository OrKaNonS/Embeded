package javabasic;

public class Person {
	
	String name;
	int age;
	
	public Person(String name, int age) {
		this.name = name;
		this.age = age;		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	
	//오러바이드를 해주면 p1, p2의 값을 비교해서 동일 인물이라고 나오지만 안해주면 object의 equal을 가져온다. 즉 참조값을 비교함으로 다른 사람이라고 나온다.
//	@Override
//	public boolean equals(Object obj) {
//		Person p = (Person)obj;
//		if(p.name.equals(this.name)
//				&& p.age == this.age) {
//			return true;
//		} else {
//			return false;
//		}
	
	
	@Override
	public String toString() {
		return this.name + "님은 " + this.age + "살 입니다!";
	}
			
				
	

}
