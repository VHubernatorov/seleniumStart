package com.lipsum;

import org.testng.annotations.Test;

public class TestUnit {

    @Test
    public void firstTest(){
        int firstInt = 5;
        int secondInr = 10;
        boolean flag;
        if (firstInt == secondInr){
            flag = true;
        } else {
            flag = false;
            throw new NullPointerException();
        }

    }


@Test(description = " data for testing - summary")
    public void secondTest(){
        int firstInt = 5;
        int secondInr = 10;
        boolean flag;
        if (firstInt != secondInr){
            flag = true;
        } else {
            flag = false;
            throw new NullPointerException();
        }
    }

    public void thirdTest(){

    }
}
