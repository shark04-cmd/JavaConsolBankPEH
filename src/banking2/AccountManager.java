package banking2;

public class AccountManager {

	String account_number, name, credit_interest_rate;
	int balance, interest_rate;

	private Account[] accounts;
	private int numOfAccounted;

	public AccountManager(int num) {
		accounts = new Account[num];
		numOfAccounted = 0;

	}

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
			HighCreditAccount high = 
				new HighCreditAccount(account_number
					, name, credit_interest_rate, interest_rate,balance);
			accounts[numOfAccounted++] = high;
		} else if (choice == 2) {
			System.out.print("");
			accounts[numOfAccounted++] = 
				new NormalAccount(account_number, 
					name, balance, interest_rate);
		}
		System.out.println();
		System.out.println(" 계좌정보 입력이 완료되었습니다! ");
		System.out.println();
		System.out.println("=====================================");
	}

	public void depositMoney() { // 입금
		System.out.println(" 입금할 계좌를 선택해주세요! ");
		System.out.println(" 계좌번호와 입금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String Accountsed = BankingSystemMain.scan.nextLine();
		System.out.print(" 입금할 금액 : ");
		int money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		for (int i = 0; i < numOfAccounted; i++) {
			if (accounts[i].account_number.equals(Accountsed)) {
				accounts[i].deposit(money);
				System.out.println();
				System.out.println(" 입금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 입금하신 계좌의 현제 금액은 : "
					+ accounts[i].balance + "원 입니다.");
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
		System.out.print(" 계좌번호 : ");
		String accounted = BankingSystemMain.scan.nextLine();
		System.out.print(" 출금할 금액 : ");
		int money = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		for (int i = 0; i < numOfAccounted; i++) {
			if (accounts[i].account_number.equals(accounted)) {
				accounts[i].withdraw(money);
				System.out.println();
				System.out.println(" 출금이 완료되었습니다! ");
				System.out.println();
				System.out.println(" 출금하신 계좌의 현제 금액은 : " 
					+ accounts[i].balance + " 원 입니다.");
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
		System.out.println("☆★☆계좌정보가 출력되었습니다☆★☆");
		for (int i = 0; i < numOfAccounted; i++) {
			accounts[i].showAccInfo();
		}
		System.out.println("=====================================");
	}
}
/*
컨트롤 클래스로 프로그램의 전반적인 기능을 구현한다.
*/