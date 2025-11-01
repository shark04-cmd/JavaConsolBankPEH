package chat_GPT_3;

public class NormalAccount extends Account {
    protected int interest; // 기본이자율 (%)

    public NormalAccount(String accNum, String name, int balance, int interest) {
        super(accNum, name, balance);
        this.interest = interest;
    }

    @Override
    public void deposit(int money) {
        balance += balance * interest / 100;
        balance += money;
    }

    @Override
    public void showAccInfo() {
        super.showAccInfo();
        System.out.println("기본이자>" + interest + "%");
        System.out.println("-------------");
    }
}
