package cmh.api.stringbuilder;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append(52);
        System.out.println(stringBuilder);//�������ֵ����ʾStringBuilder�Ѿ���д��toString����

        StringBuilder stringBuilder1 = new StringBuilder();//StringBuilder֧����ʽ���
        stringBuilder1.append(1).append("����").append("false");
        System.out.println(stringBuilder1);



    }
}
