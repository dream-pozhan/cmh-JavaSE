package cmh.excecise.storage;

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
        if(!new File(STORE_FILE).exists()){
            return new ArrayList<>();
        }
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
        ArrayList<Transaction> result = new ArrayList<>();
        for (Transaction transaction : transactionList) {
            if (transaction.getUserNumber().equals(userNumber)) {
                result.add(transaction);
            }
        }
        return result;
    }

}
