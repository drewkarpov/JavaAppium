package lib.ui.MobileWeb;

import io.appium.java_client.AppiumDriver;
import lib.ui.MainPageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

public class WelcomePageObject extends MainPageObject {

    private static final String
    STEP_LEARN_MORE_LINK ="xpath://*[@name='Learn more about Wikipedia']",
    STEP_NEW_WAYS_TO_EXPLORE_TEXT ="xpath://*[@name='New ways to explore']",
    STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK ="xpath://*[@name='Add or edit preferred languages']",
    STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK ="xpath://*[@name='Learn more about data collected']",
    NEXT_LINK ="xpath://*[@label='Next']",
    SKIP_BUTTON ="xpath://*[@name='Skip']",
    GET_STARTED_BUTTON="xpath://*[@label='Get started']";


    public WelcomePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public void waitForLearnMoreLink(){

        this.waitForElementPresent(STEP_LEARN_MORE_LINK,
                "Cannot find Learn more about Wikipedia",10);
    }
    public void waitForNewWayToExploreText(){

        this.waitForElementPresent(STEP_NEW_WAYS_TO_EXPLORE_TEXT,
                "Cannot find 'New ways to explore'",10);
    }
    public void waitForAddOrEditPrefferedLangText(){

        this.waitForElementPresent(STEP_ADD_OR_EDIT_PREFFERED_LANG_LINK,
                "Cannot find 'Add or edit preferred languages'",10);
    }
    public void waitForLearnMoreAboutDataCollectedText(){

        this.waitForElementPresent(STEP_LEARN_MORE_ABOUT_DATA_COLLECTED_LINK,
                "Cannot find 'Learn more about data collected'",10);
    }
    public void clickNextButton(){

        this.waitForElementAndClick(NEXT_LINK,
                "Cannot find and click 'Next' link",10);
    }
    public void clickGetStartedButton(){

        this.waitForElementAndClick(GET_STARTED_BUTTON,
                "Cannot find and click 'Get started' link",10);
    }

    public void clickSkip() {
        this.waitForElementAndClick(SKIP_BUTTON,
                "Cannot find and click 'Skip' link",10);
    }
}
