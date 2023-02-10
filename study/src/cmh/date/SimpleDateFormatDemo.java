package cmh.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //目标：学会使用SimpleDateFormat解析字符串时间成为日期对象
        //计算2021年08月06日 11:11:11往后2天14小时49分06秒
        String dateString = "2021年08月06日 11:11:11";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date date = simpleDateFormat.parse(dateString);
        System.out.println(date);
        //计算时间
        Long time = date.getTime()+(2L*24*60*60 + 14*60*60 + 49*60 +6)*1000;
        System.out.println(simpleDateFormat.format(time));


    }
}
