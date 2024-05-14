package javabasic;

import java.util.Scanner;


public class ArrayLotto {
   public static void main(String args[]) {
      Scanner sc = new Scanner(System.in);
      
      
      // Math.random() : 0.0 <= 랜덤실수 < 1.0
      //(int)(Math.random()*45)+1 = 1~45중 랜덤한 정수
      

      int test = 0; // 번호 입력 오류 확인용
      
      int[] picknum = new int[7]; // 당첨된 번호
      int[] selnum = new int[6]; // 선택한 번호
      
      int pickleng = picknum.length; // 당첨된 번호 길이 - 7
      int selleng = selnum.length; // 선택한 번호 길이 - 6
      
      
      
      
      System.out.println("숫자 6개를 골라주세요 (1~45 / 중복안됨)");
      for(int i=0 ; i<selleng ; i++) { selnum[i] = sc.nextInt(); }
      

      //중복 or 45 넘는 숫자 입력이 오류 출력
      for(int i=0 ; i<selleng ; i++) {
         for(int j=0 ; j<i ; j++ ) 
            if(selnum[i]>45 || (selnum[i] == selnum[j]))
               test++;          
    }
      if(test>0) System.out.println("번호를 잘못입력하셨습니다. 다시 입력해주세요");
      
      
      for(int a = 0 ; a < 50 ; a++) // 50번 반복 실행
      { 
    	  
   
      //중복제거 7개의 1~45 범위의 랜덤 정수
      for(int i=0 ; i<pickleng ; i++) {
        picknum[i]=((int)(Math.random()*45)+1);
        for(int j=0 ; j<i ; j++) {
           if(picknum[i]==picknum[j])
              i--; // 중복 발생시 1번 더 랜덤 번호 생성
        }
      }  
      
      int luknum = 0; // 겹치는 번호(선택한 번호 + 당첨된 번호)
      
      
      //겹치는 번호 생길 시 luknum에 +1 씩 더하기
      for(int i=0 ; i<selleng ; i++) {
         for(int j=0 ; j<selleng ; j++) {
            if(selnum[i] == picknum[j])
               luknum++;
         }
      }      
      
      System.out.println();
      
      System.out.print("당첨된 숫자는 ");
      for(int i=0 ; i<6 ; i++) 
         System.out.print(picknum[i]);
      System.out.println("\n보너스 숫자는 " + picknum[6]);
      
      System.out.print("고객님께서는 ");
      
      for(int i=0 ; i<selleng ; i++) {
         if(luknum==5 && selnum[i]==picknum[6])
            System.out.println("2등에 당첨되셨습니다. 축하드립니다.");
      }
      
      if(luknum==6) System.out.println("1등에 당첨되셨습니다. 축하드립니다.");
      else if(luknum==5) System.out.println("3등에 당첨되셨습니다. 축하드립니다.");
      else if(luknum==4) System.out.println("4등에 당첨되셨습니다. 축하드립니다.");
      else if(luknum==3) System.out.println("5등에 당첨되셨습니다. 축하드립니다.");
      else System.out.println("이번에 당첨되지 않았습니다. 다음 기회에");
      }
      
      
      
// 개인과제
// 과제명 : 배열 로또
// 제출마감일 : 5/6(화)   
// 과제설명 : 배열을 이용해서 로또 645 프로그램을 작성하세요
// 프로세스
// 1. 프로그램 시작 시 사용자에게 7개의 서로 다른1~45 사이의 숫자를 입력 받는다.
// 2. 프로그램에서 랜덤한 숫자를 순서대로 7개 추출
// 3. 등수선정(보너스 숫자는 맨 마지막에 입력)
//   1). 앞에나온 6개와 사용자가 입력한 순서대로 6개가 일치하면 1등
//  2). 5개와 보너스 1개 일치하면 2등
//  3). 5개 맞으면 3등
//  4). 4개 맞으면 4등
//  5). 3개 맞으면 3등
//
// 4. 예시
// * 사용자가 1 1 2 3 4 5 6 입력 시 => 중복 숫자가 있습니다. 다시 입력하세요!
// * 사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤추출한 숫자가 1 2 3 4 5 6 45 => 1등
// *  사용자가 1 2 3 4 5 6 7 입력하고 프로그램에서 랜덤추출한 숫자가 1 2 3 4 5 45 7 => 2등
//
// 5. 주요 고려사항
//  - 사용자가 입력한 7개의 숫자에 중복이 있는지 체크, 중복이 있다면 다시 입력도록
//  - 프로그램에서 랜덤하게 생성한 7개싀 숫자에 중복이 없어야 한다.
//   - 사용자 입력 수와 랜덤 수와 비교해서 등수 연산 후 출력   
//      
// 6. 과제 제출 방법      
//   - 소스코드(java파일)와 실행결과 캡쳐이미지 압축해서 realchoky@naver.com으로 이름써서 제출
//      
//      
      
   }

}