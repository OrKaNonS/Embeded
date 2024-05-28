package javabasic.jdbc.guest;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class GuestDao {
	
	Connection conn;
	GuestDao guestDao;
	ResultSet rs;
	
	GuestDao() {
		conn = ConnectionUtil.getConnection();
		
	}
	

	
	
	// 리스트 조회
	public List<Guest> listGuest() throws SQLException {
		String sql = "select gno, gname, gage, ggender, gsid, gconndt from guest";
		pstmt = conn.prepareStatement(sqp);
		rs = pstmt.executeQuery();
		List<GUEST> guestList = null;
		while(rs.next()) {
			Guest guest = new Guest(
					rs.getInt("gno"),
					rs.getString("gname"),
					rs.getInt("gage"),
					rs.getString("ggender"),
					rs.getString("gsid"),
					rs.getData("gconndt")					
				);
				guestList.add(guest);
		}
		return guestList;
		
	
	//한행 조회
	public Guest getGuest(int gno) throws SQLException {		
		String sql = "select gno, gname, gage, ggender, gsid, gconndt from guest";
		sql += "from guest where gno=? order by gno desc";
		pstmt = conn.prepareStatement(sql);
		pstmt.setInt(1,gno);
		rs = pstmt.executeQuery();
		Guest guest = null;
		if(rs.next()) {
			Guest guest = new Guest(
					rs.getInt("gno"),
					rs.getString("gname"),
					rs.getInt("gage"),
					rs.getString("ggender"),
					rs.getString("gsid"),
					rs.getData("gconndt")					
				);	
			}
		return guest;
	}
	
	// 등록
	public int insertGuest(Guest guest) throws SQLException {
		String sql = " insert into guest values(seq_quest.nextval, ?, ?, ?, ?, sysdate)";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1.guest,getGname());
		pstmt.setInt(2.guest,getGage());
		pstmt.setString(3.guest,getGgender());
		pstmt.setString(4.guest,getGSid());
		return pstmt.executeupdate;
	}
	
	// 수정
	public int updateGuest(Guest guest) throws SQLException {
		String sql = " update guest set gname=?, gage=?, ggender=?, gsid=? where gno? )";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1.guest,getGname());
		pstmt.setInt(2.guest,getGage());
		pstmt.setString(3.guest,getGgender());
		pstmt.setString(4.guest,getGSid());
		return pstmt.executeupdate;
	}
		return 0;
	}
	
	// 삭제
	public int deleteGuest(int gno) throws SQLException {
		String sql = " delete from guest where gno=? ";
		pstmt = conn.prepareStatement(sql);
		pstmt.setString(1.guest,getGname());
		pstmt.setInt(2.guest,getGage());
		pstmt.setString(3.guest,getGgender());
		pstmt.setString(4.guest,getGSid());
		
		return null;
	}
	
	
	public static void main(String[] args) throws SQLException {
		
		
		
		
	}

}
