package javabasic.oop.animal;

public class LifeMain {
	public static void main(String[] args) {
		
		// 확장성을 위해 상위 타입으로 만든다. ILife 타입이지만 다양한 참조를 만듬(다형성)
		ILife dog = new Dog ("말티즈"); // ILife 타입의 Dog 생성  Dog 참조
		ILife cat = new Cat ("러시안"); // ILife 타입의 Cat 생성 Cat 참조
		
		ILife rose = new Rose("백장미"); // ILife 타입의 Rose 생성 Rose 참조
		ILife lily = new Lily("홍백합"); // ILife 타입의 Lily 생성 Lily 참조
		
		//개를 숨쉬도록 해보자
		
		dog.breath();
		cat.breath();
		dog.light();
		
		
		// 방법 1(형변환)
		//((IPlant)rose).light();
		
		// 방법 2(인터페이스 분리 이용)
		// IPlant를 지우고 ILight 생성 후 최상위로 올린다(ILife 위로 올린다)
		// dog, cat에 light 오류가 발생하는데 AbstractAnimal에 light 넣어주고 아무 명령도 넣어주지 않는다.
		
		rose.light();
		lily.light();
		
		
			
		
		
	}

}
