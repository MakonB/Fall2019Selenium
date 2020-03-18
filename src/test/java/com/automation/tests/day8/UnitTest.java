package com.automation.tests.day8;

import org.testng.Assert;
import org.testng.annotations.Test;

public class UnitTest {

    public static void main(String[] args) {

        String expected = "cba";
        String toReverce = "abc";
        String actual = reverse(toReverce);
        checkEqual(expected,actual);



    }

    @Test(description = "verify if method can reverse a string")
    public void test(){
        String expected = "elppa";
        String actual = reverse("apple");
        Assert.assertEquals(expected,actual);

    }

    public static String reverse(String word){
        String reversed = "";

        for (int i = word.length()-1; i >=0 ; i--) {
            reversed +=word.charAt(i);
        }
        return reversed;
    }
    public static boolean checkEqual(String expected, String actual){
        if (expected.equals(actual)){
            System.out.println("passed");
            return true;
        }else {
            System.out.println("failed");
            System.out.println(expected);
            System.out.println(actual);
            return false;
        }
    }

}
