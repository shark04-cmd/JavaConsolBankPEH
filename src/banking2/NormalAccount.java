package banking2;

public class NormalAccount extends Account {
	
	int interest_rate;
	
	public NormalAccount(String account_number, 
			String name, int balance, int interest_rate) {
		super(account_number, name, balance);
		this.interest_rate = interest_rate;
	}	
	
	public void deposit(int money) {
		balance += (balance * interest_rate / 100) + money;
	}
	
	public void withdraw(int money) {
		balance -= money;
	}
	
	@Override
	public void showAccInfo() {
		System.out.println("---------------------------");
		System.out.println(" 보통 예금 계좌 ");
		super.showAccInfo();
		System.out.println(" 이자율 : " + interest_rate + "%");
		System.out.println();
	}
}
/*
 * Account 의 자식클래스로 보통예금계좌를 의미한다. 생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.
 * 
 * 계좌번호(String 형), 이름(String 형), 잔액(int 형)
 * 
 * 
 * 일반계좌 : 잔고 + (잔고 * 기본이자) + 입금액
 */