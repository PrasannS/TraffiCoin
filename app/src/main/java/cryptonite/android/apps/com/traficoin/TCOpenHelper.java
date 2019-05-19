package cryptonite.android.apps.com.traficoin;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import cryptonite.android.apps.com.traficoin.Models.DaoMaster;

public class TCOpenHelper extends DaoMaster.OpenHelper {
    public TCOpenHelper(Context context, String name) {
        super(context, name);
    }

    public TCOpenHelper(Context context, String name, SQLiteDatabase.CursorFactory factory) {
        super(context, name, factory);
    }


}
