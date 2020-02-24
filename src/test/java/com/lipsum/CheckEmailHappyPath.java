package com.lipsum;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class CheckEmailHappyPath {
    Email email = new Email();
    boolean flag = email.isEmailCorrect("poor@gmail.com");
    boolean flag1 = email.isEmailCorrect("po1234or@gm1al.com");
    boolean flag3 = email.isEmailCorrect("Po12or3@Mail2.com");


    @DataProvider(name = "Authentication")
    public static Object[] credentials() {
        return new Object[] { "poor@gmail.com", "po1234or@gm1al.com", "Po12or3@Mail2.com"};
    }
    @Test
    public void checkEmail(){
        Assert.assertEquals(true, flag);
    }
    @Test
    public void checkEmail2(){
        Assert.assertEquals(true, flag1);
    }
    @Test
    public void checkEmail3(){
        Assert.assertEquals(true, flag3);
    }

    @Test(dataProvider = "Authentication")
    public void checkEmailArray(String str){
        boolean flag4 = email.isEmailCorrect(str);
    }


}
