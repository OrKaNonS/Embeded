package javabasic.oop;

public class InheritanceMain {
	
	public static void main(String[] args) {
		
		// gp는 GrandParent 타입이고 가지고 있는 참조는 GrandParent타입니다.
		GrandParent gp = new GrandParent("홍할배", 80, "산적");
		System.out.println(gp.name + "님은 " + gp.age + "살이고 직업은 " + gp.job + "입니다.");
		
		// parent는 GrandParent타입이고 가지고 있는 참조는 Parent타입니다.
		GrandParent parent = new Parent("홍아범", 50, "산적");
		// GrandParent의 name, age, job을 찾으므로
		// null님은 0살이고 직업은 null입니다. 
		System.out.println(parent.name + "님은 " + parent.age + "살이고 직업은 " + parent.job + "입니다.");
		
		// child는 GrandParent타입이고 가지고 있는 참조는 Child타입이다.		
		GrandParent child = new Child("홍길동", 20, "산적");
		// GrandParent의 name, age, job을 찾으므로
		// null님은 0살이고 직업은 null입니다. 
		System.out.println(child.name + "님은 " + child.age + "살이고 직업은 " + child.job + "입니다.");
		
		
		
		// 상위타입 > 하위타입 하위형변환
		// parent는 위에서 GrandParent타입으로 바뀌었다가 다시 Parent타입으로 변환
		// 즉 하위형변화이 되려면 한번은 상위형변환이 일어났어야 함.
		// parent2 : Parent 타입, 가지고 있는 참조는 Parent
		// parent : GrandParent타입, 가지고 있는 참조는 Parent(상위형변화에 의해서 Parent 참조를 가지게 됨)
		Parent parent2 = (Parent)parent;
		System.out.println(parent2.name + "님은 " + parent2.age + "살이고 직업은 " + parent2.job + "입니다.");
		
		// child2 : child 타입, 가지고 있는 참조는 child
		// child : GrandParent타입, 가지고 있는 참조는 child(상위형변화에 의해서 child 참조를 가지게 됨)
		
		Child child2 = (Child)child;
		System.out.println(child2.name + "님은 " + child2.age + "살이고 직업은 " + child2.job + "입니다.");
		
		
		
		
		//Overriding (오버라이딩 = 메소드재정의)
		GrandParent gp1 = new GrandParent("강할범", 90, "장군");
		Parent p1 = new Parent("강아범", 60, "장군");
		Child c1 = new Child("강감찬", 30, "장군");
		
		gp1.say();
		p1.say();
		c1.say();
		
		// 오버라이딩을 하는 이유
		// 상위타입으로 하위타입의 기능을 수행할 수 있도록 상위형변환을 수행한 것
		// 각각의 하위타입들을 상위타입으로 호출하면... 각각의 하위타입들을 알 필요가 없다.
		// 하위타입의 갯수가 아무리 많아도 상위타입으로 호출을 일원화 시킬 수 있다.( 매우 중요함)
		GrandParent gp2 = p1;
		GrandParent gp3 = c1;
		Parent p2 = c1;
		gp2.say();
		gp3.say();
		p2.say();
	
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main

} // class
