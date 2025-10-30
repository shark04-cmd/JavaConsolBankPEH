package banking;

import java.util.Scanner;

public class AccountManager {
	
	String account_number, name; 
	Long balance;
	
	
	
//	NormalAccount[] 보통계좌에 배열을 
//	만들 공간을 생성한다 
	private HighCreditAccount[] highCreditAccounts;
//	착각하지 않게 처음에는 이름 그대로 , 두번째는 s 붙여서 , 세번째는 ed 붙여서 한다
	private int numOfhighCreditAccounted;
	
/*  
	NormalAccount[] 보통계좌에 배열을 
	만들 공간을 생성한다 
	(쉽게 말하면 배열을 집 지금 상황을 땅이라고 가정했을 때
	집을 아직 만들지는 않았고 땅만 산 상태
	땅은 있는데 집이 없는 상황 어느 집이든 만들수 있음)
*/
	private NormalAccount[] normalAccounts;
//	착각하지 않게 처음에는 이름 그대로 , 두번째는 s 붙여서 , 세번째는 ed 붙여서 한다
	private int numOfNormalAccounted;
	
	public AccountManager(int num) {
		highCreditAccounts = new HighCreditAccount[num];
		numOfhighCreditAccounted = 0;
		normalAccounts = new NormalAccount[num];
		numOfNormalAccounted = 0;
	}

	public void makeAccount(int choice) {
		System.out.println("☆★☆신규 계좌 개설☆★☆");
//		값을 입력받아 옴 그 값으로 무언가를 호출함
		Scanner scan = new Scanner(System.in);
//		계좌번호 , 이름 , 계좌잔액을 호출한다.
		
//		1. 계좌 번호를 입력받는다.
		System.out.print(" 계좌 번호 : ");
//			계좌잔액에 입력받은(스캔) 값을 넣는다.
			account_number = scan.nextLine();
			
//		2. 이름을 입력받는다.
		System.out.print(" 이름 : ");
//			이름에 입력받은(스캔) 값을 넣는다.
			name = scan.nextLine();
			
//		3. 계좌 잔액을 입력받는다.
		System.out.print(" 계좌 잔액 : ");

//			계좌 잔액에 입력받은 값을 넣는다.
//			balance(계좌 잔액)은 계산이 필요하니 숫자형태로 바꿔준다.
			balance = Long.decode(scan.nextLine());
			
		
		
		if(choice==1) {
//			System.out.println(" 신용 등급 : "); 일단 뼈대 만든 후 나중에 수정할 예정 (스캔을 넣어야함)
			HighCreditAccount high = new HighCreditAccount(account_number, name, balance);
			highCreditAccounts[numOfhighCreditAccounted++] = high;
		}
		
		else if(choice==2) {
			NormalAccount normal = new NormalAccount(account_number, name, balance);
			normalAccounts[numOfNormalAccounted++] = normal;
		}
		
		
		System.out.println();
		System.out.println(" 계좌정보 입력이 완료되었습니다! ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void depositMoney() { // 입금
		
		System.out.println(" 입금할 계좌를 선택해주세요! ");
		System.out.println(" 계좌번호와 입금할 금액을 입력해주세요! ");
		Scanner scan = new Scanner(System.in);
		System.out.print(" 계좌번호 : ");
		String highCreditAccounted = scan.nextLine();
		System.out.print(" 입금할 금액 : ");
		int money = Integer.parseInt(scan.nextLine());
		
//		신용계좌에서 0부터 1씩 늘어나면서 같은걸 찾음
		for(int i = 0; i < numOfhighCreditAccounted ; i++) {
//			신용계좌에서 계좌번호가 같은 것을 찾음
			if(highCreditAccounts[i].account_number.equals(highCreditAccounted)) { 
				highCreditAccounts[i].balance += money;
				System.out.println();
				System.out.println(" 입금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 입금하신 계좌의 현제 금액은 : " + highCreditAccounts[i].balance + "원 입니다.");
				System.out.println("=====================================");
				return;
			}
		}
		System.out.println();
		System.out.println(" 동일한 계좌가 없습니다. ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void withdrawMoney() { // 출금
		
		System.out.println(" 출금할 계좌를 선택해주세요! ");
		System.out.println(" 계좌번호와 출금할 금액을 입력해주세요! ");
		Scanner scan = new Scanner(System.in);
		System.out.print(" 계좌번호 : ");
		String highCreditAccounted = scan.nextLine();
		System.out.print(" 출금할 금액 : ");
		int money = Integer.parseInt(scan.nextLine());
		
//		신용계좌에서 0부터 1씩 늘어나면서 같은걸 찾음
		for(int i = 0; i < numOfhighCreditAccounted ; i++) {
//			신용계좌에서 계좌번호가 같은 것을 찾음
			if(highCreditAccounts[i].account_number.equals(highCreditAccounted)) { 
				highCreditAccounts[i].balance -= money;
				
				System.out.println();
				System.out.println(" 출금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 출금하신 계좌의 현제 금액은 : " + highCreditAccounts[i].balance + " 원 입니다.");
				System.out.println("=====================================");
				return;
			}
		}
		System.out.println();
		System.out.println(" 동일한 계좌가 없습니다. ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void showAccInfo() { // 계좌 정보 출력
		
//		계좌정보 출력을 입력받으면 신용계좌를 0번부터 출력하고 그후 1이 더해진다음 1번출력
//		이게 끝날때까지 반복한다.
		System.out.println("☆★☆계좌정보가 출력되었습니다☆★☆");
		
		for(int i = 0 ; i < numOfhighCreditAccounted ; i++) {
			highCreditAccounts[i].showAccInfo();
		}
//		계좌정보 출력을 입력받으면 일반계좌를 0번부터 출력하고 그후 1이 더해진다음 1번출력
//		이게 끝날때까지 반복한다.
		for(int i = 0 ; i < numOfNormalAccounted ; i++) {
			normalAccounts[i].showAccInfo();
		}
		System.out.println("=====================================");
	}
}								// 시마이
/*
컨트롤 클래스로 프로그램의 전반적인 기능을 구현한다.
*/