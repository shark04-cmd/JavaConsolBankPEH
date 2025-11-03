package banking11;

public class HighCreditAccount extends 
	Account implements ICustomDefine {
/*	Account 에 쓴것과 같이 부모 클래스를 자식클래스에 상속,
	하이클래스에서는 ICustomDefine(아이커스텀디파인)을 
	인터페이스 하여 신용등급 A,B,C 를 쓸수있음 */
	
	String ICustomDefine; // 신용등급 A , B , C 로 나뉘여져있음
	int interest_rate; // (기본)이자율
	int rate = 0; // 신용 이자율
	
/*	부모 클래스 Account 에 있는 생성자를 호출해 
	(계좌번호 이름 잔액 이자율) 등을 초기화 */
	public HighCreditAccount(String account_number, 
			String name, String ICustomDefine,
			int interest_rate,int balance) {
		super(account_number, name, balance ,interest_rate);
		this.ICustomDefine = ICustomDefine;
	}
	
/*	입금 (deposit) 규칙을 오버라이딩 하여 신용계좌에 맞게
	수정 신용등급에 맞게 A =7 ,B = 4 ,C = 2 인 값을
	ICustomDefine 에서 가져와서 입력된 문자를 값으로 수정	 */
	@Override
	public void deposit(int money) {
		if (ICustomDefine.equals("A")) rate = A;
		else if (ICustomDefine.equals("B")) rate = B;
		else if (ICustomDefine.equals("C")) rate = C;
		balance += ((balance * interest_rate / 100) 
			+ (balance * rate / 100) + money);
	}
	
//	일단 오버라이딩 하였지만 굳이 할 필요는 없음
	@Override
	public void withdraw(int money) {
		balance -= money;
	}
	
	@Override
	public void showAccInfo() {
		System.out.println("===========신용계좌===========");
		super.showAccInfo();
		System.out.println(" 신용 등급 : " + ICustomDefine);
		System.out.println(" 신용 이자율 : " + rate);
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