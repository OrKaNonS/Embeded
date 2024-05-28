package javabasic.jdbc.board;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

import javabasic.jdbc.ConnectionUtil;

public class BoardMain {
	
	Connection conn;
	CallableStatement cstmt;
	
	BoardMain() {
		conn = ConnectionUtil.getConnection();
		
	}

	public static void main(String[] args) throws SQLException {
		
		BoardMain bm = new BoardMain();
		
		// Java에서 Procedure 호출
		// String sql = " insert into board values(seq_board.nextval, ?, ?, sysdate)";
//		String sql = "{call PROC_INSERT(?,?)}";
//		bm.cstmt = bm.conn.prepareCall(sql);
//		bm.cstmt.setString(1,  "제목1");
//		bm.cstmt.setString(2,  "내용1");
//		int result = bm.cstmt.executeUpdate();
//		if(result>0) {
//			System.out.println("한 행 입력 완료");
//		}
		
		// Java에서 IN OUT Procedure 호출
		String sql = "{ call PROC_INOUT(?) } ";
		bm.cstmt = bm.conn.prepareCall(sql);
		bm.cstmt.setInt(1, 5);		
		bm.cstmt.registerOutParameter(1, Types.NUMERIC); // DB입장에서는 나가는 데이터_OutParameter
		bm.cstmt.executeUpdate();
		System.out.println(bm.cstmt.getInt(1));
		
		
		
		
		// Java에서 Function만 호출
//		String sql = "{ ? = call FUNC_COUNT} "; // return이 있으니 ?로 받아서 콜한다.
//		bm.cstmt = bm.conn.prepareCall(sql);
//		bm.cstmt.registerOutParameter(1, Types.NUMERIC); // DB입장에서는 나가는 데이터_OutParameter
//		bm.cstmt.executeUpdate();
//		System.out.println("함수 호출 후 리턴 받은 값 : " + bm.cstmt.getInt(1));
		
		// SELECT 문 안 함수를 호출할 때
//		String sql = "SELECT FUNC_COUNT() CNT FROM DUAL";
//		bm.cstmt = bm.conn.prepareCall(sql);
//		ResultSet rs = bm.cstmt.executeQuery();
//		if(rs.next()) {
//			System.out.println(rs.getInt("CNT"));
//		}
		
		
//		String sql = "{ call PROC_INSERT2(?,?,?)}";
//		bm.cstmt = bm.conn.prepareCall(sql);		
//		bm.cstmt.setString(1,  "제목1"); // 오라클로 주는 데이터
//		bm.cstmt.setString(2,  "내용1"); // 오라클로 주는 데이터
//		bm.cstmt.registerOutParameter(3, Types.NUMERIC); // 오라클에서 가져온 CNT를 수행
//		int result = bm.cstmt.executeUpdate();
//		if(result>0) {
//			System.out.println("한 행 입력 완료");
//			System.out.println("전체 행의 수 : " + bm.cstmt.getInt(3));
//		}
//		
		
		
	} // main
	
	
} // class
