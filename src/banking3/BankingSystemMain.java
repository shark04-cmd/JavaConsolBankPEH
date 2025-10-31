package banking3;

import java.util.InputMismatchException;
import java.util.Scanner;

public class BankingSystemMain extends MenuSelectException implements ICustomDefine {
	
	public static Scanner scan = new Scanner(System.in);
	
	String ICustomDefine;
	
	public static void showMenu() {
		System.out.println(" 원하시는 번호를 선택해주세요!");
		System.out.println(" (1) 개좌 개설 ");
		System.out.println(" (2) 입금 ");
		System.out.println(" (3) 출금 ");
		System.out.println(" (4) 계좌정보 출력");
		System.out.println(" (5) 프로그램 종료");
		System.out.print(" 메뉴 선택 :");
	}
	
	public static void main(String[] args) {
		AccountManager handler = new AccountManager(50);
		while (true) {
			showMenu();
			
			try {
				int choice = scan.nextInt();
				BankingSystemMain.scan.nextLine();
				if (choice < MAKE || choice > EXIT) {
					throw new MenuSelectException();
				}
				switch (choice) {
				case MAKE:
					handler.makeAccount();
					break;
				case DEPOSIT:
					handler.depositMoney();
					break;
				case WITHDRAW:
					handler.withdrawMoney();
					break;
				case INQUIRE:
					handler.showAccInfo();
					break;
				case EXIT:
					System.out.println(" 프로그램 종료 ");
					return;
				}
			}
			catch (MenuSelectException e) {
				System.out.println("=====================================");
				System.err.println();
				System.out.println(" 1~5 사이만 써주세요! ");
				System.out.println("=====================================");
			}
			catch (InputMismatchException e) {
				System.out.println("=====================================");
				System.err.println();
				System.out.println(" 숫자만 써주세요!");
				System.out.println("=====================================");
				scan.nextLine();
			}
		}
	}
}

/*
main 메서드를 포함한 클래스. 프로그램은 여기서 실행한다.

MAKE=1 DEPOSIT=2 WITHDRAW=3 INQUIRE=4 EXIT=5

void showMenu(); 메뉴출력 
void makeAccount(); 계좌개설을 위한 함수 
void depositMoney(); 입금 
void withdrawMoney(); 출 금 
void showAccInfo(); 전체계좌정보출력
*/