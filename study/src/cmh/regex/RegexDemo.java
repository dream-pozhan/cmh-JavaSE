package cmh.regex;

import java.util.Scanner;

public class RegexDemo {
    public static void main(String[] args) {
        //checkNumber();\
        checkEmail();
    }
    public static void checkEmail(){
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("��������������Ϣ:");
            String emailNumber = scanner.next();
            if (emailNumber.matches("\\w{1,30}@[0-9a-zA-z]{2,10}(\\.[a-zA-Z0-9]{2,20}){1,2}")){
                System.out.println("У��ͨ����ע��ɹ�~~");
            }else{
                System.out.println("У��ʧ�ܣ�ע��ʧ��~~");
            }
        }
    }
    public static void checkNumber(){
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("��������绰���룺");
            String phoneNumber = sc.next();
            if (phoneNumber.matches("1[3-9]\\d{9}")) {
                System.out.println("����У��ͨ����ע��ɹ�~~");
                break;
            } else {
                System.out.println("����У�鲻ͨ����ע��ʧ��~~");
            }
        }
    }

}
