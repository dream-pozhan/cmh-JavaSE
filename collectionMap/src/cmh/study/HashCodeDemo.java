package cmh.study;

public class HashCodeDemo {
    public static void main(String[] args) {
        //同一个对象调用多次hashcode，值是一样的
        String name = "蔡徐坤";
        System.out.println(name.hashCode());
        System.out.println(name.hashCode());

        //不同对象调用hashcode，值不一样
        String name1 = "坤坤";
        System.out.println(name1.hashCode());
        System.out.println(name1.hashCode());
    }
}
