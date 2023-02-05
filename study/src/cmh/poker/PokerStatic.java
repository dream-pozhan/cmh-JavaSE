package cmh.poker;

import java.util.ArrayList;
class Card{
    String point;
    String color="";

    @Override
    public String toString() {
        return  point+color;
    }
}
public class PokerStatic {
    //����һ��ArrayList�洢�˿���
    public static ArrayList<Card> cards = new ArrayList<>();
    static {
        //����洢�Ƶĵ���
        String[] size = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //����洢�ƵĻ�ɫ
        String[] color = {"����","����","÷��","��Ƭ"};
        //��ɫ����������,�ȱ�������
        for (int i = 0; i < size.length; i++) {
            for (int j = 0; j < color.length; j++) {
                Card card = new Card();
                card.point=size[i];
                card.color=color[j];
                cards.add(card);
            }
        }
        //������Ӵ�С��
        Card card = new Card();
        Card card1 = new Card();
        card.point="����";
        card1.point="С��";
        cards.add(card);
        cards.add(card1);
    }




    public static void main(String[] args) {
        System.out.println(cards);
    }
}

