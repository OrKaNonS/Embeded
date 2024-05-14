package javabasic;

public class HelloThread extends Thread {
	
	//Thread에는 run()을 기본 구현 해놓았기 때문에 Thread를 상속받았기 때문에 오버라이드 하라라고 뜨지는 않으나 해야함.
	
	@Override
	public void run() {
		
		while(true) {
			System.out.println("Hello");
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			
		}
	} 
}

