package lib.factories;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.MobileWeb.MWArticlePageObject;
import lib.ui.android.AndroidArticlePageObject;
import lib.interfaces.IArticlePageObject;
import lib.ui.ios.IOSArticlePageObject;


public class ArticlePageObjectFactrory {

    public static IArticlePageObject get(MainPageObject mainPageObject) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidArticlePageObject(mainPageObject);
        } else if(Platform.getInstance().isIOS()) {
            return new IOSArticlePageObject(mainPageObject);
        } else {
            return new MWArticlePageObject(mainPageObject);
        }
    }
}
