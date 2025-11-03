package chat_GPT_4;

import java.util.Objects;

public abstract class Account {
    protected String accNum;
    protected String name;
    protected int balance;

    public Account(String accNum, String name, int balance) {
        this.accNum = accNum;
        this.name = name;
        this.balance = balance;
    }

    public String getAccNum() {
        return accNum;
    }

    public abstract void deposit(int money);
    public void withdraw(int money) {
        balance -= money;
    }

    public void showAccInfo() {
        System.out.println("-------------");
        System.out.println("계좌번호>" + accNum);
        System.out.println("고객이름>" + name);
        System.out.println("잔고>" + balance);
    }

    // ✅ 계좌번호 기준으로 중복 판정
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;
        Account acc = (Account) obj;
        return Objects.equals(this.accNum, acc.accNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNum);
    }
}
