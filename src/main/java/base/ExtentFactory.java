package base;

import com.aventstack.extentreports.ExtentTest;

public class ExtentFactory {

    public static ExtentFactory instance = new ExtentFactory();

    public static ExtentFactory getInstance(){
        return instance;
    }

    ThreadLocal<ExtentTest> extent = new ThreadLocal<ExtentTest>();

    public void setExtent(ExtentTest extentTestObject){
        extent.set(extentTestObject);
    }
    public ExtentTest getExtent(){
        return extent.get();
    }
    public void RemoveExtent(){
        extent.remove();
    }

}
