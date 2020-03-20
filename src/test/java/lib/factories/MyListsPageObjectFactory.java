package lib.factories;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.MobileWeb.MWMyListsPageObject;
import lib.ui.android.AndroidMyListsPageObject;
import lib.ui.interfaces.IMyListPageObject;
import lib.ui.ios.IOSMyListsPageObject;
import org.openqa.selenium.remote.RemoteWebDriver;

public class MyListsPageObjectFactory {

    public static IMyListPageObject get(MainPageObject mainPageObject){
        if (Platform.getInstance().isAndroid()){
            return new AndroidMyListsPageObject(mainPageObject);
        } else if (Platform.getInstance().isIOS()) {
            return new IOSMyListsPageObject(mainPageObject);
        } else {
            return new MWMyListsPageObject(mainPageObject);
        }
    }
}
