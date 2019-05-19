package cryptonite.android.apps.com.traficoin;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

import org.greenrobot.greendao.database.Database;
import org.greenrobot.greendao.database.DatabaseOpenHelper;

import java.util.Date;

import cryptonite.android.apps.com.traficoin.Models.DaoMaster;
import cryptonite.android.apps.com.traficoin.Models.DaoSession;
import cryptonite.android.apps.com.traficoin.Models.Goal;

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
        Goal fd = new Goal();
        fd.setDistance(true);
        fd.setTimestamp((new Date()).getTime());
        fd.setValue(37);
        Goal fs = new Goal();
        fs.setDistance(false);
        fs.setTimestamp((new Date()).getTime());
        fs.setValue(59);
        daoSession.getGoalDao().insert(fs);
        daoSession.getGoalDao().insert(fd);
    }

    public DaoSession getDaoSession() {
        return daoSession;
    }
}
