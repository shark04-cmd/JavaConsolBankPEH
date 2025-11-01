package chat_GPT_6;

import java.io.Serializable;
import java.util.Objects;

public abstract class Account implements Serializable {
    private static final long serialVersionUID = 1L;

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

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Account)) return false;
        Account acc = (Account) obj;
        return Objects.equals(accNum, acc.accNum);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNum);
    }
}
