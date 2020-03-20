package lib.interfaces;

import org.openqa.selenium.WebElement;

public interface IArticlePageObject {

    void addArticleToMyList(String nameOfFolder);

    String getArticleTitle();

    void removeArticleFromSaveAdded();

    void swipeToFooter();

    void closeArticle();

    void addArticlesToMySaved();

    WebElement waitForTitleElement();
}
