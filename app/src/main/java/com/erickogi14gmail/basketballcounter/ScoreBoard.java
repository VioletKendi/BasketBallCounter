package com.erickogi14gmail.basketballcounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import com.erickogi14gmail.basketballcounter.DataBase.DBKeys;
import com.erickogi14gmail.basketballcounter.DataBase.DBOperations;
import com.weiwangcn.betterspinner.library.material.MaterialBetterSpinner;

public class ScoreBoard extends AppCompatActivity implements View.OnClickListener {
TextView textView_team_a_name,textView_team_b_name,textView_team_a_score,textView_team_b_score;

    Button button_team_a_three,button_team_a_two,button_team_a_one,button_team_a_minus,

          button_team_b_three,button_team_b_two,button_team_b_one,button_team_b_minus,button_save;

    MaterialBetterSpinner materialDesignSpinner;
    int scoreA=0;
    int scoreB=0;
    DBOperations dboperations;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_board);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        String [] rounds={"1","2","3","4"};



      ArrayAdapter<String> arrayAdapterc = new ArrayAdapter<String>(this,
                android.R.layout.simple_dropdown_item_1line, rounds );

         materialDesignSpinner = (MaterialBetterSpinner)
                findViewById(R.id.android_material_design_spinner_round);
        materialDesignSpinner.setAdapter(arrayAdapterc);






        textView_team_a_score=(TextView)findViewById(R.id.txt_team_a_score) ;
        textView_team_b_score=(TextView)findViewById(R.id.txt_team_b_score);


        textView_team_a_score.setText("0");
        textView_team_b_score.setText("0");


        Intent intent=getIntent();
        textView_team_a_name=(TextView)findViewById(R.id.txt_team_a_name) ;
        textView_team_b_name=(TextView)findViewById(R.id.txt_team_b_name) ;

       textView_team_a_name.setText( intent.getStringExtra("key_team_a"));
       textView_team_b_name.setText( intent.getStringExtra("key_team_b"));





        button_team_a_three=(Button)findViewById(R.id.btn_add_3_a) ;
        button_team_a_two=(Button)findViewById(R.id.btn_add_2_a) ;
        button_team_a_one=(Button)findViewById(R.id.btn_add_1_a) ;
        button_team_a_minus=(Button)findViewById(R.id.btn_minus_1_a) ;
        button_team_b_three=(Button)findViewById(R.id.btn_add_3_b) ;
        button_team_b_two=(Button)findViewById(R.id.btn_add_2_b) ;
        button_team_b_one=(Button)findViewById(R.id.btn_add_1_b) ;
        button_team_b_minus=(Button)findViewById(R.id.btn_minus_1_b) ;


        button_team_a_three.setOnClickListener(this);
        button_team_a_two.setOnClickListener(this);
        button_team_a_one.setOnClickListener(this);
        button_team_a_minus.setOnClickListener(this);
        button_team_b_three.setOnClickListener(this);
        button_team_b_two.setOnClickListener(this);
        button_team_b_two.setOnClickListener(this);
        button_team_b_minus.setOnClickListener(this);




        button_save=(Button)findViewById(R.id.btn_save);
        button_save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                insert();

                Snackbar.make(v, "Saved", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();


                close();



            }
        });




/*
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        })*/;
    }


    private void close() {
        startActivity(new Intent(ScoreBoard.this,MainActivity.class));
        this.finish();
    }

    private void insert() {

    int team_A_Round_1=0;
    int team_B_Round_1=0;
    int team_A_Round_2=0;
    int team_B_Round_2=0;
    int team_A_Round_3=0;
    int team_B_Round_3=0;
    int team_A_Round_4=0;
    int team_B_Round_4=0;
    int team_A_Round_5=0;
    int team_B_Round_5=0;

    int team_A_Round_T=Integer.valueOf(textView_team_a_score.getText().toString());
    int team_B_Round_T=Integer.valueOf(textView_team_b_score.getText().toString());







    dboperations = new DBOperations(this);
    DBKeys keys = new DBKeys();
    keys.NAME_A = textView_team_a_name.getText().toString();
    keys.NAME_B=textView_team_b_name.getText().toString();

    keys.TEAM_ONE_R1=team_A_Round_1;


    keys.TEAM_ONE_R2= team_A_Round_2;

    keys.TEAM_ONE_R3=team_A_Round_3;

    keys.TEAM_ONE_R4=team_A_Round_4;

    keys.TEAM_ONE_R5=team_A_Round_5;

    keys.TEAM_ONE_T=team_A_Round_T;


    keys.TEAM_TWO_R1=team_B_Round_1;


    keys.TEAM_TWO_R2= team_B_Round_2;

    keys.TEAM_TWO_R3=team_B_Round_3;

    keys.TEAM_TWO_R4=team_B_Round_4;

    keys.TEAM_TWO_R5=team_B_Round_5;

    keys.TEAM_TWO_T=team_B_Round_T;




    dboperations.insert(keys);














    }
    @Override
    public void onClick(View v) {


        int valueA=Integer.valueOf(textView_team_a_score.getText().toString());
        int valueB=Integer.valueOf(textView_team_b_score.getText().toString());
        if(v==button_team_a_three){
           textView_team_a_score.setText(String.valueOf(valueA+3));
        }
        else if (v==button_team_a_two){
            textView_team_a_score.setText(String.valueOf(valueA+2));
        }
        else if(v==button_team_a_one){
            textView_team_a_score.setText(String.valueOf(valueA+1));
        }
        else if(v==button_team_a_minus){
            textView_team_a_score.setText(String.valueOf(valueA-1));
        }



       else if(v==button_team_b_three){
            textView_team_b_score.setText(String.valueOf(valueB+3));
        }
        else if (v==button_team_b_two){
            textView_team_b_score.setText(String.valueOf(valueB+2));
        }
        else if(v==button_team_b_one){
            textView_team_b_score.setText(String.valueOf(valueB+1));
        }
        else if(v==button_team_b_minus){
            textView_team_b_score.setText(String.valueOf(valueB-1));
        }

    }
}
