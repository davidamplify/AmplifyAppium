import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.apache.xpath.operations.And;
import org.apache.xpath.operations.String;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.*;
import static io.appium.java_client.touch.WaitOptions.waitOptions;

public class HappyLoginPath {

    AndroidDriver driver;

    @Before
    public void setup() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();


        capabilities.setCapability("automationName", "UiAutomator2");
        capabilities.setCapability("platformVersion","8.1");

        capabilities.setCapability("deviceName", "Android Emmulator");
        capabilities.setCapability("app", "/Users/devops/Desktop/10007.apk");
        capabilities.setCapability("chromedriverExecutable","/Users/devops/Downloads/chromedriver");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities);
    }

    @After
    public void teardown() {
        driver.quit();
    }
    @Test
    public void pathThroughApp() throws InterruptedException, ParseException {


        //waits and finds skip button then clicks it

        //driver.context("NATIVE_APP");

        java.lang.String buttonId = "skip";
        AndroidElement skipEl = (AndroidElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(buttonId)));

        skipEl.click();

        //Log in process, select Login

        java.lang.String loginId = "Login";
        AndroidElement loginEl = (AndroidElement) new WebDriverWait(driver, 30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(loginId)));

        loginEl.click();

        setDriverToWebContext();
        java.lang.String inputClass = ".text-input.text-input-md";
        List<WebElement> inputs = driver.findElementsByCssSelector(inputClass);

        for (WebElement input : inputs) {
            java.lang.String type = input.getAttribute("type");

            if (type.equals("email")) {
                input.sendKeys("davidlea.tf@gmail.com" + "\n");
            } else {
                input.sendKeys("Bucketandspade6");
            }
        }

        setDriverToMobileContext();

        java.lang.String loginAfterDetailsClass = "Login";

        if (driver.isKeyboardShown()) {
            driver.hideKeyboard();
        }

        setDriverToWebContext();
        java.lang.String className = ".disable-hover.item-button.button.button-md.button-default.button-default-md.button-block.button-block-md.button-md-amp-yellow";

        AndroidElement LoginButton = (AndroidElement) driver.findElementByCssSelector(className) ;
        LoginButton.click();

        setDriverToWebContext();

        //Moving to settings tab
        java.lang.String ProfileClass = "navbar-imgs-settings";

        AndroidElement ProfileButton  = (AndroidElement) new WebDriverWait(driver, 60)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.className(ProfileClass)));

        ProfileButton.click();

        //moves back to native app to select native elements, then tabs through
        setDriverToMobileContext();

        java.lang.String DevicesId = "DEVICES";

        AndroidElement DevicesTab = (AndroidElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(DevicesId)));

        DevicesTab.click();

        java.lang.String SettingsId = "SETTINGS";

        AndroidElement settingsTab = (AndroidElement) new WebDriverWait(driver,30)
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

        setDriverToWebContext();

        AndroidElement AmplifyButton  = (AndroidElement) driver.findElementByName(AmplifyName);
        AmplifyButton.click();

        java.lang.String AddButtonClass = ".add-button.fab.fab-md.fab-in-list.fab-md-in-list.show";
        AndroidElement AddActivityButton = (AndroidElement) driver.findElementByCssSelector(AddButtonClass);//when using class to find element and the class name uses spaces switch to css selector and put a dot instead of a space and before the class
        AddActivityButton.click();

        setDriverToMobileContext();

        java.lang.String DateId = UsefulDate("dd MMM HH:mm");

        AndroidElement DatePickerButton = (AndroidElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(DateId)));

        DatePickerButton.click();
        Thread.sleep(5000);

        AddActivityDateUsingInitialCoordinates(2,5,6,3,DateId);



        java.lang.String DoneId = "Done";
        AndroidElement DoneWithDatePicker = (AndroidElement) new WebDriverWait(driver,30)
                .until(ExpectedConditions.visibilityOfElementLocated(MobileBy.AccessibilityId(DoneId)));
        DoneWithDatePicker.click();

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

        AndroidElement currentDayElement;
        AndroidElement currentMonthElement;
        AndroidElement currentHourElement;
        AndroidElement currentMinuteElement;

        if (DayChange<0) {
            currentDayElement = CurrentDateElementFinder("Day", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("down", 30, DayChange * -1, currentDayElement);
        }
        else if (DayChange>0) {
            currentDayElement = CurrentDateElementFinder("Day", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("up", 30 , DayChange , currentDayElement);
        }
        if (MonthChange<0) {
            currentMonthElement = CurrentDateElementFinder("Month", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("down", 30, MonthChange * -1, currentMonthElement);
        }
        else if (MonthChange>0) {
            currentMonthElement = CurrentDateElementFinder("Month", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("up", 30 , MonthChange , currentMonthElement);
        }
        if (HourChange<0) {
            currentHourElement = CurrentDateElementFinder("Hour", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("down", 30, HourChange * -1, currentHourElement);
        }
        else if (HourChange>0) {
            currentHourElement = CurrentDateElementFinder("Hour", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("up", 30 , HourChange , currentHourElement);
        }
        if (MinuteChange<0) {
            currentMinuteElement = CurrentDateElementFinder("Minute", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("down", 30, MinuteChange * -1, currentMinuteElement);
        }
        else if (MinuteChange>0) {
            currentMinuteElement = CurrentDateElementFinder("Minute", CurrentDay,CurrentMonth,CurrentHour,CurrentMinute);
            swipeToDirectionWithIteration("up", 30 , MinuteChange , currentMinuteElement);
        }

    }

    public int MonthToint(java.lang.String Month, java.lang.String ReqPattern) throws ParseException {

        Date date = new SimpleDateFormat(ReqPattern, Locale.ENGLISH).parse(Month);
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        int finalVal = cal.get(Calendar.MONTH);
        return finalVal;

    }

    public java.lang.String UsefulDate(java.lang.String ReqFormat) {

        DateFormat dateFormat = new SimpleDateFormat(ReqFormat);
        Date date = new Date();
        Object stringdate = dateFormat.format(date);
        java.lang.String DateId = stringdate.toString();
        return DateId;
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
    public AndroidElement CurrentDateElementFinder (java.lang.String type , int CurrentDay , int CurrentMonth, int CurrentHour, int CurrentMinute) {
        setDriverToWebContext();
        java.lang.String selected = ".picker-opt.picker-opt-selected";
        List <AndroidElement> selectedElements = driver.findElementsByCssSelector(selected);
        //Arrays.sort(selectedElements, new SortByX());
        if (type=="Day") {
            return selectedElements.get(0);
        }
        else if (type == "Month" ) {
            return selectedElements.get(1);

        }
        else if (type == "Hour") {
            return  selectedElements.get(2);
        }
        else {
            return selectedElements.get(3);
        }
//        if (type == "Day") {
//            int xcord = 100000;
//            java.lang.String currentDayString = Integer.toString(CurrentDay);
//            for (AndroidElement number:numberss) {
//                int locationboi = number.getLocation().getX();
//                if (locationboi<xcord) {
//                    xcord = locationboi;
//                    Returned = number;
//                }
//            }
//            return Returned;
//
//        }
//        else if (type == "Month") {
//            Returned = (AndroidElement) driver.findElementByAccessibilityId(intToMonth(CurrentMonth));
//            return Returned;
//
//        }
//        else if (type == "Hour") {
//
//            List <AndroidElement> numberss =  driver.findElementsByAccessibilityId(Integer.toString(CurrentHour));
//            if (numberss.size() == 1) {
//                for (AndroidElement number:numberss) {
//                    Returned = number;
//                }
//            }
//            else if (numberss.size() == 2) {
//                if (((CurrentMinute -4)<CurrentHour) && ((CurrentMinute + 4)>CurrentHour)) {
//                    int xcord = 1000000;
//                    for (AndroidElement number:numberss) {
//                        int locationboi = number.getLocation().getX();
//                        if (locationboi<xcord) {
//                            xcord = locationboi;
//                            Returned = number;
//                        }
//                    }
//                }
//                else {
//                    int xcord = 0;
//                    for (AndroidElement number:numberss) {
//                        int locationboi = number.getCenter().getX();
//                        if (locationboi>xcord) {
//                            xcord = locationboi;
//                            Returned = number;
//                        }
//                    }
//                }
//            }
//            else {
//                AndroidElement Returnable1;
//                Returnable1 = null;
//                AndroidElement Returnable2;
//                Returnable2 = null;
//                AndroidElement Returnable3;
//                Returnable3 = null;
//                int Return1x = 0;
//                int Return2x = 0;
//                int Return3x = 0;
//                int y=0;
//
//                for (AndroidElement number:numberss) {
//                    if (y==0) {
//                        Returnable1 = number;
//                        Return1x = number.getCenter().getX();
//                    }
//                    else if (y==1) {
//                        Returnable2 = number;
//                        Return2x = number.getCenter().getX();
//                    }
//                    else if (y==2) {
//                        Returnable3 = number;
//                        Return3x = number.getCenter().getX();
//                    }
//                }
//                List<Integer> lList = new ArrayList<Integer>();
//
//                lList.add(Return1x);
//                lList.add(Return2x);
//                lList.add(Return3x);
//
//                Collections.sort(lList);
//
//                if (lList.get(1)==Return1x) {
//                    return Returnable1;
//                }
//                else if (lList.get(1)==Return2x) {
//                    return Returnable2;
//                }
//                else if (lList.get(1)==Return3x) {
//                    return Returnable3;
//                }
//
//
//            }
//        }
//        else {
//            int xcord = 0;
//            List <AndroidElement> numberss =  driver.findElementsByAccessibilityId(Integer.toString(CurrentMinute));
//            for (AndroidElement number:numberss) {
//                int locationboi = number.getLocation().getX();
//                if (locationboi>xcord) {
//                    xcord = locationboi;
//                    Returned = number;
//                }
//            }
//            return Returned;
//        }
//        return Returned;
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

    public void swipeToDirectionWithIteration( java.lang.String direction, int magnitude, int frequency, AndroidElement el) throws InterruptedException {

        if (direction == "up") {
            int x = el.getCenter().getX();
            int y = el.getCenter().getY();
            setDriverToWebContext();
            for (int i=0;i<frequency; i++) {
//                io.appium.java_client.TouchAction action = new TouchAction((AndroidDriver) driver);
//                action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y - magnitude)).release().perform();
                setDriverToMobileContext();
                new TouchAction((AndroidDriver) driver).press(PointOption.point(x,y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x,y - magnitude)).release().perform();
                Thread.sleep(200);
            }
            setDriverToWebContext();
        }

        if (direction == "down") {
            int x = el.getCenter().getX();
            int y = el.getCenter().getY();
            setDriverToWebContext();
            for (int i=0;i<frequency; i++) {
//                io.appium.java_client.TouchAction action = new TouchAction( driver);
//                action.press(PointOption.point(x, y)).waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1))).moveTo(PointOption.point(x, y + magnitude)).release().perform();
                setDriverToMobileContext();
                new TouchAction((AndroidDriver) driver).press(PointOption.point(x,y)).waitAction(WaitOptions.waitOptions(Duration.ofMillis(500))).moveTo(PointOption.point(x,y + magnitude)).release().perform();
                Thread.sleep(200);//gives slider chance to stop
            }
            setDriverToWebContext();
        }
    }
    public class SortByX implements Comparator<AndroidElement> {
        public int compare(AndroidElement a, AndroidElement b) {
            if ( a.getLocation().getX() < b.getLocation().getX() ) return -1;
            else if ( a.getLocation().getX() == b.getLocation().getX() ) return 0;
            else return 1;
        }
    }
}