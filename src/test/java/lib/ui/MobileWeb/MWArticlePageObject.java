package lib.ui.MobileWeb;

import lib.ui.ArticlePageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MWArticlePageObject extends ArticlePageObject {

    static {
        TITLE = "css:#content h1";
        FOOTER_ELEMENT = "css:footer";
        OPTIONS_ADD_TO_MY_LIST_BUTTON = "css:#page-actions>li#page-actions-watch>a#ca-watch";
        OPTIONS_REMOVE_FROM_MY_LIST_BUTTON ="css:#page-actions li#ca-watch.mw-ui-icon-mf-watch button";
        ADD_TO_MY_LIST_OVERLAY = "";
        MY_LIST_NAME_INPUT = "";
        MY_LIST_OK_BUTTON = "";
        MY_LIST_TITLE_TLS = "";
        CLOSE_HINT_UNTIL_ADD_ARTICLE = "id:places auth close";
        CLOSE_ARTICLE_BUTTON = "id:Back";
    }

    public MWArticlePageObject(RemoteWebDriver driver) {
        super(driver);
    }
}
