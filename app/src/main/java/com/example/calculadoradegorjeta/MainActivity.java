package com.example.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText textEditValorConta;
    private SeekBar seekBarGorjeta;
    private TextView textPorcentagemGorjeta, textGorjeta, textTotalConta;

    private double porcentagem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textEditValorConta     = findViewById(R.id.textEditValorConta);
        textGorjeta = findViewById(R.id.textGorjeta);
        textTotalConta = findViewById(R.id.textTotalConta);
        seekBarGorjeta         = findViewById(R.id.seekBarGorjeta);
        textPorcentagemGorjeta = findViewById(R.id.textPorcentagemGorjeta);

        seekBarGorjeta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textPorcentagemGorjeta.setText( progress + " %" );
                porcentagem = progress;

                calcularGorjeta();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }


    public void calcularGorjeta(  ){

            String valorRecuperado = textEditValorConta.getText().toString();




            if (valorRecuperado.equals("") || valorRecuperado == null ){
                textTotalConta.setText("Digite o valor da conta");
            } else {
                double valorDigitado = Double.parseDouble(valorRecuperado);
               double gorjeta = valorDigitado * (porcentagem/100);
               textGorjeta.setText("R$ "+ Math.round(gorjeta));
               textTotalConta.setText("R$ "+ (gorjeta + valorDigitado));
            }

    }

}