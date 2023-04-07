package cmh.excecise.storage;

import cmh.excecise.exception.ApplicationError;
import cmh.excecise.model.Account;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UserInformationStorage {

    private final static String STORE_FILE = "Bookkeeping/src/users.txt";
    private final static Map<String, Account> accountStorage = new HashMap<>();

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
            Account account = Account.fromLine(line);
            accountStorage.put(account.getUserNumber(), account);
        }

    }

    public static boolean addAccount(String userNumber, String password) {
        if (userNumber == null) {
            throw new IllegalArgumentException("userNumber can't be null");
        }
        if (accountStorage.get(userNumber) != null) {
            return false;
        }
        Account account = new Account(userNumber, password);
        accountStorage.put(userNumber, account);
        writeToStorage(account);
        return true;
    }

    public static Account getAccount(String userNumber) {
        if (userNumber == null) {
            throw new IllegalArgumentException("userNumber can't be null");
        }
        return accountStorage.get(userNumber);

    }

    public static void writeToStorage(Object information) {
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
}
