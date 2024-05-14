package javabasic.oop;

public class IMonitorMain {

	public static void main(String[] args) {
		
		IMonitor imonitor = new IMonitorImpl();
		imonitor.powerOn();
		imonitor.powerOff();
		imonitor.brightUp();
		imonitor.brightDown();
		
		
		

	}

}
