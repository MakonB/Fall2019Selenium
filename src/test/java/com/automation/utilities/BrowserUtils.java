package com.automation.utilities;

public class BrowserUtils {

    public  static  void wait(int second){

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
