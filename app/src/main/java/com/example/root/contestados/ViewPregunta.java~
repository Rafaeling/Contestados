package com.example.root.contestados;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TabHost;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import java.io.IOException;


public class ViewPregunta extends ActionBarActivity {

    private Contestados juego;

    int randomNum;

    String correcto, mal;

    MediaPlayer player;

    boolean ok;

    public void onCreate(Bundle savedInstanceState) {
        /** invocado en la primera creación. */
        super.onCreate(savedInstanceState);

        juego = Contestados.getInstance(this);

        if(juego.getPreguntas().size() == 0)
        {
            Intent intent = new Intent(getApplicationContext(), Resultado.class);

            startActivity(intent);

        }else{

            randomNum =(int) (Math.random() * juego.getPreguntas().size());

            setContentView(R.layout.activity_view_pregunta);

            TextView txtCambiado = (TextView) findViewById(R.id.textView);
            txtCambiado.setText(juego.getPreguntas().get(randomNum).getTexto());

            Button p1_button = (Button) findViewById(R.id.button2);
            p1_button.setText(juego.getPreguntas().get(randomNum).getResp1());

            Button p2_button = (Button) findViewById(R.id.button3);
            p2_button.setText(juego.getPreguntas().get(randomNum).getResp2());

            Button p3_button = (Button) findViewById(R.id.button4);
            p3_button.setText(juego.getPreguntas().get(randomNum).getResp3());

            Button p4_button = (Button) findViewById(R.id.button5);
            p4_button.setText(juego.getPreguntas().get(randomNum).getResp4());

            correcto = Integer.toString(juego.getAciertos());

            mal = Integer.toString(juego.getFallos());

            TextView acier = (TextView) findViewById(R.id.aciert);
            acier.setText(correcto);

            TextView fail = (TextView) findViewById(R.id.fallos);
            fail.setText(mal);
        }
    }

    private void volverMenu ()
    {
        juego.limpiarValores();

        Intent intent = new Intent(getApplicationContext(), Inicio.class);
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
    }



    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("¿Qué desea hacer?")
                .setMessage("")
                .setPositiveButton("Volver a Menu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                        volverMenu();
                    }
                })
                .setNegativeButton("Seguir Jugando", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
    }
/*
    @Override
    protected void onStop() {
        super.onDestroy();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
*/


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_view_pregunta, menu);
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

    private void Calcular(int n)
    {
        int valor = juego.getPreguntas().get(randomNum).getAnswer();

        if(n == valor)
        {
            juego.aumentarAcierto();

            player = MediaPlayer.create(ViewPregunta.this, R.raw.acierto);

            player.start();

            ok = true;


        }else
        {
            juego.aumentarFallos();

            player = MediaPlayer.create(ViewPregunta.this, R.raw.error);

            player.start();

            ok = false;

        }

       juego.eliminarPregunta(randomNum);
    }


    private void llamarPregunta()
    {
        Intent i = new Intent(this, ViewPregunta.class);
        startActivity(i);
        overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }


    private void QueHacer()
    {


        if(ok == true)
        {

            llamarPregunta();

        }else
        {
            new AlertDialog.Builder(this)
                    .setTitle("Fallaste!")
                    .setMessage("¿Qué deseas hacer?")
                    .setPositiveButton("Juego Nuevo", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                            volverMenu();
                        }
                    })
                    .setNegativeButton("Seguir Jugando", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            llamarPregunta();
                        }
                    })
                    .setIcon(android.R.drawable.btn_star)
                    .show();
        }
    }



    public void Opcion1 (View view)
    {
        Calcular(1);

        QueHacer();

    }

    public void Opcion2 (View view)
    {
        Calcular(2);

        QueHacer();
    }

    public void Opcion3 (View view)
    {
        Calcular(3);

        QueHacer();
    }

    public void Opcion4 (View view)
    {
        Calcular(4);

        QueHacer();
    }

}
