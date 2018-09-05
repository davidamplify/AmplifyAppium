package LoginNew;

import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class LoginFunction {
    IOSDriver driver;

    public LoginFunction() {
        Hooks now = new Hooks();
        this.driver = now.getDriver();

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();

        //waits and finds continue button then clicks it

        java.lang.String buttonId = "skip";
        IOSElement skipEl = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(buttonId)));

        skipEl.click();

        //Log in process, select Login

        java.lang.String loginId = "Login";
        IOSElement loginEl = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(loginId)));

        loginEl.click();

        setDriverToWebContext();
        java.lang.String inputClass = ".text-input.text-input-ios";
        List<IOSElement> inputs = driver.findElementsByCssSelector(inputClass);
        IOSElement email;
        email = new IOSElement();
        IOSElement password;
        password = new IOSElement();

        for (IOSElement input: inputs) {
            Object initial = input.getAttribute("type");
            java.lang.String type = initial.toString();

            if (type.equals("email")) {


            }

            else {
                input.setValue("Bucketandspade6");
            }
        }

        setDriverToMobileContext();
        java.lang.String emailclassname = ".user-input.ampemail.input.input-ios.ng-valid.ng-dirty.ng-touched";
        IOSElement emailinput = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeOther[@name=\"Ionic App\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")));

        emailinput.sendKeys("dleaanotheramplify@gmail.com");
        setDriverToMobileContext();
        //Login Process Logs in
        java.lang.String loginAfterDetailsId = "Login";
        IOSElement loginAfterDetailsEl = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(loginAfterDetailsId)));

        loginAfterDetailsEl.click();
        loginAfterDetailsEl.click();

    }
    public void setDriverToWebContext  () {

        final Set<String> contextNames = driver.getContextHandles();
        for (final java.lang.String contextName : contextNames) {
            System.out.println(contextName);
            if (contextName.contains("WEBVIEW")) {
                driver.context(contextName);
            }
        }
    }

    public void setDriverToMobileContext() {

        driver.context("NATIVE_APP");

    }
}
