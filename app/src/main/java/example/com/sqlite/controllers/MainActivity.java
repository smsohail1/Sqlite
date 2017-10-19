package example.com.sqlite.controllers;

import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import example.com.sqlite.R;
import example.com.sqlite.helper.DBhelper;
import example.com.sqlite.models.Data;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Setting Context to DbHelper static class
        DBhelper.setInstance(this);

        // sqLite db transactions
        SQLiteDatabase db = DBhelper.getInstance().getWritableDatabase();
        db.beginTransaction();

        example.com.sqlite.collections.Data dataCollection = new example.com.sqlite.collections.Data();
        if(dataCollection.deleteRecord(db)==-1){
            Toast.makeText(this, "delete", Toast.LENGTH_SHORT).show();
        }

//        Data dataModel = new Data("john", "03452292192");
//        if (!dataModel.saveData()) {
//            transactionFailure(db);
//            return;
//        }

        // Commit transaction
        db.setTransactionSuccessful();
        //end transaction
        db.endTransaction();


    }

    private void transactionFailure(SQLiteDatabase db) {
        // End transaction
        db.endTransaction();
        // re-try fetch data

    }
}
