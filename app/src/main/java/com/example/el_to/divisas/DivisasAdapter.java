package com.example.el_to.divisas;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class DivisasAdapter extends ArrayAdapter<Divisas>
{
    DivisasAdapter(Context context, ArrayList<Divisas> objects)
    {
        super(context, 0, objects);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Divisas divisas = getItem(position);

        if(convertView == null)
        {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.divisas_list, parent, false);
        }

        ImageView imageView = convertView.findViewById(R.id.imagenDivisa);
        TextView textView = convertView.findViewById(R.id.valorDivisa);

        imageView.setImageResource(divisas.getImagen());
        textView.setText(String.valueOf(divisas.getValor()));

        return convertView;
    }
}
