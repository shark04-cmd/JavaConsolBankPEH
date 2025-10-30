package chat_GPT_6;

public class HighCreditAccount extends NormalAccount {
    private static final long serialVersionUID = 1L;

    private String creditGrade;

    public HighCreditAccount(String accNum, String name, int balance, int interestRate, String creditGrade) {
        super(accNum, name, balance, interestRate);
        this.creditGrade = creditGrade.toUpperCase();
    }

    @Override
    public void deposit(int money) {
        int addRate = 0;
        switch (creditGrade) {
            case "A": addRate = 7; break;
            case "B": addRate = 4; break;
            case "C": addRate = 2; break;
        }
        balance += money + (balance * interestRate / 100) + (balance * addRate / 100);
    }

    @Override
    public void showAccInfo() {
        super.showAccInfo();
        System.out.println("신용등급>" + creditGrade);
        System.out.println("-------------");
    }
}
