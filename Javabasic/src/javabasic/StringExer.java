package javabasic;

import java.util.Scanner;

public class StringExer {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		// String 객체 생성
		
		//literal(리터럴) 방식
//		String str1 = "안녕하세요";
		
		
		// constructor(생성자) 방식
		char[] charArray = {'안','녕','하','세','요'};
		String str2 = new String(charArray);
		
//		System.out.println(str1);
		System.out.println("안녕하세요");
		System.out.println(str2);
		
		// 문자열의 인덱스(index)/길이(length)
		// 인덱스 = 0 ~ length-1
		String str3 = "Hello Java"; // index 0~9, length 10
		System.out.println(str3.charAt(0)); // H
		System.out.println(str3.charAt(5)); // 공백문자
		System.out.println(str3.length()); // 10
		
		//반복문을 사용해서 문자열의 문자 추출
		// 성능이 좋은 코드를 위해서 동이랗ㄴ 결과를 내는 메소드(기능)은 한번만 수행해서 변수에 값을 담아두고
		// 변수를 사용하는 것이 반복적으로 메소드를 호출하지 않느 성능이 좋은 코드이다.
		// 두 개의 결과는 동일하나 위에는 str3.length()를 계속 연산. 밑에는 leng 1번만 연산
		// 연산 수가 많아지면 위의 로직은 효율이 떨어짐.
				
		int leng = str3.length();  
		for(int i= 0 ; i<str3.length() ; i++) {System.out.println(str3.charAt(i));}
		for(int i= 0 ; i<leng ; i++) {System.out.println(str3.charAt(i));}
		
		// 한번만 사용되는 변수는 생성하지 않는 것이 좋은 코드
		// 두 개의 결과는 동일하나 위는 변수 선언하여 메모리를 차지함. 1번만 사용될 것이라면 아래처럼 하여 메모리를 줄이는게 좋다.
		String str4 = "Hi There";
		System.out.println(str4);
		System.out.println("Hi There");
		
		//for : 구문을 사요 ㅇ해서 배열의 요소(element)들을 출력
		for(char ch : charArray) { System.out.println(ch);}
		
		
		// 변수의 생성단계
		// 선언(Declaration) : 변수의 타입을 지정(메모리의 크기를 지정)
		int i;
		// i는 main 메소드 내에서 선언된 지역변수이므로 main 메소드 밖에서는 사용할 수 있다.
		// i는 main 메소드의 지역변수이므로 초기화 후에만 사용할 수 있다.
		// System.out.println("선언 후 : "+i);
		
		// 초기화(Initialization) : 변수의 값을 처음 할당(대입, 저장)
		i = 100;
		System.out.println("초기화 후 : "+i);
		
		// 할당(Assignment) : 초기화한 후 변수의 값을 저장
		i = 200;
		System.out.println("할당 후 : "+i);
		
		
		//문자열 조작
		String str5 = "안";
		String str6 = "녕";
		String str7 = "하";
		String str8 = "세";
		String str9 = "요";
		
		System.out.println(str5 + str6 + str7 + str8 + str9);
		
		
		// 문자열은 불면이므로 문자열에 접합연산(+)을 많이하면 불필요한 문자열들이 메모리에 생성됨.
		// String Buffer 또는 StringBuilder를 사용해서 문자열 조작작업을 버퍼상에서 진행하고 최종적으로 문자열을 한번만 생성한다.
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("안");
		sb.append("녕");
		sb.append("하");
		sb.append("세");
		sb.append("요");
		
		System.out.println(sb.toString());
		
		// String 주요 메서드
		String str10 = "동해물과 백두산이 마르고 닳도록";
		System.out.println(str10.charAt(5)); // 백
		System.out.println(str10.contains("백두산")); // "백두산"을 포함하고 있냐 -  true
		System.out.println(str10.endsWith("하느님이")); // "하느님이"로 끝나냐 - false
		byte[] byteArray = str10.getBytes();
		
		for(byte b : byteArray) { System.out.println((char)b); }
		System.out.println(str10.getBytes()); //
		
		System.out.println(str10.hashCode());
		System.out.println("동해물과 백두산이 마르고 닳도록".hashCode());
		System.out.println(str10.indexOf("산")); // 몇번 쨰 index냐? - 7
		System.out.println(str10.indexOf("마르고")); // 몇번 쨰 index냐? - 10
		System.out.println(str10.isEmpty()); // 문자열이 비어있냐? - false
		System.out.println(str10.lastIndexOf("도")); // 마지막 "도"의 인덱스 - 15
		System.out.println(str10.length()); // 길이는? 17
		System.out.println(str10.replace("백두산","한라산")); // 백두산 -> 한라산으로 변경
		System.out.println(str10.replace(" ","-")); // " " 공백을 "-"으로 변경
		String[] strSplit = str10.split(" "); // 공백을 기준으로 잘름(줄바꿈)
		for(String str : strSplit) { System.out.println(str); } // 자른것을 전체 출력
		
		String str11 = "      헬로우        ";
		System.out.println(str11.trim()); // 공백 제거
		
		

		String exerStr = "  Time is a kind friend, he will make us old 010/1234/5678  ";
		
		// 실습 1) exerStr문자열의 양쪽 공백을 제거
		 System.out.println(exerStr.trim());
		
		// 실습 2) Time을 Gold로 변경
		 System.out.println(exerStr.replace("Time","Gold"));
		 
		 System.out.println();
		
		// 실습 3) 전화번호를 010-1234-5678로 변경해서 전화번호만 출력
		 // 1. 전화번호 변경
		 // 2. 전화번호만 출력
		 System.out.println(exerStr.replace("/","-"));
		 System.out.println(exerStr.replace("/","-").substring(45,57)); // 해당 문자열 뒤로 출력
		
		 
		// 실습 4) exerStr문장열을 공백 기준으로 분리하여 String[]로 변환해 출력
		 String[] strSplit2 = exerStr.split(" ");
		 for(String str : strSplit2) { System.out.println(str);}
		 
		 System.out.println();
		
		// 실습 5) exerStr문장열을 공백 기준으로 분리하여 문자수가 3 이상인 것들만 출력
		 // 1. 공백 기준으로 분리
		 // 2. 문자수가 3애 이상인 문자열 출력
		 String[] strSplit3 = exerStr.split(" ");
		 for(String str : strSplit3)
			 if(str.length()>=3) {System.out.println(str);}
		 
		 System.out.println();
		 
		// 실습 6) i 문자의 인덱스들을 출력
		 //System.out.println(exerStr.charAt(i));
		 
		 int startIdx = 0;
		 for(int j=0 ; j<5 ; j++) {
			 startIdx = exerStr.indexOf("i", startIdx+1);
			 System.out.println(startIdx);
			 
		 }
				 
		 
		 
		 
		 System.out.println();
		
		// 실습 7) 전체 문자열을 소문자로 한번, 대문자로 한번 변경해서 출력
		System.out.println(exerStr.toLowerCase());
		System.out.println(exerStr.toUpperCase());
		
		
		
		
		
		
		
		
			
		
		
		
		
		
	} // main

} // class
