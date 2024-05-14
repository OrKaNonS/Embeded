package javabasic.oop;

public class MonitorMain {
	
	public static void main(String[] args) {
		
		//Monitor타입 객체 3개 생성
		
		Monitor monitor1 = new Monitor();
		Monitor.objcount++;
		Monitor monitor2 = new Monitor();
		Monitor.objcount++;
		Monitor monitor3 = new Monitor();
		Monitor.objcount++;
		
		
		//객체 데이터 설정

		monitor1.brand = "밴큐";
		monitor1.name =  "조위";
		monitor1.inch = 25;
		
		monitor2.brand = "LG";
		monitor2.name =  "마이뷰";
		monitor2.inch = 32;
		
		monitor3.brand = "삼성";
		monitor3.name =  "베젤리스";
		monitor3.inch = 27;		
				
		
		//객체 데이터 출력
		System.out.println(monitor1.brand + "에서 만든 " + monitor1.name + " 모니터는 " + monitor1.inch + "인치 입니다.");
		System.out.println(monitor2.brand + "에서 만든 " + monitor2.name + " 모니터는 " + monitor2.inch + "인치 입니다.");
		System.out.println(monitor3.brand + "에서 만든 " + monitor3.name + " 모니터는 " + monitor3.inch + "인치 입니다.");
		
		System.out.println();
		
		// 객체 메소트 호출
		monitor1.Poweron();
		monitor1.Poweroff();
		monitor2.Poweron();
		monitor2.Poweroff();
		monitor3.Poweron();
		monitor3.Poweroff();
		
		
		
		//생성된 객채 수
		System.out.println("\n총 " + Monitor.objcount + "개의 객체 생성됨.");
		System.out.println("\n총 " + Monitor.getObjCount() + "개의 객체 생성됨.");
		
		
	} // main

} // class
