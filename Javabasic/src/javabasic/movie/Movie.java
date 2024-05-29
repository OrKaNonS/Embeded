package javabasic.movie;

import java.util.Scanner;

public class Movie {

	private static String[][] seats; 	// 좌석
	private static String seatRow;		// 앉을 행(A, B, C, D)
	private static int seatRowInt;		// 앉을 행을 숫자로 표현
	private static int seatNum;			// 앉을 열(1~10)
	private static int reservationCount;// 예약좌석 수

	Scanner sc = new Scanner(System.in);

	static {
		seatRow = ""; 				// 좌석 ROW 문자
		seatRowInt = 0; 			// 좌석 ROW 숫자
		seatNum = 0;				// 좌석 NUM열 초기화
		reservationCount = 0; 		// 예약좌석수 초기화
		seats = new String[][] { // 좌석
				{ "1", "2", "3" },
				{ "1", "2", "3" },
				{ "1", "2", "3" },
				{ "1", "2", "3" } };
	}

	public Movie() {

	}
	
	public void show_menu() {

//		1. 좌석 보기
//		2. 영화 예매
//		3. 영화 예매 취소
//		4. 예매 일괄 취소
//		5. 종료
		
//		show_seats();
		
		do {

		System.out.println("다음 보기중 선택해 주세요(1~5)");

		System.out.println("1. 좌석 보기");		
		
		System.out.print("2. 영화 예매");
		nowseats(seats);
		
		System.out.println("3. 영화 예매 취소");

		System.out.println("4. 영화 일괄 취소");

		System.out.println("5. 종료");

		int menu = sc.nextInt();

		switch (menu) {

		case 1:
			show_seats();
			break;

		case 2:
			settingseat(menu);
			break;

		case 3:
			settingseat(menu);
			break;

		case 4:
			allcancel();
			break;

		default:
			System.out.println("다시 입력");
		}
	} while(true);
}
	
	// 1. 좌석보기
	public void show_seats() { // 좌석 보여주기

//		 SCREEN		
//		---------
//		A | 1 2 3
//		---------
//		B | 1 2 3
//		---------
//		C | 1 2 3
//		---------
//		D | 1 2 3
//		---------

		System.out.println("  SCREEN"); // 최상단 SCREEN
		System.out.println("---------");

		for (int i = 65; i < 65 + seats.length; i++) { // 좌석의 ROW 알파벳 출력 (길이 3 : A, B, C)
			System.out.print((char) i);
			System.out.print(" | ");
			for (int j = 0; j < seats[j].length; j++) {
				System.out.print(seats[i-65][j] + " ");
			}
			System.out.println("");
			System.out.println("---------");

		}
	}	
	
	// <예배 or 취소로 가는 메소드>
	public void settingseat(int menu){
		
		if(reservationCount==0 & menu==3) {
			System.out.println("예약 없음");
			return;
		}
		
		 else if(menu==2) {
			Choiceseat();
		}
		 else if(menu==3) {
			Cancelseat();
		}
		
		switch(seatRow) {
		case "A":
			seatRowInt = 0;
			break;
			
		case "B":
			seatRowInt = 1;
			break;
			
		case "C":
			seatRowInt = 2;
			break;
			
		case "D":
			seatRowInt = 3;
			break;

		default :
			System.out.println("다시 입력");
		}
	
	}

	
	// 2. 영화 예매
	public void Choiceseat() { // Choice 선택한 자리 X표시하는 메소드		
		
		System.out.println("X 는 이미 예약된 좌석");
		System.out.println("행을 입력(A~D)");
		seatRow = sc.next();
		System.out.println("열을 입력(1~3)");
		seatNum = sc.nextInt();			
		
		if (seats[seatRowInt][seatNum - 1] != "X") { // 선택한 자리가 X가 아니라면
			seats[seatRowInt][seatNum - 1] = "X"; // 선택한 자리는 X로 표시
			System.out.println(seats[seatRowInt][seatNum - 1]);
			System.out.println(seatRow + seatNum + "자리 예매 완료"); // 선택한 자리 예매 완료
			reservationCount++;
		} else {
			System.out.println("다시 선택하세요"); // 잘못선택시 즉_ 중복 선택시 다시 선택요청
		}
	}
	
	
	// 2. 영화 예매 + (전체좌석 : ?? / 예약가능 좌석 : ??)
	public void nowseats(String[][] array) { // 현재 좌석 수 확인하기 위한 메소드
		int sum = 0; // sum 초기화
		for (int i = 0; i < array.length; i++) {
			sum += array[i].length; // sum에 현재 모든 행의 대한 길이를 계속 더해줌 => 전체 좌석수
		}
		System.out.println(" (전체좌석 : " + sum + " / 예약가능 좌석 : " + (sum - reservationCount) + ")"); // 전체좌석 과 예약좌석 출력
	}
	
	
	
	// 3. 영화 예매 취소
	public void Cancelseat() { // Cancel 선택한 자리의 X표시를 숫자로 바꾸는 메소드
		
			System.out.println("취소할 행과 열을 입력");
			System.out.println("행을 입력(A~D)");
			seatRow = sc.next();
			System.out.println("열을 입력(1~3)");
			seatNum = sc.nextInt();	
		
		if (seats[seatRowInt][seatNum - 1] == "X") { // 선택한 자리가 X라면
			seats[seatRowInt][seatNum - 1] = String.valueOf(seatNum); // seatNum 즉 X표시를 선택한 숫자로 바꾸는 바꾼다.
			System.out.println(seats[seatRowInt][seatNum] + "자리 예매 취소"); // 선택한 자리 숫자로 바꾸기 완료
			reservationCount--;
		} else {
			System.out.println("다시 선택하세요"); // 예매한 자리가 없고나 잘못 입력시 다시 선택 요청
		}
	}

	
	

	// 4. 영화 예매 일괄 취소
	public void allcancel() {
		if (reservationCount == 0) { // 예매 숫자 0이면 예매 없다고 출력
			System.out.println("예매된 영화가 없습니다.");
			return;
		} else {
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[i].length; j++) {// 예매 있을경우 해당 자리를 숫자로 바꿈
					seats[i][j] = String.valueOf(j + 1); // seats[][] 의 값이 null이면 j+1을 대입
				}
			}
			reservationCount = 0;
			System.out.println("예매 모두 취소");
		}

	}



	public void mainmenu() {
		System.out.println("  SCREEN"); // 최상단 SCREEN
		System.out.println("---------");
		for (int i = 65; i < 65 + seats.length; i++) { // 좌석의 ROW 알파벳 출력 (길이 3 : A, B, C)
			System.out.print((char) i);
			System.out.print(" | ");
			for (int j = 0; j < seats[j].length; j++) {
				System.out.print(j+1 + " ");
			}
			System.out.println("");
		}
			System.out.println("---------");	
	}



} // class