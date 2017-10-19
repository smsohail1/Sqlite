package example.com.sqlite.models;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import example.com.sqlite.helper.DBhelper;

/**
 * Created by m.imran on 2/3/2016.
 */
public abstract class BaseModel {

    /**
     * DB Insert Methods
     *
     * @param tbl
     * @param cv
     * @return
     */
    protected boolean insertRecord(String tbl, ContentValues cv) {
        SQLiteDatabase sqLite = DBhelper.getInstance().getWritableDatabase();
        long result = sqLite.insert(tbl, DBhelper.COL_CONTACT_NO, cv);
        return result > 0;
    }

    /**
     * DB Delete Method
     *
     * @param tbl
     * @param condition
     * @param args
     * @return
     */
    protected boolean deleteRecord(String tbl, String condition, String[] args) {
        SQLiteDatabase sqLite = DBhelper.getInstance().getWritableDatabase();
        long result = sqLite.delete(tbl, condition, args);
        return result > 0;
    }

    /**
     * DB Update Method
     *
     * @param tbl
     * @param condition
     * @param cv
     * @param args
     * @return
     */
    protected boolean updateRecord(String tbl, String condition, ContentValues cv, String[] args) {
        SQLiteDatabase sqLite = DBhelper.getInstance().getWritableDatabase();
        long result = sqLite.update(tbl, cv, condition, args);
        return result > 0;
    }

    /**
     * DB Insert Methods
     *
     * @param sqLite
     * @param tbl
     * @param cv
     * @return
     */
    protected boolean insertRecord(SQLiteDatabase sqLite, String tbl, ContentValues cv) {
        long result = sqLite.insert(tbl, DBhelper.COL_CONTACT_NO, cv);
        return result > 0;
    }

    /**
     * DB Delete Method
     *
     * @param sqLite
     * @param tbl
     * @param condition
     * @param args
     * @return
     */
    protected boolean deleteRecord(SQLiteDatabase sqLite, String tbl, String condition, String[] args) {
        long result = sqLite.delete(tbl, condition, args);
        return result > 0;
    }

    /**
     * Truncate table Method
     *
     * @param sqLite
     * @param tbl
     * @return
     */
    protected int truncate(SQLiteDatabase sqLite, String tbl) {
        int result = sqLite.delete(tbl, null, null);
        return result;
    }

    /**
     * DB Update Method
     *
     * @param sqLite
     * @param tbl
     * @param condition
     * @param cv
     * @param args
     * @return
     */
    protected boolean updateRecord(SQLiteDatabase sqLite, String tbl, String condition, ContentValues cv, String[] args) {
        long result = sqLite.update(tbl, cv, condition, args);
        return result > 0;
    }

    /**
     * DB Insert or Replace Method
     *
     * @param sqLite
     * @param tbl
     * @param cv
     * @return
     */
    protected boolean insertOrReplaceRecord(SQLiteDatabase sqLite, String tbl, ContentValues cv) {
        long result = sqLite.insertWithOnConflict(tbl, null, cv, SQLiteDatabase.CONFLICT_REPLACE);
        return result > 0;
    }

    /**
     * DB Select Method
     *
     * @param tbl
     * @param condition
     * @param args
     * @return
     */
    protected Cursor getRecord(String tbl, String condition, String[] args) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getReadableDatabase();
        String query = "SELECT * FROM " + tbl;

        if (condition != null) {
            query += " WHERE " + condition;
        }

        Log.d("Query", query.toString());
        Cursor cursor = sqLite.rawQuery(query, args);
        return cursor;
    }

    /**
     * DB Select Method
     *
     * @param sqLite
     * @param tbl
     * @param condition
     * @param args
     * @return
     */
    protected Cursor getRecord(SQLiteDatabase sqLite, String tbl, String condition, String[] args) {

        String query = "SELECT * FROM " + tbl;

        if (condition != null) {
            query += " WHERE " + condition;
        }

        Cursor cursor = sqLite.rawQuery(query, args);
//        sqLite.close();
        return cursor;
    }

    /**
     * DB Select Method
     *
     * @param tbl
     * @param condition
     * @param args
     * @param order
     * @return
     */
    protected Cursor getRecord(String tbl, String condition, String[] args, String order) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getReadableDatabase();
        String query = "SELECT * FROM " + tbl;

        if (condition != null) {
            query += " WHERE " + condition;
        }
        if (order != null) {
            query += order;
        }
        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }

    /**
     * DB Select Method
     *
     * @param tbl
     * @param condition
     * @param join
     * @param args
     * @return
     */
    protected Cursor getRecord(String tbl, String condition, String join, String[] args) {

        SQLiteDatabase sqLite = DBhelper.getInstance().getReadableDatabase();
        String query = "SELECT * FROM " + tbl;

        if (join != null) {
            query += " " + join + " ";
        }

        if (condition != null) {
            query += " WHERE " + condition;
        }

        Cursor cursor = sqLite.rawQuery(query, args);

        return cursor;
    }

    /**
     * Abstract SaveData Method
     *
     * @return
     */
    public abstract boolean saveData();
}
