package com.example.root.contestados;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class Inicio extends ActionBarActivity {


    private MediaPlayer player;

    private Contestados juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        juego = Contestados.getInstance(this);
    }



    @Override
    protected void onRestart()
    {
        super.onRestart();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_inicio, menu);
        return true;
    }



    @Override
    public void onBackPressed() {

        new AlertDialog.Builder(this)
                .setTitle("¿No deseas jugar una partida?")
                .setMessage("")
                .setPositiveButton("Volver a Menu", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {

                    }
                })
                .setNegativeButton("Salir", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int which) {
                        android.os.Process.killProcess(android.os.Process.myPid());
                    }
                })
                .setIcon(android.R.drawable.ic_dialog_alert)
                .show();
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



    public void Ranking(View view)
    {

        player = MediaPlayer.create(Inicio.this, R.raw.inicio);

        player.start();
        Intent i = new Intent(this, Ranking.class);
        startActivity(i);
        //overridePendingTransition(R.anim.left_in, R.anim.left_out);
    }

    public void Go_Out(View view) {

        player = MediaPlayer.create(Inicio.this, R.raw.fin);

        player.start();

        android.os.Process.killProcess(android.os.Process.myPid());
    }

    public void Play(View view)
    {
        player = MediaPlayer.create(Inicio.this, R.raw.jugar);

        player.start();


        Intent i = new Intent(this, Play.class);
        startActivity(i);

    }
}
