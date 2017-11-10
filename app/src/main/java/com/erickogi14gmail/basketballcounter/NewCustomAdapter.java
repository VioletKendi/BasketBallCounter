package com.erickogi14gmail.basketballcounter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.erickogi14gmail.basketballcounter.DataBase.Pojo;

import java.util.ArrayList;

/**
 * Created by kimani kogi on 4/14/2017.
 */

public class NewCustomAdapter extends BaseAdapter {
    Context context;
    ArrayList<Pojo> listData;

    public NewCustomAdapter(Context context, ArrayList<Pojo> listData) {
        this.context = context;
        this.listData = listData;
    }

    @Override
    public int getCount() {
        return (null != listData ? listData.size() : 0);
    }

    @Override
    public Object getItem(int position) {
        return listData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder = null;
        if(convertView == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.game_list_item,null);
            viewHolder = new ViewHolder();
           viewHolder.textView_team_A_Name    =   (TextView)  convertView.findViewById(R.id.txt_team_a);
           viewHolder.textView_team_B_Name    =   (TextView)  convertView.findViewById(R.id.txt_team_b);
           viewHolder.textView_team_A_total_Score   =   (TextView)  convertView.findViewById(R.id.txt_team_a_scores);
           viewHolder.textView_team_B_total_score   =   (TextView)  convertView.findViewById(R.id.txt_team_b_scores);
           viewHolder.txtId  =   (TextView)  convertView.findViewById(R.id.txt_id);
            convertView.setTag(viewHolder);
        }else{
            viewHolder = (ViewHolder) convertView.getTag();
        }
        Pojo pojo = listData.get(position);
        viewHolder.textView_team_A_Name.setText(pojo.getNAME_A());
        viewHolder.textView_team_B_Name.setText(pojo.getNAME_B());
        viewHolder.textView_team_A_total_Score.setText(String.valueOf(pojo.getTEAM_ONE_T()));
        viewHolder.textView_team_B_total_score.setText(String.valueOf(pojo.getTEAM_TWO_T()));
        viewHolder.txtId.setText(String.valueOf(pojo.getGId()));



        return convertView;



    }
    static class ViewHolder {
        TextView textView_team_A_Name,textView_team_B_Name,textView_team_A_total_Score,textView_team_B_total_score,txtId;
    }
}
