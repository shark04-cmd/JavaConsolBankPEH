package banking1;

import java.awt.Menu;
import java.util.Scanner;

public class BankingSystemMain {
	
//	메뉴 출력 ( 처음르로 시작할 시 보이는 것 )
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
		
//		스케너 무언가 콘솔에 글을 써서 상호작용 할 수 있게 만들어준다.
		Scanner scan = new Scanner(System.in);
		
//		계좌의 갯수를 최대 50개로 지정하고 매니져클레스에 저장
		AccountManager handler = new AccountManager(50);
		
		
//		무한으로 돌아가게 함
		while(true) {
//			가장 처음 출력시 showMenu가 출력됨
			showMenu();
//			숫자중 정수만 입력을 받고 그값으로 선택함
			int choice = scan.nextInt();
			switch(choice) {
			case 1: 
				handler.makeAccount(choice); // 신규 계좌 개설
				break;
			
			case 2:
				handler.depositMoney(); // 입금
				break;
			case 3:
				handler.withdrawMoney(); // 출금
				break;
				
			case 4:
				handler.showAccInfo(); // 전체 계좌 출력
				break;
				
			case 5:
				System.out.println(" 프로그램 종료 "); // 프로그램 종료
				return;
			}	
		}
	}
}
/*
main 메서드를 포함한 클래스. 프로그램은 여기서 실행한다. 

MAKE=1
DEPOSIT=2
WITHDRAW=3
INQUIRE=4
EXIT=5

void showMenu();       // 메뉴출력
void makeAccount();    // 계좌개설을 위한 함수
void depositMoney();    // 입    금
void withdrawMoney(); // 출    금
void showAccInfo();  // 전체계좌정보출력

*/