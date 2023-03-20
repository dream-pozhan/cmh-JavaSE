package dom4J;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

public class Dom4JDemo {
    @Test
    public void test() throws Exception {
        //创建一个Dom4J的解析器对象，代表整个dom4J框架
        SAXReader saxReader = new SAXReader();
        //把xml文件加载到内存中成为一个Document对象
        Document document = saxReader.read(new File("cmh-JavaSE\\xml\\src\\data.xml"));//通过模块名去定位，当模块名被修改时，会出错
        //Document document = saxReader.read(new FileInputStream("cmh-JavaSE\\xml\\data.xml"));
        //InputStream inputStream = Dom4JDemo.class.getResourceAsStream("data.xml");
        //Document document = saxReader.read(inputStream);

        Element root = document.getRootElement();
        System.out.println(root.getName());
    }
}
