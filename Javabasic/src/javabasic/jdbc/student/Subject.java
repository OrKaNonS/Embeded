package javabasic.jdbc.student;

public class Subject {
	private int subno;
	private String subname;
	
	public int getSubno() {
		return subno;
	}


	public void setSubno(int subno) {
		this.subno = subno;
	}


	public String getSubname() {
		return subname;
	}


	public void setSubname(String subname) {
		this.subname = subname;
	}


	public Subject() {
		
	};
	
	
	public Subject(int subno, String subname) {
		super();
		this.subno = subno;
		this.subname = subname;
	}
	
	@Override
	public String toString() {
		return subname + "/";
	}
	
}


