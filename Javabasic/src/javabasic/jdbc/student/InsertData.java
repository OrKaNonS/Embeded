package javabasic.jdbc.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class InsertData {

	Connection conn;

	InsertData() {
		conn = ConnectionUtil.getConnection();
	}
	
	List<Student> studentList; // 학생 리시트
	List<Subject> subjectList; // 과목 리스트

	public void startInsertData() {

		//객체 생성
		

		// 과목 데이터를 배열 저장
		String[] subjectArray = { "국어", "영어", "수학", "과학", "역사" };

		try {
			// 과목 데이터 insert			
			for (int i=0; i<subjectArray.length; i++ ) {
				String sql = " insert into subject values(subject_seq.nextval, '" 
						+ subjectArray[i] + "') ";
				conn.createStatement().execute(sql);
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		}

		// 학생리스트, 과목리스트 생성
		studentList = new ArrayList<Student>();
		subjectList = new ArrayList<Subject>();
		
		// 과목리스트에 과목객체들 추가
		subjectList.add(new Subject(1, "국어"));
		subjectList.add(new Subject(2, "영어"));
		subjectList.add(new Subject(3, "수학"));
		
		// 학생리스트에 학생객체를 추가 
		studentList.add(new Student(0, "홍길동", 20, "M", subjectList));

		subjectList = new ArrayList<Subject>();
		
		subjectList.add(new Subject(1, "국어"));
		subjectList.add(new Subject(2, "영어"));
		
		studentList.add(new Student(0, "김길순", 30, "F", subjectList));

		subjectList = new ArrayList<Subject>();
		
		subjectList.add(new Subject(2, "영어"));
		subjectList.add(new Subject(3, "수학"));
		
		studentList.add(new Student(0, "최길동", 40, "M", subjectList));

		subjectList = new ArrayList<Subject>();
		
		subjectList.add(new Subject(1, "국어"));
		subjectList.add(new Subject(3, "수학"));
		
		studentList.add(new Student(0, "박길순", 50, "F", subjectList));
		
		subjectList = new ArrayList<Subject>();
		
		subjectList.add(new Subject(1, "국어"));
		subjectList.add(new Subject(2, "영어"));
		subjectList.add(new Subject(3, "수학"));
		subjectList.add(new Subject(4, "과학"));
		
		studentList.add(new Student(0, "유길동", 60, "M", subjectList));

		
		// 학생리스트 -> 학생 -> 과목리스트 -> 과목 추출 후 insert
		PreparedStatement pstmt = null;
		try {
			for (Student student : studentList) {
				for (Subject subject : student.getSubjectList()) {
					String sql = "insert into student values(student_seq.nextval, ?, ?, ?, ?)";
					pstmt = conn.prepareStatement(sql);
					pstmt.setString(1, student.getSname());
					pstmt.setInt(2, student.getSage());
					pstmt.setString(3, student.getSgender());
					pstmt.setInt(4, subject.getSubno());
					pstmt.executeUpdate();
				}
			}
		} catch (SQLException sqle) {
			sqle.printStackTrace();
		} finally {
			try {
				pstmt.close();
				ConnectionUtil.closeConnection(conn);
			} catch (SQLException sqle) {
				sqle.printStackTrace();
			}
		}

	} 
	// main
	
	// 학생리스트 반환 메소드
	List<Student> getStudentList() {
		return studentList;
	}
	
} // class
