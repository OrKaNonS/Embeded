package javabasic.oop;

public class IMonitorImpl extends AbstractIMonitor {

	@Override
	public void brightUp() {
		System.out.println("밝기정도를 높입니다.");

	}

	@Override
	public void brightDown() {
		System.out.println("밝기정도를 낮춥니다.");

	}

}
