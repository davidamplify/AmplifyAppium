package LoginNew;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import java.util.function.Function;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;

public class Hooks {




    private static IOSDriver driver;

    @Before ("@appium")
    public void setupAppium() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformVersion", "11.4");
        capabilities.setCapability("deviceName", "iPhone Simulator");
        capabilities.setCapability("app", "/Users/devops/Library/Developer/Xcode/DerivedData/Amplify-dsflugdjsryzoabjtinzyfmflwce/Build/Products/Debug-iphonesimulator/Amplify.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
    }

    @After
    public void teardown() {
        driver.quit();
    }


    public static IOSDriver getDriver() {
        return driver;
    }

}


