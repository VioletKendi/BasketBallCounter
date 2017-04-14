package com.erickogi14gmail.basketballcounter;

import android.app.Dialog;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.erickogi14gmail.basketballcounter.DataBase.DBOperations;
import com.erickogi14gmail.basketballcounter.Login.LoginActivity;
import com.erickogi14gmail.basketballcounter.Login.prefrenceManager;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    prefrenceManager prefrencemanager=new prefrenceManager();
    private CustomAdapter customAdapter;
    ListView listView;
    Cursor cursor;
    DBOperations dbOperations ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if(prefrencemanager.getStatus(getApplicationContext())){

        }
        else {
            startActivity(new Intent(MainActivity.this, LoginActivity.class));
        }




        listView = (ListView) findViewById(R.id.games_list_display);


            setListView();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                final TextView txtId=(TextView)view.findViewById(R.id.txt_id);

               final Dialog dialog =new Dialog(MainActivity.this);
                dialog.setContentView(R.layout.dialog_delete_game);
                dialog.setTitle("Delete Game");
                Button button_delete_game=(Button)dialog.findViewById(R.id.btn_delete);
                Button button_keep_game=(Button)dialog.findViewById(R.id.btn_keep);

                button_delete_game.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        dbOperations.delete(txtId.getText().toString());

                        dialog.dismiss();
                        setListView();
                    }
                });
                button_keep_game.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        customAdapter.notifyDataSetChanged();
                        dialog.dismiss();
                    }
                });




dialog.show();
                return false;
            }

        });



        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View view) {

                final Dialog dialog=new Dialog(MainActivity.this);
                dialog.setTitle("Enter Teams");
                dialog.setContentView(R.layout.fragment_teamnames);
                final EditText editText_teamA=(EditText)dialog.findViewById(R.id.edt_team_a);
                final EditText editText_teamB=(EditText)dialog.findViewById(R.id.edt_team_b);
                Button button_start=(Button)dialog.findViewById(R.id.btn_start);

                button_start.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if(editText_teamA.getText().toString().isEmpty()||editText_teamB.getText().toString().isEmpty()){
                            Snackbar.make(view, "You must fill the Team names", Snackbar.LENGTH_LONG)
                                    .setAction("Action", null).show();
                        }
                        else{
                            Intent intent=new Intent(MainActivity.this,ScoreBoard.class);
                            intent.putExtra("key_team_a",editText_teamA.getText().toString());
                            intent.putExtra("key_team_b",editText_teamB.getText().toString());

                            startActivity(intent);
                            close();

                            dialog.dismiss();
                        }
                    }
                });



                dialog.show();



               // startActivity(new Intent(MainActivity.this,f));
               /* Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();*/
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        FragmentManager fragmentManager = getSupportFragmentManager();
    }

    private void close() {
        this.finish();
    }
public void setListView(){

    ;
    dbOperations = new DBOperations(MainActivity.this);
    cursor=dbOperations.getGameList();

    customAdapter = new CustomAdapter(MainActivity.this,  cursor, 0);
    customAdapter.notifyDataSetChanged();
    listView = (ListView) findViewById(R.id.games_list_display);
    if(customAdapter.isEmpty()){
        Toast.makeText(MainActivity.this, "Empty", Toast.LENGTH_SHORT).show();
        listView.setAdapter(customAdapter);
    }
    else {
        listView.setAdapter(customAdapter);
    }



}

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_slideshow) {

        } else if (id == R.id.nav_manage) {

        } else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
