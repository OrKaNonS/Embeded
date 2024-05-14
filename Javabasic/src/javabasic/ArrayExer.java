package javabasic;

import java.util.Scanner;

public class ArrayExer {
	public static void main(String[] args) {
		
		
		// 기본타입의 배열(int)
		
		int[] score = {100, 90, 80};
		System.out.println(score[1]);
		
		System.out.println(score.length);
		
		for(int i : score) {
			System.out.println(i);
		}
		
		
		// 참조타입의 배열
		String[] name = {"홍길동", "강감찬", "이순신"};
		for(String str : name) {System.out.println(str);}
		
		
		
		// 2차원 배열
		int[][] intArray = {
				{1, 2, 3},
				{10, 20, 30}
		};
		
		System.out.println(intArray.length); // 2
		System.out.println(intArray[1].length); // 3
		System.out.println(intArray[1][2]); // 30
		
		
		System.out.println();
		
		// 3차원 배열
		String[][][] strArray = {
				{
					{"가", "나"},
					{"다", "라"}
				},
				{
					{"마", "바"},
					{"사", "아"}
				}				
		};
		
		System.out.println(strArray.length); // 2
		System.out.println(strArray[0].length); // 2
		System.out.println(strArray[0][1].length); // 2
		System.out.println(strArray[1][0][1]); // 바
		
		
		//배열의 크기 지정
		int[] iArray = new int[5];//5개의 정수를 저장하는 배열
		iArray[0] = 1; 
		iArray[1] = 2;
		iArray[2] = 3;
		iArray[3] = 4;
		iArray[4] = 5;
				
	}

}
