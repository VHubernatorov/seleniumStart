package com.lipsum;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailHappyPath {

    @DataProvider(name = "ListOfEmails")
    public static Object[] credentials() {
        return new Object[] { "poor@gmail.com", "po1234or@gm1al.com", "Po12or3@Mail2.com", "sE1@Qa.as",
                "asdQwsD!edrs5&dfcxa@Qds3ea.cFgsa", "FadsdQwsD!edrs5&dfcxa@QdDsA3ea.cFgDsa", " @ . "};
    }

    @Test(dataProvider = "ListOfEmails")
    public void checkEmails(String emails){
        Assert.assertEquals(true, Email.isEmailCorrect(emails));
    }


}
