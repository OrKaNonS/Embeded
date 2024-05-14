package javabasic;

import java.util.Scanner;

public class ArrayExer2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 실습 1) 1~100까지의 정수를 배열에 담아 출력
		int[] intArray = new int[100];
		int length = intArray.length;
		for(int i=0 ; i < length ; i++) {
			intArray[i] = i+1;
		System.out.println(intArray[i]);
		}
		
		System.out.println();
		
		// 실습 2) 1~100까지의 정수 중에서 홀수만 배열에 담아 출력
		int[] intArray2 = new int[50];
		int length2 = intArray2.length;
		for(int i=0 ; i < length2 ; i++) {
			intArray2[i] = i*2+1;
		System.out.println(intArray2[i]);
		}
		
		System.out.printf("%10d %10.2f %10s", 99999, 3.141592, "hello");
		
		System.out.println();
		
		
		
		// 실습 3) 아래 테이터에 2차원 배열을 만들어서 출력
		//			이름		국어		영어		수학
		//			홍길동	100		90		80
		//			강감찬	 90		80		70
		//			이순신	 80		70		60
		
		// 실습 4) 개인별 / 과목별 총점과 평균을 실습 3)에 추가해서 출력

		String[] nameArr = {"홍길동", "강감찬", "이순신"};
		
		int[][] scoreArr = {
				{100, 90, 80},
				{90, 80, 70},
				{80, 70, 60}
		};
		

		
		
		System.out.printf("\n%5s %5s %5s %5s %5s %5s", "이름", "국어", "영어", "수학", "총점", "평균");

		
		System.out.println();
		
		int[] sumArr = new int[3];
		int sumleng = sumArr.length;
		for(int k=0 ; k<sumArr.length; k++) {
			for(int l=0 ; l<sumArr.length ; l++)
				sumArr[k] += scoreArr[k][l];
		}
		
		//개인별 총점/평균
		int[][] pAgg = {
				{0,0}, // 홍길동 총점 평균
				{0,0}, // 강감찬 총점 평균
				{0,0}  // 이순신 총점 평균
		};
		
		// 과목별 총점/평균
		int[][] sAgg = {
				{0,0}, // 국어 총점 평균
				{0,0}, // 영어 총점 평균
				{0,0}  // 수학 총점 평균
		};
			
		
		int nameArrleng = nameArr.length;
		int scoreArrleng = scoreArr.length;
		for(int i=0 ; i<nameArrleng; i++) {			
			System.out.printf("\n%6s", nameArr[i]); // 이름 출력
			for(int j=0 ; j<scoreArrleng ; j++){
			System.out.printf("%6d", scoreArr[i][j]); // 개인점수 출력	
			pAgg[i][0] += scoreArr[i][j]; // 개인점수 총합
			sAgg[j][0] += scoreArr[i][j]; // 과목 총점
			}
			
			pAgg[i][1] = pAgg[i][0]/scoreArrleng; // 개인 평균 
			System.out.printf("%8d %6d", pAgg[i][0], pAgg[i][1]);		
		}
		

		
		
		
		for(int i=0; i<scoreArrleng; i++) {
			sAgg[i][1] = sAgg[i][0]/nameArrleng; // 과목 평균
		}
			for(int i=0 ; i<2 ; i++) {
				System.out.printf("\n%5s", i==0 ? "총점" : "평균");
			for(int j=0; j <scoreArrleng; j++) {
				System.out.printf("%7d", sAgg[j][i]);
				}
			}
	}
}
