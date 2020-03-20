package lib.ui.MobileWeb;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.interfaces.IArticlePageObject;
import org.openqa.selenium.WebElement;

public class MWArticlePageObject implements IArticlePageObject {

    private String
        TITLE = "css:#content h1",
        FOOTER_ELEMENT = "css:footer",
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions>li#page-actions-watch>a#ca-watch",
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON ="css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button",
        ADD_TO_MY_LIST_OVERLAY = "",
        MY_LIST_NAME_INPUT = "",
        MY_LIST_OK_BUTTON = "",
        MY_LIST_TITLE_TLS = "",
        CLOSE_HINT_UNTIL_ADD_ARTICLE = "id:places auth close",
        CLOSE_ARTICLE_BUTTON = "id:Back";

    private MainPageObject main;

    public MWArticlePageObject(MainPageObject mainPageObject)
    {
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
        return null;
    }

    @Override
    public void removeArticleFromSaveAdded() {
        if(main.isElementPresent(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON)){
            main.waitForElementAndClick(OPTIONS_REMOVE_FROM_MY_LIST_BUTTON,
                    "Cannot click button to remove Article from saved",5);
            main.waitForElementPresent(
                    OPTIONS_ADD_TO_MY_LIST_BUTTON,
                    "Cannot find button to add an article to saved list after removing it from this list before",6);
        }
    }

    @Override
    public void swipeToFooter() {
        main.scrollWebPageTillElementNotVisible(FOOTER_ELEMENT,
                "Cannot find the end of Article", 40);
    }

    @Override
    public void closeArticle() {
        System.out.println("Method closeArticle()  do nothing for platform" + Platform.getInstance().getPlatformVar());
    }

    @Override
    public void addArticlesToMySaved() {
        this.removeArticleFromSaveAdded();
        main.waitForElementAndClick(OPTIONS_ADD_TO_MY_LIST_BUTTON, "Cannot find opion to add article to reading list", 10);
    }

    @Override
    public WebElement waitForTitleElement() {
        return main.waitForElementPresent(TITLE, "Cannot article title on page", 15);

    }
}
