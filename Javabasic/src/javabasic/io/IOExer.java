/*
 * IO 실습 2) 
 * 1. StudentScore 데이터클래스 생성(int sno, String name, int kor, int eng, int math, int total)
 * 2. IOExer에서 5개의 StudentScore 객체 생성 후 assets/studentscore.dat에 직렬화
 * 3. 직렬화된 객체를 역직렬화하여 학생 성적 데이터 출력
 * 4. 출력 시 과목별 총점도 출력
 *  
 */
package javabasic.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.List;

public class IOExer {
	public static void main(String[] args) {

		List<StudentScore> ssList = new ArrayList<StudentScore>();
		ssList.add(new StudentScore(1, "김", 100, 90, 80, 0));
		ssList.add(new StudentScore(2, "이", 90, 80, 70, 0));
		ssList.add(new StudentScore(3, "박", 80, 70, 60, 0));
		ssList.add(new StudentScore(4, "최", 70, 60, 50, 0));
		ssList.add(new StudentScore(5, "문", 60, 50, 40, 0));

		File file = null;
		FileOutputStream fos = null; // 파일을 쓰는 스트림
		ObjectOutputStream oos = null; // 객체를 내보내는 스트림

		FileInputStream fis = null; // 파일을 읽는 스트림
		ObjectInputStream ois = null; // 파일을 받는 스트림

		try {
			file = new File("D:\\embeded\\git\\Javabasic\\src\\assets\\StudentScore.dat");
			fos = new FileOutputStream(file);
			oos = new ObjectOutputStream(fos);
			oos.writeObject(ssList); // 직렬화 메소드

			fis = new FileInputStream(file);
			ois = new ObjectInputStream(fis);

			// 역직렬화 및 Object타입을 List 타입으로 변경
			List<StudentScore> readList = (ArrayList<StudentScore>) ois.readObject();

			int korTotal = 0;
			int engTotal = 0;
			int mathTotal = 0;

			for (StudentScore ss : readList) {
				ss.setTotal(0); // 점수 총점 해주는 메소드
				korTotal += ss.kor;
				engTotal += ss.eng;
				mathTotal += ss.math;
				System.out.println(ss);
			}
			System.out.println("국어총점 : " + korTotal + " 영어총점 : " + engTotal + " 수학총점 : " + mathTotal);

		} catch (ClassNotFoundException cnfe) {
			cnfe.printStackTrace();
		} catch (FileNotFoundException fnfe) {
			fnfe.printStackTrace();
		} catch (IOException ioe) {
			ioe.printStackTrace();

		} finally {
			try {
				ois.close();
				oos.close();
			} catch (IOException ioe) {
				ioe.printStackTrace();
			}

		}

	} // main
} // class
