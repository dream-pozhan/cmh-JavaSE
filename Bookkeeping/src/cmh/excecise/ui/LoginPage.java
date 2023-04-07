package cmh.excecise.ui;

import cmh.excecise.Start;
import cmh.excecise.model.Account;
import cmh.excecise.storage.UserInformationStorage;
import java.util.Scanner;

import static cmh.excecise.ui.OperatePage.operatePage;

public class LoginPage {
    static Scanner scanner = new Scanner(System.in);
    public static void register() {
        System.out.println("请输入你的账户号码：");
        String registerNumber = scanner.next();
        System.out.println("请输入你的账户密码");
        String registerPassword = scanner.next();
        UserInformationStorage.addAccount(registerNumber, registerPassword);
        System.out.println("注册成功!");
        login();
    }
    public static void login() {
        while (true) {
            System.out.println("请输入账户号码：");
            String numberNow = scanner.next();
            System.out.println("请输入账户密码：");
            String passwordNow = scanner.next();
            Account loginAccount = UserInformationStorage.getAccount(numberNow);
            if (loginAccount == null) {
                System.out.println("账户名或者密码不正确");
                break;
            }
            boolean loginSuccess = loginAccount.getPassword().equals(passwordNow);
            if (loginSuccess) {
                //调用Start类里currentAccount
                Start.currentAccount = loginAccount;
                System.out.println("登录成功");
                operatePage();
            }

        }
    }
}
