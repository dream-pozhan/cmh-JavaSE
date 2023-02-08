package cmh.api.innerclassstatic;

public class Test {
    public static void main(String[] args) {
        Outer.inner inner = new Outer.inner("Ğ¡Íõ",26);
        inner.run();
        System.out.println(inner.getAge());
        System.out.println(inner.getName());
    }
}
