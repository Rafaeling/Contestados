package com.example.root.contestados;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.sql.SQLException;

/**
 * Created by root on 9/05/15.
 */

public class Helper extends SQLiteOpenHelper {

    private static final String NOMBRE_BD = "despuesdsdfe";
    private static final int VERSION_BD = 1;



    // nombre de la tabla
    private static final String NOMBRE_TABLA = "Preguntas";

    // nombres de los campos de la tabla Preguntas
    public static final String BD_ID = "id";
    public static final String BD_TEXT = "text";
    public static final String BD_RESP1 = "resp1";
    public static final String BD_RESP2 = "resp2";
    public static final String BD_RESP3 = "resp3";
    public static final String BD_RESP4 = "resp4";

    public static final String BD_GENERO = "genero";

    public static final String BD_ANSWER = "answer";

    private static final String ID_LOG = "Gestor de base de datos";

    // sentencia SQL de creación de la tabla
    private static final String CREATE_PREGUNTAS = "CREATE TABLE `" + NOMBRE_TABLA + "` (`id`	INTEGER PRIMARY KEY AUTOINCREMENT, " + "`text`	TEXT, " + "`resp1` TEXT, " + "`resp2`	TEXT, " + "`resp3`	TEXT, " + "`resp4`	TEXT, " + "`genero`	INTEGER, " + "`answer`	INTEGER);";

    private static final String CREATE_RANKING = "CREATE TABLE `Ranking` (`name` TEXT, `puntos` INTEGER, `fecha` TEXT, PRIMARY KEY(name));";


    private Context mContext;

    public Helper(Context context) {
        super(context, NOMBRE_BD, null, 1);

        this.mContext = context;
    }



    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(CREATE_PREGUNTAS);
        db.execSQL(CREATE_RANKING);

        InputStream is = null;
        try {
            is = mContext.getAssets().open("Datos");
            if (is != null) {
                db.beginTransaction();
                BufferedReader reader = new BufferedReader(new InputStreamReader(is));
                String line = reader.readLine();
                while (!TextUtils.isEmpty(line)) {
                    db.execSQL(line);
                    line = reader.readLine();
                }
                db.setTransactionSuccessful();
            }
        } catch (Exception ex) {
            // Muestra log
        } finally {
            db.endTransaction();
            if (is != null) {
                try {
                    is.close();
                } catch (IOException e) {
                    // Muestra log
                }
            }
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}