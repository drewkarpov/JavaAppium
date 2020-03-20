package lib.ui.ios;

import lib.ui.MainPageObject;
import lib.interfaces.IArticlePageObject;
import org.openqa.selenium.WebElement;

public class IOSArticlePageObject implements IArticlePageObject {

    private String
            TITLE = "id:Java (programming language)",
            FOOTER_ELEMENT = "id:View article in browser",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "id:Save for later",
            ADD_TO_MY_LIST_OVERLAY = "",
            MY_LIST_NAME_INPUT = "",
            MY_LIST_OK_BUTTON = "",
            MY_LIST_TITLE_TLS = "",
            CLOSE_HINT_UNTIL_ADD_ARTICLE = "id:places auth close",
            CLOSE_ARTICLE_BUTTON = "id:Back";
    private MainPageObject main;


    public IOSArticlePageObject(MainPageObject mainPageObject) {
        this.main = mainPageObject;
    }

    @Override
    public void addArticleToMyList(String nameOfFolder) {

        main.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option add article to reading list",
                5
        );
        main.waitForElementAndClick(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find option add article to reading list",
                5
        );
        main.waitForElementAndClick(
                ADD_TO_MY_LIST_OVERLAY,
                "Cannot find 'Got it' tip overlay",
                5
        );
        main.waitFotElementAndClear(
                MY_LIST_NAME_INPUT,
                "Cannot find input to set name of articles folder",
                5
        );
        main.waitForElementAndSendKeys(
                MY_LIST_NAME_INPUT,
                nameOfFolder,
                "cannot put text into articles folder input",
                5
        );
        main.waitForElementAndClick(
                MY_LIST_OK_BUTTON,
                "Cannot press OK  button",
                5
        );
    }

    @Override
    public String getArticleTitle() {
        return waitForTitleElement().getAttribute("name");
    }

    @Override
    public void removeArticleFromSaveAdded() {
        main.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to add an article to saved list after removing it from this list before", 6);
    }

    @Override
    public void swipeToFooter() {
        main.swipeUpTillElementAppear(FOOTER_ELEMENT,
                "Cannot find the end of Article", 40);
    }

    @Override
    public void closeArticle() {
        main.waitForElementAndClick(
                CLOSE_ARTICLE_BUTTON,
                "Cannot close article, cannot find X link",
                5
        );
    }

    @Override
    public void addArticlesToMySaved() {
        main.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find opion to add article to reading list", 10);

    }

    @Override
    public WebElement waitForTitleElement() {
        return main.waitForElementPresent(TITLE, "Cannot article title on page", 15);

    }
}
