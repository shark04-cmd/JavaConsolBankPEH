package banking11;

import java.util.HashSet;
import java.util.InputMismatchException;

public class AccountManager {
	
/*	이 클래스에서 쓸 계좌번호 , 이름 , 신용등급 등을저장할 변수
	컨트롤 클래스로 이 클래스에서 대부분 계산 , 입력 등을 한다.
*/
	String account_number, name, ICustomDefine;
	int balance, interest_rate;
	
//	헤쉬셋을 사용하여 중복된 계좌번호를 관리
	private HashSet<Account> accounts;

//	객체를 생성할 때 계좌를 저장하기 위해 해시셋을 초기화
	public AccountManager(int num) {
		accounts = new HashSet<>();
	}

/*	신규 계좌 개설 makeAccount 
	
	조건 
	1. 신용계좌인지 보통계좌인지 나눌 것 
	2. 계좌번호 입력 
	3. 이름 입력 
	4. 잔액입력 
	5. 이자율 입력 
	6. 신용 등급 입력
	
	추가 조건!!!!! 
	1. 동일한 계좌가 존재하는지 확인하기 (계좌번호로 조회) 
	2. 만약 중복된 값이 존재하면 기존 정보를 삭제할지
		,아니면 유지할지 정하기 
	3. for 문이 아닌 equals() , hashCode() 
		를 오버라이딩하여 중복을 찾아 삭제 */
	
/*	계좌를 만드는 메서드 
	여기에서 계좌 생성을 함
	1. 신용인지 , 보통인지 계좌 선택
	2. 계좌번호 임력
	3. 만약 계좌 번호가 같은게 존재하면 
		덮어쓰기 할지, 원래 있던걸 그대로 쓸지 정함
	4. 이름 입력
	5. 계좌 잔액 입력
	6. 이자율 입력
	7. 신요 계좌일 시 신용등급 입력
	추가로 초이스의 값을 0으로 초기화 해서 스캔으로 입력된 값을 받는다.	*/
	public void makeAccount() {
		int choice = 0;
		
		System.out.println("===========계좌선택===========");
		System.out.println(" (1) 신용 신뢰 계좌 ");
		System.out.println(" (2) 보통 예금 계좌 ");
		System.out.print(" 선택해주세요 : ");
		
//		초이스의 값을 입력
		choice = BankingSystemMain.scan.nextInt();
		BankingSystemMain.scan.nextLine();
		
//		1~2 까지의 값만 립력받음
		if (choice > 0 && choice < 3) {
			System.out.println("===========신규계좌===========");
			System.out.print(" 계좌 번호 : ");
			account_number = BankingSystemMain
					.scan.nextLine();
			Account temp = new Account(account_number, null, 0, 0);
			
//			같은 계좌번호를 가진 값이 있는지 확인 후 있으면 true
			if (accounts.contains(temp)) {
				System.out.println("========================");
				System.out.println(" 입력하신 계좌가 이미 존재합니다.");
				System.out.println(" 계좌를 덮어쓰기 할까요? (Y) , (N)");
				System.out.print(" 입력해주세요 : ");
				String input = BankingSystemMain.scan
						.nextLine().trim().toUpperCase();
				
//				그 값을 덮어쓰기 할지 아니면 그대로 유지할지를 Y , N으로 선택
				if (input.equals("Y") || input.equals("YES")|| input.equals("예")
					|| input.equals("수락")|| input.equals("네")|| input.equals("넵")) {
					accounts.remove(temp);
					System.out.println(" 기존 계좌를 삭제 후 덮어쓰기 하였습니다 ");
					System.out.println("=====================================");
			        System.out.println(" 계좌 번호 : " + account_number);
				} 
				else {
					System.out.println("=====================================");
					System.out.println(" 신규 계좌 생성이 취소되었습니다.");
					return;
				}
			}
//			같은 계좌번호를 가진 값이 없을시 그대로 이름 계좌잔액 등을 입력
			System.out.print(" 이름 : ");
			name = BankingSystemMain.scan.nextLine();
			System.out.print(" 계좌 잔액 : ");
			balance = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
			System.out.print(" 이자율 : ");
			interest_rate = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
		}
//		신용등급이면 ICustomDefine 에 신용등급을 입력
		if (choice == 1) {
			System.out.println(" A, B, C 중에서 골라주세요! ");
			System.out.print(" 신용 등급 : ");
			ICustomDefine = BankingSystemMain.scan.
					nextLine().trim().toUpperCase();
			HighCreditAccount high = new HighCreditAccount
				(account_number, name, ICustomDefine, interest_rate, balance);
			accounts.add(high);
		} 
		else if (choice == 2) {
			accounts.add(new NormalAccount
				(account_number, name, balance, interest_rate));
		} 
//		신용등급 선택에서 1 혹은 2로만 입력 가능하게 정의 (1.신용계좌), (2.보통계좌)
		else {
			System.out.println("============================");
			System.out.println(" 1 혹은 2 로만 입력해주세요");
			return;
		}
//		아무런 예외상황이 없을 시 계좌정보 입력
		System.out.println("============================");
		System.out.println(" 계좌정보 입력이 완료되었습니다! ");
		return;
	}
	
/*	입금 계좌 depositMoney 
	입금 값 받는곳 deposit 
	조건 
	1. 입금액을 숫자로 입력할 것 
	2. 입금액이 0보다 많을 것 
	3. 입금시 500원단위로만 입금할 것 
	4. 입금시 이자율 반영하기 
	5. 신용 계좌일 경우 입금시 신용등급에 따른 이자율도 반영할 것 
	6. 입력한 계좌번호를 가진 계좌가 존재할 것 */
	public void depositMoney() { // 입금
		System.out.println("============입금============");
		System.out.println(" 계좌번호와 입금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String Accountsed = BankingSystemMain.scan.nextLine();
		int money;

		try {
			System.out.print(" 입금할 금액 : ");
			money = BankingSystemMain.scan.nextInt();
		} 
		catch (InputMismatchException e) {
			System.out.println("금액은 숫자로 입력해야 합니다.");
			return;
		}
		if (money <= 0) { // 0 < money 도 가능
			System.out.println("============================");
			System.out.println(" 입금액은 0원보다 많아야 합니다. ");
			return;
		}
		if (money % 500 != 0) {
			System.out.println("============================");
			System.out.println(" 입금액은 500원 단위로만 가능합니다.");
			return;
		}

		boolean found = false;
		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(Accountsed)) {
				acc.deposit(money);
				System.out.println("입금 후 현제 잔액은 " + acc.balance + " 원 입니다.");
				found = true;
				return;
			}
		}
		System.out.println("============================");
		System.out.println(" 입력하신 계좌가 없습니다. ");
		return;
	}
	
