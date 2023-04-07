package cmh.excecise.storage;

import cmh.excecise.Start;
import cmh.excecise.exception.ApplicationError;
import cmh.excecise.model.Transaction;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class UserTransactionStorage {

    private final static String STORE_FILE = "Bookkeeping/src/transactions.txt";
    private static final List<Transaction> transactionList = new ArrayList<>();

    static {
        initStorage();
    }

    private static List<String> readStorageFile() {

        try (BufferedReader br = new BufferedReader(new FileReader(STORE_FILE))) {
            String line;
            List<String> totalLines = new ArrayList<>();
            while ((line = br.readLine()) != null) {
                if ("".equals(line)) {
                    continue;
                }
                totalLines.add(line);
            }
            return totalLines;
        } catch (IOException e) {
            throw new ApplicationError(e);
        }


    }

    private static void initStorage() {
        List<String> totalLines = readStorageFile();
        for (String line : totalLines) {
            Transaction transaction = Transaction.fromString(line);
            transactionList.add(transaction);
        }

    }

    public static void addTransaction(Transaction transaction) {
        transactionList.add(transaction);
        writeToStorage(transaction);
    }

    private static void writeToStorage(Object information) {
        if (information == null) {
            return;
        }
        OutputStream outputStream = null;
        try {
            outputStream = new FileOutputStream(STORE_FILE, true);
            outputStream.write(information.toString().getBytes());
            outputStream.flush();
        } catch (IOException e) {
            throw new ApplicationError(e);
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

    public static List<Transaction> getUserTransactions(String userNumber) {
        // TODO
        double income = 0.0;
        double expense = 0.0;
        for (Transaction transaction : transactionList) {
            if (transaction.getType().equals("INCOME") == true&& transaction.getUserNumber().equals(userNumber) == true) {
                income += transaction.getSubtotal();
            }
            if (transaction.getType().equals("EXPENSE") ==true && transaction.getUserNumber().equals(userNumber) == true) {
                expense += transaction.getSubtotal();
            }
        }
        System.out.println(Start.currentAccount.getUserNumber());
        Start.currentAccount.setMonthIncome(income);
        Start.currentAccount.setMonthExpense(expense);
        System.out.println(userNumber+"总收入为:"+Start.currentAccount.getMonthIncome());
        System.out.println(userNumber+"总支出为:"+Start.currentAccount.getMonthExpense());
        System.out.println(userNumber+"剩余金额为:"+(Start.currentAccount.getMonthIncome()-Start.currentAccount.getMonthExpense()));

        return transactionList;
    }

}
