package cmh.excecise.ui;

import cmh.excecise.model.Transaction;
import cmh.excecise.storage.UserTransactionStorage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import static cmh.excecise.Start.*;

public class OperatePage {
    static Scanner scanner = new Scanner(System.in);


    public OperatePage() {
        init();
    }

    public  void init() {
        System.out.println("++++操作页面+++++");
        while (true) {
            System.out.println("请选择你的操作：0-记录每日支出与每日收入,1-统计月支出与月收入,2-备注,3-退出");
            int command = scanner.nextInt();
            switch (command) {
                case 0:
                    signDailyIncomeAndExpense();
                    break;
                case 1:
                    summarizeMonthIncomeAndExpense();
                    break;
                case 2:
                    break;
                case 3:
                    new HomePage();
                    break;
                default:
                    System.out.println("输入的指令有误，请重新输入！");

            }
        }

    }

    public  void summarizeMonthIncomeAndExpense() {
        System.out.println("当前的用户为：" + currentAccount.getUserNumber());
        List<Transaction> userTransactions = UserTransactionStorage.getUserTransactions(currentAccount.getUserNumber());
        double totalIncome = 0;
        double totalExpense = 0;
        SimpleDateFormat monthFormatter = new SimpleDateFormat("yyyyMM");
        String currentMonth = monthFormatter.format(new Date());
        for (Transaction transaction : userTransactions) {
            boolean isCurrentMonth = monthFormatter.format(transaction.getCreatedAt()).equals(currentMonth);
            if (isCurrentMonth && transaction.getType().equals(Transaction.INCOME)) {
                totalIncome += transaction.getSubtotal();
            }
            if (isCurrentMonth && transaction.getType().equals(Transaction.EXPENSE)) {
                totalIncome += transaction.getSubtotal();
            }
        }
        System.out.println("当月收入：" + totalIncome);
        System.out.println("当月支出：" + totalExpense);

    }

    public  void signDailyIncomeAndExpense() {

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
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.INCOME, incomeMoney, incomeThings, new Date());
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
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.EXPENSE, expenseMoney, expenseThings, new Date());
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
