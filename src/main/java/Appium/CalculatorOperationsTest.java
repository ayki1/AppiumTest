package Appium;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.cucumber.java.After;
import io.cucumber.java.AfterAll;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeAll;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.net.MalformedURLException;
import java.net.URL;

public class CalculatorOperationsTest {
    //AppiumDriver<MobileElement> driver;

    @Test
    public void test1() throws MalformedURLException, InterruptedException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 3");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
        capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

        //App=Calculator
        capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");
        URL url = new URL("http://localhost:4723/wd/hub");

        //launch AppiumDriver
        AppiumDriver<MobileElement> driver;
        driver = new AndroidDriver<MobileElement>(url, capabilities);
        Thread.sleep(1000);


        //BU İŞLEMİ YAP -> 4+5= 9
        MobileElement fourElm=driver.findElement(By.id("com.google.android.calculator:id/digit_4"));
        fourElm.click();

        MobileElement plusElm=driver.findElement(MobileBy.AccessibilityId("plus"));
        plusElm.click();

        MobileElement fiveElm=driver.findElement(By.id("com.google.android.calculator:id/digit_5"));
        fiveElm.click();

        MobileElement equalElm=driver.findElement(MobileBy.AccessibilityId("equals"));
        equalElm.click();

        MobileElement resultElm=driver.findElement(MobileBy.id("com.google.android.calculator:id/result_final"));
        System.out.println("resultElm = " + resultElm);



        Thread.sleep(2000);
        //close the App
        //driver.closeApp();
    }

    @Test
    public void addTest(){

    }

    @Test
    public void cleanUp(){
        //driver.closeApp();
        System.out.println("TEST BİTTİ");
    }

}

    /*DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("deviceName", "Pixel 3");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "Android");
                capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, "10");
                capabilities.setCapability(MobileCapabilityType.AUTOMATION_NAME, "UiAutomator2");

                //App=Calculator
                capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/calculator.apk");
                //App=Etsy
                //capabilities.setCapability(MobileCapabilityType.APP,"https://cybertek-appium.s3.amazonaws.com/etsy.apk");
                URL url = new URL("http://localhost:4723/wd/hub");

                //launch AppiumDriver
                driver = new AndroidDriver<MobileElement>(url, capabilities);
        Thread.sleep(3000);*/