package banking3;

import java.util.InputMismatchException;

public class AccountManager {

	String account_number, name, credit_interest_rate;
	int balance, interest_rate;
	
	private Account[] accounts;
	private int numOfAccounted;
	
	public AccountManager(int num) {
		accounts = new Account[num];
		numOfAccounted = 0;
	}
	
/*	신규 계좌 개설 makeAccount 조건 
	1. 신용계좌인지 보통계좌인지 나눌 것 
	2. 계좌번호 입력 
	3. 이름 입력 
	4. 잔액입력 
	5.이자율 입력 
	6. 신용 등급 입력 */
	public void makeAccount() {
		System.out.println(" ☆★☆계좌 선택☆★☆ ");
		System.out.println(" (1) 신용 신뢰 계좌 ");
		System.out.println(" (2) 보통 예금 계좌 ");
		System.out.print(" 선택해주세요! : ");
		int choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		System.out.println(" ☆★☆신규 계좌 개설☆★☆ ");
		System.out.print(" 계좌 번호 : ");
		account_number = BankingSystemMain.scan.nextLine();
		System.out.print(" 이름 : ");
		name = BankingSystemMain.scan.nextLine();
		System.out.print(" 계좌 잔액 : ");
		balance = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		System.out.print(" 이자율 : ");
		interest_rate = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
		if (choice == 1) {
			System.out.println(" A, B, C 중에서 골라주세요! ");
			System.out.print(" 신용 등급 : ");
			credit_interest_rate = BankingSystemMain.scan.nextLine();
			HighCreditAccount high = new HighCreditAccount(account_number, name, credit_interest_rate, interest_rate,
					balance);
			accounts[numOfAccounted++] = high;
		} else if (choice == 2) {
			System.out.print("");
			accounts[numOfAccounted++] = new NormalAccount(account_number, name, balance, interest_rate);
		}
		System.out.println();
		System.out.println(" 계좌정보 입력이 완료되었습니다! ");
		System.out.println();
		System.out.println("=====================================");
	}

/*	입금 계좌 depositMoney 
	입금 값 받는곳 deposit 조건 
	1. 입금액을 숫자로 입력할 것
	2. 입금액이 0보다 많을 것 
	3. 입금시 500원단위로만 입금할 것 
	4. 입금시 이자율 반영하기 
	5. 신용 계좌일 경우 입금시 신용등급에 따른 이자율도 반영할것 
	6. 동일한
	계좌가 존제할것
	 */
	public void depositMoney() { // 입금
		System.out.println(" 계좌번호와 입금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String Accountsed = BankingSystemMain.scan.nextLine();
		int money;

		try {
			System.out.print(" 입금할 금액 : ");
			money = BankingSystemMain.scan.nextInt();
		} catch (InputMismatchException e) {
			System.out.println("금액은 숫자로 입력해야 합니다.");
			return;
		}
		if (0 >= money) { // 0 < money 도 가능
			System.out.println(" 입금액은 0원보다 많아야 합니다.");
			return;
		}
		if (money % 500 != 0) {
			System.out.println(" 입금액은 500원 단위로만 가능합니다.");
			return;
		}
		for (int i = 0; i < numOfAccounted; i++) {
			if (accounts[i].account_number.equals(Accountsed)) {
				accounts[i].deposit(money);
				System.out.println("=====================================");
				return;
			}
		}
		System.out.println();
		System.out.println(" 동일한 계좌가 없습니다. ");
		System.out.println();
		System.out.println("=====================================");
		return;
	}

/*	출금 계좌 withdrawMoney 
	출금 값 받는곳 withdraw 
	조건 
	1. 출금액을 숫자만 입력할 것 
	2. 출금액이 0 보다 커야함
	3. 출금액이 잔고보다 많아야 할것 
	4. 출금시 1000원 단위로만 출금할것 
	5. 동일한 계좌가 존제할것 */
	public void withdrawMoney() { // 출금
		System.out.println(" 출금할 계좌를 선택해주세요! ");
		System.out.println(" 계좌번호와 출금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String accounted = BankingSystemMain.scan.nextLine();
		int money;
		try {
			System.out.print(" 출금할 금액 : ");
			money = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
			
		} catch (InputMismatchException e) {
			System.out.println(" 숫자만 입력이 가능합니다.");
			return;
		}
		if (0 >= money) {
			System.out.println("출금액은 0원보다 많아야 합니다.");
			return;
		}
		
		if (0 != money % 1000) {
			System.out.println(" 출금은 1000원 단위로만 가능합니다.");
			return;
		}
		for (int i = 0; i < numOfAccounted; i++) {
			if (accounts[i].account_number.equals(accounted)) {
				if (accounts[i].balance <= money) {
					System.out.println(" 잔고가 부족합니다.");
					System.out.println(" 금액전체를 출금할까요? (Y , N)");
					System.out.print(" 입력해주세요 : ");
					String input = BankingSystemMain.scan.
							nextLine().trim().toUpperCase();
					if (input.equals("Y")) {
						System.out.println(accounts[i].balance + "원이 출금되었습니다.");
						accounts[i].withdraw(accounts[i].balance);
						return;
					} 
					else {
						System.out.println("출금이 취소되었습니다.");
						return;
					}
				}
				accounts[i].withdraw(money);
				System.out.println();
				System.out.println(" 출금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 출금하신 계좌의 현제 금액은 : " +
						accounts[i].balance + " 원 입니다.");
				System.out.println("=====================================");
				return;
			}
		}
		System.out.println();
		System.out.println(" 동일한 계좌가 없습니다. ");
		System.out.println();
		System.out.println("=====================================");
		return;
	}
	
/*	계좌정보 출력 그냥 모든 계좌정보가 출력된다. 
	정보 출력 showAccInfo 
	내용 
	신용 계좌 		보통 계좌 
	계좌 번호 		계좌 번호 
	이름 			이름
	계좌 잔액 		계좌 잔액 
	이자율 		이자율 
	신용등급				*/
	public void showAccInfo() {
		System.out.println("☆★☆계좌정보가 출력되었습니다☆★☆");
		for (int i = 0; i < numOfAccounted; i++) {
			accounts[i].showAccInfo();
		}
		System.out.println("=====================================");
	}
}
/*
 * 컨트롤 클래스로 프로그램의 전반적인 기능을 구현한다.
 */