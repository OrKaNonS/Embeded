package javabasic.movie;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.JOptionPane;


public class MovieDao {
	private Connection connection;

	public MovieDao() {
		connection = ConnectionUtil.getConnection();
	}

	// dBeaver 테이블에 예약 넣기
	// boolean으로 받아서 해당 값들이 다 잘 제대로 들어가면 true, 잘못들어가면 false로 
	public void reserveSeat(String row, int col, String name, String id) {
	    String sql = "INSERT INTO RESERVATION VALUES (SEQ_RESERVATION.NEXTVAL,?, ?, ?, ?, SYSDATE)";
	    
	    try (PreparedStatement pstmt = connection.prepareStatement(sql)) {
	        pstmt.setString(1, row);
	        pstmt.setInt(2, col); // 
	        pstmt.setString(3, name);
	        pstmt.setString(4, id);
	        pstmt.executeUpdate();
	       
	    } catch (SQLException e) {
	        e.printStackTrace();
	        // 실패 시 예외 처리
	        JOptionPane.showMessageDialog(null, "예약을 처리하는 도중 오류가 발생했습니다.");
	    } 
	}

	// dBeaver 테이블에 예약된거 취소하기
	public void cancelSeat(String seatRow, int seatNum, String name, String id ) {
		try {
			String query = "DELETE FROM reservation WHERE seat_row = ? AND seat_num = ? AND user_name = ? AND user_id = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, seatRow);
			stmt.setInt(2, seatNum);
			stmt.setString(3, name);
			stmt.setString(4, id);
			
			int workrows = stmt.executeUpdate(); // 예약 취소시 실행된 행이 > 0 이면 적어도 1개는 삭제된것으로 삭제됬다고 판단.
			if (workrows <= 0) {
	           	JOptionPane.showMessageDialog(null, "예약 취소에 실패하였습니다. 예약 정보를 다시 확인해주세요.");
	        }
			
		} catch (SQLException e) {
			e.printStackTrace();
			JOptionPane.showMessageDialog(null, "예약 취소 도중 오류가 발생하였습니다.");
		}
	}

	// DBeaver 테이블 예약 됬는지 확인
	public boolean isReserved(String seatRow, int seatNum) {
		try {
			String query = "SELECT * FROM reservation WHERE seat_row = ? AND seat_num = ?";
			PreparedStatement stmt = connection.prepareStatement(query);
			stmt.setString(1, seatRow);
			stmt.setInt(2, seatNum);
			ResultSet rs = stmt.executeQuery();
			return rs.next();
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
	}

	// 예약된 수
	public int getReservationCount() {
		try {
			String query = "SELECT COUNT(*) AS count FROM reservation";
			PreparedStatement stmt = connection.prepareStatement(query);
			ResultSet rs = stmt.executeQuery();
			if (rs.next()) {
				return rs.getInt("count");
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}
