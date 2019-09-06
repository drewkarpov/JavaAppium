package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class ArticlePageObject extends MainPageObject {
    protected static String
            TITLE,
            FOOTER_ELEMENT,
            OPTIONS_BUTTON,
            OPTIONS_ADD_TO_MY_LIST_BUTTON,
            OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
            ADD_TO_MY_LIST_OVERLAY,
            MY_LIST_NAME_INPUT,
            MY_LIST_OK_BUTTON,
            MY_LIST_TITLE_TLS,
            CLOSE_HINT_UNTIL_ADD_ARTICLE,
            CLOSE_ARTICLE_BUTTON;


    public ArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }

    public WebElement waitForTitleElement() {
        return this.waitForElementPresent(TITLE, "Cannot article title on page", 15);
    }

    public String getArticleTitle() {
        WebElement titleElement = waitForTitleElement();
        if (Platform.getInstance().isAndroid()) {
            return titleElement.getAttribute("text");
        } else if (Platform.getInstance().isIOS()){
            return titleElement.getAttribute("name");
        } else {
            return titleElement.getText();
        }

    }
    public void removeArticleFromSaveAdded(){
        if(this.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
            this.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove Article from saved",5);
            this.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before",6);
        }
    }



    public void swipeToFooter() {
        if (Platform.getInstance().isAndroid()) {
            this.swipeUpToElement(FOOTER_ELEMENT,
                    "Cannot find the end of Article", 20);
        } else if(Platform.getInstance().isIOS()){
            this.swipeUpTillElementAppear(FOOTER_ELEMENT,
                    "Cannot find the end of Article", 40);
        } else {
            this.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT,
                    "Cannot find the end of Article", 40);
        }
    }

    public String getTitleListXpath(String nameOfFolder) {
        return MY_LIST_TITLE_TLS.replace("{LIST_TITLE}", nameOfFolder);
    }

    public void addArticleToMyList(String nameOfFolder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option add article to reading list",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option add article to reading list",
                5
        );
        this.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );
        this.waitFotElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );
        this.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                nameOfFolder,
                "cannot put text into articles folder input",
                5
        );
        this.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK  button",
                5
        );
    }

    public void addArticleToMyExistList(String nameOfFolder) {
        this.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
        this.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option add article to reading list",
                5
        );
        this.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option add article to reading list",
                5
        );
        String titleXpath = getTitleListXpath(nameOfFolder);
        this.waitForElementAndClick(
                titleXpath,
                "Cannot find item title in my list",
                5
        );

    }

    public void closeHintUntilAddArticle(){
        this.waitForElementAndClick(
                CLOSE_HINT_UNTIL_ADD_ARTICLE,
                "Cannot hint article, cannot find X link",
                5
        );
    }
    public void closeArticle() {
        if(Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()){
        this.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );} else {
            System.out.println("Method closeArticle()  do nothing for platform" +Platform.getInstance().getPlatformVar());
        }
    }

    public void addArticlesToMySaved() {
        if(Platform.getInstance().isMobileWeb()){
            this.removeArticleFromSaveAdded();
        }
        this.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find opion to add article to reading list", 10);
    }

}
