package cmh.api.stringbuilder;

public class StringBuilderDemo {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("1");
        stringBuilder.append(52);
        System.out.println(stringBuilder);//输出的是值，表示StringBuilder已经重写了toString方法

        StringBuilder stringBuilder1 = new StringBuilder();//StringBuilder支持链式编程
        stringBuilder1.append(1).append("张三").append("false");
        System.out.println(stringBuilder1);



    }
}
