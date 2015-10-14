package com.example.root.contestados;

import android.app.AlertDialog;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;


public class Resultado extends ActionBarActivity {

    private Contestados juego;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultado);

        juego = Contestados.getInstance(this);

        ImageView thumb_image=(ImageView) findViewById(R.id.imageView2);

        Animation giro;

        giro = AnimationUtils.loadAnimation(this, R.anim.girar);
        giro.reset();
        thumb_image.startAnimation(giro);

        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
        Date date = new Date();

        TextView acier = (TextView) findViewById(R.id.textView8);
        acier.setText(dateFormat.format(date));

        TextView puntos = (TextView) findViewById(R.id.textView6);
        puntos.setText(Integer.toString(juego.getAciertos() - juego.getFallos()));

        WebView myWebView = (WebView) this.findViewById(R.id.webView);
        myWebView.loadUrl("https://play.google.com/store/search?q=trivial&c=apps");
        myWebView.computeScroll();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_resultado, menu);
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

    public void enviar(View view)
    {
        TextView acier = (TextView) findViewById(R.id.textView8);


        TextView puntos = (TextView) findViewById(R.id.textView6);


        EditText p3_button = (EditText) findViewById(R.id.editText);
        p3_button.getText();

        ContentValues valores = new ContentValues();
        valores.put("name", p3_button.getText().toString());
        valores.put("puntos", puntos.getText().toString());
        valores.put("fecha", acier.getText().toString());

        SQLiteDatabase dates = juego.getBaseDeDatos().getReadableDatabase();

        if(dates.insert("Ranking", null, valores)== -1)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);

            builder.setTitle("ERROR! NOMBRE OCUPADO")
                    .setMessage("INTRODUCIR NOMBRE NUEVO")
                    .setPositiveButton("", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {

                        }
                    })
                    .setNegativeButton("", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                        }
                    })
                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();

            final AlertDialog dlg = builder.create();

            final Timer t = new Timer();
            t.schedule(new TimerTask() {
                public void run() {
                    dlg.dismiss(); // when the task active then close the dialog
                    t.cancel(); // also just top the timer thread, otherwise, you may receive a crash report
                }
            }, 3000);


        }else {

            Intent intent = new Intent(getApplicationContext(), Inicio.class);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }

    }

}
