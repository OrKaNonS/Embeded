package javabasic.io;

import java.io.Serializable;

public class StudentScore implements Serializable {

	// network 상에서 Studentscore의 ID

	public static final long serialVersionUID = 216540640648L;
	
	public StudentScore() {
		
	}

	public int sno; //  번호
	public String name; // 이름
	public int kor; // 국어점수
	public int eng; // 영어점수
	public int math; // 수학점수
	public int total; // 총점
	
	
	public int getSno() {
		return sno;
	}


	public void setSno(int sno) {
		this.sno = sno;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getKor() {
		return kor;
	}


	public void setKor(int kor) {
		this.kor = kor;
	}


	public int getEng() {
		return eng;
	}


	public void setEng(int eng) {
		this.eng = eng;
	}


	public int getMath() {
		return math;
	}


	public void setMath(int math) {
		this.math = math;
	}


	public int getTotal() {
		return total;
	}


	public void setTotal(int total) {
		this.total = kor + eng + math;
	}


	public StudentScore(int sno, String name, int kor, int eng, int math, int total) {
		super();
		this.sno = sno;
		this.name = name;
		this.kor = kor;
		this.eng = eng;
		this.math = math;
		this.total = total;
	}

	@Override
	public String toString() {
		return "StudentScore [sno=" + sno + ", name=" + name + ", kor=" + kor + ", eng=" + eng + ", math=" + math
				+ ", total=" + total + "]";
	}

}
