package cmh.date;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Activity {
    public static void main(String[] args) throws ParseException {
        //传入活动开始时间和结束时间
        String startTime = "2020年11月11日 00:00:00";
        String endTime = "2020年11月11日 00:10:00";
        //传入小贾、小皮
        String xiaoJia = "2020年11月11日 00:03:47";
        String xiaoPi = "2020年11月11日 00:10:11";
        //解析时间
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
        Date startDate = simpleDateFormat.parse(startTime);
        Date endDate = simpleDateFormat.parse(endTime);
        Date xiaoJiaDate = simpleDateFormat.parse(xiaoJia);
        Date xiaoPiDate = simpleDateFormat.parse(xiaoPi);

        /*if (xiaoJiaDate.after(startDate) && xiaoJiaDate.before(endDate)){
            System.out.println("购买成功，发货~~");
        }else {
            System.out.println("购买失败~~");
        }
        if (xiaoPiDate.after(startDate) && xiaoPiDate.before(endDate)){
            System.out.println("购买成功，发货~~");
        }else {
            System.out.println("购买失败~~");
        }*/
        String string = xiaoJiaDate.after(startDate) && xiaoJiaDate.before(endDate) ? "小贾购买成功，发货":"小贾购买失败";
        String string2 = xiaoPiDate.after(startDate) && xiaoPiDate.before(endDate) ? "小皮购买成功，发货":"小皮购买失败";
        System.out.println(string);
        System.out.println(string2);
    }
}
