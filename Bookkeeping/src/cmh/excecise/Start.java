package cmh.excecise;

import cmh.excecise.model.Account;
import cmh.excecise.model.Transaction;
import cmh.excecise.storage.UserTransactionStorage;
import java.util.ArrayList;
import java.util.Scanner;
import static cmh.excecise.ui.HomePage.homePage;
import static cmh.excecise.ui.LoginPage.login;
public class Start {
    private static ArrayList<Double> dailyIncome = new ArrayList<>();
    private static ArrayList<Double> dailyExpense = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    public static Account currentAccount;

    public static void main(String[] args) {
        homePage();
        login();
    }
    public static void remark() {


    }

    public static void addMonthIncomeAndExpense() {
        System.out.println("当前的用户为：" + currentAccount.getUserNumber());
        double monthSumIncome = 0;
        double monthSumExpense = 0;
        //月总收入
        for (int i = 0; i < dailyIncome.size(); i++) {
            monthSumIncome += dailyIncome.get(i);
        }
        //月总支出
        for (int i = 0; i < dailyExpense.size(); i++) {
            monthSumExpense += dailyExpense.get(i);
        }
        System.out.println("月总收入" + monthSumIncome);
        System.out.println("月总支出" + monthSumExpense);

    }

    public static void signDailyIncomeAndExpense() {

        while (true) {
            System.out.println("当前的账户为：" + currentAccount.getUserNumber());
            System.out.println("请输入你想进行的操作   i--每日收入;e--每日支出;b--返回");
            String choice = scanner.next();
            if (choice.equals("i")) {
                while (true) {
                    System.out.println("请输入收入原因：(记录结束请输入“无”)");
                    String incomeThings = scanner.next();
                    if (incomeThings.equals("无")) {
                        break;
                    }
                    System.out.println("请输入收入金额：");
                    double incomeMoney = scanner.nextDouble();
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.INCOME, incomeMoney, incomeThings);
                    UserTransactionStorage.addTransaction(transaction);
                }
            } else if (choice.equals("e")) {
                while (true) {
                    System.out.println("请输入支出原因：(记录结束请输入“无”)");
                    String expenseThings = scanner.next();
                    if (expenseThings.equals("无")) {
                        break;
                    }
                    System.out.println("请输入支出金额：");
                    double expenseMoney = scanner.nextDouble();
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.EXPENSE, expenseMoney, expenseThings);
                    UserTransactionStorage.addTransaction(transaction);
                }
            } else if (choice.equals("b")) {
                return;

            } else {
                System.out.println("输入指令有误，请重新输入!");
            }

        }

    }
}