package cmh.excecise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Start {
    private static ArrayList<Double> dailyIncome = new ArrayList<>();
    private static ArrayList<Double> dailyExpense = new ArrayList<>();
    //accountList存储账户信息
    private static ArrayList accountList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    static Account account = new Account();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("请选择登录或者注册：1：登录 2：注册");
            int choice = scanner.nextInt();
            if (choice == 1){
                if (accountList.size() != 0){
                    System.out.println("请输入账户号码:");
                    String userNumber = scanner.next();
                    System.out.println("请输入账户密码:");
                    String password = scanner.next();
                    login(userNumber,password);
                }else {
                    System.out.println("无账户信息，请先注册！");
                    System.out.println("请输入注册的账户号码:");
                    String registerNumber = scanner.next();
                    System.out.println("请输入注册的账户密码:");
                    String registerPassword = scanner.next();
                    register(registerNumber,registerPassword);
                    break;
                }

            } else if (choice == 2) {
                System.out.println("请输入注册的账户号码:");
                String registerNumber = scanner.next();
                System.out.println("请输入注册的账户密码:");
                String registerPassword = scanner.next();
                register(registerNumber,registerPassword);
                break;
            }else {
                System.out.println("输入指令有误，请重新输入：1,登录 2，注册");
            }
        }
    }

    public static void register(String registerNumber, String registerPassword) throws Exception {
        OutputStream outputStream = new FileOutputStream("Bookkeeping/src/userinfomation.txt");
        account.setUserNumber(registerNumber);
        account.setPassword(registerPassword);
        accountList.add(account);
        System.out.println("注册成功，你的信息如下：");
        System.out.println("账户号码:"+account.getUserNumber()+"账户密码："+account.getPassword());
        outputStream.write(account.toString().getBytes());
        outputStream.flush();
        outputStream.close();
        login(registerNumber,registerPassword);

    }

    private static void login(String userNumber, String password)  {
        while (true) {
            System.out.println("请输入账户号码：");
            String numberNow = scanner.next();
            System.out.println("请输入账户密码：");
            String passwordNow = scanner.next();
            if (numberNow.equals(userNumber) && passwordNow.equals(password)){
                System.out.println("登录成功");
                System.out.println("用户账户："+account.getUserNumber());
                operatePage();
                break;
            }else {
                System.out.println("登录失败，请重新输入账户号码与密码！");
            }
        }

    }

    private static void operatePage()  {
        System.out.println("++++操作页面+++++");
        while (true) {
            System.out.println("请选择你的操作：0-记录每日支出与每日收入,1-统计月支出与月收入，2-备注");
            int command = scanner.nextInt();
            switch (command){
                case 0:
                    signDailyIncomeAndExpense(account,dailyIncome,dailyExpense);
                    break;
                case 1:
                    addMonthIncomeAndExpense(account,dailyIncome,dailyExpense);
                    break;
                case 2:
                    Remark(account);
                    break;
                default:
                    System.out.println("输入的指令有误，请重新输入！");

            }
        }

    }

    private static void Remark(Account account) {
        ArrayList<String> remarkList = new ArrayList<>();
        System.out.println("当前账户是："+account.getUserNumber());
        String remark = scanner.next();
        remarkList.add(remark);
        try {
            OutputStream outputStream = new FileOutputStream("Bookkeeping/src/remark.txt");
            outputStream.write(remarkList.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    private static void addMonthIncomeAndExpense(Account account,ArrayList<Double> dailyIncome,ArrayList<Double> dailyExpense) {
        System.out.println("当前的用户为："+account.getUserNumber());
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
        System.out.println("月总收入"+monthSumIncome);
        System.out.println("月总支出"+monthSumExpense);

    }

    private static void signDailyIncomeAndExpense(Account account,ArrayList<Double> dailyIncome,ArrayList<Double> dailyExpense) {
        double sumIncome = 0;
        double sumExpense = 0;
        double totalMoney = 0;
        HashMap<String,Double> hashMap1 = new HashMap<>();
        HashMap<String,Double> hashMap2 = new HashMap<>();
        try {
            OutputStream outputStream = new FileOutputStream("Bookkeeping/src/incomelist.txt");
            OutputStream outputStream2 = new FileOutputStream("Bookkeeping/src/expenselist.txt");
            while (true) {
                System.out.println("当前的账户为："+account.getUserNumber());
                System.out.println("请输入你想进行的操作   i--每日收入;e--每日支出;b--返回");
                String choice = scanner.next();
                if (choice.equals("i")){
                    while (true) {
                        System.out.println("请输入收入原因：(记录结束请输入“无”)");
                        String incomeThings = scanner.next();
                        if (incomeThings.equals("无")){
                            try {
                                outputStream.write(hashMap1.toString().getBytes());
                                outputStream.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyIncome.add(sumIncome);//将每日总收入存入dailyIncome数组中
                            break;
                        }
                        System.out.println("请输入收入金额：");
                        double incomeMoney = scanner.nextDouble();
                        sumIncome += incomeMoney;
                        hashMap1.put(incomeThings,incomeMoney);
                    }
                }else if (choice.equals("e")){
                    while (true) {
                        System.out.println("请输入支出原因：(记录结束请输入“无”)");
                        String expenseThings = scanner.next();
                        if (expenseThings.equals("无")){
                            try {
                                outputStream2.write(hashMap2.toString().getBytes());
                                outputStream2.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyExpense.add(sumExpense);//将每日总支出存入dailyExpense数组中
                            break;
                        }
                        System.out.println("请输入支出金额：");
                        double expenseMoney = scanner.nextDouble();
                        sumExpense += expenseMoney;
                        hashMap2.put(expenseThings,expenseMoney);
                    }
                } else if (choice.equals("b")) {
                    return;

                } else {
                    System.out.println("输入指令有误，请重新输入!");
                }
                //每日收入存入account账户
                account.setDayIncome(sumIncome);
                System.out.println("当日收入："+account.getDayIncome());
                account.setDayExpense(sumExpense);
                System.out.println("当日支出："+account.getDayExpense());
                totalMoney = sumIncome - sumExpense;
                System.out.println("今日结余："+totalMoney);
                account.setDayTotalMoney(totalMoney);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}