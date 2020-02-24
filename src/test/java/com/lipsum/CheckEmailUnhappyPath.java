package com.lipsum;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailUnhappyPath {
    Email email = new Email();
    boolean flag = email.isEmailCorrect("po@gmail.com");
    boolean flag1 = email.isEmailCorrect("po1234or@g.com");
    boolean flag3 = email.isEmailCorrect("@ .com");


    @DataProvider(name = "Authentication")
    public static Object[] credentials() {
        return new Object[] { "po@gmail.com", "po1234or@g.com", "@ .com", "@."};
    }
    @Test
    public void checkEmail(){
        Assert.assertEquals(false, flag);
    }
    @Test
    public void checkEmail2(){
        Assert.assertEquals(false, flag1);
    }
    @Test
    public void checkEmail3(){
        Assert.assertEquals(false, flag3);
    }

    @Test(dataProvider = "Authentication")
    public void testEmailArray(String str){
        boolean flag4 = email.isEmailCorrect(str);
    }


}
