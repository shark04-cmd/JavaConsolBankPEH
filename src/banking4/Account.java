package banking4;

public class Account {
	
	String account_number; 	// 계좌번호
	String name; 			// 이름
	int balance;			// 잔액
	
	public Account(String account_number, String name, int balance) {
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
	}
	
	public void deposit(int money) {
	}
	
	public void withdraw(int money) {
		
	}
	
	public void showAccInfo() {
		System.out.println(" 계좌 번호 : " + account_number);
		System.out.println(" 성함 : " + name);
		System.out.println(" 계좌 잔액 : " + balance);
	}
}

/*
NormalAccount.java : 보통 예금계좌 
Ex) 5000 + (5000 * 0.02) + 2000 = 7,100원

HighCreditAccount.java : 
	신용도가 높은 고객들의 이율 높은 계좌 
	Ex) 5000 + (5000 * 0.02) +
	(5000 * 0.04) + 2000 = 7,300원

의 부모클래스로 만든다.

메뉴도 인터페이스형 상수로 인터페이스 이상함 코드정렬

@Override 없는 부분(상속 받은 클래스)
*/
