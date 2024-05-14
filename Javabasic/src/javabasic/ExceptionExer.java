/*
 * 예외처리 실습
 *  
 * 보험사고 발생시에 사고별 대응하는 프로그램
 *  1. 사고유형 : 정면충동사고, 후면충돌사고, 접촉사고
 *  2. 정명충돌사고시에는 경찰서와 119구급대에 연락
 *  3. 후면충돌사고시에는 보험직원을 파견
 *  4. 접촉하고시에는 보험가입자와 전화상담
 *  정면충동사고:후면충돌사고:접촉하고 비율은 1:3:6
 *  (Math.random으로 1~10 이용, 1:정면, 2~4 후면, 5~10 접촉)
 *  
 *  5. 뺑소니사고에는 경찰서에 대리전화 : 11
 *  
 *  사용자정의예외를 생성해서 예외처리를 통해서 구현
 *  
 *  
 */

package javabasic;

public class ExceptionExer {

	public static final String FRONT_ACC = "정면충돌사고"; // 정면충돌
	public static final String BACK_ACC = "후면충돌사고"; // 후면충동
	public static final String CONT_ACC = "접촉사고"; // 접촉사고

	public static void main(String[] args) {

		for (int i = 0; i < 10; i++) {
			int ran = ((int) (Math.random() * 11) + 1);

			try {
				if (ran == 1) {
					throw new FrontException();
				} else if (ran >= 2 && ran <= 4) {
					throw new BackException();
				} else if (ran >= 5 && ran <= 10) {
					throw new ContException();
				} else {
					throw new HitandrunException();
				}
			} catch (Exception ex) {
				String msg = "";
				if (ex instanceof FrontException) {
					msg = " 정면충돌 처리 완료";
				}
				if (ex instanceof BackException) {
					msg = "접촉사고 처리 완료";
				}
				if (ex instanceof ContException)
					;
				{
					msg = "뺑소니 처리 완료";
				}
				if (ex instanceof HitandrunException)
					;
				{
					msg = "후면충돌 처리 완료";
				}
			}

		}
	}
}

//		if(ran == 1) {
//			try {
//			throw new FrontException();
//		}catch(FrontException fe) {
//			System.out.println(fe.getMessage() + " 청명충돌 처리 완료");
//		}
//		} 
//		
//		else if(ran >= 5) {
//			try {
//			throw new ContException();
//		} catch(ContException ce) {
//			System.out.println(ce.getMessage() + "접촉사고 처리 완료");
//			
//		} 
//		}
//		else if(ran == 11) {
//			try {
//			throw new HitandrunException();
//		} catch(HitandrunException har) {
//			System.out.println(har.getMessage() + "뺑소니 처리 완료");
//			
//		} 
//		}
//			else {
//			try {
//			throw new BackException();
//		} catch (BackException be) {
//			System.out.println(be.getMessage() + "후면충돌 처리 완료");	
//		
//		}
//		}
