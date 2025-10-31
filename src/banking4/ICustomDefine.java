package banking4;

public interface ICustomDefine {
	
	int MAKE	 = 1;
	int DEPOSIT	 = 2;
	int WITHDRAW = 3;
	int INQUIRE	 = 4;
	int DELETE	 = 5;
	int EXIT	 = 6;
	
	int A = 7;
	int B = 4;
	int C = 2;
	
}				
/*
interface 로 생성한다. 
메뉴선택과 이자율 지정을 위한 인터페이스형 상수를 정의한다. 
메뉴 : 계좌개설, 입금, 출금, 전체 계좌정보출력, 종료를 1~5까지로 지정한다.
추가 계좌정보삭제를 5번으로 추가하고 종료버튼을 6번으로 바꾼다.


이자율 : 고객의 신용등급을 A, B, C로 나눠서 7%, 4%, 2%로 지정한다.
*/