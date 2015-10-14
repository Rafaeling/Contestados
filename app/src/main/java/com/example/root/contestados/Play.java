package com.example.root.contestados;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.ArrayList;


public class Play extends ActionBarActivity {

    ImageView circulo;

    Cursor cur;

    private Contestados juego;

    SQLiteDatabase datos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play);

        juego = Contestados.getInstance(this);

        juego.limpiarValores();

        circulo = (ImageView) findViewById(R.id.imageView);

        Animation giro;

        giro = AnimationUtils.loadAnimation(this, R.anim.girar);
        giro.reset();
        circulo.startAnimation(giro);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_play, menu);
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


    private void cribarPreguntas()
    {
        cur.moveToFirst();

        do {

            juego.getPreguntas().add(new Pregunta(cur.getInt(0), cur.getString(1), cur.getString(2), cur.getString(3), cur.getString(4), cur.getString(5), cur.getInt(6), cur.getInt(7)));

        } while (cur.moveToNext());

    }

    public void Historia(View view)
    {

        datos = juego.getBaseDeDatos().getReadableDatabase();

        cur = datos.rawQuery("SELECT * FROM Preguntas WHERE genero=1", null);

        cribarPreguntas();

        Intent i = new Intent(this, ViewPregunta.class);

        this.finish();

        startActivity(i);
    }



    public void Deportes(View view)
    {

        datos = juego.getBaseDeDatos().getReadableDatabase();

        cur = datos.rawQuery("SELECT * FROM Preguntas WHERE genero=2", null);


        cribarPreguntas();


        Intent i = new Intent(this, ViewPregunta.class);

        startActivity(i);
    }


    public void Cine(View view)
    {

        datos = juego.getBaseDeDatos().getReadableDatabase();

        cur = datos.rawQuery("SELECT * FROM Preguntas WHERE genero=3", null);

        cribarPreguntas();

        Intent i = new Intent(this, ViewPregunta.class);
        startActivity(i);
    }


    public void Ciencia(View view)
    {

        datos = juego.getBaseDeDatos().getReadableDatabase();

        cur = datos.rawQuery("SELECT * FROM Preguntas WHERE genero=4", null);

        cribarPreguntas();

        Intent i = new Intent(this, ViewPregunta.class);
        startActivity(i);
    }


/*
    private void initQuestion()
    {
        ContentValues q1 = new ContentValues();
        q1.put(juego.BD_ID, "1");
        q1.put(juego.BD_TEXT, "¿Quién pintó el “Gernika”?");
        q1.put(juego.BD_RESP1, "Salvador Dalí");
        q1.put(juego.BD_RESP2, "Francisco de Goya");
        q1.put(juego.BD_RESP3, "Pablo Picasso");
        q1.put(juego.BD_RESP4, "Tú");
        q1.put(juego.BD_ANSWER, "3");
        q1.put(juego.BD_GENERO, "1");

        aux.insert(juego.getNameTablaPreguntas(), null, q1);

        ContentValues q2 = new ContentValues();
        q1.put(juego.BD_ID, "2");
        q1.put(juego.BD_TEXT, "¿A qué movimiento pertenecía Salvador Dalí? ");
        q1.put(juego.BD_RESP1, "Surrealismo");
        q1.put(juego.BD_RESP2, "Futurismo");
        q1.put(juego.BD_RESP3, "Cubismo");
        q1.put(juego.BD_RESP4, "Tú");
        q1.put(juego.BD_ANSWER, "2");
        q1.put(juego.BD_GENERO, "1");

        aux.insert(juego.getNameTablaPreguntas(), null, q2);


        ContentValues q3 = new ContentValues();
        q1.put(juego.BD_ID, "3");
        q1.put(juego.BD_TEXT, "¿Quién escribió “Don Quijote de la Mancha?");
        q1.put(juego.BD_RESP1, "Lope de Vega");
        q1.put(juego.BD_RESP2, "Miguel de Cervantes");
        q1.put(juego.BD_RESP3, "Francisco de Quevedo");
        q1.put(juego.BD_RESP4, "Tú");
        q1.put(juego.BD_ANSWER, "2");
        q1.put(juego.BD_GENERO, "1");

        aux.insert(juego.getNameTablaPreguntas(), null, q3);

        ContentValues q4 = new ContentValues();
        q1.put(juego.BD_ID, "4");
        q1.put(juego.BD_TEXT, "¿Qué actor español ganó el Óscar al mejor actor de reparto por el film “No country for old men”? ");
        q1.put(juego.BD_RESP1, "Antonio Banderas");
        q1.put(juego.BD_RESP2, "Javier Bardem ");
        q1.put(juego.BD_RESP3, "Benicio del Toro");
        q1.put(juego.BD_RESP4, "Tú");
        q1.put(juego.BD_ANSWER, "3");
        q1.put(juego.BD_GENERO, "1");

        aux.insert(juego.getNameTablaPreguntas(), null, q4);

    }
    */
}
