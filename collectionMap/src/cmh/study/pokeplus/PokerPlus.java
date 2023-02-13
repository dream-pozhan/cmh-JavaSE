package cmh.study.pokeplus;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PokerPlus {
    public static List<Card> allCardList = new ArrayList<Card>();
    static {
        //定义牌的大小
        String[] sizes = {"3","4","5","6","7","8","9","10","J","Q","K","A","2"};
        //定义牌的花色
        String[] colors = {"红桃","黑桃","方块","梅花"};
        //记录牌的大小
        int index = 0;
        //遍历
        for (String size : sizes) {
            index++;
            for (String color : colors) {
                Card card = new Card(size,color,index);
                allCardList.add(card);
            }
        }
        //存入大小王
        Card bigKingCard = new Card("","大王",++index);
        Card smallKingCard = new Card("","小王",++index);
        Collections.addAll(allCardList,bigKingCard,smallKingCard);
        System.out.println(allCardList);
    }
    public static void main(String[] args) {
        //洗牌
        Collections.shuffle(allCardList);
        System.out.println(allCardList);
        //定义三个集合对象发牌
        List<Card> Zero = new ArrayList<Card>();
        List<Card> Ace = new ArrayList<Card>();
        List<Card> Seven = new ArrayList<Card>();
        //发牌，轮转算法，求余
        for (int i = 0; i < allCardList.size()-3; i++) {
            if (i%3 == 0){
                Zero.add(allCardList.get(i));
            }else if (i%3 == 1){
                Ace.add(allCardList.get(i));
            }else if (i%3 == 2){
                Seven.add(allCardList.get(i));
            }
        }
        //最后三张牌用数组存储，便于collections.addAll()存储
        List<Card> lastThreeCard = allCardList.subList(allCardList.size()-3,allCardList.size());
        //排序
        sortCard(Zero);
        sortCard(Ace);
        sortCard(Seven);
        //输出玩家的牌
        System.out.println("Zero"+Zero);
        System.out.println("Ace"+Ace);
        System.out.println("Seven"+Seven);
        System.out.println("最后三张牌"+lastThreeCard);

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
