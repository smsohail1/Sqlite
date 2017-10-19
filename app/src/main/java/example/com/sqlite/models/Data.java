package example.com.sqlite.models;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

import example.com.sqlite.helper.DBhelper;

/**
 * Created by muhammad.sohail on 10/19/2017.
 */

public class Data extends BaseModel {

    private String contactNo;
    private String name;

    public Data(String contactNo, String name) {
        this.contactNo = contactNo;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNo() {
        return contactNo;
    }

    public void setContactNo(String contactNo) {
        this.contactNo = contactNo;
    }


    @Override
    public boolean saveData() {
        return super.insertRecord(DBhelper.TABLE_USER, getContentValues());
    }

    public boolean saveData(SQLiteDatabase db) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(DBhelper.COL_USER_NAME, this.name);
        contentValues.put(DBhelper.COL_CONTACT_NO, this.contactNo);

        return super.insertRecord(DBhelper.TABLE_USER, contentValues);
    }

    /**
     * Common content values method to use
     *
     * @return
     */
    private ContentValues getContentValues() {

        // NOTE:
        // This method is used in all methods that need contentValues to perform db operations,
        // be careful to make changes, that may apply to all other methods as well,
        // in case of specific change in specific method create new getContentValues method or
        // define with in the respective method, Only make common change here

        ContentValues contentValues = new ContentValues();
        contentValues.put(DBhelper.COL_USER_NAME, this.name);
        contentValues.put(DBhelper.COL_CONTACT_NO, this.contactNo);


        return contentValues;
    }


}
