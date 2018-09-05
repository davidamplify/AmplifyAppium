package LoginNew;
import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.MobileBy;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class StepDefinitions {
    private IOSDriver driver;

    //Used for logging in , signing up or Profile edits
    String emailString = "";
    String passwordString = "";
    String usersName = "";
    String userScreenName = "";
    String userPostcode = "";

    //Used for QA Profile at signup or edits
    String interestOne = "";//Running, Cycling, Swimming, Triatholon, or others added at a later date
    String interestTwo = "";
    String interestThree = "";
    String interestFour = "";
    String ConnectionOne = ""//Healthista, London Triatholon or others added at a later date

    //Used for manually adding an activity
    String activityType = "";//Running, Cycling, Swimming, Triatholon or others added at a later date
    String activityDate = "";
    String activityLength = "";
    String activityDescription = "";



    public  StepDefinitions() {
        this.driver = Hooks.getDriver();
    }


    @Given("^I have a correct email and password$")
        public void i_Login() throws Exception {
        emailString = "dleaanotheramplify@gmail.com";
        passwordString = "Bucketandspade6";

    }

    @When("^I try to Login$")
    public void i_try_to_enter_a_valid_activity_and_save() throws Exception {
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

//                    input.click();
//                    driver.hideKeyboard();
//                    input.setValue("dleaanotheramplify@gmail.com");
//                    System.out.println(input.getText());

            }

            else {
                input.setValue(passwordString);
            }
        }

        setDriverToMobileContext();
        java.lang.String emailclassname = ".user-input.ampemail.input.input-ios.ng-valid.ng-dirty.ng-touched";
        IOSElement emailinput = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeOther[@name=\"Ionic App\"]/XCUIElementTypeOther[2]/XCUIElementTypeTextField")));

        emailinput.sendKeys(emailString);
//        email.clear();
//        email.click();
//
//        email.setValue("dleaanotheramplify@gmail.com");
//        password.setValue("Bucketandspade6");

        setDriverToMobileContext();
        //Login Process Logs in
        java.lang.String loginAfterDetailsId = "Login";
        IOSElement loginAfterDetailsEl = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.name(loginAfterDetailsId)));

        loginAfterDetailsEl.click();
        loginAfterDetailsEl.click();
    }

    @Then("^Timeline should load$")
    public void it_should_appear_on_the_timeline() throws Exception {
        // Write code here that turns the phrase above into concrete actions
        throw new PendingException();
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
