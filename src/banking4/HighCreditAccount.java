package banking4;

public class HighCreditAccount extends 
	Account implements ICustomDefine {
	
	String ICustomDefine; // 신용등급 A , B , C 로 나뉘여져있음
	
	int interest_rate; // 이자율
	String credit_interest_rate;

	public HighCreditAccount(String account_number, 
			String name, String credit_interest_rate,
			int interest_rate,int balance) {
		super(account_number, name, balance);
		this.interest_rate = interest_rate;
		this.ICustomDefine = credit_interest_rate;
	}
	
	@Override
	public void deposit(int money) {
		int rate = 0;
		if (ICustomDefine.equals("A")) rate = A;
		else if (ICustomDefine.equals("B")) rate = B;
		else if (ICustomDefine.equals("C")) rate = C;
		balance += ((balance * interest_rate / 100) 
			+ (balance * rate / 100) + money);
	}
	
	@Override
	public void withdraw(int money) {
		balance -= money;
	}
	
	@Override
	public void showAccInfo() {
		System.out.println("===========신용계좌===========");
		super.showAccInfo();
		System.out.println(" 이자율 : " + interest_rate + "%");
		System.out.println(" 신용 등급 : " + ICustomDefine);
	}
}
/*
신용 신뢰 계좌

Account 의 자식클래스로 신용도가 
높은 고객에게 개설이 허용되며 높은 이율의 계좌이다. 
생성자를 통해서 이율정보(이자비율의정보)를
초기화 할수있도록 정의한다.

계좌번호(String 형), 이름(String 형), 잔액(int 형)


신용계좌 : 잔고 + (잔고 * 기본이자) + (잔고 * 추가이자) + 입금액
*/