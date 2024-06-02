
package javabasic.movie;

public class MovieMain {

	public static void main(String[] args) {

		Movie mv = new Movie(); // 자바 코드 실행
		MovieGui mg = new MovieGui(); // 자바 GUI 실행
		MovieDao md = new MovieDao(); // Dao 실행

//		자바 코드 실행		
//		mv.showMenu();

//		자바 GUI 실행		
		mg.MainMenuGui();
// 

//		Dao 예약 코드
		/*
		 * // 예약할 좌석 정보를 설정합니다 String seatRow = "A"; int seatNum = 1; String userName =
		 * "John Doe"; String userId = "JD123";
		 * 
		 * // 좌석을 예약하기 전에 해당 좌석이 이미 예약되었는지 확인합니다 boolean alreadyReserved =
		 * md.isReserved(seatRow, seatNum); if (alreadyReserved) {
		 * System.out.println("해당 좌석은 이미 예약되었습니다."); } else { // 좌석을 예약합니다 boolean
		 * isReserved = md.reserveSeat(seatRow, seatNum, userName, userId); if
		 * (isReserved) { System.out.println("좌석이 성공적으로 예약되었습니다."); } else {
		 * System.out.println("좌석 예약에 실패했습니다."); } }
		 */

	} // class

} // main