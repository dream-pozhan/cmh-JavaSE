package cmh.study;

import java.util.Arrays;

public class MethodDemo {
    public static void main(String[] args) {
        sum();//���Բ�������
        sum(10);//���Դ�һ������
        sum(10,20,30,40);//���Դ��������
        sum(new int[]{10,20,30,40});//���Դ�����
    }
    public static void sum(int...numbers){
        //numbersΪһ������
        System.out.println("���鳤��"+numbers.length);
        System.out.println("�����ڵ�Ԫ����"+ Arrays.toString(numbers));
    }
}
