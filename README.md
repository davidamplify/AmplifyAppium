#### AmplifyAppium
Some key files backed up and some help for new guy taking over me stuff init

### PreRequisites

install Xcode 

install homebrew

'ruby -e "$(curl -fsSL https://raw.githubusercontent.com/Homebrew/install/master/install)"'

check install

'brew doctor'

install appium desktop

install Android Studio

install intelliJ IDEA

download "selenium-server-standalone 3.13.x.jar" or later

download Appium "java-client-6.1.x.jar" or later

download chromedriver.exe (used for Web context, in event it does not work, warning given should indicate what version to download)

'brew install carthage' (for iOS)

'brew install node'


### Setting up Appium Tests 

## iOS

Create project in itelliJ - name whatever you want

go to src, new java class, name whatever you want the test to be

File-Project Structure-Libraries, add selenium server and appium java client, apply

Follow example code in MyFirstTest - First_Test.java

## Android

make

Create project in itelliJ - name whatever you want

go to src, new java class, name whatever you want the test to be

File-Project Structure-Libraries, add selenium server and appium java client, apply

Follow example code in AndroidAmplifyAppiumLoginHappyPath - src - HappyLoginPath.java

### Running The Test

Open Appium Desktop

Click big start server button

(On Android) Open Android Studio, cmd+shif+a, avd, set up android device, start simulator
 
Go to itellij project, right click on .java test file, run

### Integrating Appium Tests with Cucumber



For help with common problems  go to HELPMEIWANTTODIE.txt most general problems are quashed in example files, so compare where possible to them for relevant solutions.
