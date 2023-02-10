package cmh.date;

import java.util.Date;

public class CalculateTime {
    public static void main(String[] args) {
        //计算1小时121秒后的时间
        Date dateBefore = new Date();
        System.out.println(dateBefore);
        //将1小时121秒装换成毫秒
        Long time = System.currentTimeMillis();
        time +=((60*60)+121)*1000;

        /*Date dateNow = new Date(time);
        System.out.println(dateNow);
        */
        Date date = new Date();
        date.setTime(time);
        System.out.println(date);
    }
}
