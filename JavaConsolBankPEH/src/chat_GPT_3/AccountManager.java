package chat_GPT_3;


import java.util.Scanner;

public class AccountManager implements ICustomDefine {

    private Account[] accounts;
    private int numOfAcc;
    private Scanner sc;

    public AccountManager() {
        accounts = new Account[50];
        numOfAcc = 0;
        sc = new Scanner(System.in);
    }

    public void showMenu() {
        System.out.println("-----Menu------");
        System.out.println("1.계좌개설");
        System.out.println("2.입\t금");
        System.out.println("3.출\t금");
        System.out.println("4.계좌정보출력");
        System.out.println("5.프로그램종료");
        System.out.print("선택:");
    }

    public void makeAccount() {
        System.out.println("***신규계좌개설***");
        System.out.println("-----계좌선택------");
        System.out.println("1.보통계좌");
        System.out.println("2.신용신뢰계좌");
        System.out.print("선택:");

        int choice;
        try {
            choice = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("숫자만 입력 가능합니다.\n");
            return;
        }

        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();
        System.out.print("고객이름: ");
        String name = sc.nextLine();
        System.out.print("잔고: ");
        int balance = Integer.parseInt(sc.nextLine());
        System.out.print("기본이자%(정수형태로입력): ");
        int interest = Integer.parseInt(sc.nextLine());

        if (choice == 1) {
            accounts[numOfAcc++] = new NormalAccount(accNum, name, balance, interest);
        } else if (choice == 2) {
            System.out.print("신용등급(A,B,C등급): ");
            String grade = sc.nextLine();
            accounts[numOfAcc++] = new HighCreditAccount(accNum, name, balance, interest, grade);
        } else {
            System.out.println("잘못된 선택입니다.\n");
        }

        System.out.println("계좌계설이 완료되었습니다.\n");
    }

    public void depositMoney() {
        System.out.println("***입   금***");
        System.out.println("계좌번호와 입금할 금액을 입력하세요");

        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();

        int money;
        try {
            System.out.print("입금액: ");
            money = Integer.parseInt(sc.nextLine());
        } 
        catch (NumberFormatException e) {
            System.out.println("금액은 숫자로 입력해야 합니다.\n");
            return;
        }

        if (money <= 0) {
            System.out.println("음수나 0원은 입금할 수 없습니다.\n");
            return;
        }

        if (money % 500 != 0) {
            System.out.println("입금은 500원 단위로만 가능합니다.\n");
            return;
        }

        for (int i = 0; i < numOfAcc; i++) {
            if (accounts[i].accNum.equals(accNum)) {
                accounts[i].deposit(money);
                System.out.println("입금이 완료되었습니다.\n");
                return;
            }
        }

        System.out.println("해당 계좌가 존재하지 않습니다.\n");
    }

    public void withdrawMoney() {
        System.out.println("***출   금***");
        System.out.println("계좌번호와 출금할 금액을 입력하세요");
        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();

        int money;
        try {
            System.out.print("출금액: ");
            money = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
            System.out.println("금액은 숫자로 입력해야 합니다.\n");
            return;
        }

        if (money <= 0) {
            System.out.println("음수나 0원은 출금할 수 없습니다.\n");
            return;
        }

        if (money % 1000 != 0) {
            System.out.println("출금은 1000원 단위로만 가능합니다.\n");
            return;
        }

        for (int i = 0; i < numOfAcc; i++) {
            if (accounts[i].accNum.equals(accNum)) {
                if (accounts[i].balance < money) {
                    System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
                    System.out.print("YES / NO : ");
                    String answer = sc.nextLine().trim().toUpperCase();

                    if (answer.equals("YES")) {
                        System.out.println(accounts[i].balance + "원이 출금되었습니다.\n");
                        accounts[i].withdraw(accounts[i].balance);
                        return;
                    } else {
                        System.out.println("출금이 취소되었습니다.\n");
                        return;
                    }
                }
                accounts[i].withdraw(money);
                System.out.println("출금이 완료되었습니다.\n");
                return;
            }
        }

        System.out.println("해당 계좌가 존재하지 않습니다.\n");
    }

    public void showAccInfo() {
        System.out.println("***계좌정보출력***");
        for (int i = 0; i < numOfAcc; i++) {
            accounts[i].showAccInfo();
        }
        System.out.println("전체계좌정보 출력이 완료되었습니다.\n");
    }
}
