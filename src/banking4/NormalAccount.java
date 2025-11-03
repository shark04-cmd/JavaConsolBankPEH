package banking4;

public class NormalAccount extends Account {
	int interest_rate;
/*	Account 에 쓴것과 같이 부모 클래스를 자식클래스에 상속 */	
	public NormalAccount(String account_number, 
			String name, int balance, int interest_rate) {
		super(account_number, name, balance, interest_rate);
		this.interest_rate = interest_rate;
	}	
	
//	신용계좌와 동일하게 입금을 오버라이딩 하여 노말계좌에 맞게 규칙을 변경
	@Override
	public void deposit(int money) {
		balance += (balance * interest_rate / 100) + money;
		System.out.println(" 입금이 완료되었습니다! ");
	}
	
//	신용계좌와 동일하게 출금을 오버라이딩 하였지만 굳이 할 필요는 없음
//	(신용 계좌와 보통 계좌 로직이 같음)
	@Override
	public void withdraw(int money) {
		balance -= money;
		
	}
	
//	계좌 출력을 오버라딩하여 신용계좌와 동일한 것을 출력
	@Override
	public void showAccInfo() {
		System.out.println("===========보통계좌===========");
		super.showAccInfo();
	}
}
/*
Account 의 자식클래스로 보통예금계좌를 의미한다. 
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.

계좌번호(String 형), 이름(String 형), 잔액(int 형)


일반계좌 : 잔고 + (잔고 * 기본이자) + 입금액
*/