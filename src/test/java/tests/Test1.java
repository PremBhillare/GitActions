package tests;

import base.DriverFactory;
import base.TestBase;
import org.testng.annotations.Test;

public class Test1 extends TestBase {

    @Test
    public void get(){
        System.out.println("Hi");
    }
    @Test
    public void TearDown(){
        DriverFactory.getInstance().getDriver().close();
    }
}
