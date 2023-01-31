package com.example.bmi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText height;
    private EditText weight;
    private Button calculate;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        height = (EditText) findViewById(R.id.yourHeight);
        weight = (EditText) findViewById(R.id.yourWeight);
        calculate = (Button) findViewById(R.id.calculate);

        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    double height2 = Double.parseDouble(height.getText().toString());
                    double weight2 = Double.parseDouble(weight.getText().toString());

                    //criar uma nova Intent para chamar a ResultActivity
                    //passando os valores recebidos para a atividade

                    Intent intent = new Intent(MainActivity.this, BMIResult.class);
                    intent.putExtra(BMIResult.YOUR_HEIGHT, height2);
                    intent.putExtra(BMIResult.YOUR_WEIGHT, weight2);

                    //lançar a ResultActivity
                    startActivity(intent);
                } catch(NumberFormatException ex) {
                    Toast.makeText(MainActivity.this, "Invalid Input", Toast.LENGTH_SHORT).show();
                }
                }
        });
    }
}