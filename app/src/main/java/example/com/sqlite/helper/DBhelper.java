package example.com.sqlite.helper;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by muhammad.sohail on 10/19/2017.
 */

public class DBhelper extends SQLiteOpenHelper {

    //Database instance
    private static DBhelper dbHelper;

    private static final String DB_NAME = "testdb";

    /* Increment the Database version by 1 each time we change it,
    *  For example if DB version is currently 3 than upgrade it to 4,
    *  Please do not jump numbers that is from 3 to 5
    * */
    private static final int DB_VERSION = 1;

    public static final String TABLE_USER = "user_table";
    public static final String COL_USER_NAME = "user_name";
    public static final String COL_CONTACT_NO = "contact_no";

    public static final String CREATE_TABLE_USER = "CREATE TABLE IF NOT EXISTS " + TABLE_USER + " (" +
            "id INTEGER PRIMARY KEY AUTOINCREMENT, " + COL_USER_NAME + " text , " + COL_CONTACT_NO + " text );";

    /*public DBhelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }*/

    private DBhelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static void setInstance(Context context) {
        dbHelper = new DBhelper(context);
    }

    public static DBhelper getInstance() {
        return dbHelper;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(CREATE_TABLE_USER);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        //DONT ADD break in any Switch CASE as it will stop the upgrades
        switch (oldVersion) {
            case 1:
                /* For example,
                * db.execSQL(DATA_BASE_UPDATE_1);
                * */
            case 2:
                // sqLiteDatabase.execSQL(CREATE_BILL_CUSTOMER_SIGNATURE_NIFT);
                // sqLiteDatabase.execSQL(CREATE_REF_SYNC_FILES);

                //   sqLiteDatabase.execSQL(CREATE_BOOKING_ROUTE);

//                Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM rms_bill_trans", null); // grab cursor for all data
//                int deleteStateColumnIndex = cursor.getColumnIndex("Destination_route_Code");  // see if the column is there
//                  int engineStateColumnIndex = csr.getColumnIndex("engine_number_bins");
//                if (deleteStateColumnIndex < 0) {
//                    // missing_column not there - add it
//                    sqLiteDatabase.execSQL("ALTER TABLE rms_bill_trans ADD COLUMN Destination_route_Code TEXT");
//                }
//                if (dobProductFilerStateColumnIndex < 0) {
//                    // missing_column not there - add it
//                    sqLiteDatabase.execSQL("ALTER TABLE rms_bill_insurance ADD COLUMN date_of_birth_bins TEXT");
//                }

//                sqLiteDatabase.execSQL("DROP TABLE IF EXISTS '" + TABLE_RMS_REF_BOOKING_ROUTE + "'");
//                sqLiteDatabase.execSQL(CREATE_BOOKING_ROUTE);
                break;
        }
    }
}
