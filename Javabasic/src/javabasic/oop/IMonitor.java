package javabasic.oop;

public interface IMonitor {
	
	//인터페이스 상수
	public static final int INCH_TWENTY_FOUR = 24;
	public static final int INCH_THIRTY = 30;
	public static final int INCH_FOURTY = 40;
	
	//인터페이스 시그니처
	public abstract void powerOn(); 
	public abstract void powerOff();
	public abstract void brightUp();
	public abstract void brightDown();
	

}
