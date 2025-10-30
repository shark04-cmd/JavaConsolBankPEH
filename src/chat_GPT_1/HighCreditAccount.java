package chat_GPT_1;


public class HighCreditAccount {
	
	public String ANum; // 계좌번호
	public String name; // 이름
	public long BNum; // 잔고
	
	public HighCreditAccount(String ANum, String name, String BNum) {
		this.ANum = ANum;
		this.name = name;
		this.BNum = Long.parseLong(BNum);
	}
		
	void showAccInfo() {
		System.out.println("☆★☆신규 계좌 개설☆★☆");
		System.out.println("-----------------");
		System.out.print("계좌번호: "+ ANum);
		System.out.print("고객이름: "+ name);
		System.out.print("잔고 : "+ BNum + "원");
		System.out.println("-----------------");
		
		
		
	}
}
