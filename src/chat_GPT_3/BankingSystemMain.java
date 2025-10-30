package chat_GPT_3;

import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountManager manager = new AccountManager();

        while (true) {
            manager.showMenu();

            try {
                int choice = Integer.parseInt(sc.nextLine());

                if (choice < MAKE || choice > EXIT) {
                    throw new MenuSelectException("1~5 사이의 숫자만 입력 가능합니다.");
                }

                switch (choice) {
                    case MAKE:
                        manager.makeAccount();
                        break;
                    case DEPOSIT:
                        manager.depositMoney();
                        break;
                    case WITHDRAW:
                        manager.withdrawMoney();
                        break;
                    case INQUIRE:
                        manager.showAccInfo();
                        break;
                    case EXIT:
                        System.out.println("프로그램을 종료합니다.");
                        return;
                }
            } catch (MenuSelectException e) {
                System.out.println("[예외발생] " + e.getMessage() + "\n");
            } catch (NumberFormatException e) {
                System.out.println("문자는 입력할 수 없습니다. 숫자만 입력해주세요.\n");
            }
        }
    }
}
