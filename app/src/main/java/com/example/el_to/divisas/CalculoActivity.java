package com.example.el_to.divisas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.ArrayList;

public class CalculoActivity extends AppCompatActivity {

    private String divisa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculo);

        Intent divisasIntent = getIntent();
        divisa = divisasIntent.getStringExtra("Divisa");

        banderaDivisa(divisa);

        findViewById(R.id.procesar).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DivisasAdapter divisasAdapter =
                        new DivisasAdapter(CalculoActivity.this, TipoDivisa(divisa));

                ListView listView = findViewById(R.id.list_view);
                listView.setAdapter(divisasAdapter);
            }
        });
    }

    private String calcularDivisa(double divisa1, double divisa2, double valorIngresado)
    {
        NumberFormat formatter = new DecimalFormat("#0.00");
        System.out.println(formatter.format(4.0));
        return formatter.format((valorIngresado / divisa1)* divisa2);
    }

    private ArrayList<Divisas> TipoDivisa(String divisa)
    {
        EditText editText = findViewById(R.id.monto);
        if(editText.getText().toString().isEmpty() || editText.getText().toString().equals("."))
        {
            editText.setText("0");
        }
        double monto = Double.parseDouble(editText.getText().toString());

        double[] arrayDivisas =
                {
                        Double.parseDouble(CalculoActivity.this.getString(R.string.dop_value)),
                        Double.parseDouble(CalculoActivity.this.getString(R.string.usd_value)),
                        Double.parseDouble(CalculoActivity.this.getString(R.string.eur_value))
                };

        ArrayList<Divisas> divisaList = new ArrayList<>();

        switch (divisa)
        {
            case "DOP":
                divisaList.add(new Divisas(R.drawable.usd_divisa,
                        calcularDivisa(arrayDivisas[1],arrayDivisas[0],monto)));
                divisaList.add(new Divisas(R.drawable.eur_divisa,
                        calcularDivisa(arrayDivisas[2],arrayDivisas[0],monto)));
                break;
            case "USD":
                divisaList.add(new Divisas(R.drawable.dop_divisa,
                        calcularDivisa(arrayDivisas[0],arrayDivisas[1],monto)));
                divisaList.add(new Divisas(R.drawable.eur_divisa,
                        calcularDivisa(arrayDivisas[2],arrayDivisas[1],monto)));
                break;
            case "EUR":
                divisaList.add(new Divisas(R.drawable.dop_divisa,
                        calcularDivisa(arrayDivisas[0],arrayDivisas[2],monto)));
                divisaList.add(new Divisas(R.drawable.usd_divisa,
                        calcularDivisa(arrayDivisas[1],arrayDivisas[2],monto)));
                break;
        }

        return divisaList;
    }

    private void banderaDivisa(String divisa)
    {
        ImageView imageView = findViewById(R.id.banderaDivisa);

        switch (divisa)
        {
            case "DOP":
                imageView.setImageResource(R.drawable.dop_divisa);
                break;
            case "USD":
                imageView.setImageResource(R.drawable.usd_divisa);
                break;
            case "EUR":
                imageView.setImageResource(R.drawable.eur_divisa);
                break;
        }
    }
}
