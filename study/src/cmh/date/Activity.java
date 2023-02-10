package cmh.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {
    public static void main(String[] args) throws ParseException {
        //������ʼʱ��ͽ���ʱ��
        String startTime = "2020��11��11�� 00:00:00";
        String endTime = "2020��11��11�� 00:10:00";
        //����С�֡�СƤ
        String xiaoJia = "2020��11��11�� 00:03:47";
        String xiaoPi = "2020��11��11�� 00:10:11";
        //����ʱ��
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy��MM��dd�� HH:mm:ss");
        Date startDate = simpleDateFormat.parse(startTime);
        Date endDate = simpleDateFormat.parse(endTime);
        Date xiaoJiaDate = simpleDateFormat.parse(xiaoJia);
        Date xiaoPiDate = simpleDateFormat.parse(xiaoPi);

        /*if (xiaoJiaDate.after(startDate) && xiaoJiaDate.before(endDate)){
            System.out.println("����ɹ�������~~");
        }else {
            System.out.println("����ʧ��~~");
        }
        if (xiaoPiDate.after(startDate) && xiaoPiDate.before(endDate)){
            System.out.println("����ɹ�������~~");
        }else {
            System.out.println("����ʧ��~~");
        }*/
        String string = xiaoJiaDate.after(startDate) && xiaoJiaDate.before(endDate) ? "С�ֹ���ɹ�������":"С�ֹ���ʧ��";
        String string2 = xiaoPiDate.after(startDate) && xiaoPiDate.before(endDate) ? "СƤ����ɹ�������":"СƤ����ʧ��";
        System.out.println(string);
        System.out.println(string2);
    }
}
