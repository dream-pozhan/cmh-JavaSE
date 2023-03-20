package annotation;
//类上可以进行标注
@MyBook(name = "《Java》",authors = {"张三","李四"},price = 199.5)
public class AnnotationDemo {
    //构造器上可以进行标注
    @MyBook(name = "《Java》",authors = {"张三","李四"},price = 199.5)
    public AnnotationDemo(){

    }
    //方法上可以进行标注
    @MyBook(name = "《Java》",authors = {"张三","李四"},price = 199.5)
    public static void main(String[] args) {
        //局部变量也可以进行标注
        @MyBook(name = "《Java》",authors = {"张三","李四"},price = 199.5)
        int m;
    }
}
