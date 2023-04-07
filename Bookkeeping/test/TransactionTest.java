import cmh.excecise.model.Transaction;
import org.junit.Assert;
import org.junit.Test;

public class TransactionTest {

    @Test
    public void given_string_line_when_parse_then_return_transaction() {

        String input = "1,INCOME,20.0,xxxiiii,20230407";
        Transaction actualResult = Transaction.fromString(input);
        Assert.assertEquals("1,INCOME,20.0,xxxiiii,20230407\n", actualResult.toString());

    }
}
