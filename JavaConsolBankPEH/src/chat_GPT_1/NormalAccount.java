package chat_GPT_1;


public class NormalAccount {
	
	public String ANum; // 계좌번호
	public String name; // 이름
	public long BNum; // 잔고
	
	public NormalAccount(String ANum, String name, String BNum) {
		this.ANum = ANum;	// 계좌 번호
	    this.name = name;	// 이름
	    this.BNum = Long.parseLong(BNum); // 잔고를 계산 할 수 있게 long(숫자)타입으로 지정
	}
		
	public NormalAccount(String aNum2, String name2, long bNum2, double interestRate) {
		// TODO Auto-generated constructor stub
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
