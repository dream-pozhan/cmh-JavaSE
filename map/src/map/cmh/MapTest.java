package map.cmh;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * �����а�ʮ��ѧ����ABCD�ĸ����㣬ͳ��ÿ������ѧ����ѡ������
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
        //����һ��Map��¼ͳ�ƽ��A=30,B=20,C=20,.D=10,���Ǿ��㣬ֵ�ǳ��ִ���
        Map<Character,Integer> informatinonMap = new HashMap<>();
        //����80��ѧ��ѡ��Ľ��
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
