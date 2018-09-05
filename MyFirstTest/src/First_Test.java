import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.junit.After;
import org.junit.Before;
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

public class First_Test {


    IOSDriver driver;
    @Before
    public void setup() throws MalformedURLException {

        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("automationName", "XCUITest");
        capabilities.setCapability("platformVersion","11.4");
        capabilities.setCapability("deviceName", "iPhone Simulator");
        capabilities.setCapability("app", "/Users/devops/Library/Developer/Xcode/DerivedData/Amplify-dsflugdjsryzoabjtinzyfmflwce/Build/Products/Debug-iphonesimulator/Amplify.app");

        driver = new IOSDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void HappyLoginPathThroughApp() throws InterruptedException, ParseException { //To be used in future for navigating opening pages

        //waits up to 30 seconds for alert to pop up th

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
        List <IOSElement> inputs = driver.findElementsByCssSelector(inputClass);
        IOSElement email;
        email = new IOSElement();
        IOSElement password;
        password = new IOSElement();

        for (IOSElement input: inputs) {
            var initial = input.getAttribute("type");
            java.lang.String type = initial.toString();

            if (type.equals("email")) {

//                    input.click();
//                    driver.hideKeyboard();
//                    input.setValue("dleaanotheramplify@gmail.com");
//                    System.out.println(input.getText());

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

        //Switches to Web Context to allow discovery of ionic elements
        setDriverToWebContext();

        //Moving to settings tab
        java.lang.String ProfileClass = "navbar-imgs-settings";

        IOSElement ProfileButton  = (IOSElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className(ProfileClass)));

        ProfileButton.click();

        //moves back to native app to select native elements, then tabs through
        setDriverToMobileContext();

        java.lang.String DevicesId = "DEVICES";

        IOSElement DevicesTab = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(DevicesId)));

        DevicesTab.click();
        java.lang.String SettingsId = "SETTINGS";

        IOSElement settingsTab = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(SettingsId)));
        settingsTab.click();
        driver.getContextHandles();
        //back to web context to go back to lifeline
        setDriverToWebContext();

        java.lang.String lifeLineClass = "navbar-imgs-calendar";

        //there are conflicting buttons with the same class name (only identifier for this button) and only one is visible so makes a list of them and clicks the correct one
        List <WebElement> lifeLineButtons =  driver.findElementsByClassName(lifeLineClass);

        for (WebElement lifelineButton: lifeLineButtons) {
            if (lifelineButton.isDisplayed()) {
                lifelineButton.click();
            }
        }

        java.lang.String AmplifyName = "close";

        setDriverToMobileContext();

        JavascriptExecutor js = (JavascriptExecutor) driver;
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("direction", "down");
        js.executeScript("mobile: scroll", scrollObject);

        IOSElement AmplifyButton  = (IOSElement) driver.findElementByName(AmplifyName);
        AmplifyButton.click();

        setDriverToWebContext();

        java.lang.String AddButtonClass = ".add-button.fab.fab-ios.fab-in-list.fab-ios-in-list";
        IOSElement AddActivityButton = (IOSElement) driver.findElementByCssSelector(AddButtonClass);//when using class to find element and the class name uses spaces switch to css selector and put a dot instead of a space and before the class
        AddActivityButton.click();//occasionally (maybe 1 in 10 times) this element is not found, I believe due to the timing of the instabug alert.

        setDriverToMobileContext();

        java.lang.String DateId = UsefulDate("dd MMM HH:mm");

        IOSElement DatePickerButton = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(DateId)));

        DatePickerButton.click();

        java.lang.String CurrentValue = DatePickerButton.getAttribute("value");

        setDriverToMobileContext();
        //AddActivityDateUsingElements(10,8,10,55, DateId);
        AddActivityDateUsingInitialCoordinates(29,7,9,25,DateId);
        DoneWithInput();

        IOSElement DurationButton = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Duration")));

        DurationButton.click();

        //AddDurationUsingElements(23,59,59);
        AddDurationUsingInitialCoordinates(0,1,5);
        DoneWithInput();

