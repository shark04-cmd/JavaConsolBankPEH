package chat_GPT_1;

public class Account {
    String accNum;   // 계좌번호
    String name;     // 이름
    int balance;     // 잔액

    public Account(String accNum, String name, int balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    public void deposit(int money) {
        balance += money;
    }

    public void withdraw(int money) {
        balance -= money;
    }

    public void showAccInfo() {
        System.out.println("-------------");
        System.out.println("계좌번호 : " + accNum);
        System.out.println("고객이름 : " + name);
        System.out.println("잔고 : " + balance);
        System.out.println("-------------");
    }
}
