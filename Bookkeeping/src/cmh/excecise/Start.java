package cmh.excecise;

import cmh.excecise.model.Account;
import cmh.excecise.ui.HomePage;

import java.util.Scanner;

public class Start {
    public static Account currentAccount;
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new HomePage();
    }

}