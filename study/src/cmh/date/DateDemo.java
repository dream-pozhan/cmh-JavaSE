package cmh.date;

import java.util.Date;

public class DateDemo {
    public static void main(String[] args) {
        //创建一个Date类对象
        Date date = new Date();
        System.out.println(date);

        //获取时间毫秒值
        long time = date.getTime();
        System.out.println(time);

        long time1 = System.currentTimeMillis();
        System.out.println(time1);

    }
}
