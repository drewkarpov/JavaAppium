package lib.factories;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.MobileWeb.MWSearchPageObject;
import lib.ui.android.AndroidSearchPageObject;
import lib.ui.interfaces.ISearchMenuPageObject;
import lib.ui.ios.IOSSearchPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SearchPageObjectFactory {

    public static ISearchMenuPageObject get(MainPageObject mainPageObject) {
        if (Platform.getInstance().isAndroid()) {
            return new AndroidSearchPageObject(mainPageObject);
        } else if(Platform.getInstance().isIOS()){
            return new IOSSearchPageObject(mainPageObject);
        } else {
            return  new MWSearchPageObject(mainPageObject);
        }
    }
}
