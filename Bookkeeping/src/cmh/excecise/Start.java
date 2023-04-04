package cmh.excecise;

import cmh.excecise.model.Account;
import cmh.excecise.model.Transaction;
import cmh.excecise.storage.UserInformationStorage;
import cmh.excecise.storage.UserTransactionStorage;

import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Start {
    private static ArrayList<Double> dailyIncome = new ArrayList<>();
    private static ArrayList<Double> dailyExpense = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    private static Account currentAccount;

    public static void main(String[] args) {
        homePage();
    }

    public static void homePage() {
        while (true) {
            System.out.println("请选择登录或者注册：1：登录 2：注册");
            int choice = scanner.nextInt();
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                System.out.println("输入指令有误，请重新输入：1,登录 2，注册");
            }
        }
    }


    public static void register() {
        System.out.println("请输入你的账户号码：");
        String registerNumber = scanner.next();
        System.out.println("请输入你的账户密码");
        String registerPassword = scanner.next();
        UserInformationStorage.addAccount(registerNumber, registerPassword);
        System.out.println("注册成功!");
        login();
    }


    public static void login() {
        while (true) {
            System.out.println("请输入账户号码：");
            String numberNow = scanner.next();
            System.out.println("请输入账户密码：");
            String passwordNow = scanner.next();
            Account loginAccount = UserInformationStorage.getAccount(numberNow);
            if (loginAccount == null) {
                System.out.println("账户名或者密码不正确");
                break;
            }
            boolean loginSuccess = loginAccount.getPassword().equals(passwordNow);
            if (loginSuccess) {
                currentAccount = loginAccount;
                System.out.println("登录成功");
                operatePage();
            }

        }
    }

    public static void operatePage() {
        System.out.println("++++操作页面+++++");
        while (true) {
            System.out.println("请选择你的操作：0-记录每日支出与每日收入,1-统计月支出与月收入,2-备注,3-退出");
            int command = scanner.nextInt();
            switch (command) {
                case 0:
                    signDailyIncomeAndExpense();
                    break;
                case 1:
                    addMonthIncomeAndExpense();
                    break;
                case 2:
                    remark();
                    break;
                case 3:
                    homePage();
                    break;
                default:
                    System.out.println("输入的指令有误，请重新输入！");

            }
        }

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
                    System.out.println("请输入收入金额：");
                    double expenseMoney = scanner.nextDouble();
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.INCOME, expenseMoney, expenseThings);
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