package javabasic.movie;

import java.util.Scanner;

public class Movie {

	MovieSeat[][] seats; // 좌석 배열
	private int reservationCount; // 예약된 좌석 수
	Scanner sc = new Scanner(System.in);

	public Movie() {

		reservationCount = 0;
		seats = new MovieSeat[8][10]; // 8행 10열 좌석 배열 초기화
		char FRow = 'A';
		for (int i = 0; i < seats.length; i++, FRow++) {
			for (int j = 0; j < seats[i].length; j++) {
				seats[i][j] = new MovieSeat(String.valueOf(j + 1));
			}
		}

	}

	public void showMenu() {

//		1. 좌석 보기
//		2. 영화 예매
//		3. 영화 예매 취소
//		4. 예매 일괄 취소
//		5. 종료

//		show_seats();

		do {

			System.out.println("1. 좌석 보기");
			System.out.print("2. 영화 예매 ");
			nowSeats();
			System.out.println("3. 영화 예매 취소");
			System.out.println("4. 영화 일괄 취소");
			System.out.println("5. 종료");
			System.out.println("다음 보기중 선택해 주세요(1~5)");

			int menu = sc.nextInt();

			switch (menu) {

			case 1:
				showSeats();
				break;

			case 2:
				reserveSeat();
				break;

			case 3:
				cancelSeat();
				break;

			case 4:
				cancelAll();
				break;

			case 5:
				System.out.println("프로그램 종료");
				return;

			default:
				System.out.println("다시 입력");
			}
		} while (true);
	}

	// 1. 좌석보기
	public void showSeats() { // 좌석 보여주기

		System.out.println("         SCREEN"); // 최상단 SCREEN
		System.out.println("------------------------");

		char row = 'A';
		for (int i = 0; i < seats.length; i++, row++) {
			System.out.print(row + " | ");
			for (int j = 0; j < seats[i].length; j++) {
				System.out.print(seats[i][j] + " ");
			}
			System.out.println("\n------------------------");
		}
	}

	// 2. 예매 메소드
	public void reserveSeat() {

		System.out.println("예매를 원하시는 행을 입력해주세요(A~H)");
		String seatRow = sc.next();
		int seatRowint = seatRow.charAt(0) - 'A'; // seatRow.charAt(0)는 입력받은 seatRow를 String 을 char로 변경하는 것으로 A 입력시 A-A
													// = 0 이 되므로 A입력하면 0이 된다.

		System.out.println("예매를 원하시는 열을 입력해주세요(1~10)");
		int seatNum = sc.nextInt() - 1;

		if (seats[seatRowint][seatNum].isReserved()) {
			System.out.println("이미 예약된 좌석입니다. 다시 선택해주세요");
		} else {
			System.out.println("예약자 이름을 입력해주세요 :");
			String name = sc.next();
			System.out.println("예약자 회원가입 ID를 입력해주세요('-' 제외) :");
			String id = sc.next();
			seats[seatRowint][seatNum].reserve(name, id);
			System.out.println(seatRow + (seatNum + 1) + " 자리 예매가 완료되었습니다.");
			reservationCount++;
		}
	}

	// 3. 영화 예매 취소
	public void cancelSeat() {
		if (reservationCount == 0) { // 예매 숫자 0이면 예매 없다고 출력
			System.out.println("예먜한 자리가 없습니다.");
			return;
		}
		System.out.println("예매취소를 원하는 행을 입력해주세요(A~H)");
		String seatRow = sc.next();
		int seatRowint = seatRow.charAt(0) - 'A';
		System.out.println("예매를 원하시는 열을 입력해주세요(1~10)");
		int seatNum = sc.nextInt() - 1;

		if (seats[seatRowint][seatNum].isReserved()) {
			System.out.println("예약자 이름을 입력해주세요");
			String name = sc.next();
			System.out.println("예약자 회원가입 ID를 입력해주세요");
			String id = sc.next();

			if (seats[seatRowint][seatNum].getreserveName().equals(name)
					&& (seats[seatRowint][seatNum].getreserveName().equals(id))) {
				seats[seatRowint][seatNum].cancel();
				System.out.println(seatRow + (seatNum + 1) + " 자리 예매가 취소되었습니다.");
				reservationCount--;
			} else {
				System.out.println("예약자 정보가 일치하지 않습니다. 다시 입력해주세요");
			}
		} else {
			System.out.println("예매된 자리가 아닙니다. 다시 입력해주세요");
		}
	}

	// 4. 영화 예매 일괄 취소
	public void cancelAll() {
		if (reservationCount == 0) { // 예매 숫자 0이면 예매 없다고 출력
			System.out.println("예매된 영화가 없습니다.");
			return;
		}

		System.out.println("모든 좌석의 예매를 취소하시겠습니까?  (Y/N)");
		String confirm = sc.next();

		if (confirm.equalsIgnoreCase("Y")) {
			for (int i = 0; i < seats.length; i++) {
				for (int j = 0; j < seats[i].length; j++) {// 예매 있을경우 해당 자리를 숫자로 바꿈
					if (seats[i][j].isReserved()) {
						seats[i][j].cancel();
					}
				}
			}
			reservationCount = 0;
			System.out.println("예매를 모두 취소하였습니다.");
		} else {
			System.out.println("예약된 예매가 없음으로 일괄 취소가 실패하였습니다.");
		}
	}

	private void nowSeats() {
		int totalSeats = seats.length * seats[0].length;
		System.out.println(" (전체좌석 : " + totalSeats + " / 예약된 좌석 : " + (totalSeats - reservationCount) + ")");
	}

} // class