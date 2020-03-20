package lib.factories;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.MobileWeb.MWSearchPageObject;
import lib.ui.MobileWeb.MWSearchResultPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.android.AndroidSearchResultPageObject;
import lib.ui.interfaces.ISearchMenuPageObject;
import lib.ui.interfaces.ISearchResultPageObject;
import lib.ui.ios.IOSSearchPageObject;
import lib.ui.ios.IOSSearchResultPageObject;

public class SearchResultPageObjectFactory {

    public static ISearchResultPageObject get(MainPageObject mainPageObject) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchResultPageObject(mainPageObject);
        } else if(Platform.getInstance().isIOS()){
            return new IOSSearchResultPageObject(mainPageObject);
        } else {
            return  new MWSearchResultPageObject(mainPageObject);
        }
    }
}
