package cryptonite.android.apps.com.traficoin;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import cryptonite.android.apps.com.traficoin.Models.DaoMaster;
import cryptonite.android.apps.com.traficoin.Models.DaoSession;

public class App extends Application {

    TCOpenHelper helper;
    Database db;
    DaoMaster daoMaster;
    DaoSession daoSession;

    @Override
    public void onCreate() {
        super.onCreate();
        helper = new TCOpenHelper(this, "traficoindb", null);
        db = helper.getWritableDb();
        daoMaster = new DaoMaster(db);
        daoSession = daoMaster.newSession();
    }
}
