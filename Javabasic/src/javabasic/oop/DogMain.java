package javabasic.oop;

public class DogMain {
	public static void main(String[] args) {
		
		Dog dog1 = new Dog();
		System.out.println(dog1.toString());
		//dog1은 Dog 타입이라 String으로 변환해야 하는데 자동으로 됨
		
		System.out.println();
		
		Dog dog2 = new Dog("진돗개");
		System.out.println(dog2);
		
		System.out.println();
		
		Dog dog3 = new Dog("진돗개", 10);
		System.out.println(dog3);
		
		System.out.println();
		
		Dog dog4 = new Dog("진돗개", 10, "갈색");
		System.out.println(dog4);
		
		System.out.println();
		
		Dog dog5 = new Dog("똥개", 15, "빨강색");
		System.out.println(dog5);
		
		
	}

}
