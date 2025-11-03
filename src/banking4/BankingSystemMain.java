package banking4;
 
import java.util.InputMismatchException;
import java.util.Scanner;
/*	지금 까지 한것
	1. 이 프로그램에 뼈대 제작 
	(기본적인 입금 출금 계좌개설 등의 기능을 제작)
	
	2. 새로운 부모클래스를 만들어 자식클래스를 2개로 하여 
	두개의 자식클래스의 차이점에 따라 관리
	
	3. 예외처리 및 추가로 입금, 출금을 할 때 
	조건을 만듦
	
	4. 중복된 계좌들을 발견하고 그를 처리할지 유지할지
	선택하는 조건을 만듦
	추가로 메인에 계좌정보 삭제하는 메뉴를 추가
	
 */
public class BankingSystemMain extends MenuSelectException {
/*	예외처리를 위해 MenuSelectException 를 상속받음
	실행시 문자 입력을 위해 스케너를 사용함
	추가로 스태틱 메서드를 사용해서 어디서든 동일하게 사용할 수 있게 만듦   */
	public static Scanner scan = new Scanner(System.in);
	
	public static void showMenu() {
		
//		시작시 출력되는 문구들
		System.out.println();
		System.out.println("============MENU============");
		System.out.println(" 원하시는 번호를 선택해주세요!");
		System.out.println(" (1) 계좌 개설 ");
		System.out.println(" (2) 입금 ");
		System.out.println(" (3) 출금 ");
		System.out.println(" (4) 계좌정보 출력");
		System.out.println(" (5) 계좌정보 삭제");
		System.out.println(" (6) 프로그램 종료");
		System.out.print(" 메뉴 선택 :");
	}
	
/*	프로그램이 시작됨
	추가로 계좌들을 관리할 객체 생성 최대 50개까지 계좌 관리 가능 
	while 문을 통해 무한루프를 걸어줘서 사용자가 종료를 할 때 까지
	메뉴가 반복됨
	1~6까지 번호만 입력이 가능하고 그 범위를 벗어나면 
	사용자정의 예외 발생 (MenuSelectException)
	*/
	public static void main(String[] args) {
		AccountManager handler = new AccountManager(50);
		while (true) {
			showMenu();
			
			try {
				int choice = scan.nextInt();
				BankingSystemMain.scan.nextLine();
				if (choice < ICustomDefine.MAKE 
					|| choice > ICustomDefine.EXIT) {
					throw new MenuSelectException();
				}
				switch (choice) {
				case ICustomDefine.MAKE: 	// 계정 생성 
					handler.makeAccount();	
					break;
				case ICustomDefine.DEPOSIT:	// 입금
					handler.depositMoney();
					break;
				case ICustomDefine.WITHDRAW:// 출금
					handler.withdrawMoney();
					break;
				case ICustomDefine.INQUIRE:	// 계좌정보 출력
					handler.showAccInfo();
					break;
				case ICustomDefine.DELETE:	// 계좌정보 삭제
					handler.deleteAccount();
					break;
				case ICustomDefine.EXIT:	// 프로그램 종료
					System.out.println("============================");
					System.out.println(" 프로그램 종료 ");
					return;
				}
			}
/*			예외처리 1 ~ 6 까지 정수만 입력가능
			숫자만 입력가능		*/
			catch (MenuSelectException e) {
				System.out.println("============================");
				System.out.println(e.getMessage());
			}
			catch (InputMismatchException e) {
				System.out.println("============================");
				System.out.println(" 숫자만 써주세요!");
				scan.nextLine();
			}
		}
	}
}

/*
main 메서드를 포함한 클래스. 프로그램은 여기서 실행한다.

MAKE	= 1 
DEPOSIT	= 2 
WITHDRAW= 3 
INQUIRE	= 4 
DELETE	= 5
EXIT	= 6

void showMenu(); 메뉴출력 
void makeAccount(); 계좌개설을 위한 함수 
void depositMoney(); 입금 
void withdrawMoney(); 출 금 
void showAccInfo(); 전체계좌정보출력
*/