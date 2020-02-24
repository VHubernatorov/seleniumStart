import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailUnhappyPath {

    @DataProvider(name = "ListOfEmails")
    public static Object[] credentials() {
        return new Object[]{"P@g.c", "pozdczcdzaDSA12!1234or@zdzFR1g.comsFffds", "@ . ", "@", ""};
    }

    @Test(dataProvider = "ListOfEmails")
    public void testEmails(String emails) {
        Assert.assertFalse(Email.isEmailCorrect(emails));
    }
}
