package com.example.root.contestados;


import java.util.ArrayList;
import java.util.HashMap;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class AdaptadorRanking extends BaseAdapter {

    private Activity actividad;
    private ArrayList<HashMap<String, String>> datos;
    private static LayoutInflater inflador=null;

    public AdaptadorRanking(Activity a, ArrayList<HashMap<String, String>> d) {

        actividad = a;

        datos = d;

        inflador = (LayoutInflater)actividad.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    public int getCount() {
        return datos.size();
    }

    public Object getItem(int position) {
        return position;
    }

    public long getItemId(int position) {
        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        View vi=convertView;

        if(convertView==null)

            vi = inflador.inflate(R.layout.list_row, null);

        TextView nombre = (TextView)vi.findViewById(R.id.title);
        TextView fecha = (TextView)vi.findViewById(R.id.artist);
        TextView puntos = (TextView)vi.findViewById(R.id.duration);
        ImageView imagen =(ImageView)vi.findViewById(R.id.list_image);

        final int circulo2 = R.drawable.circulo;

        HashMap<String, String> song = new HashMap<String, String>();
        song = datos.get(position);


        puntos.setText(song.get(Ranking.KEY_PUNTOS));
        nombre.setText(song.get(Ranking.KEY_NAME));
        fecha.setText(song.get(Ranking.KEY_DATE));
        imagen.setImageResource(circulo2);

        return vi;
    }
}