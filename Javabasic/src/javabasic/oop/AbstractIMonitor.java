package javabasic.oop;

public abstract class AbstractIMonitor implements IMonitor {

	@Override
	public void powerOn() {
		System.out.println("전원을 킵니다!");

	}

	@Override
	public void powerOff() {
		System.out.println("전원을 끕니다");

	}

	@Override
	public abstract void brightUp();
	
	@Override
	public  abstract void brightDown();
	
	
//	@Override
//	public void brightUp() {
//		System.out.println("밝기정도를 높입니다.");
//
//	}
//
//	@Override
//	public void brightDown() {
//		System.out.println("밝기정도를 낮춥니다.");
//
//	}

}
