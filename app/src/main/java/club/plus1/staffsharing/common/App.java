package club.plus1.staffsharing.common;

import android.app.Application;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.widget.Toast;

import club.plus1.staffsharing.R;
import club.plus1.staffsharing.db.Database;
import club.plus1.staffsharing.db.User;

public class App extends Application {

    private static Context appContext;
    private static Database db;
    public static User user;
    public static int versionCode;
    public static String versionName;

    public static Context getAppContext() {
        return appContext;
    }

    public static void setAppContext(Context appContext) {
        App.appContext = appContext;
    }

    public static Database getDb() {
        return db;
    }

    public static void setDb(Database db) {
        App.db = db;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        init();
    }

    @Override
    public void onTerminate() {
        super.onTerminate();
        terminate();
    }

    private void init(){
        setAppContext(this);
        setDb(Database.getLocalDatabase(this));
        PackageInfo pInfo = null;
        try {
            PackageManager pm = getPackageManager();
            if (pm != null){
                pInfo = pm.getPackageInfo(getPackageName(), 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            String message = getString(R.string.error_app_package_not_found);
            Toast.makeText(getAppContext(), message, Toast.LENGTH_LONG).show();
        }
        if (pInfo == null) {
            pInfo = new PackageInfo();
            pInfo.versionName = "0.0";
            pInfo.versionCode = 0;
        }
        versionName = pInfo.versionName;
        versionCode = pInfo.versionCode;
    }

    private void terminate(){
        setAppContext(null);
        Database.destroyInstance();
        setDb(null);
        user = null;
    }
}
