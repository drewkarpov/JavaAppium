package lib.ui.ios;

import lib.ui.MainPageObject;
import lib.ui.interfaces.IMyListPageObject;

public class IOSMyListsPageObject implements IMyListPageObject {

   private String ARTICLE_BY_TITLE_TPL = "xpath://*[contains(@name,'{TITLE}')]";
   private MainPageObject main;

    public IOSMyListsPageObject(MainPageObject mainPageObject) {
      this.main = mainPageObject;
    }


    public String getFolderXpathByName(String nameOfFolder) {
      //  return FOLDER_BY_NAME_TPL.replace("{FOLDER_NAME}",nameOfFolder);
        return "";
    }

    @Override
    public String getArticleXpathByName(String articleTitle) {
        return ARTICLE_BY_TITLE_TPL.replace("{TITLE}",articleTitle);
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
        String articleTitleByXpath = getArticleXpathByName(articleTitle);
        main.swipeElementToLeft(
                articleTitleByXpath,
                "cannot find saved article"
        );
        main.clickElementToTheRightUpperCorner(articleTitleByXpath, "Cannot find saved article");
        this.waitForArticleToDisappearByTitle(articleTitle);
    }

    @Override
    public void assertArticleIsExist(String articleTitle) {
        this.waitForArticleToAppearByTitle(articleTitle);
    }
}
