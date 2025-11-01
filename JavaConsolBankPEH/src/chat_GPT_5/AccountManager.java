package chat_GPT_5;

import java.io.*;
import java.util.*;

public class AccountManager implements ICustomDefine {
    private Set<Account> accounts = new HashSet<>();
    private Scanner sc = new Scanner(System.in);
    private final String FILE_NAME = "AccountInfo.obj";

    // ✅ 생성자에서 자동으로 파일 복원
    public AccountManager() {
        loadAccountInfo();
    }

    public void showMenu() {
        System.out.println("-----Menu------");
        System.out.println("1.계좌개설");
        System.out.println("2.입\t금");
        System.out.println("3.출\t금");
        System.out.println("4.계좌정보출력");
        System.out.println("5.계좌정보삭제");
        System.out.println("6.프로그램종료");
        System.out.print("선택:");
    }

    public void makeAccount() {
        System.out.println("***신규계좌개설***");
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

        Account newAcc;
        if (choice == 1) {
            newAcc = new NormalAccount(accNum, name, balance, interest);
        } else if (choice == 2) {
            System.out.print("신용등급(A,B,C등급): ");
            String grade = sc.nextLine();
            newAcc = new HighCreditAccount(accNum, name, balance, interest, grade);
        } else {
            System.out.println("잘못된 선택입니다.\n");
            return;
        }

        if (accounts.contains(newAcc)) {
            System.out.println("중복계좌발견됨. 덮어쓸까요?(y or n)");
            String answer = sc.nextLine().trim().toLowerCase();
            if (answer.equals("y")) {
                accounts.remove(newAcc);
                accounts.add(newAcc);
                System.out.println("기존계좌를 덮어썼습니다.\n");
            } else {
                System.out.println("기존계좌정보를 유지합니다.\n");
            }
        } else {
            accounts.add(newAcc);
            System.out.println("계좌계설이 완료되었습니다.\n");
        }
    }

    public void depositMoney() {
        System.out.println("***입   금***");
        System.out.print("계좌번호: ");
        String accNum = sc.nextLine();

        int money;
        try {
            System.out.print("입금액: ");
            money = Integer.parseInt(sc.nextLine());
        } catch (NumberFormatException e) {
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

        for (Account acc : accounts) {
            if (acc.getAccNum().equals(accNum)) {
                acc.deposit(money);
                System.out.println("입금이 완료되었습니다.\n");
                return;
            }
        }

        System.out.println("해당 계좌가 존재하지 않습니다.\n");
    }

    public void withdrawMoney() {
        System.out.println("***출   금***");
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

        for (Account acc : accounts) {
            if (acc.getAccNum().equals(accNum)) {
                if (acc.balance < money) {
                    System.out.println("잔고가 부족합니다. 금액전체를 출금할까요?");
                    System.out.print("YES / NO : ");
                    String ans = sc.nextLine().trim().toUpperCase();
                    if (ans.equals("YES")) {
                        System.out.println(acc.balance + "원이 출금되었습니다.\n");
                        acc.withdraw(acc.balance);
                        return;
                    } else {
                        System.out.println("출금이 취소되었습니다.\n");
                        return;
                    }
                }
                acc.withdraw(money);
                System.out.println("출금이 완료되었습니다.\n");
                return;
            }
        }

        System.out.println("해당 계좌가 존재하지 않습니다.\n");
    }

    public void showAccInfo() {
        System.out.println("***계좌정보출력***");
        for (Account acc : accounts) {
            acc.showAccInfo();
        }
        System.out.println("전체계좌정보 출력이 완료되었습니다.\n");
    }

    public void deleteAccount() {
        System.out.println("***계좌정보삭제***");
        System.out.print("삭제할 계좌번호: ");
        String accNum = sc.nextLine();

        Account target = null;
        for (Account acc : accounts) {
            if (acc.getAccNum().equals(accNum)) {
                target = acc;
                break;
            }
        }

        if (target != null) {
            accounts.remove(target);
            System.out.println("계좌가 삭제되었습니다.\n");
        } else {
            System.out.println("해당 계좌가 존재하지 않습니다.\n");
        }
    }

    // ✅ 파일 저장 (프로그램 종료 시)
    public void saveAccountInfo() {
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {
            out.writeObject(accounts);
            System.out.println("[저장 완료] AccountInfo.obj 파일이 생성되었습니다.\n");
        } catch (IOException e) {
            System.out.println("파일 저장 중 오류 발생: " + e.getMessage());
        }
    }

    // ✅ 파일 복원 (프로그램 시작 시)
    @SuppressWarnings("unchecked")
    public void loadAccountInfo() {
        File file = new File(FILE_NAME);
        if (!file.exists()) return;

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(file))) {
            accounts = (Set<Account>) in.readObject();
            System.out.println("[불러오기 완료] 기존 계좌정보를 복원했습니다.\n");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("파일 복원 중 오류 발생: " + e.getMessage());
        }
    }
}
