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


    public static void register() {
        System.out.println("����������˻����룺");
        String registerNumber = scanner.next();
        System.out.println("����������˻�����");
        String registerPassword = scanner.next();
        UserInformationStorage.addAccount(registerNumber, registerPassword);
        System.out.println("ע��ɹ�!");
        login();
    }


    public static void login() {
        while (true) {
            System.out.println("�������˻����룺");
            String numberNow = scanner.next();
            System.out.println("�������˻����룺");
            String passwordNow = scanner.next();
            Account loginAccount = UserInformationStorage.getAccount(numberNow);
            if (loginAccount == null) {
                System.out.println("�˻����������벻��ȷ");
                break;
            }
            boolean loginSuccess = loginAccount.getPassword().equals(passwordNow);
            if (loginSuccess) {
                currentAccount = loginAccount;
                System.out.println("��¼�ɹ�");
                operatePage();
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
                    System.out.println("�����ָ���������������룡");

            }
        }

    }

    public static void remark() {


    }

    public static void addMonthIncomeAndExpense() {
        System.out.println("��ǰ���û�Ϊ��" + currentAccount.getUserNumber());
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

    public static void signDailyIncomeAndExpense() {

        while (true) {
            System.out.println("��ǰ���˻�Ϊ��" + currentAccount.getUserNumber());
            System.out.println("������������еĲ���   i--ÿ������;e--ÿ��֧��;b--����");
            String choice = scanner.next();
            if (choice.equals("i")) {
                while (true) {
                    System.out.println("����������ԭ��(��¼���������롰�ޡ�)");
                    String incomeThings = scanner.next();
                    if (incomeThings.equals("��")) {
                        break;
                    }
                    System.out.println("�����������");
                    double incomeMoney = scanner.nextDouble();
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.INCOME, incomeMoney, incomeThings);
                    UserTransactionStorage.addTransaction(transaction);
                }
            } else if (choice.equals("e")) {
                while (true) {
                    System.out.println("������֧��ԭ��(��¼���������롰�ޡ�)");
                    String expenseThings = scanner.next();
                    if (expenseThings.equals("��")) {
                        break;
                    }
                    System.out.println("�����������");
                    double expenseMoney = scanner.nextDouble();
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.INCOME, expenseMoney, expenseThings);
                    UserTransactionStorage.addTransaction(transaction);
                }
            } else if (choice.equals("b")) {
                return;

            } else {
                System.out.println("����ָ����������������!");
            }

        }

    }
}