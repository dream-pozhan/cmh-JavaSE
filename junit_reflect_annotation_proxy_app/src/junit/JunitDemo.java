package junit;

public class JunitDemo {
    public String loginName(String name,String password){
        if ("admin1".equals(name) && "123456".equals(password)){
            return "登陆成功";
        }else {
            return "登陆失败";
        }
    }
    public void number(){
        System.out.println(10/0);
        System.out.println("123456");
    }
}
