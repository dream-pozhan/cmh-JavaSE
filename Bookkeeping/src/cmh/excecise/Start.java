package cmh.excecise;

import cmh.excecise.model.Account;
import cmh.excecise.model.Transaction;
import cmh.excecise.storage.UserTransactionStorage;
import cmh.excecise.ui.HomePage;
import cmh.excecise.ui.LoginPage;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class Start {
    public static Account currentAccount;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new HomePage();
        new LoginPage();
    }

    public static void remark() {


    }

    public static void summarizeMonthIncomeAndExpense() {
        System.out.println("��ǰ���û�Ϊ��" + currentAccount.getUserNumber());
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
        System.out.println("�������룺" + totalIncome);
        System.out.println("����֧����" + totalExpense);

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
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.INCOME, incomeMoney, incomeThings, new Date());
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
                    Transaction transaction = new Transaction(currentAccount.getUserNumber(), Transaction.EXPENSE, expenseMoney, expenseThings, new Date());
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