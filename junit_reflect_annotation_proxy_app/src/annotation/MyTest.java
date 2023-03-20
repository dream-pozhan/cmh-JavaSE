package annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD,ElementType.METHOD,ElementType.LOCAL_VARIABLE})//元注解target（）规定注解应在放置的位置
@Retention(RetentionPolicy.RUNTIME)//元注解Retention()表示注解存在的周期
public @interface MyTest {
}
