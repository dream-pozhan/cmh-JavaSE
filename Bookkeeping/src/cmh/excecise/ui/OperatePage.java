package cmh.excecise.ui;

import java.util.Scanner;

import static cmh.excecise.Start.*;
import static cmh.excecise.ui.HomePage.homePage;

public class OperatePage {
    static Scanner scanner = new Scanner(System.in);
    public static void operatePage() {
        System.out.println("++++操作页面+++++");
        while (true) {
            System.out.println("请选择你的操作：0-记录每日支出与每日收入,1-统计月支出与月收入,2-备注,3-退出");
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
                    System.out.println("输入的指令有误，请重新输入！");

            }
        }

    }
}
