package cmh.excecise;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

public class Start {
    private static ArrayList<Double> dailyIncome = new ArrayList<>();
    private static ArrayList<Double> dailyExpense = new ArrayList<>();
    //accountList�洢�˻���Ϣ
    private static ArrayList accountList = new ArrayList<>();
    private static Scanner scanner = new Scanner(System.in);
    static Account account = new Account();

    public static void main(String[] args) throws Exception {
        while (true) {
            System.out.println("��ѡ���¼����ע�᣺1����¼ 2��ע��");
            int choice = scanner.nextInt();
            if (choice == 1){
                if (accountList.size() != 0){
                    System.out.println("�������˻�����:");
                    String userNumber = scanner.next();
                    System.out.println("�������˻�����:");
                    String password = scanner.next();
                    login(userNumber,password);
                }else {
                    System.out.println("���˻���Ϣ������ע�ᣡ");
                    System.out.println("������ע����˻�����:");
                    String registerNumber = scanner.next();
                    System.out.println("������ע����˻�����:");
                    String registerPassword = scanner.next();
                    register(registerNumber,registerPassword);
                    break;
                }

            } else if (choice == 2) {
                System.out.println("������ע����˻�����:");
                String registerNumber = scanner.next();
                System.out.println("������ע����˻�����:");
                String registerPassword = scanner.next();
                register(registerNumber,registerPassword);
                break;
            }else {
                System.out.println("����ָ���������������룺1,��¼ 2��ע��");
            }
        }
    }

    public static void register(String registerNumber, String registerPassword) throws Exception {
        OutputStream outputStream = new FileOutputStream("Bookkeeping/src/userinfomation.txt");
        account.setUserNumber(registerNumber);
        account.setPassword(registerPassword);
        accountList.add(account);
        System.out.println("ע��ɹ��������Ϣ���£�");
        System.out.println("�˻�����:"+account.getUserNumber()+"�˻����룺"+account.getPassword());
        outputStream.write(account.toString().getBytes());
        outputStream.flush();
        outputStream.close();
        login(registerNumber,registerPassword);

    }

    private static void login(String userNumber, String password)  {
        while (true) {
            System.out.println("�������˻����룺");
            String numberNow = scanner.next();
            System.out.println("�������˻����룺");
            String passwordNow = scanner.next();
            if (numberNow.equals(userNumber) && passwordNow.equals(password)){
                System.out.println("��¼�ɹ�");
                System.out.println("�û��˻���"+account.getUserNumber());
                operatePage();
                break;
            }else {
                System.out.println("��¼ʧ�ܣ������������˻����������룡");
            }
        }

    }

    private static void operatePage()  {
        System.out.println("++++����ҳ��+++++");
        while (true) {
            System.out.println("��ѡ����Ĳ�����0-��¼ÿ��֧����ÿ������,1-ͳ����֧���������룬2-��ע");
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
                    System.out.println("�����ָ���������������룡");

            }
        }

    }

    private static void Remark(Account account) {
        ArrayList<String> remarkList = new ArrayList<>();
        System.out.println("��ǰ�˻��ǣ�"+account.getUserNumber());
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
        System.out.println("��ǰ���û�Ϊ��"+account.getUserNumber());
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
        System.out.println("��������"+monthSumIncome);
        System.out.println("����֧��"+monthSumExpense);

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
                System.out.println("��ǰ���˻�Ϊ��"+account.getUserNumber());
                System.out.println("������������еĲ���   i--ÿ������;e--ÿ��֧��;b--����");
                String choice = scanner.next();
                if (choice.equals("i")){
                    while (true) {
                        System.out.println("����������ԭ��(��¼���������롰�ޡ�)");
                        String incomeThings = scanner.next();
                        if (incomeThings.equals("��")){
                            try {
                                outputStream.write(hashMap1.toString().getBytes());
                                outputStream.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyIncome.add(sumIncome);//��ÿ�����������dailyIncome������
                            break;
                        }
                        System.out.println("�����������");
                        double incomeMoney = scanner.nextDouble();
                        sumIncome += incomeMoney;
                        hashMap1.put(incomeThings,incomeMoney);
                    }
                }else if (choice.equals("e")){
                    while (true) {
                        System.out.println("������֧��ԭ��(��¼���������롰�ޡ�)");
                        String expenseThings = scanner.next();
                        if (expenseThings.equals("��")){
                            try {
                                outputStream2.write(hashMap2.toString().getBytes());
                                outputStream2.flush();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                            dailyExpense.add(sumExpense);//��ÿ����֧������dailyExpense������
                            break;
                        }
                        System.out.println("������֧����");
                        double expenseMoney = scanner.nextDouble();
                        sumExpense += expenseMoney;
                        hashMap2.put(expenseThings,expenseMoney);
                    }
                } else if (choice.equals("b")) {
                    return;

                } else {
                    System.out.println("����ָ����������������!");
                }
                //ÿ���������account�˻�
                account.setDayIncome(sumIncome);
                System.out.println("�������룺"+account.getDayIncome());
                account.setDayExpense(sumExpense);
                System.out.println("����֧����"+account.getDayExpense());
                totalMoney = sumIncome - sumExpense;
                System.out.println("���ս��ࣺ"+totalMoney);
                account.setDayTotalMoney(totalMoney);

            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

    }

}