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
            System.out.println("��ѡ���¼����ע�᣺1����¼ 2��ע��");
            int choice = scanner.nextInt();
            if (choice == 1) {
                login();
            } else if (choice == 2) {
                register();
            } else {
                System.out.println("����ָ���������������룺1,��¼ 2��ע��");
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
        System.out.println("����������˻����룺");
        String registerNumber = scanner.next();
        System.out.println("����������˻�����");
        String registerPassword = scanner.next();
        Account registerAccount = new Account();
        registerAccount.setUserNumber(registerNumber);
        registerAccount.setPassword(registerPassword);
        writeUserInformation(registerAccount);
        System.out.println("ע��ɹ�!");
        login();
    }

    public static String toRegisterInfo(String registerNumber, String password) {
        return "userNumber='" + registerNumber + '\'' +
                ", password='" + password + '\'';

    }
    //�Ӵ洢���ı����ȡ��Ϣ
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
            System.out.println("�������˻����룺");
            String numberNow = scanner.next();
            System.out.println("�������˻����룺");
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
                            System.out.println("��¼�ɹ�");
                            System.out.println("��ǰ�˻�Ϊ��" + numberNow);
                            operatePage();
                            break;
                        }else {
                            System.out.println("��¼ʧ�ܣ������������˻�����");
                            System.out.println("��ǰ�˻�Ϊ��" + numberNow);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public static void operatePage() {
        System.out.println("++++����ҳ��+++++");
        while (true) {
            System.out.println("��ѡ����Ĳ�����0-��¼ÿ��֧����ÿ������,1-ͳ����֧����������,2-��ע,3-�˳�");
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
                    System.out.println("�����ָ���������������룡");

            }
        }

    }

    public static void Remark(Account account) {
        ArrayList<String> remarkList = new ArrayList<>();
        System.out.println("��ǰ�˻��ǣ�" + account.getUserNumber());
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
        System.out.println("��ǰ���û�Ϊ��" + account.getUserNumber());
        double monthSumIncome = 0;
        double monthSumExpense = 0;
        //��������
        for (int i = 0; i < dailyIncome.size(); i++) {
            monthSumIncome += dailyIncome.get(i);
        }
        //����֧��
        for (int i = 0; i < dailyExpense.size(); i++) {
            monthSumExpense += dailyExpense.get(i);
        }
        System.out.println("��������" + monthSumIncome);
        System.out.println("����֧��" + monthSumExpense);

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
                System.out.println("��ǰ���˻�Ϊ��" + account.getUserNumber());
                System.out.println("������������еĲ���   i--ÿ������;e--ÿ��֧��;b--����");
                String choice = scanner.next();
                if (choice.equals("i")) {
                    while (true) {
                        System.out.println("����������ԭ��(��¼���������롰�ޡ�)");
                        String incomeThings = scanner.next();
                        if (incomeThings.equals("��")) {
                            try {
                                outputStream.write(hashMap1.toString().getBytes());
                                outputStream.flush();
                                outputStream.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyIncome.add(sumIncome);//��ÿ�����������dailyIncome������
                            break;
                        }
                        System.out.println("�����������");
                        double incomeMoney = scanner.nextDouble();
                        sumIncome += incomeMoney;
                        hashMap1.put(incomeThings, incomeMoney);
                    }
                } else if (choice.equals("e")) {
                    while (true) {
                        System.out.println("������֧��ԭ��(��¼���������롰�ޡ�)");
                        String expenseThings = scanner.next();
                        if (expenseThings.equals("��")) {
                            try {
                                outputStream2.write(hashMap2.toString().getBytes());
                                outputStream2.flush();
                                outputStream2.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyExpense.add(sumExpense);//��ÿ����֧������dailyExpense������
                            break;
                        }
                        System.out.println("������֧����");
                        double expenseMoney = scanner.nextDouble();
                        sumExpense += expenseMoney;
                        hashMap2.put(expenseThings, expenseMoney);
                    }
                } else if (choice.equals("b")) {
                    return;

                } else {
                    System.out.println("����ָ����������������!");
                }
                //ÿ���������account�˻�
                account.setDayIncome(sumIncome);
                System.out.println("�������룺" + account.getDayIncome());
                account.setDayExpense(sumExpense);
                System.out.println("����֧����" + account.getDayExpense());
                totalMoney = sumIncome - sumExpense;
                System.out.println("���ս��ࣺ" + totalMoney);
                account.setDayTotalMoney(totalMoney);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}