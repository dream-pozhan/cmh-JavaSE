package cmh.api.innerclass;

public class Outer {
    public static int number = 111;
    private String hobby;

    public Outer() {

    }

    public String getHobby() {
        return hobby;
    }

    public void setHobby(String hobby) {
        this.hobby = hobby;
    }

    public Outer(String hobby) {
        this.hobby = hobby;
    }

    public class Inner{
        private String name;
        private int age;
        //private static int a =100;JDK16֮��ʼ֧��

        void test(){
            System.out.println("��Ա�ڲ���");
        }
        void show(){
            System.out.println("����"+name);
            System.out.println("����"+age);
            System.out.println("����"+hobby);
        }

        public Inner() {
        }

        public Inner(String name, int age) {
            this.name = name;
            this.age = age;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            this.age = age;
        }
    }
}
