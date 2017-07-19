package com.reselbob.testing;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

import org.testng.annotations.Test;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

public class BasicAppiumTest {

  private AndroidDriver<WebElement> driver;

  @BeforeTest
  public void setUp() throws MalformedURLException {
    DesiredCapabilities desiredCapabilities = new DesiredCapabilities();
    desiredCapabilities.setCapability("app", "/Users/reselbob/AndroidStudioProjects/MyAppimApp/app/build/outputs/apk/app-debug.apk");
    desiredCapabilities.setCapability("platformName", "Android");
    desiredCapabilities.setCapability("platformVersion", 6);
    desiredCapabilities.setCapability("appActivity", "MainActivity");
    desiredCapabilities.setCapability("appPackage", "com.example.reselbob.myappimapp");
    desiredCapabilities.setCapability("deviceName", "Android Emulator");

    URL remoteUrl = new URL("http://localhost:4723/wd/hub");

    driver = new AndroidDriver<WebElement>(remoteUrl, desiredCapabilities);
  }

  @Test
  public void sampleTest() {
	MobileElement tv = (MobileElement) driver.findElementById("com.example.reselbob.myappimapp:id/textView");
	Assert.assertEquals("Welcome to My App", tv.getText());

    MobileElement el1 = (MobileElement) driver.findElementByXPath("/hierarchy/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.widget.LinearLayout/android.widget.FrameLayout/android.view.ViewGroup/android.view.ViewGroup/android.widget.Button");
    el1.click();
    Assert.assertEquals("Be Kind To Strangers", tv.getText());

    el1.click();
    Assert.assertEquals("Always Be Honest", tv.getText());

    el1.click();
    Assert.assertEquals("The Truth is the Best", tv.getText());

  }

  @AfterTest
  public void tearDown() {
    driver.quit();
  }
}
