package chat_GPT_5;

import java.util.Scanner;

public class BankingSystemMain implements ICustomDefine {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        AccountManager manager = new AccountManager();

        while (true) {
            manager.showMenu();
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case MAKE -> manager.makeAccount();
                    case DEPOSIT -> manager.depositMoney();
                    case WITHDRAW -> manager.withdrawMoney();
                    case INQUIRE -> manager.showAccInfo();
                    case 5 -> manager.deleteAccount();
                    case 6 -> {
                        manager.saveAccountInfo(); // ✅ 프로그램 종료 시 저장
                        System.out.println("프로그램을 종료합니다.");
                        return;
                    }
                    default -> System.out.println("잘못된 선택입니다. 1~6 입력해주세요.\n");
                }
            } catch (NumberFormatException e) {
                System.out.println("문자는 입력할 수 없습니다. 숫자만 입력해주세요.\n");
            }
        }
    }
}
