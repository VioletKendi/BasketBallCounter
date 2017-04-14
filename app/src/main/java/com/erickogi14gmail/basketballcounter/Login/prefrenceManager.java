package com.erickogi14gmail.basketballcounter.Login;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by kimani kogi on 4/13/2017.
 */

public class prefrenceManager {


    int PRIVATE_MODE = 0;

    private  static final  String myprefrence="MYPREFRENCE";


    public  void setStatus(Context context, boolean loggedIn){

        try {
            SharedPreferences settings = context.getSharedPreferences(myprefrence, PRIVATE_MODE);
            SharedPreferences.Editor editor = settings.edit();


            editor.putBoolean("loginStatus", loggedIn);
            editor.commit();

        }
        catch (Exception n){

        }

    }
    public boolean getStatus(Context context){
        SharedPreferences settings=  context.getSharedPreferences(myprefrence, PRIVATE_MODE);

        boolean status=settings.getBoolean("loginStatus",false);
        return  status;

    }
}
