package com.erickogi14gmail.basketballcounter.DataBase;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by kimani kogi on 4/13/2017.
 */

public class DBHandler extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "game.db";


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + DBKeys.TABLE);


        // Create tables again
        onCreate(db);

    }
    String CREATE_TABLE = "CREATE TABLE " + DBKeys.TABLE  + "("
            + DBKeys.KEY_ID  + " INTEGER PRIMARY KEY AUTOINCREMENT ,"

            + DBKeys.KEY_NAME_A + " TEXT, "
            + DBKeys.KEY_NAME_B + " TEXT, "

            + DBKeys.KEY_TEAM_ONE_R1 + " INTEGER ,"
            + DBKeys.KEY_TEAM_TWO_R1 + " INTEGER ,"

            + DBKeys.KEY_TEAM_ONE_R2 + " INTEGER ,"
            + DBKeys.KEY_TEAM_TWO_R2 + " INTEGER ,"

            + DBKeys.KEY_TEAM_ONE_R3 + " INTEGER ,"
            + DBKeys.KEY_TEAM_TWO_R3 + " INTEGER ,"

            + DBKeys.KEY_TEAM_ONE_R4 + " INTEGER ,"
            + DBKeys.KEY_TEAM_TWO_R4 + " INTEGER ,"

            + DBKeys.KEY_TEAM_ONE_R5 + " INTEGER ,"
            + DBKeys.KEY_TEAM_TWO_R5 + " INTEGER ,"

            + DBKeys.KEY_TEAM_ONE_T + " INTEGER ,"
            + DBKeys.KEY_TEAM_TWO_T + " INTEGER "

            +")";

}
