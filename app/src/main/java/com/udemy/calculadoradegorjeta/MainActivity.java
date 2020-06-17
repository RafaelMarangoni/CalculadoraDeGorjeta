package com.udemy.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import static java.lang.Double.doubleToLongBits;
import static java.lang.Double.parseDouble;

public class MainActivity extends AppCompatActivity {
    private EditText editValor;
    private TextView textPorcentagem,  textGorjeta, textTotal;
    private SeekBar seekPorcentagem;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editValor       = findViewById(R.id.editValor);
        textPorcentagem     = findViewById(R.id.textPorcentagem);
        textGorjeta     = findViewById(R.id.textGorjeta);
        textTotal       = findViewById(R.id.textTotal);
        seekPorcentagem = findViewById(R.id.seekPorcentagem);



        seekPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textPorcentagem.setText( Math.round(porcentagem) + "%");
                calcular();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcular(){
        String valorRecuperado = editValor.getText().toString();
        if (valorRecuperado == null || valorRecuperado.equals("")){
            Toast.makeText(this, "por valor digite o valor a ser pago", Toast.LENGTH_SHORT).show();
        }else{
            //converter string para double
            double valorDigitado = parseDouble(valorRecuperado);

            //calculo total
            double gorjeta = valorDigitado * (porcentagem/100);
            double total = gorjeta + valorDigitado;

            //exibe a gorjeta total
            textGorjeta.setText("R$ " + Math.round(gorjeta));
            textTotal.setText("R$ " + total);


        }
    }
}