/*	출금 계좌 withdrawMoney 
	출금 값 받는곳 withdraw 
	조건 
	1. 출금액을 숫자만 입력할 것 
	2. 출금액이 0 보다 커야함
	3. 출금액이 잔고보다 많아야 할것 
	4. 출금시 1000원 단위로만 출금할것 
	5. 동일한 계좌가 존재할것		*/
	public void withdrawMoney() { // 출금
		System.out.println("============출금============");
		System.out.println();
		System.out.println(" 계좌번호와 출금할 금액을 입력해주세요! ");
		System.out.print(" 계좌번호 : ");
		String accounted = BankingSystemMain.scan.nextLine();
		int money;
		try {
//			계좌번호 입력후 출금액 입력
			System.out.print(" 출금할 금액 : ");
			money = BankingSystemMain.scan.nextInt();
			BankingSystemMain.scan.nextLine();
		} 
//		숫자만 입력 가능
		catch (InputMismatchException e) {
			System.out.println("=====================================");
			System.out.println(" 숫자만 입력이 가능합니다.");
			return;
		}
//		0보다 출금액이 많아야 가능
		if (0 >= money) {
			System.out.println("=====================================");
			System.out.println("출금액은 0원보다 많아야 합니다.");
			return;
		}
//		출금액이 1000단위로만 가능 (잔액을 1000으로 나눴을때 나머지가 0인것)
		if (0 != money % 1000) {
			System.out.println("=====================================");
			System.out.println(" 출금은 1000원 단위로만 가능합니다.");
			return;
		}
/*		만약 계좌 잔액보다 출금액이 많은 경우에는
		잔액을 전체 출금할지 아니면 그대로 유지할지 
		Y , N 을 선택		*/
		boolean found = false;
		for (Account acc : accounts) {
			if (acc.getAccountNumber().equals(accounted)) {
				found = true;
				if (money > acc.balance) {
					System.out.println(" 잔고가 부족합니다.");
					System.out.println(" 금액전체를 출금할까요? (Y) , (N)");
					System.out.print(" 입력해주세요 : ");
					String input = BankingSystemMain.scan.
							nextLine().trim().toUpperCase();
//					입력된 값에 공백을 제거, 모두 대문자로 변경 
//					그 후 Y와 문자가 동일할시 잔액 전체 출금 아니면 출금 취소
					if (input.equals("Y") || input.equals("YES")|| input.equals("예")
						|| input.equals("수락")|| input.equals("네")|| input.equals("넵")) {
						System.out.println("=====================================");
						System.out.println(acc.balance + "원이 출금되었습니다.");
						acc.withdraw(acc.balance);
						return; 
						// 내가 한 것 잔액 - 잔액을 해서 0원으로 만들었음
						// 다르게 하는법 잔액 = 0 잔액에 0을 대입해서 0원으로 만듦
					} 
					else {
						System.out.println("=====================================");
						System.out.println("출금이 취소되었습니다.");
						return;
					}
				}
//				만약 예외상황이 없을시에는 출금액을 출력
				acc.withdraw(money);
				System.out.println("=====================================");
				System.out.println(" 출금이 완료되었습니다! ");
				System.out.println(" 출금하신 계좌의 현제 금액은 : "
						+ acc.balance + " 원 입니다.");
				return;
			}
		}
//		계좌번호와 동일한 계좌가 없을시 출금 종료
		System.out.println("=====================================");
		System.out.println(" 동일한 계좌가 없습니다. ");
		return;
	}
	
