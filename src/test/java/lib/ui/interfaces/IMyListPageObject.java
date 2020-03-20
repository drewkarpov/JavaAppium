package lib.ui.interfaces;

public interface IMyListPageObject {

    String getArticleXpathByName(String articleTitle);

    void openFolderByName(String nameOfFolder);

    void waitForArticleToDisappearByTitle(String articleTitle);

    void waitForArticleToAppearByTitle(String articleTitle);

    void swipeByArticleToDelete(String articleTitle);

    void assertArticleIsExist (String articleTitle);
}
