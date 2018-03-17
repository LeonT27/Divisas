package com.example.el_to.divisas;

import android.content.Context;
import android.content.Intent;

class Divisas {

    private int Imagen;
    private double Valor;

    Divisas(int imagen, double valor)
    {
        this.Imagen = imagen;
        this.Valor = valor;
    }

    int getImagen()
    {
        return this.Imagen;
    }

    double getValor()
    {
        return this.Valor;
    }

    static Intent PasarDivisa(Context context, Class aClass, String data)
    {
        Intent intent = new Intent(context, aClass);

        intent.putExtra("Divisa",data);

        return  intent;
    }
}