package javabasic;

public class ThreadExer2 {

	public static void main(String[] args) {
		
		Thread ht = new HelloThread();
		Thread gt = new GoodbyeThread();
		
		ht.start();
//		ht.yield();
//		try {
//			ht.join();
//		} catch (InterruptedException ie) {
//			ie.printStackTrace();
//		}
		gt.start();
		
//		 - activeCount() : 실행중인 쓰레드의 수
//		 - currentThread() : 현재 실행중인 쓰레드가 무엇인지
//		 - getId() : 쓰레드의 아이디
//		 - getName() : 쓰레드의 이름
//		 - getPriority() : 쓰레드의 우선순위(우선순위가 높은 쓰레드가 먼저 실행 될 확률이 높음)
//		 - getState() : 쓰레드의 상태
		
		// 출력시 out 대신 err로 하면 빨간 글씨 나옴
		
		System.out.println(Thread.activeCount());
		System.out.println(Thread.currentThread()); // Thread[main,5,main] [그룹명, 몇뻔쨰스레드, 쓰레드명]
		System.out.println(ht.getId());
		ht.setName("Hello Thread");
		System.out.println(ht.getName());
		gt.setName("GoodbyeThread");
		System.out.println(gt.getName());
		ht.setPriority(10);
		gt.setPriority(1);
		System.out.println(ht.getPriority()); // 기본값 5
		System.out.println(ht.getState());
		
		
		
		
		
		
	}

}