//        setDriverToWebContext();
//
//        java.lang.String descriptionClassName = ".desc.ng-untouched.ng-pristine.ng-valid";
//
//        WebElement DescriptionTextField = (WebElement) driver.findElementByCssSelector(descriptionClassName);
//        DescriptionTextField.sendKeys("Just a light 3 hours of table tennis");

        setDriverToMobileContext();

        IOSElement DistanceButton = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Distance")));

        DistanceButton.click();
        AddDistanceUsingInitialCoordinates(5,5,"MILES");
        DoneWithInput();

        IOSElement DescriptionTextBox = (IOSElement) new WebDriverWait(driver, 30)
            .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.xpath("//XCUIElementTypeOther[@name=\"Ionic App\"]/XCUIElementTypeTextField")));
        DescriptionTextBox.sendKeys("Reaching a light 300mph");

        IOSElement SaveButton = (IOSElement) driver.findElementByAccessibilityId("SAVE");
        SaveButton.click();

        Thread.sleep(10000);

        IOSElement activityJustDunnit = (IOSElement) driver.findElementByAccessibilityId("Reaching a light 300mph");
        List <IOSElement> JoeHarts = (List<IOSElement>) driver.findElementsByName("heart outline");

        int lowestdist = 10000;
        WebElement ToBeUsed = null;
        int activityLocation = activityJustDunnit.getLocation().getY();
        for (WebElement joe:JoeHarts) {
            int posDist = usefulModulo(joe.getLocation().getY()-activityLocation);
            if (posDist< lowestdist) {
                lowestdist = posDist;
                ToBeUsed = joe;
                }
        }

        js.executeScript("mobile: scroll", scrollObject);

        ToBeUsed.click();
        Thread.sleep(10000);
        List <IOSElement> PlansToDropDownTown = (List<IOSElement>) driver.findElementsByName("arrow round-down");
        IOSElement QueenB = (IOSElement) driver.findElementByAccessibilityId("Queen Elizabeth Olympic Park Winter 10k Series - February");
        int QueenBY = QueenB.getLocation().getY();
        int distQueenBY = 10000;
        WebElement TheFoRealDropDown = null;

        for (WebElement plan:PlansToDropDownTown) {
            int posDist = usefulModulo(plan.getLocation().getY()-QueenBY);
            if (posDist<distQueenBY) {
                distQueenBY=posDist;
                TheFoRealDropDown = plan;
            }
        }
        TheFoRealDropDown.click();

        Thread.sleep(10000);
        TheFoRealDropDown.click();

        IOSElement planBegin = (IOSElement) driver.findElementByAccessibilityId("edit create");
        planBegin.click();
        Thread.sleep(10000);
        setDriverToWebContext();
        IOSElement baCKaMoNTh = (IOSElement) driver.findElementByName("arrow-back");
        baCKaMoNTh.click();
        List <WebElement> datesAvailable = driver.findElementsByClassName("centered");
        Random rand = new Random();
        int randomdate = rand.nextInt(28) ;
        datesAvailable.get(randomdate).click();

        int farX = 10000;
        WebElement DoneButtonCalendar = null;
        List <WebElement> buttons = driver.findElementsByClassName("button-inner");
        for (WebElement button:buttons) {
            if (button.getLocation().getX()<farX)
                farX = button.getLocation().getX();
                DoneButtonCalendar = button;
        }
        DoneButtonCalendar.click();
        Thread.sleep(2500);
        List <WebElement> daysYouWerkOut = driver.findElementsByClassName("week-img");
        int randomday = rand.nextInt(7);
        int randomday2 = 0;
        do {
            randomday2 = rand.nextInt(7);
        } while (randomday == randomday2);
        daysYouWerkOut.get(randomday).click();
        daysYouWerkOut.get(randomday2).click();

        Thread.sleep(10000);
        setDriverToMobileContext();
        IOSElement createPlan = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("CREATE PLAN")));
        createPlan.click();
        setDriverToWebContext();
        farX = 10000;
        WebElement planSummaryOK = null;
        java.lang.String buttontext = "";
        System.out.print(driver.getPageSource());
        List <WebElement> alertButtons = driver.findElementsByClassName("button-inner");
        for (WebElement button:alertButtons) {
//            if (button.getLocation().getX()<farX)
//                farX = button.getLocation().getX();
//                planSummaryOK = button;
            buttontext = button.getText();
            System.out.println(buttontext);
              if (buttontext.equals("Ok")) {
                  planSummaryOK=button;
              }
        }
        int flag1 = 0;
        if (planSummaryOK == null) {
            planSummaryOK = alertButtons.get(50);
            flag1= 1;
        }
        planSummaryOK.click();
        Thread.sleep(15000);


        ProfileButton.click();
        setDriverToMobileContext();
        Thread.sleep(15000);
        IOSElement NewsettingsTab = (IOSElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(SettingsId)));
        NewsettingsTab.click();

        IOSElement DeletePlan = (IOSElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId("Delete Plan")));
        DeletePlan.click();

        Thread.sleep(10000);



    }
    public static void scrollToElement(IOSDriver driver, IOSElement element) {
        HashMap<String, String> scrollObject = new HashMap<String, String>();
        scrollObject.put("element", element.getId());
        driver.executeScript("mobile: scrollTo",scrollObject);
    }

    public void DoneWithInput() {
        java.lang.String DoneId = "Done";
        MobileElement DoneWithDatePicker = (MobileElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(DoneId)));
        DoneWithDatePicker.click();
    }

    public void AddDurationUsingElements(int Hours, int Minutes, int Seconds) {
        int CurrentHour=0;
        int CurrentMinute=0;
        int CurrentSecond=0;
        do {
            if (Hours>0) {
                java.lang.String finderString = Integer.toString(CurrentHour) + " h";
                IOSElement CurrentHoursElement = (IOSElement) driver.findElementByAccessibilityId(finderString);
                swipeToDirectionFromObject(CurrentHoursElement,"up",30);
                Hours--;
                CurrentSecond++;
            }
        }while (Hours>0);

        do {
            if (Minutes>0) {
                java.lang.String finderString = Integer.toString(CurrentMinute) + " m";
                IOSElement CurrentMinuteElement = (IOSElement) driver.findElementByAccessibilityId(finderString);
                swipeToDirectionFromObject(CurrentMinuteElement,"up",30);
                Minutes--;
                CurrentMinute++;
            }
        }while (Minutes>0);

        do {
            if (Seconds>0) {
                java.lang.String finderString = Integer.toString(CurrentSecond) + " s";
                IOSElement CurrentSecondElement = (IOSElement) driver.findElementByAccessibilityId(finderString);
                swipeToDirectionFromObject(CurrentSecondElement,"up",30);
                Seconds--;
                CurrentSecond++;
            }
        }while (Seconds>0);

    }
    public void AddDurationUsingInitialCoordinates(int Hours, int Minutes, int Seconds) throws InterruptedException {

        IOSElement CurrentHourElement = (IOSElement) driver.findElementByAccessibilityId("0 h");
        IOSElement CurrentMinuteElement = (IOSElement) driver.findElementByAccessibilityId("0 m");
        IOSElement CurrentSecondElement = (IOSElement) driver.findElementByAccessibilityId("0 s");

        swipeToDirectionWithIteration("up",30,Hours,CurrentHourElement);
        swipeToDirectionWithIteration("up",30,Minutes,CurrentMinuteElement);
        swipeToDirectionWithIteration("up",30,Seconds,CurrentSecondElement);
    }

    public void AddDistanceUsingInitialCoordinates(int xone, int xpointone, java.lang.String type) throws InterruptedException {
        java.lang.String xoneString = "0 .";
        java.lang.String xpointOneString = "0 " + type;
        IOSElement xoneElement = (IOSElement) driver.findElementByAccessibilityId(xoneString);
        IOSElement xpointoneElement = (IOSElement) driver.findElementByAccessibilityId(xpointOneString);

        swipeToDirectionWithIteration("up",30,xone,xoneElement);
        swipeToDirectionWithIteration("up",30,xpointone,xpointoneElement);
    }


    public void AddActivityDateUsingElements(int Day, int Month, int Hour , int Minute, java.lang.String Current) throws ParseException {

        java.lang.String FirstDateArray[] = Current.split(" ");
        java.lang.String SecondDateArray[] = FirstDateArray[2].split(":");
        int CurrentDay = Integer.parseInt(FirstDateArray[0]);
        int CurrentMonth = 1 + MonthToint(FirstDateArray[1],"MMM");
        int CurrentHour = Integer.parseInt(SecondDateArray[0]);
        int CurrentMinute = Integer.parseInt(SecondDateArray[1]);
        int DayChange = Day - CurrentDay;
        int MonthChange = Month - CurrentMonth;
        int HourChange = Hour - CurrentHour;
        int MinuteChange = Minute - CurrentMinute;

        //write funtion to return currently selected element

        IOSElement currentDayElement;
        IOSElement currentMonthElement;
        IOSElement currentHourElement;
        IOSElement currentMinuteElement;




            do {
                if (DayChange <0) {
                    currentDayElement = CurrentNumberElementFinder("Day",CurrentDay);
                    swipeToDirectionFromObject(currentDayElement,"down", 30);
                    DayChange++;
                    CurrentDay--;
                }
                else if (DayChange>0) {
                    currentDayElement = CurrentNumberElementFinder("Day",CurrentDay);
                    swipeToDirectionFromObject( currentDayElement,"up",30);
                    DayChange--;
                    CurrentDay++;
                }

            }while (DayChange!=0);

            do {
                if (MonthChange <0) {
                    currentMonthElement = CurrentMonthElementFinder(CurrentMonth);
                    swipeToDirectionFromObject(currentMonthElement,"down",30);
                    MonthChange++;
                    CurrentMonth--;
                }
                else if (MonthChange>0) {
                    currentMonthElement = CurrentMonthElementFinder(CurrentMonth);
                    swipeToDirectionFromObject(currentMonthElement,"up",30);
                    MonthChange--;
                    CurrentMonth++;
                }

            }while (MonthChange!=0);

            do {
                if (HourChange <0) {
                    currentHourElement = CurrentNumberElementFinder("Hour",CurrentHour);
                    swipeToDirectionFromObject(currentHourElement,"down",30);
                    HourChange++;
                    CurrentHour--;
                }
                else if (HourChange>0) {
                    currentHourElement = CurrentNumberElementFinder("Hour",CurrentHour);
                    swipeToDirectionFromObject(currentHourElement,"up",30);
                    DayChange--;
                    CurrentHour++;
                }

            }while (HourChange!=0);

            do {
                if (MinuteChange <0) {
                    currentMinuteElement = CurrentNumberElementFinder("Minute",CurrentMinute);
                    swipeToDirectionFromObject(currentMinuteElement,"down",30);
                    MinuteChange++;
                    CurrentHour--;
                }
                else if (MinuteChange>0) {
                    currentMinuteElement = CurrentNumberElementFinder("Minute",CurrentMinute);
                    swipeToDirectionFromObject(currentMinuteElement,"up",30);
                    MinuteChange--;
                    CurrentMinute++;
                }

            }while (MinuteChange!=0);
    }

    public void AddActivityDateUsingInitialCoordinates (int Day, int Month, int Hour , int Minute, java.lang.String Current ) throws InterruptedException, ParseException {

        java.lang.String FirstDateArray[] = Current.split(" ");
        java.lang.String SecondDateArray[] = FirstDateArray[2].split(":");
        int CurrentDay = Integer.parseInt(FirstDateArray[0]);
        int CurrentMonth = 1 + MonthToint(FirstDateArray[1],"MMM");
        int CurrentHour = Integer.parseInt(SecondDateArray[0]);
        int CurrentMinute = Integer.parseInt(SecondDateArray[1]);
        int DayChange = Day - CurrentDay;
        int MonthChange = Month - CurrentMonth;
        int HourChange = Hour - CurrentHour;
        int MinuteChange = Minute - CurrentMinute;

        //write funtion to return currently selected element

        IOSElement currentDayElement;
        IOSElement currentMonthElement;
        IOSElement currentHourElement;
        IOSElement currentMinuteElement;

        if (DayChange<0) {
            currentDayElement = CurrentNumberElementFinder("Day", CurrentDay);
            swipeToDirectionWithIteration("down", 30, DayChange * -1, currentDayElement);
        }
        else if (DayChange>0) {
            currentDayElement = CurrentNumberElementFinder("Day", CurrentDay);
            swipeToDirectionWithIteration("up", 30 , DayChange , currentDayElement);
        }
        if (MonthChange<0) {
            currentMonthElement = CurrentMonthElementFinder(CurrentMonth);
            swipeToDirectionWithIteration("down", 30, MonthChange * -1, currentMonthElement);
        }
        else if (MonthChange>0) {
            currentMonthElement = CurrentMonthElementFinder(CurrentMonth);
            swipeToDirectionWithIteration("up", 30, MonthChange , currentMonthElement);
        }
        if (HourChange<0) {
            currentHourElement = CurrentNumberElementFinder("Hour", CurrentHour);
            swipeToDirectionWithIteration("down", 30, HourChange * -1, currentHourElement);
        }
        else if (HourChange>0) {
            currentHourElement = CurrentNumberElementFinder("Hour", CurrentHour);
            swipeToDirectionWithIteration("up", 30, HourChange , currentHourElement);
        }
        if (MinuteChange<0) {
            currentMinuteElement = CurrentNumberElementFinder("Minute", CurrentMinute);
            swipeToDirectionWithIteration("down", 30, MinuteChange * -1, currentMinuteElement);
        }
        else if (MinuteChange>0) {
            currentMinuteElement = CurrentNumberElementFinder("Minute", CurrentMinute);
            swipeToDirectionWithIteration("up", 30, MinuteChange, currentMinuteElement);
        }

    }

    public void setDriverToWebContext  () {

        final Set<java.lang.String> contextNames = driver.getContextHandles();
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

    public void swipeToDirectionFromObject(IOSElement el, java.lang.String direction, int amount) {
        if (direction == "up") {
            int x = el.getCenter().getX();
            int y = el.getCenter().getY();
            setDriverToWebContext();
            io.appium.java_client.TouchAction action = new TouchAction((IOSDriver) driver);
            action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y - amount)).release().perform();
            setDriverToMobileContext();
        }
        else if (direction=="down") {
            int x = el.getCenter().getX();
            int y = el.getCenter().getY();
            setDriverToWebContext();
            io.appium.java_client.TouchAction action = new TouchAction((IOSDriver) driver);
            action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y + amount)).release().perform();
            setDriverToMobileContext();
        }
    }

    public void swipeToDirectionWithIteration( java.lang.String direction, int magnitude, int frequency, IOSElement el) throws InterruptedException {

        if (direction == "up") {
            int x = el.getCenter().getX();
            int y = el.getCenter().getY();
            setDriverToWebContext();
            for (int i=0;i<frequency; i++) {
                io.appium.java_client.TouchAction action = new TouchAction((IOSDriver) driver);
                action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y - magnitude)).release().perform();
                Thread.sleep(200);
            }
            setDriverToMobileContext();
        }

        if (direction == "down") {
            int x = el.getCenter().getX();
            int y = el.getCenter().getY();
            setDriverToWebContext();
            for (int i=0;i<frequency; i++) {
                io.appium.java_client.TouchAction action = new TouchAction((IOSDriver) driver);
                action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y + magnitude)).release().perform();
                Thread.sleep(200);//gives slider chance to stop
            }
            setDriverToMobileContext();
        }
    }

    public java.lang.String UsefulDate(java.lang.String ReqFormat) {

        DateFormat dateFormat = new SimpleDateFormat(ReqFormat);
        Date date = new Date();
        var stringdate = dateFormat.format(date);
        java.lang.String DateId = stringdate.toString();
        return DateId;
    }

    public java.lang.String intToMonth(int month) {

        if (month == 1) {
            return "Jan";
        }
        else if (month==2) {
            return "Feb";
        }
        else if (month==3) {
            return "Mar";
        }
        else if (month==4) {
            return "Apr";
        }
        else if (month==5) {
            return "May";
        }
        else if (month==6) {
            return "Jun";
        }
        else if (month==7) {
            return "Jul";
        }
        else if (month==8) {
            return "Aug";
        }
        else if (month==9) {
            return "Sep";
        }
        else if (month==10) {
            return "Oct";
        }
        else if (month==11) {
            return "Nov";
        }
        else if (month==12) {
            return "Dec";
        }
        else {return "";}
    }

    public int MonthToint(java.lang.String Month, java.lang.String ReqPattern) throws ParseException {

        Date date = new SimpleDateFormat(ReqPattern, Locale.ENGLISH).parse(Month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int finalVal = cal.get(Calendar.MONTH);
        return finalVal;

    }

    public IOSElement CurrentNumberElementFinder (java.lang.String type , int CurrentVal) {

        java.lang.String ReqString = "";
        if (CurrentVal<10) {
            ReqString = "0" + Integer.toString(CurrentVal);
        }
        else {
            ReqString = Integer.toString(CurrentVal);
        }
        if (type == "Day") {
            IOSElement day = (IOSElement) driver.findElementByAccessibilityId("59");
            return day;
        } else if (type == "Hour") {
            //gonna require some webelement stuff init bruv
            List <IOSElement> numberss = driver.findElementsByName(ReqString);
            IOSElement Hour = null;
            int current=100000;

            for (IOSElement number:numberss) {
                int location = number.getLocation().getX();;

                    if (location!=0) {
                        if (location<current) {
                            Hour = number;
                            current = location;
                        }
                    }
            }

            return Hour;
        }
        else {

            List <IOSElement> numberss = driver.findElementsByName(ReqString);
            IOSElement MinuteEl = null;
            int current=0;

            for (IOSElement number:numberss) {
                int coord = number.getLocation().getX();

                if (coord!=0) {
                    if (coord>current) {
                        MinuteEl = number;
                        current = coord;
                    }
                }
            }
            return MinuteEl;
        }
    }

    public IOSElement CurrentMonthElementFinder ( int value) {

        java.lang.String MonthId = intToMonth(value);
        IOSElement month = (IOSElement) driver.findElementByAccessibilityId(MonthId);
        return month;
    }

    public int usefulModulo(int i) {
        if (i<0) {
            return i*-1;
        }
        else {
            return i;
        }
    }
}
