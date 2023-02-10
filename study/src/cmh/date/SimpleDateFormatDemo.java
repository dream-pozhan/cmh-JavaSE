package cmh.date;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class SimpleDateFormatDemo {
    public static void main(String[] args) throws ParseException {
        //Ŀ�꣺ѧ��ʹ��SimpleDateFormat�����ַ���ʱ���Ϊ���ڶ���
        //����2021��08��06�� 11:11:11����2��14Сʱ49��06��
        String dateString = "2021��08��06�� 11:11:11";
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        Date date = simpleDateFormat.parse(dateString);
        System.out.println(date);
        //����ʱ��
        Long time = date.getTime()+(2L*24*60*60 + 14*60*60 + 49*60 +6)*1000;
        System.out.println(simpleDateFormat.format(time));


    }
}