/*	계좌정보 출력 
	모든 계좌정보가 출력된다. 
	정보 출력 showAccInfo 
	내용 
	신용 계좌 		보통 계좌 
	계좌 번호 		계좌 번호 
	이름 			이름
	계좌 잔액 		계좌 잔액 
	이자율 		이자율 
	신용등급				*/
	public void showAccInfo() {
		System.out.println("===========계좌출력===========");
		for (Account acc : accounts) {
			acc.showAccInfo();
		}
	}
	
/*	계좌정보 삭제 내가 입력한 값이랑 계좌 번호가 같다면 계좌 정보가 삭제된다. */
	public void deleteAccount() {
		System.out.println("===========계좌삭제===========");
		System.out.print(" 계좌 번호 : ");
		String account_number = BankingSystemMain.scan.nextLine();
		
//		계좌번호를 입력하여 같은 계좌가 있다면 삭제
		Account temp = new Account(account_number, null, 0, 0);
		if (accounts.remove(temp)) {
			System.out.println("=====================================");
			System.out.println(" 계좌번호에 맞는 계좌가 삭제되었습니다.");
			return;
		} 
//		계좌번호와 동일한 계좌가 없으면 계좌 삭제 종료
		else {
			System.out.println("=====================================");
			System.out.println(" 계좌번호에 맞는 계좌가 없습니다.");
			return;
		}
	}
}
/*
 * 컨트롤 클래스로 프로그램의 전반적인 기능을 구현한다.
 */