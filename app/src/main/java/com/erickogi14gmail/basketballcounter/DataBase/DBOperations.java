package com.erickogi14gmail.basketballcounter.DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_ID;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_NAME_A;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_NAME_B;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_ONE_R1;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_ONE_R2;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_ONE_R3;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_ONE_R4;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_ONE_R5;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_ONE_T;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_TWO_R1;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_TWO_R2;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_TWO_R3;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_TWO_R4;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_TWO_R5;
import static com.erickogi14gmail.basketballcounter.DataBase.DBKeys.KEY_TEAM_TWO_T;

/**
 * Created by kimani kogi on 4/13/2017.
 */

public class DBOperations {

    private DBHandler dbHandler;

    public DBOperations(Context context) {
        dbHandler = new DBHandler(context);
    }


    public int insert(DBKeys Keys) {

        //Open connection to write data
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();

        values.put(KEY_NAME_A, Keys.NAME_A);
        values.put(KEY_NAME_B,Keys.NAME_B);

        values.put(KEY_TEAM_ONE_R1,Keys.TEAM_ONE_R1);
        values.put(KEY_TEAM_TWO_R1,Keys.TEAM_TWO_R1);

        values.put(KEY_TEAM_ONE_R2,Keys.TEAM_ONE_R2);
        values.put(KEY_TEAM_TWO_R2,Keys.TEAM_TWO_R2);

        values.put(KEY_TEAM_ONE_R3,Keys.TEAM_ONE_R3);
        values.put(KEY_TEAM_TWO_R3,Keys.TEAM_TWO_R3);

        values.put(KEY_TEAM_ONE_R4,Keys.TEAM_ONE_R4);
        values.put(KEY_TEAM_TWO_R4,Keys.TEAM_TWO_R4);

        values.put(KEY_TEAM_ONE_R5,Keys.TEAM_ONE_R5);
        values.put(KEY_TEAM_TWO_R5,Keys.TEAM_TWO_R5);

        values.put(KEY_TEAM_ONE_T,Keys.TEAM_ONE_T);
        values.put(KEY_TEAM_TWO_T,Keys.TEAM_TWO_T);





        // Inserting Row
        long keys_Id = db.insert(DBKeys.TABLE, null, values);
        db.close(); // Closing database connection
        return (int) keys_Id;
    }

    public boolean update(String rowId, String NAME_A, String NAME_B,
                          int TEAM_ONE_R1,int TEAM_TWO_R1,
                          int  TEAM_ONE_R2,int TEAM_TWO_R2,
                          int  TEAM_ONE_R3,int TEAM_TWO_R3,
                          int  TEAM_ONE_R4,int TEAM_TWO_R4,
                          int TEAM_ONE_R5,int TEAM_TWO_R5,
                          int  TEAM_ONE_T,int TEAM_TWO_T
    ) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        ContentValues values = new ContentValues();



        values.put(KEY_NAME_A, NAME_A);
        values.put(KEY_NAME_B,NAME_B);

        values.put(KEY_TEAM_ONE_R1,TEAM_ONE_R1);
        values.put(KEY_TEAM_TWO_R1,TEAM_TWO_R1);

        values.put(KEY_TEAM_ONE_R2,TEAM_ONE_R2);
        values.put(KEY_TEAM_TWO_R2,TEAM_TWO_R2);

        values.put(KEY_TEAM_ONE_R3,TEAM_ONE_R3);
        values.put(KEY_TEAM_TWO_R3,TEAM_TWO_R3);

        values.put(KEY_TEAM_ONE_R4,TEAM_ONE_R4);
        values.put(KEY_TEAM_TWO_R4,TEAM_TWO_R4);

        values.put(KEY_TEAM_ONE_R5,TEAM_ONE_R5);
        values.put(KEY_TEAM_TWO_R5,TEAM_TWO_R5);

        values.put(KEY_TEAM_ONE_T,TEAM_ONE_T);
        values.put(KEY_TEAM_TWO_T,TEAM_TWO_T);










        return db.update(DBKeys.TABLE, values, KEY_ID + "=" + rowId, null) > 0;
    }
    public boolean delete(String rowId) {
        SQLiteDatabase db = dbHandler.getWritableDatabase();
        return db.delete(DBKeys.TABLE, KEY_ID + "=" + rowId, null) > 0;
    }
    public Cursor getGameList() {
        //Open connection to read only
        SQLiteDatabase db = dbHandler.getReadableDatabase();
        String selectQuery =  "SELECT  rowid as " +
                DBKeys.KEY_ROWID + "," +
                DBKeys.KEY_ID + "," +
                DBKeys.KEY_NAME_A + "," +
                DBKeys.KEY_NAME_B + "," +
                DBKeys.KEY_TEAM_ONE_R1 + "," +
                DBKeys.KEY_TEAM_TWO_R1 + "," +

                DBKeys.KEY_TEAM_ONE_R2 + "," +
                DBKeys.KEY_TEAM_TWO_R2 + "," +

                DBKeys.KEY_TEAM_ONE_R3 + "," +
                DBKeys.KEY_TEAM_TWO_R3 + "," +

                DBKeys.KEY_TEAM_ONE_R4 + "," +
                DBKeys.KEY_TEAM_TWO_R4 + "," +

                DBKeys.KEY_TEAM_ONE_R5 + "," +
                DBKeys.KEY_TEAM_TWO_R5 + "," +

                DBKeys.KEY_TEAM_ONE_T + "," +

                DBKeys.KEY_TEAM_TWO_T +
                " FROM " + DBKeys.TABLE;


        Cursor cursor = db.rawQuery(selectQuery, null);
        // looping through all rows and adding to list

        if (cursor == null) {
            return null;
        } else if (!cursor.moveToFirst()) {
            cursor.close();
            return null;
        }
        return cursor;


    }
}
