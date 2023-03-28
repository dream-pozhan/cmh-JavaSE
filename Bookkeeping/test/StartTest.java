import cmh.excecise.Account;
import cmh.excecise.Start;
import org.junit.Assert;
import org.junit.Test;

public class StartTest {
    @Test
    public void given_valid_account_when_register_then_return_concat_info(){
        String actualResult = Start.toRegisterInfo("user001", "123456");
        String expectedResult = "userNumber='user001', password='123456'";
        Assert.assertEquals(expectedResult,actualResult);
    }

    @Test
    public void given_valid_line_when_parse_then_return_account(){
        String inputLine = "userNumber='user001', password='123456'";
        Account actualResult = Start.fromLine(inputLine);
        String actualUserNumber = actualResult.getUserNumber();
        String expectedUserNumber = "user001";
        String actualPassword= actualResult.getPassword();
        String expectedPassword = "123456";
        Assert.assertEquals(expectedUserNumber,actualUserNumber);
        Assert.assertEquals(expectedPassword,actualPassword);

    }
}
