package javabasic.movie;

public class MovieSeat {

	private String seatNumber;	// 좌석번호
	private boolean reserved;	// 예약여부_true와 false로 구분
	private String userName;	// 예약자 이름
	private String userID;		// 예약자 회원가입 ID

	public MovieSeat() { 

	}

	public MovieSeat(String seatNumber) {
		super();
		this.seatNumber = seatNumber;
		this.reserved = false;	// 처음은 예약 안되어 있음_false
		this.userName = "";		
		this.userID = "";		
	}

	public String getSeatNumber() { // 좌석 번호 반환
		return seatNumber;
	}

	public boolean isReserved() { // 예약 되어있을시 반환
		return reserved;
	}

	public void reserve(String name, String id) { // 좌석 예약 완료_true
		
		reserved = true;
		userName = name;
		userID = id;
	}
	
	public void cancel() { // 좌석 예약 취소_false
		reserved = false;
		userName = "";
		userID = "";
	}
	
	public String getreserveName() {
		return userName;
	}

	public String getuserID() {
		return userID;
	}

	@Override
	public String toString() { // 좌석을 문자열 "X"로 변경 아니면 번호로 입력
		return reserved ? "X" : seatNumber;
	}
}