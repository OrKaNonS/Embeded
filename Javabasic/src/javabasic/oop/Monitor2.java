package javabasic.oop;

// 상속관계는 기본적으로 이즈어(isa) 관례 => Monitor2 는 Device 이다.
public class Monitor2 extends Device {

	private int xSize; // 화면의 가로 넓이
	private int ySize; // 화면의 세로 높이

	public Monitor2() {

	}

	Monitor2(int xSize, int ySize) {
		this.xSize = xSize;
		this.ySize = ySize;
	}

	public int getxSize() {
		return xSize;
	}

	public void setxSize(int xSize) {
		this.xSize = xSize;
	}

	public int getySize() {
		return ySize;
	}

	public void setySize(int ySize) {
		this.ySize = ySize;
	}

	@Override
	void on() {
		System.out.println("모니터 켜짐");
	}

	@Override
	void off() {
		System.out.println("모니터 꺼짐");
	}
}
