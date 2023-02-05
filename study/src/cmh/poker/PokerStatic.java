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
    //定义一个ArrayList存储扑克牌
    public static ArrayList<Card> cards = new ArrayList<>();
    static {
        //数组存储牌的点数
        String[] size = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //数组存储牌的花色
        String[] color = {"黑桃","红桃","梅花","方片"};
        //花色与点数的组合,先遍历点数
        for (int i = 0; i < size.length; i++) {
            for (int j = 0; j < color.length; j++) {
                Card card = new Card();
                card.point=size[i];
                card.color=color[j];
                cards.add(card);
            }
        }
        //单独添加大小王
        Card card = new Card();
        Card card1 = new Card();
        card.point="大王";
        card1.point="小王";
        cards.add(card);
        cards.add(card1);
    }




    public static void main(String[] args) {
        System.out.println(cards);
    }
}

