package javabasic.jdbc.guest;

import java.sql.Date;

public class Guest {
	
	private int gno;	
	private String gname;
	private int gage;
	private String ggender; 
	private String sid;
	private Date gconndt;
	
	public Guest () {		
	}

	public Guest(int gno, String gname, int gage, String ggender, String sid, Date gconndt) {
		super();
		this.gno = gno;
		this.gname = gname;
		this.gage = gage;
		this.ggender = ggender;
		this.sid = sid;
		this.gconndt = gconndt;
	}

	public int getGno() {
		return gno;
	}

	public void setGno(int gno) {
		this.gno = gno;
	}

	public String getGname() {
		return gname;
	}

	public void setGname(String gname) {
		this.gname = gname;
	}

	public int getGage() {
		return gage;
	}

	public void setGage(int gage) {
		this.gage = gage;
	}

	public String getGgender() {
		return ggender;
	}

	public void setGgender(String ggender) {
		this.ggender = ggender;
	}

	public String getSid() {
		return sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Date getGconndt() {
		return gconndt;
	}

	public void setGconndt(Date gconndt) {
		this.gconndt = gconndt;
	}

	@Override
	public String toString() {
		return "GuestDao [gno=" + gno + ", gname=" + gname + ", gage=" + gage + ", ggender=" + ggender + ", sid=" + sid
				+ ", gconndt=" + gconndt + "]";
	}

	
	

}
