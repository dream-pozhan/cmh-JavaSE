package map.cmh;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * 需求：有八十名学生，ABCD四个景点，统计每个景点学生的选择数量
 */
public class MapTest {
    public static void main(String[] args) {
        String[] selects = {"A","B","C","D"};
        StringBuilder stringBuilder = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < 80; i++) {
            stringBuilder.append(selects[random.nextInt(selects.length)]);
        }
        System.out.println(stringBuilder);
        //定义一个Map记录统计结果A=30,B=20,C=20,.D=10,键是景点，值是出现次数
        Map<Character,Integer> informatinonMap = new HashMap<>();
        //遍历80个学生选择的结果
        for (int i = 0; i < stringBuilder.length(); i++) {
            char ch = stringBuilder.charAt(i);
            if ( informatinonMap.containsKey(ch)){
                informatinonMap.put(ch,informatinonMap.get(ch)+1);
            }else{
                informatinonMap.put(ch,1);
            }
        }
        System.out.println(informatinonMap);
    }


}
