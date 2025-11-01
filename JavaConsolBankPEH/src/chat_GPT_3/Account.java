package chat_GPT_3;

public abstract class Account {
    protected String accNum;
    protected String name;
    protected int balance;

    public Account(String accNum, String name, int balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    // 입금 메서드 (추상메서드 아님 - 자식에서 오버라이드 가능)
    public void deposit(int money) {
        balance += money;
    }

    // 출금 (공통기능)
    public void withdraw(int money) {
        balance -= money;
    }

    // 계좌정보 출력 (공통)
    public void showAccInfo() {
        System.out.println("-------------");
        System.out.println("계좌번호>" + accNum);
        System.out.println("고객이름>" + name);
        System.out.println("잔고>" + balance);
    }
}
