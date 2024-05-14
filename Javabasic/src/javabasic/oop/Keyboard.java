package javabasic.oop;

public class Keyboard extends Device {

	private int keyCount; // 키 개수
	private String keyboardType; // 키보드의 종류

	Keyboard() {

	}

	Keyboard(int keyCount, String keyboardType) {
		this.keyCount = keyCount;
		this.keyboardType = keyboardType;

	}

	public int getKeyCount() {
		return keyCount;
	}

	public void setKeyCount(int keyCount) {
		this.keyCount = keyCount;
	}

	public String getKeyboardType() {
		return keyboardType;
	}

	public void setKeyboardType(String keyboardType) {
		this.keyboardType = keyboardType;
	}
	
	
	@Override
	void on() {
		System.out.println("키보드 켜짐");
	}

	@Override
	void off() {
		System.out.println("키보드 꺼짐");
	}

}
