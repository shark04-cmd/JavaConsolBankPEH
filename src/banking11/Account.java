package banking11;

public class Account {
/*	부모 클래스인 Account(어카운트)에 
	
	HighCreditAccount(신용 계좌) 클래스 와
	NormalAccount(보통 계좌) 클래스 를
	자식클래스로 상속하여 공통으로 들어가는
	계좌번호, 이름, 잔액 등을 부모클래스에서 관리하고 
	
	자식클래스에서는 계좌 유형별 기능 구현
	신용계좌에서는 신용 등급을 구현 
	신용 등급에 따른 이자율 등을 구현	*/

	protected String account_number; // 계좌번호
	protected String name; // 이름
	protected int balance; // 잔액
	protected int interest_rate;

	public Account(String account_number, String name, int balance, int interest_rate) {
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
		this.interest_rate = interest_rate;
	}
	
/*	입금 메서드는 자식클래스에서 오버라이딩하여
	위에 쓴것처럼 신용계좌는 신용등급에 따른 이자율을 적용되도록
	deposit 메서드를 재정의 */
	public void deposit(int money) {
	}
	
/*	마찬가지로 출금 메서드도 자식클래스에서 오버라이딩 하였음
	굳이 할 필요는 없지만 만약 나중에 계좌별로 출금 방식을 정할수 있게	
	미리 지정, 그게 아니여도 입금 , 출금 순으로 
	코드를 보기 쉽게 쓰기!!	*/
	public void withdraw(int money) {
	}
	
/*	두 자식 클래스가 오버라이딩 한 showAccInfo 에
	동일한 계좌번호, 이름, 계좌 잔액, 이자율을 정리 
	신용계좌에는 신용 등급을 추가	 */
	public void showAccInfo() {
		System.out.println(" 계좌 번호 : " + account_number);
		System.out.println(" 성함 : " + name);
		System.out.println(" 계좌 잔액 : " + balance);
		System.out.println(" 이자율 : " + interest_rate + "%");
	}
	
//	같은 계좌번호가 있는지 확인함 계좌번호가 같으면 같은 해시코드를 가지게 됨
	@Override
	public int hashCode() {
		return account_number.hashCode();
	}
	
	
/*	그 헤쉬코드를 이용하여. 
	같은 클래스에서 같은 해쉬코드를 가지고있으면 
	이건 동일한 거다! 하면서 true 를 반환함 
	타입이 다르거나 널인 경우 false 를 반환	
	obj 가 어카운트 타입이 아니라면 비교할 필요가 없으니
	false를 반환	*/
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (!(obj instanceof Account))
			return false; // Account 계열이면 모두 비교 가능
		Account other = (Account) obj;
		return account_number.equals(other.account_number);
	}
	
/*	계좌번호를 직접 접근하는것을 막음
	외부에서 account_number 를 쓰면 값이 발뀔수도 있음	*/
	public String getAccountNumber() {
		return account_number;
	}
}

/*
NormalAccount.java : 보통 예금계좌 Ex) 5000 + (5000 * 0.02) + 2000 = 7,100원

HighCreditAccount.java : 신용도가 높은 고객들의 이율 높은 계좌 Ex) 5000 + (5000 * 0.02) +
(5000 * 0.04) + 2000 = 7,300원

메뉴도 인터페이스형 상수로 인터페이스 이상함 코드정렬

@Override 없는 부분(상속 받은 클래스)
*/
