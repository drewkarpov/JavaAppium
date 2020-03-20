package lib.factories;

import lib.Platform;
import lib.ui.MainPageObject;
import lib.ui.MobileWeb.MWNavigationUI;
import lib.ui.android.AndroidNavigationUI;
import lib.interfaces.INavigationUI;
import lib.ui.ios.IOSNavigationUI;

public class NavigationUIFactory {

    public static INavigationUI get(MainPageObject mainPageObject){
        if(Platform.getInstance().isAndroid()){
            return new AndroidNavigationUI(mainPageObject);
        } else if(Platform.getInstance().isIOS()){
            return new IOSNavigationUI(mainPageObject);
        } else {
            return  new MWNavigationUI(mainPageObject);
        }
    }
}
