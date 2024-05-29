package javabasic.movie;

import java.util.List;

public class MovieSeat {
	
	// 조회
	// 예약
	// 예약취소

	private int seatNum;   	// 좌석번호
	private boolean result;	// 예약 여부
	
	public MovieSeat() {
		
	}

	public MovieSeat(int seatNum, boolean result) {
		super();
		this.seatNum = seatNum;
		this.result = result;
	}

	public int getSeatNum() {
		return seatNum;
	}

	public void setSeatNum(int seatNum) {
		this.seatNum = seatNum;
	}

	public boolean isResult() {
		return result;
	}

	public void setResult(boolean result) {
		this.result = result;
	}
	
	public void getreservation( int seatNum) { // 예약시 호출 메소드
		this.seatNum = seatNum;		
	}
	
	
	
	public void cancel(boolean result) { // 예약 취소
		this.result = false;
	}

	@Override
	public String toString() {
		return "MovieSeat [seatNum= " + seatNum + ", result=" + result + "]";
	}

	
	
	
	
	
	
	
	
}
