package cmh.api.studydemo;
import java.util.Scanner;

public class Demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入月份（1-12）:");
        int month = sc.nextInt();
        System.out.println("请输入您的座位:");
        String type = sc.next();
        System.out.println("请输入机票原价:");
        double money = sc.nextDouble();
        double rs = calc(month,type,money);
        System.out.println("优惠后的价格是："+rs);
    }

    public static double calc(int month,String type,double money){
        if(month >=5 && month <=10){
            switch (type){
                case "经济舱" :
                    money= money*0.85;
                    break;
                case "头等舱" :
                    money = money*0.9;
                    break;
                default:
                    System.out.println("您选择的座位有误！请重新输入！");
                    return -1;
            }
            return money;
        }else if (month == 11 || month == 12 ||month >=1 && month <= 4 ){
            switch (type){
                case "经济舱" :
                    money = money*0.65;
                    break;
                case "头等舱" :
                    money = money*0.7;
                    break;
                default:
                    System.out.println("您选择的座位有误！请重新输入！");
                    return -1;
            }
            return money;
        }else {
            System.out.println("您输入的月份有误，请重新输入！");
            return -1;
        }
    }
}
