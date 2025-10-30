package chat_GPT_4;

public class HighCreditAccount extends NormalAccount implements ICustomDefine {
    private String creditGrade;

    public HighCreditAccount(String accNum, String name, int balance, int interest, String creditGrade) {
        super(accNum, name, balance, interest);
        this.creditGrade = creditGrade.toUpperCase();
    }

    @Override
    public void deposit(int money) {
        int addRate = 0;
        if (creditGrade.equals("A")) addRate = A;
        else if (creditGrade.equals("B")) addRate = B;
        else if (creditGrade.equals("C")) addRate = C;

        balance += balance * interest / 100;
        balance += balance * addRate / 100;
        balance += money;
    }

    @Override
    public void showAccInfo() {
        super.showAccInfo();
        System.out.println("신용등급>" + creditGrade);
        System.out.println("-------------");
    }
}
