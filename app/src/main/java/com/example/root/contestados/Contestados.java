package com.example.root.contestados;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.media.MediaPlayer;
import android.media.MediaRecorder;
import android.os.Environment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Contestados {

    private Helper bd;

    private static ArrayList<Pregunta> Preguntas;

    private static int aciertos;

    private static int fallos;

    private static Contestados INSTANCIA = null;

    private Contestados(Context content) {

        Preguntas = new ArrayList<>();

        bd = new Helper(content);

        aciertos = 0;

        fallos = 0;

    }

    public static Contestados getInstance(Context content) {

        if (INSTANCIA == null) {
            INSTANCIA = new Contestados(content);
        }

        return INSTANCIA;
    }


    public Helper getBaseDeDatos()
    {
        return bd;
    }

    public void limpiarValores()
    {
        aciertos = 0;

        fallos = 0;

        Preguntas.clear();
    }

    public void aumentarAcierto()
    {
        aciertos = aciertos + 1;
    }

    public void aumentarFallos()
    {
        fallos = fallos + 1;
    }

    public ArrayList<Pregunta> getPreguntas()
    {
        return Preguntas;
    }


    public int getAciertos(){
        return aciertos;
    }

    public int getFallos()
    {
        return fallos;
    }

    public void eliminarPregunta(int n)
    {
        Preguntas.remove(n);
    }
}