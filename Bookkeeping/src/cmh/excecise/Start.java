package cmh.excecise;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Start {
    private static ArrayList<Double> dailyIncome = new ArrayList<>();
    private static ArrayList<Double> dailyExpense = new ArrayList<>();
    static  Account account = new Account();
    private static Scanner scanner = new Scanner(System.in);
    private static String userInformationPath = "Bookkeeping/src/userinfomation.txt";
    private static String userDailyInformation = "Bookkeeping/src/dailyinformation.txt";

    public static void main(String[] args)  {
       homePage();
    }

    public static void homePage(){
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
    public static void writeUserInformation(Object information) {
        if(information==null){
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(userInformationPath, true);
            outputStream.write(information.toString().getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void register(){
        System.out.println("请输入你的账户号码：");
        String registerNumber = scanner.next();
        System.out.println("请输入你的账户密码");
        String registerPassword = scanner.next();
        Account registerAccount = new Account();
        registerAccount.setUserNumber(registerNumber);
        registerAccount.setPassword(registerPassword);
        writeUserInformation(registerAccount);
        System.out.println("注册成功!");
        login();
    }

    public static String toRegisterInfo(String registerNumber, String password) {
        return "userNumber='" + registerNumber + '\'' +
                ", password='" + password + '\'';

    }
    //从存储的文本里读取信息
    public static Account fromLine(String line){
        String[] arr = line.split(",");

        String userNumberInfo = arr[0].split("=")[1];
        String userNumber = userNumberInfo.substring(1,userNumberInfo.length()-1);

        String passwordInfo = arr[1].split("=")[1];
        String password = passwordInfo.substring(1,passwordInfo.length()-1);

        Account account = new Account();
        account.setUserNumber(userNumber);
        account.setPassword(password);
        return account;
    }

    public static void login() {
        while (true) {
            System.out.println("请输入账户号码：");
            String numberNow = scanner.next();
            System.out.println("请输入账户密码：");
            String passwordNow = scanner.next();

            try (BufferedReader br = new BufferedReader(new FileReader(userInformationPath))) {
                String line;
                while ((line = br.readLine()) != null) {
                   //userNumber='zhao.kai', password='123456'
                    if("".equals(line)){
                        continue;
                    }
                    account = fromLine(line);
                    if(numberNow.equals(account.getUserNumber())){
                        if(passwordNow.equals(account.getPassword())){
                            System.out.println("登录成功");
                            System.out.println("当前账户为：" + numberNow);
                            operatePage();
                            break;
                        }else {
                            System.out.println("登录失败，请重新输入账户密码");
                            System.out.println("当前账户为：" + numberNow);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
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
                    signDailyIncomeAndExpense(account, dailyIncome, dailyExpense);
                    break;
                case 1:
                    addMonthIncomeAndExpense(account, dailyIncome, dailyExpense);
                    break;
                case 2:
                    Remark(account);
                    break;
                case 3:
                    homePage();
                    break;
                default:
                    System.out.println("输入的指令有误，请重新输入！");

            }
        }

    }

    public static void Remark(Account account) {
        ArrayList<String> remarkList = new ArrayList<>();
        System.out.println("当前账户是：" + account.getUserNumber());
        String remark = scanner.next();
        remarkList.add(remark);
        try {
            OutputStream outputStream = new FileOutputStream(userInformationPath, true);
            outputStream.write(remarkList.toString().getBytes());
            outputStream.flush();
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addMonthIncomeAndExpense(Account account, ArrayList<Double> dailyIncome, ArrayList<Double> dailyExpense) {
        System.out.println("当前的用户为：" + account.getUserNumber());
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

    public static void signDailyIncomeAndExpense(Account account, ArrayList<Double> dailyIncome, ArrayList<Double> dailyExpense) {
        double sumIncome = 0;
        double sumExpense = 0;
        double totalMoney = 0;
        HashMap<String, Double> hashMap1 = new MyHashMap<>();
        HashMap<String, Double> hashMap2 = new MyHashMap<>();

        try {
            OutputStream outputStream = new FileOutputStream(userDailyInformation, true);
            OutputStream outputStream2 = new FileOutputStream(userDailyInformation, true);
            while (true) {
                System.out.println("当前的账户为：" + account.getUserNumber());
                System.out.println("请输入你想进行的操作   i--每日收入;e--每日支出;b--返回");
                String choice = scanner.next();
                if (choice.equals("i")) {
                    while (true) {
                        System.out.println("请输入收入原因：(记录结束请输入“无”)");
                        String incomeThings = scanner.next();
                        if (incomeThings.equals("无")) {
                            try {
                                outputStream.write(hashMap1.toString().getBytes());
                                outputStream.flush();
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyIncome.add(sumIncome);//将每日总收入存入dailyIncome数组中
                            break;
                        }
                        System.out.println("请输入收入金额：");
                        double incomeMoney = scanner.nextDouble();
                        sumIncome += incomeMoney;
                        hashMap1.put(incomeThings, incomeMoney);
                    }
                } else if (choice.equals("e")) {
                    while (true) {
                        System.out.println("请输入支出原因：(记录结束请输入“无”)");
                        String expenseThings = scanner.next();
                        if (expenseThings.equals("无")) {
                            try {
                                outputStream2.write(hashMap2.toString().getBytes());
                                outputStream2.flush();
                                outputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyExpense.add(sumExpense);//将每日总支出存入dailyExpense数组中
                            break;
                        }
                        System.out.println("请输入支出金额：");
                        double expenseMoney = scanner.nextDouble();
                        sumExpense += expenseMoney;
                        hashMap2.put(expenseThings, expenseMoney);
                    }
                } else if (choice.equals("b")) {
                    return;

                } else {
                    System.out.println("输入指令有误，请重新输入!");
                }
                //每日收入存入account账户
                account.setDayIncome(sumIncome);
                System.out.println("当日收入：" + account.getDayIncome());
                account.setDayExpense(sumExpense);
                System.out.println("当日支出：" + account.getDayExpense());
                totalMoney = sumIncome - sumExpense;
                System.out.println("今日结余：" + totalMoney);
                account.setDayTotalMoney(totalMoney);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}