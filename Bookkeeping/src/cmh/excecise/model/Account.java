package cmh.excecise.model;

public class Account {
    private String userNumber;
    private String password;
    private double dayIncome;
    private double dayExpense;
    private double monthIncome;
    private double monthExpense;
    private String remark;
    private double dayTotalMoney;

    public Account() {
    }

    public Account(String userNumber, String password, double dayIncome, double dayExpense, double monthIncome, double monthExpense, String remark, double dayTotalMoney) {
        this.userNumber = userNumber;
        this.password = password;
        this.dayIncome = dayIncome;
        this.dayExpense = dayExpense;
        this.monthIncome = monthIncome;
        this.monthExpense = monthExpense;
        this.remark = remark;
        this.dayTotalMoney = dayTotalMoney;
    }

    public Account(String userNumber, String password) {
        this.userNumber = userNumber;
        this.password = password;
    }

    public String getUserNumber() {
        return userNumber;
    }

    public void setUserNumber(String userNumber) {
        this.userNumber = userNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public double getDayIncome() {
        return dayIncome;
    }

    public void setDayIncome(double dayIncome) {
        this.dayIncome = dayIncome;
    }

    public double getDayExpense() {
        return dayExpense;
    }

    public void setDayExpense(double dayExpense) {
        this.dayExpense = dayExpense;
    }

    public double getMonthIncome() {
        return monthIncome;
    }

    public void setMonthIncome(double monthIncome) {
        this.monthIncome = monthIncome;
    }

    public double getMonthExpense() {
        return monthExpense;
    }

    public void setMonthExpense(double monthExpense) {
        this.monthExpense = monthExpense;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public double getDayTotalMoney() {
        return dayTotalMoney;
    }

    public void setDayTotalMoney(double dayTotalMoney) {
        this.dayTotalMoney = dayTotalMoney;
    }

    @Override
    public String toString() {
        return "userNumber='" + userNumber + '\'' + ", password='" + password + '\'' + "\n";
    }

    public static Account fromLine(String line) {
        String[] arr = line.split(",");

        String userNumberInfo = arr[0].split("=")[1];
        String userNumber = userNumberInfo.substring(1, userNumberInfo.length() - 1);

        String passwordInfo = arr[1].split("=")[1];
        String password = passwordInfo.substring(1, passwordInfo.length() - 1);

        Account account = new Account();
        account.setUserNumber(userNumber);
        account.setPassword(password);
        return account;
    }
}

