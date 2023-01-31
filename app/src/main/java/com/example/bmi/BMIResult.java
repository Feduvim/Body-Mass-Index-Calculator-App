package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class BMIResult extends AppCompatActivity {

    public static final String YOUR_HEIGHT = "VALUE_HEIGHT";
    public static final String YOUR_WEIGHT = "VALUE_WEIGHT";
    private double imc;

    private Button repeat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmiresult);
        setContentView(R.layout.activity_bmiresult);
        repeat = (Button) findViewById(R.id.repeatCalculation);

        repeat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                finish();
                }
            });
        }

    private double calcularIMC(double height, double weight) {
        return (weight) / (height * height);

        private void calcularMostrarResultado () {
            Bundle extras = getIntent().getExtras();
            if (extras == null) {
                return;//isto não deverá acontecer, mas só por precaução//
            }
            double altura = extras.getDouble(YOUR_HEIGHT);
            double peso = extras.getDouble(YOUR_WEIGHT);
            imc = calcularIMC(altura, peso);

            //Button btRecalculate = (Button)findViewById(R.id.buttonRepeat);
            TextView txtResultado = (TextView) findViewById(R.id.textResult);
            txtResultado.setText(String.format("%.2f", imc));

            //alterar categoria de IMC
            String texto;
            int cor;

            if (imc < 18.5) { //underweight
                texto = getResources().getString(R.string.underweight);
                cor = getResources().getColor(R.color.underweight);
            } else if (imc < 25) {
                texto = getResources().getString(R.string.normalweight);
                cor = getResources().getColor(R.color.normalweight);
            } else {
                texto = getResources().getString(R.string.overweight);
                cor = getResources().getColor(R.color.overweight);
            }
            TextView txtCategoria = (TextView) findViewById(R.id.textCategory);
            txtCategoria.setText(texto);
            txtCategoria.setBackgroundColor(cor);
        }
    }
}
