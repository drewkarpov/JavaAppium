package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;
import org.openqa.selenium.remote.RemoteWebDriver;

abstract public class MyListsPageObject extends MainPageObject {

    protected static  String
            FOLDER_BY_NAME_TPL ,
            REMOVE_FROM_SAVED_BUTTON,
            ARTICLE_BY_TITLE_TPL;

    public MyListsPageObject(RemoteWebDriver driver) {
        super(driver);
    }
    private static String getFolderXpathByName(String nameOfFolder){
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",nameOfFolder);
    }
    private static String getArticleXpathByName(String articleTitle){
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",articleTitle);
    }
    private static String getRemoveButtonByTitle(String articleTitle){
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}",articleTitle);
    }
    public void openFoderByName(String nameOfFolder){
        String folderNameByXpath = getFolderXpathByName(nameOfFolder);
        this.waitForElementPresent(
                folderNameByXpath,
                "Cannot find navigation button to my lists",
                5
        );
        this.waitForElementAndClick(
                folderNameByXpath,
                "Cannot find navigation button to my lists",
                5
        );
    }
    public void waitForArticleToDisappearByTitle(String articleTitle){
        String articleXpath = getArticleXpathByName(articleTitle);
        this.waitForElementNotPresent(
                articleXpath,
                "Saved article still present with title "+ articleTitle,10
        );
    }
    public void waitForArticleToAppearByTitle(String articleTitle){
        String articleXpath = getArticleXpathByName(articleTitle);
        this.waitForElementPresent(
                articleXpath,
                "Cannot find article still present with title "+ articleTitle,10
        );
    }
    public void swipeByArticleToDelete(String articleTitle) {

        this.waitForArticleToAppearByTitle(articleTitle);
        String articleTitleByXpath = getArticleXpathByName(articleTitle);
        if (Platform.getInstance().isIOS() || Platform.getInstance().isAndroid()) {
            this.swipeElementToLeft(
                    articleTitleByXpath,
                    "cannot find saved article"
            );
            if (Platform.getInstance().isIOS()) {
                this.clickElementToTheRightUpperCorner(articleTitleByXpath, "Cannot find saved article");
            }
            this.waitForArticleToDisappearByTitle(articleTitle);

        } else {
            String removeLocator = getRemoveButtonByTitle(articleTitle);
            this.waitForElementAndClick(removeLocator,
                    "Cannot click button to remove article from saved",5);
            driver.navigate().refresh();
        }

    }

        public void assertArticleIsExist (String articleTitle){
            this.waitForArticleToAppearByTitle(articleTitle);
        }


}
