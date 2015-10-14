package com.example.root.contestados;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;


public class Ranking extends ActionBarActivity {


    static final String KEY_PUNTOS = "puntos";
    static final String KEY_NAME= "name";
    static final String KEY_DATE="date";

    private Contestados juego;

    SQLiteDatabase datos1;

    Cursor cur1;

    ListView list;
    AdaptadorRanking adapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ranking);


        ArrayList<HashMap<String, String>> ranking = new ArrayList<HashMap<String, String>>();

        juego = Contestados.getInstance(this);

        datos1 = juego.getBaseDeDatos().getReadableDatabase();

        cur1 = datos1.rawQuery("SELECT * FROM Ranking ORDER BY puntos DESC;", null);

        cur1.moveToFirst();
        for (int i = 0; i < cur1.getCount(); i++) {
            // creating new HashMap
            HashMap<String, String> map = new HashMap<String, String>();
            // adding each child node to HashMap key => value
            map.put(KEY_PUNTOS, Integer.toString(cur1.getInt(1)));
            map.put(KEY_NAME, cur1.getString(0));
            map.put(KEY_DATE, cur1.getString(2));

            cur1.moveToNext();
            // adding HashList to ArrayList
            ranking.add(map);
        }


        list=(ListView)findViewById(R.id.list);

        // Getting adapter by passing xml data ArrayList
        adapter=new AdaptadorRanking(this, ranking);
        list.setAdapter(adapter);


        // Click event for single list row
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {


            }
        });

    }

}