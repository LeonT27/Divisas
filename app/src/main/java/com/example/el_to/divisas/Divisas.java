package com.example.el_to.divisas;

import android.content.Context;
import android.content.Intent;

class Divisas {

    static Intent PasarDivisa(Context context, Class aClass, String data)
    {
        Intent intent = new Intent(context, aClass);

        intent.putExtra("Divisa",data);

        return  intent;
    }
}