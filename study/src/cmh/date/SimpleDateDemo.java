package cmh.date;

import java.text.SimpleDateFormat;
import java.util.Date;


public class SimpleDateDemo {
    public static void main(String[] args) {
        Date date = new Date();
        System.out.println(date);

        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��HH��dd�� HHʱmm��ss�� EEE a");
        String d = simpleDateFormat.format(date);
        System.out.println(d);
    }
}
