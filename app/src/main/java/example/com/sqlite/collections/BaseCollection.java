package example.com.sqlite.collections;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import example.com.sqlite.helper.DBhelper;



public class BaseCollection {

    protected static Cursor getRecord(String tbl, String condition, String[] args) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getWritableDatabase();

        String query = "SELECT * FROM " + tbl;

        if ( condition != null ) {
            query += " WHERE " + condition;
        }

        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }

    protected Cursor getServiceRecord(String tbl, String condition, String[] args) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getWritableDatabase();

        String query = "SELECT * FROM " + tbl;

        if ( condition != null ) {
            query += " WHERE " + condition;
        }

        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }

    protected Cursor getRecord(String tbl, String condition, String[] args, String order) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getWritableDatabase();

        String query = "SELECT * FROM " + tbl;

        if ( condition != null ) {
            query += " WHERE " + condition;
        }

        if (order!=null){
            query += " order by " + order;
        }

        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }

    protected Cursor getRecord(String tbl, String condition, String join, String[] args) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getReadableDatabase();
        String query = "SELECT * FROM " + tbl;

        if ( join != null ) {
            query += " " + join + " ";
        }

        if ( condition != null ) {
            query += " WHERE " + condition;
        }

        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }

    /**
     * Delete Records Method
     * @param tbl
     * @param condition
     * @param args
     * @return
     */
    protected int deleteRecords(String tbl, String condition, String[] args) {

        if (null == condition)
            return -1;

        SQLiteDatabase sqLite = DBhelper.getInstance().getReadableDatabase();

        return sqLite.delete(tbl, condition, args);
    }

    /**
     * Delete Records Method
     * @param sqLite
     * @param tbl
     * @param condition
     * @param args
     * @return
     */
    protected int deleteRecords(SQLiteDatabase sqLite, String tbl, String condition, String[] args) {

        if (null == condition)
            return -1;

        return sqLite.delete(tbl, condition, args);
    }

    /**
     * Delete All Records Method
     * @param sqLite
     * @param tbl
     * @return
     */
    protected int deleteAllRecords(SQLiteDatabase sqLite, String tbl) {
//        int result = sqLite.delete(tbl, null, null);
        // android.database.sqlite.SQLiteException: cannot VACUUM from within a transaction
        // sqLite.execSQL("VACUUM");

        // TRUNCATE optimizer
        sqLite.execSQL("DELETE FROM " + tbl);
        return 1;
    }

    /**
     * Get Record Method
     *
     * @param query
     * @param condition
     * @param join
     * @param args
     * @param groupBy
     * @return
     */
    protected Cursor getRecord(String query, String condition, String join, String[] args, String groupBy) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getReadableDatabase();

        if ( join != null ) {
            query += " " + join + " ";
        }

        if ( condition != null ) {
            query += " WHERE " + condition;
        }

        if (groupBy!=null){
            query += " group by " + groupBy;
        }


        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }
}
