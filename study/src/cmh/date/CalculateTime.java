package cmh.date;

import java.util.Date;

public class CalculateTime {
    public static void main(String[] args) {
        //����1Сʱ121����ʱ��
        Date dateBefore = new Date();
        System.out.println(dateBefore);
        //��1Сʱ121��װ���ɺ���
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
