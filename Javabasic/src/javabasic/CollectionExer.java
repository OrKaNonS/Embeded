// Collection 실습
// 3개의 반에 각각 3명의 국어, 영어, 수학 점수가 있다
// 반별 각 학생의 국영수 촘점을 산출해 반, 이름, 총점을 출력하는 프로그램을 만들어 보자

package javabasic;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class CollectionExer  {
	
	public static void main(String[] args) {
		
		StudentScore S11 = new StudentScore(1, 1, "홍길동", 100, 100, 100, 0);
		StudentScore S12 = new StudentScore(1, 2, "김길동", 90, 90, 90, 0);
		StudentScore S13 = new StudentScore(1, 3, "이길동", 80, 80, 80, 0);
		StudentScore S21 = new StudentScore(2, 1, "최길동", 70, 70, 70, 0);
		StudentScore S22 = new StudentScore(2, 2, "박길동", 60, 60, 60, 0);
		StudentScore S23 = new StudentScore(2, 3, "조길동", 50, 50, 50, 0);
		StudentScore S31 = new StudentScore(3, 1, "장길동", 40, 40, 40, 0);
		StudentScore S32 = new StudentScore(3, 2, "주길동", 30, 30, 30, 0);
		StudentScore S33 = new StudentScore(3, 3, "성길동", 20, 20, 20, 0);
		
		
		// HashMap -> LinkedHashMap 로 변경해주면 정렬이 된다.
		// HashMap은 순서가 없어서 정렬 없이 출력이 된다.
		
	
		
//		Map<String, StudentScore> map = new LinkedHashMap<String, StudentScore> ();
		Map<String, StudentScore> map = new HashMap<String, StudentScore> ();
		map.put("s11", S11);	map.put("s12", S12);	map.put("s13", S13);
		map.put("s21", S21);	map.put("s22", S22);	map.put("s23", S23);
		map.put("s31", S31);	map.put("s32", S32);	map.put("s33", S33);
		
		map.values().forEach(studentScore -> System.out.println(studentScore));

		
		
		
		
		
	}
	
	
	
	
}
