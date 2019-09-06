package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class NavigationUI extends MainPageObject {

    protected static  String MY_LIST_BUTTON,
                             OPEN_NAVIGATION;

    public NavigationUI(RemoteWebDriver driver) {
        super(driver);
    }

    public void openNavigation(){
        if(Platform.getInstance().isMobileWeb()){
            this.waitForElementAndClick(OPEN_NAVIGATION,"Cannot find and click navigation button",6);

        }else{
            System.out.println("Method openNavigation() dose nothing to platform"+Platform.getInstance().getPlatformVar());
        }
    }

    public void clickMyLists(){

        if(Platform.getInstance().isMobileWeb()){
            this.tryClickElementWithFewAttemts(MY_LIST_BUTTON,
                    "Cannot find and click myList button", 6);
        } else {
        this.waitForElementPresent(
                MY_LIST_BUTTON,
                "Cannot find navigation button to my lists",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_BUTTON,
                "Cannot find navigation button to my lists",
                5
        );
    }}
}
