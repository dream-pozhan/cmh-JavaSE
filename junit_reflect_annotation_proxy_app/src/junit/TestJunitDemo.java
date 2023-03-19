package junit;

import org.junit.Assert;
import org.junit.Test;

public class TestJunitDemo {
    //Junit测试必须公开，无返回值
    @Test
    public void testLoginName(){
        JunitDemo junitDemo = new JunitDemo();
        String rs = junitDemo.loginName("admin","123456");
        //断言，用于预期结果的安全性测试
        Assert.assertEquals("你的登录业务可能出现问题","登陆成功",rs);
    }
    @Test
    public void testNumber(){
        JunitDemo junitDemo = new JunitDemo();
        junitDemo.number();
    }


}
