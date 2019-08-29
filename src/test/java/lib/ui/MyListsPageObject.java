package lib.ui;

import io.appium.java_client.AppiumDriver;
import lib.Platform;
import org.openqa.selenium.By;

abstract public class MyListsPageObject extends MainPageObject {

    protected static  String
            FOLDER_BY_NAME_TPL ,
            ARTICLE_BY_TITLE_TPL;

    public MyListsPageObject(AppiumDriver driver) {
        super(driver);
    }
    private static String getFolderXpathByName(String nameOfFolder){
        return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",nameOfFolder);
    }
    private static String getArticleXpathByName(String articleTitle){
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",articleTitle);
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
    public void swipeByArticleToDelete(String articleTitle){
        this.waitForArticleToAppearByTitle(articleTitle);
        String articleTitleByXpath = getArticleXpathByName(articleTitle);
        this.swipeElementToLeft(
                articleTitleByXpath,
                "cannot find saved article"
        );
        if (Platform.getInstance().isIOS()) {
        this.clickElementToTheRightUpperCorner(articleTitleByXpath,"Cannot find saved article");
        }
        this.waitForArticleToDisappearByTitle(articleTitle);
    }
    public void assertArticleIsExist(String articleTitle){
        this.waitForArticleToAppearByTitle(articleTitle);
    }


}
