package lib.ui.MobileWeb;

import lib.ui.MainPageObject;
import lib.interfaces.IMyListPageObject;

public class MWMyListsPageObject implements IMyListPageObject {
    private String
        ARTICLE_BY_TITLE_TPL = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]",
        REMOVE_FROM_SAVED_BUTTON = "xpath://ul[contains(@class,'watchlist')]//h3[contains(text(),'{TITLE}')]/../../div[contains(@class,'watched')]";

    private MainPageObject main;

    public MWMyListsPageObject(MainPageObject mainPageObject)
    {
        this.main =mainPageObject;
    }


    public String getFolderXpathByName(String nameOfFolder) {
    //    return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",nameOfFolder);
        return "";
    }

    @Override
    public String getArticleXpathByName(String articleTitle) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",articleTitle);
    }
    private  String getRemoveButtonByTitle(String articleTitle){
        return REMOVE_FROM_SAVED_BUTTON.replace("{TITLE}",articleTitle);
    }

    @Override
    public void openFolderByName(String nameOfFolder) {
        String folderNameByXpath = getFolderXpathByName(nameOfFolder);
        main.waitForElementPresent(
                folderNameByXpath,
                "Cannot find navigation button to my lists",
                5
        );
        main.waitForElementAndClick(
                folderNameByXpath,
                "Cannot find navigation button to my lists",
                5
        );
    }

    @Override
    public void waitForArticleToDisappearByTitle(String articleTitle) {
        String articleXpath = getArticleXpathByName(articleTitle);
        main.waitForElementNotPresent(
                articleXpath,
                "Saved article still present with title "+ articleTitle,10
        );
    }

    @Override
    public void waitForArticleToAppearByTitle(String articleTitle) {
        String articleXpath = getArticleXpathByName(articleTitle);
        main.waitForElementPresent(
                articleXpath,
                "Cannot find article still present with title "+ articleTitle,10
        );
    }

    @Override
    public void swipeByArticleToDelete(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
        String removeLocator = getRemoveButtonByTitle(articleTitle);
        main.waitForElementAndClick(removeLocator,
                "Cannot click button to remove article from saved",5);

    }

    @Override
    public void assertArticleIsExist(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
    }
}
