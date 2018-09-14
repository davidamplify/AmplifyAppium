# AmplifyAppium
Some key files backed up and some help for new guy taking over me stuff init

## PreRequisites

install Xcode 

install homebrew

`ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"`

check install

`brew doctor`

install appium desktop (I use version 1.6.2, as when I tried a recent update it broke the test, but feel free to try updating, they include useful features like setting JAVA_HOME and ANDROID_HOME

install Android Studio

install intelliJ IDEA

download "selenium-server-standalone 3.13.x.jar" or later https://mvnrepository.com/artifact/org.seleniumhq.selenium/selenium-server

download Appium "java-client-6.1.x.jar" or later https://mvnrepository.com/artifact/io.appium/java-client

download chromedriver.exe (used for Web context, in event it does not work, warning given should indicate what version to download)

`brew install carthage` (for iOS)

`brew install node`


## Setting up Appium Tests 

### iOS

Create project in itelliJ - name whatever you want

go to src, new java class, name whatever you want the test to be

File-Project Structure-Libraries, add selenium server and appium java client, apply

Follow example code in MyFirstTest - First_Test.java

For a newer app progress go to MyFirstTest Copy

### Android

Set JAVA_HOME, ANDROID_HOME : http://www.sajeconsultants.com/how-to-set-java_home-on-mac-os-x/

Create project in itelliJ - name whatever you want

go to src, new java class, name whatever you want the test to be

File-Project Structure-Libraries, add selenium server and appium java client, apply

Follow example code in AndroidAmplifyAppiumLoginHappyPath - src - HappyLoginPath.java

Note: sometimes the app doesn't like java 10 so you might want to change to 8. Here's how: https://stackoverflow.com/questions/21964709/how-to-set-or-change-the-default-java-jdk-version-on-os-x

## Running The Test

Open Appium Desktop

Click big start server button

(On Android) Open Android Studio, cmd+shif+a, avd, set up android device, start simulator
 
Go to itellij project, right click on .java test file, run

### Integrating Appium Tests with Cucumber

To start a project, the best place to start is here: https://medium.com/@mlvandijk/getting-started-with-cucumber-in-java-a-10-minute-tutorial-586652d2c82

Add to your libraries the same code as you usually would for your appium stuff.

After that I would take a look at my cucumber project (LoginNew) to see how to get it going, as there aren't any good tutorials online (that I could find).

Once configured, cucumber is fairly simple and it's mainly about modularising your appium code.

### Running Cucumber Test from IntelliJ

Right click on feature file, or feature file directory to run.

### Running Cucumber Test from Terminal

`mvn test` or `mvn clean test`. Go to Help if there are any issues.

## HELP

For help with common problems  go to AmplifyAppium/Common issues and Tips.docx most general problems are quashed in example files, so compare where possible to them for relevant solutions.

Also not on github, but on the Devops machine (password bing btw) at Docs/Appium Tests/How To are some videos on how to set it all up.

Also, a bunch of these files are updated on the devops machine, including the help document. tests and stuff in docs/Appium Tests/IntelliJ Tests and the help document at just docs. hope this all helps. over and out
