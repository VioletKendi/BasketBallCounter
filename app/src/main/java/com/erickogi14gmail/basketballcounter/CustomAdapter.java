package com.erickogi14gmail.basketballcounter;

import android.content.Context;
import android.database.Cursor;

import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.erickogi14gmail.basketballcounter.DataBase.DBKeys;

/**
 * Created by kimani kogi on 4/13/2017.
 */

public class CustomAdapter extends CursorAdapter{


    private LayoutInflater mInflater;

    public CustomAdapter(Context context,Cursor c,int f) {
        super(context,c,f);
        mInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View   view    =    mInflater.inflate(R.layout.game_list_item, parent, false);
        ViewHolder holder  =   new ViewHolder();
        holder.textView_team_A_Name    =   (TextView)  view.findViewById(R.id.txt_team_a);
        holder.textView_team_B_Name    =   (TextView)  view.findViewById(R.id.txt_team_b);
        holder.textView_team_A_total_Score   =   (TextView)  view.findViewById(R.id.txt_team_a_scores);
        holder.textView_team_B_total_score   =   (TextView)  view.findViewById(R.id.txt_team_b_scores);
        holder.txtId  =   (TextView)  view.findViewById(R.id.txt_id);

        view.setTag(holder);
        return view;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ViewHolder holder  =   (ViewHolder)    view.getTag();
        holder.textView_team_A_Name.setText(cursor.getString(cursor.getColumnIndex(DBKeys.KEY_NAME_A)));
        holder.textView_team_B_Name.setText(cursor.getString(cursor.getColumnIndex(DBKeys.KEY_NAME_B)));
        holder.textView_team_A_total_Score.setText(cursor.getString(cursor.getColumnIndex(DBKeys.KEY_TEAM_ONE_T)));
        holder.textView_team_B_total_score.setText(cursor.getString(cursor.getColumnIndex(DBKeys.KEY_TEAM_TWO_T)));
        holder.txtId.setText(cursor.getString(cursor.getColumnIndex(DBKeys.KEY_ID)));
    }
    static class ViewHolder {
        TextView textView_team_A_Name,textView_team_B_Name,textView_team_A_total_Score,textView_team_B_total_score,txtId;
    }
}
