package javabasic.oop;

public class CarMain {
	public static void main(String[] args) {
		
		Car car1 = new Car(); // Car타입의 객체를 생성, car1 = 객체참조변수
		// new Car() : Car 생성자를 호출하여 새로운 Car타입 객체를 Heap에 생성 => 생성된 개체 주소 => 해쉬알고리즘을 통해 참조값
		car1.mfName = "현대"; // "." 은 참조연산자
		car1.carName = "소나타";
		car1.color = "빨간색";
		car1.tireCount = 4;
		
		car1.carCount = 1;
		
		System.out.println(car1.mfName + "에서 만들 " + car1.carName + "는 " + car1.color + "이며 타이어수는 " + car1.tireCount + "입니다." );
		
		System.out.println();		
		
		car1.startCar();
		car1.axcelCar();
		car1.breakCar();
		car1.stopCar();
		
		System.out.println();
		
		car1.carName = "그랜져";
		
		car1.startCar();
		car1.axcelCar();
		car1.breakCar();
		car1.stopCar();
		
		System.out.println();
		
		Car car2 = new Car();
		car2.mfName = "기아";
		car2.carName = "쏘렌토";
		car2.color = "백색";
		car2.tireCount = 4;
				
		car2.carCount = 2;
		
		System.out.println(car2.mfName + "에서 만들 " + car2.carName + "는 " + car2.color + "이며 타이어수는 " + car2.tireCount + "입니다." );
		
		System.out.println();
		
		car2.startCar();
		car2.axcelCar();
		car2.breakCar();
		car2.stopCar();
		
		System.out.println();
		
		// 해쉬코드값(참조값)이 같다는 건 메모리에 같은 곳에 있다는 것이고
		// 메모리에 같은 곳에 있다는 건 같은 객체라는 뜻!!!
		
		Car car3 = new Car();
		
		System.out.println("car1에 저장된 참조값 : " + car1.hashCode());
		System.out.println("car2에 저장된 참조값 : " + car2.hashCode());
		System.out.println("car3에 저장된 참조값 : " + car3.hashCode());
		
		System.out.println();
		
		car3.carCount = 3;
		
		
		Car car4 = new Car();
		
		car4.carCount = 4;
		
		
		System.out.println(car3.equals(car4));
		
		System.out.println(Car.carCount);
		System.out.println(car1.carCount);
		System.out.println(car2.carCount);
		System.out.println(car3.carCount);
		System.out.println(car4.carCount);
		
		car4.carCount = 100;
		
		System.out.println(Car.carCount);
		System.out.println(car1.carCount);
		System.out.println(car2.carCount);
		System.out.println(car3.carCount);
		System.out.println(car4.carCount);
		
		
		System.out.println(Car.getCarCount());
		System.out.println(car1.getCarCount());
		System.out.println(car2.getCarCount());
		System.out.println(car3.getCarCount());
		System.out.println(car4.getCarCount());
		
		
		
		
	} // main
	

} // class
