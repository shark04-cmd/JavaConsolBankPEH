package chat_GPT_5;

public class NormalAccount extends Account {
    private static final long serialVersionUID = 1L;

    // ✅ 바로 이 부분!
    protected int interestRate; // 기본이자 (% 단위)

    public NormalAccount(String accNum, String name, int balance, int interestRate) {
        super(accNum, name, balance);
        this.interestRate = interestRate;  // ← 생성자에서 초기화됨
    }

    @Override
    public void deposit(int money) {
        balance += money + (balance * interestRate / 100);
    }

    @Override
    public void showAccInfo() {
        super.showAccInfo();
        System.out.println("기본이자>" + interestRate + "%");
        System.out.println("-------------");
    }
}
