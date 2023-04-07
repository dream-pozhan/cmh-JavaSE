package cmh.excecise;

import cmh.excecise.model.Account;
import cmh.excecise.model.Transaction;
import cmh.excecise.storage.UserTransactionStorage;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import static cmh.excecise.ui.HomePage.homePage;
import static cmh.excecise.ui.LoginPage.login;
public class Start {
    private static Scanner scanner = new Scanner(System.in);
    public static Account currentAccount;

    public static void main(String[] args) {
        homePage();
        login();
    }
    public static void remark() {


    }

    public static void addMonthIncomeAndExpense() {
        System.out.println("��ǰ���û�Ϊ��" + currentAccount.getUserNumber());
        UserTransactionStorage.getUserTransactions(currentAccount.getUserNumber());


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
                    System.out.println("������֧����");
                    double expenseMoney = scanner.nextDouble();
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.EXPENSE, expenseMoney, expenseThings);
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