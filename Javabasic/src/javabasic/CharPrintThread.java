package javabasic;

public class CharPrintThread implements Runnable {

	@Override
	public void run() {

		while(true) {
			
			//대문자 A~Z중 임의의 영문자를 출력 (아스키코드 65 ~ 95까지)
			
			int ranNum = (int)(Math.random()*26)+65;
			System.out.println((char)ranNum);
			

//			System.out.println((char)(Math.random()*26)+65);
			
			try {
				Thread.sleep(500);				
			} catch(InterruptedException ie) {
				ie.printStackTrace();
			}
			
		
		}
		
	}

}
