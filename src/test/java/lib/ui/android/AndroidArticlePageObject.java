package lib.ui.android;

import lib.ui.MainPageObject;
import lib.interfaces.IArticlePageObject;
import org.openqa.selenium.WebElement;

public class AndroidArticlePageObject implements IArticlePageObject {
    private String
            TITLE = "id:org.wikipedia:id/view_page_title_text",
            FOOTER_ELEMENT = "xpath://*[@text='View page in browser']",
            OPTIONS_BUTTON = "xpath://android.widget.ImageView[@content-desc='More options']",
            OPTIONS_ADD_TO_MY_LIST_BUTTON = "xpath://*[@resource-id='org.wikipedia:id/title'][@text='Add to reading list']",
            ADD_TO_MY_LIST_OVERLAY = "id:org.wikipedia:id/onboarding_button",
            MY_LIST_NAME_INPUT = "id:org.wikipedia:id/text_input",
            MY_LIST_OK_BUTTON = "xpath://*[@text='OK']",
            MY_LIST_TITLE_TLS = "xpath://*[@text='{LIST_TITLE}']",
            CLOSE_ARTICLE_BUTTON = "xpath://android.widget.ImageButton[@content-desc='Navigate up']";

    private MainPageObject main;

    public AndroidArticlePageObject(MainPageObject mainPageObject) {
        this.main = mainPageObject;
    }


    @Override
    public void addArticleToMyList(String nameOfFolder) {
        main.waitForElementAndClick(
                OPTIONS_BUTTON,
                "Cannot find button to open article options",
                5
        );
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
    public WebElement waitForTitleElement() {
        return main.waitForElementPresent(TITLE, "Cannot article title on page", 15);

    }
    @Override
    public String getArticleTitle() {
        return waitForTitleElement().getAttribute("text");
    }

    @Override
    public void removeArticleFromSaveAdded() {
        main.waitForElementPresent(
                OPTIONS_ADD_TO_MY_LIST_BUTTON,
                "Cannot find button to add an article to saved list after removing it from this list before", 6);

    }
    @Override
    public void swipeToFooter() {
        main.swipeUpToElement(FOOTER_ELEMENT,
                "Cannot find the end of Article", 20);
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

}
