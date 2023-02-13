package cmh.study.pokeplus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerPlus {
    public static List<Card> allCardList = new ArrayList<Card>();
    static {
        //�����ƵĴ�С
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //�����ƵĻ�ɫ
        String[] colors = {"����","����","����","÷��"};
        //��¼�ƵĴ�С
        int index = 0;
        //����
        for (String size : sizes) {
            index++;
            for (String color : colors) {
                Card card = new Card(size,color,index);
                allCardList.add(card);
            }
        }
        //�����С��
        Card bigKingCard = new Card("","����",++index);
        Card smallKingCard = new Card("","С��",++index);
        Collections.addAll(allCardList,bigKingCard,smallKingCard);
        System.out.println(allCardList);
    }
    public static void main(String[] args) {
        //ϴ��
        Collections.shuffle(allCardList);
        System.out.println(allCardList);
        //�����������϶�����
        List<Card> Zero = new ArrayList<Card>();
        List<Card> Ace = new ArrayList<Card>();
        List<Card> Seven = new ArrayList<Card>();
        //���ƣ���ת�㷨������
        for (int i = 0; i < allCardList.size()-3; i++) {
            if (i%3 == 0){
                Zero.add(allCardList.get(i));
            }else if (i%3 == 1){
                Ace.add(allCardList.get(i));
            }else if (i%3 == 2){
                Seven.add(allCardList.get(i));
            }
        }
        //���������������洢������collections.addAll()�洢
        List<Card> lastThreeCard = allCardList.subList(allCardList.size()-3,allCardList.size());
        //����
        sortCard(Zero);
        sortCard(Ace);
        sortCard(Seven);
        //�����ҵ���
        System.out.println("Zero"+Zero);
        System.out.println("Ace"+Ace);
        System.out.println("Seven"+Seven);
        System.out.println("���������"+lastThreeCard);

    }

    private static void sortCard(List<Card> allCardList) {
        Collections.sort(allCardList, new Comparator<Card>() {
            @Override
            public int compare(Card o1, Card o2) {
                return o2.getIndex()-o1.getIndex();
            }
        });
    }
}
