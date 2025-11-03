package chat_GPT_2;


public class NormalAccount extends Account {
    int interest; // 기본이자율 (%)

    public NormalAccount(String accNum, String name, int balance, int interest) {
        super(accNum, name, balance);
        this.interest = interest;
    }

    @Override
    public void deposit(int money) {
        // 기본이자율만 계산
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
