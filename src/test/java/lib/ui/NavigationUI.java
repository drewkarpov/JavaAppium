package lib.ui;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;

abstract public class NavigationUI extends MainPageObject {

    protected static  String MY_LIST_BUTTON;
    public NavigationUI(AppiumDriver driver) {
        super(driver);
    }

    public void clickMyLists(){
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
    }
}
