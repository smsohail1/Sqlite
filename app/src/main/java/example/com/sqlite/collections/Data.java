package example.com.sqlite.collections;

import android.database.sqlite.SQLiteDatabase;

import example.com.sqlite.helper.DBhelper;

/**
 * Created by muhammad.sohail on 10/19/2017.
 */

public class Data extends BaseCollection {

    public int deleteRecord(SQLiteDatabase db) {
        return super.deleteAllRecords(db, DBhelper.TABLE_USER);
    }
}
