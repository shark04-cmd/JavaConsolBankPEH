package banking1;


public class HighCreditAccount {
	
	public String account_number;	// 계좌번호
	public String name;				// 이름
	public Long balance;				// 잔액
	
//	public 접근 제어자 (어디서든 이 생성자를 쓸 수 있음) NormalAccount (클래스 이름) 
//	String ㅁㅁ (객체를 만들 때 전받을 초기값)
//	요약] public( 어디서든 쓸수있다.) NormalAccount (노말 어카운트에 있는) (String ㅁㅁ) (생성자를 )
	public HighCreditAccount(String account_number, String name, Long balance) {
		this.account_number = account_number;
		this.name = name;
		this.balance = balance;
	}
	
	public void showAccInfo() {
		System.out.println("---------------------------");
		System.out.println(" 신용 신뢰 계좌 ");
		System.out.println(" 계좌 번호 : "+ account_number);
		System.out.println(" 성함 : "+ name);
		System.out.println(" 계좌 잔액 : "+ balance);
		System.out.println();
	}
}
/*
신용 신뢰 계좌

Account 의 자식클래스로 신용도가 높은 고객에게 개설이 허용되며 높은 이율의 계좌이다.
생성자를 통해서 이율정보(이자비율의정보)를 초기화 할수있도록 정의한다.

계좌번호(String형), 이름(String형), 잔액(int형)
*/