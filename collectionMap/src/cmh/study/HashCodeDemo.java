package cmh.study;

public class HashCodeDemo {
    public static void main(String[] args) {
        //ͬһ��������ö��hashcode��ֵ��һ����
        String name = "������";
        System.out.println(name.hashCode());
        System.out.println(name.hashCode());

        //��ͬ�������hashcode��ֵ��һ��
        String name1 = "����";
        System.out.println(name1.hashCode());
        System.out.println(name1.hashCode());
    }
}
