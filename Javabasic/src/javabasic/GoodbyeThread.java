package javabasic;

public class GoodbyeThread extends Thread {
	
	@Override
	public void run() {
		
		while(true) {
		System.out.println("Good Bye!");
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		
	   }
	}


	}
}
