import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailHappyPath {

    @DataProvider(name = "ListOfEmails")
    public static Object[] credentials() {
        return new Object[]{"poor@gmail.com", "po1234or@gm1al.com", "Po12or3@Mail2.com", "sE1@Qa.as",
                "asdQwsD!edks534dfcxa@Qds3a.cfgsa"};
    }

    @Test(dataProvider = "ListOfEmails")
    public void checkEmails(String emails) {
        Assert.assertTrue(Email.isEmailCorrect(emails), "Checking Valid e-mails");
    }
}
