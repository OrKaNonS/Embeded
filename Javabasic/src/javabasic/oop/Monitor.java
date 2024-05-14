package javabasic.oop;

public class Monitor {
	
	static int objcount = 0; // static은 초기화 해주는 것이 좋다.
	
	String brand; // 브랜드 ""로 자동 초기화
	String name; // 이름 ""로 자동 초기화
	int inch; // 인치_크기 ""0으로 자동 초기화
	int pixel; // 화소 ""0으로 자동 초기화
	
	
	static int getObjCount() {
		return objcount;
	}
	
	
	void Poweron() {
		System.out.println(this.name + "모니터 켜짐!");
	}
	void Poweroff() {
		System.out.println(this.name + "모니터 꺼짐!");
	}
	
	
	
	
	

}
