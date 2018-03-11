package com.example.el_to.divisas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class DivisasActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_divisas);

        findViewById(R.id.dop).setOnClickListener(this);
        findViewById(R.id.eur).setOnClickListener(this);
        findViewById(R.id.usd).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.dop:
                startActivity(Divisas.PasarDivisa(this, CalculoActivity.class, "DOP"));
                break;
            case R.id.usd:
                startActivity(Divisas.PasarDivisa(this, CalculoActivity.class, "USD"));
                break;
            case R.id.eur:
                startActivity(Divisas.PasarDivisa(this, CalculoActivity.class, "EUR"));
                break;
        }
    }
}
