package cmh.api.math;

public class MathDemo {
    public static void main(String[] args) {
        //ȡ����ֵ����������
        System.out.println(Math.abs(10));//10
        System.out.println(Math.abs(-10.3));//10.3
        //����ȡ����5
        System.out.println(Math.ceil(6.000001));//7
        //����ȡ����4
        System.out.println(Math.floor(4.99999));//4
        //��ָ���η�
        System.out.println(Math.pow(2,3));//8
        //��������
        System.out.println(Math.round(4.4999999));//4
        System.out.println(Math.round(4.5000001));//5
        //0-9�����������չ��
        System.out.println(Math.random());
        int data = (int)(Math.random()*7+3);
        System.out.println(data);
    }
}
