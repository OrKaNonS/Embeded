package javabasic.jdbc.board;

import java.sql.Timestamp;

public class Board {
	
//	BID NUMBER PRIMARY KEY,
//	BTITLE VARCHAR2(2000) NOT NULL, 
//	BCONTENT VARCHAR2(4000), 
//	BREGDATE TIMESTAMP
	
	private int bid;
	private String btitle;
	private String bcontent;
	private Timestamp bregdate;
	
	public Board() {
		
	}
	
	public Board(int bid, String btitle, String bcontent, Timestamp breddate) {
		super();
		this.bid = bid;
		this.btitle = btitle;
		this.bcontent = bcontent;
		this.bregdate = breddate;		
	}


	public int getBid() {
		return bid;
	}


	public void setBid(int bid) {
		this.bid = bid;
	}


	public String getBtitle() {
		return btitle;
	}


	public void setBtitle(String btitle) {
		this.btitle = btitle;
	}


	public String getBcontent() {
		return bcontent;
	}


	public void setBcontent(String bcontent) {
		this.bcontent = bcontent;
	}


	public Timestamp getBregdate() {
		return bregdate;
	}


	public void setBreddate(Timestamp breddate) {
		this.bregdate = breddate;
	}


	@Override
	public String toString() {
		return "Board [bid=" + bid + ", btitle=" + btitle + ", bcontent=" + bcontent + ", breddate=" + bregdate + "]";
	}
	
	
	
} // class
