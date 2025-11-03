package chat_GPT_2;

import java.util.Scanner;

public class BankingSystemMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountManager manager = new AccountManager();

        while (true) {
            manager.showMenu();

            int choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case ICustomDefine.MAKE:
                    manager.makeAccount();
                    break;
                case ICustomDefine.DEPOSIT:
                    manager.depositMoney();
                    break;
                case ICustomDefine.WITHDRAW:
                    manager.withdrawMoney();
                    break;
                case ICustomDefine.INQUIRE:
                    manager.showAccInfo();
                    break;
                case ICustomDefine.EXIT:
                    System.out.println("프로그램을 종료합니다.");
                    return;
                default:
                    System.out.println("잘못된 선택입니다. 다시 입력해주세요.\n");
            }
        }
    }
}
