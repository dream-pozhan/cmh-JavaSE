package cmh.date;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        //����һ��Date�����
        Date date = new Date();
        System.out.println(date);

        //��ȡʱ�����ֵ
        long time = date.getTime();
        System.out.println(time);

        long time1 = System.currentTimeMillis();
        System.out.println(time1);

    }
}
