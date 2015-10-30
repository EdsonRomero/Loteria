package com.example.edson.loteria;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText editText,editText1,editText2,editText3,editText4,editText5;
    TextView textView2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);








    }
    public void jogar (View View) {
        editText=(EditText) findViewById(R.id.editText);
        editText1=(EditText) findViewById(R.id.editText1);
        editText2=(EditText) findViewById(R.id.editText2);
        editText3=(EditText) findViewById(R.id.editText3);
        editText4=(EditText) findViewById(R.id.editText4);
        editText5=(EditText) findViewById(R.id.editText5);

         int[] numerosApostados = {Integer.parseInt(editText.getText().toString()),Integer.parseInt(editText1.getText().toString()),Integer.parseInt(editText2.getText().toString())
         ,Integer.parseInt(editText3.getText().toString()),Integer.parseInt(editText4.getText().toString()),Integer.parseInt(editText5.getText().toString())};
        int acerto=0;

        // cria os valores
        int[] valores = new int[60];
        for (int i = 0; i < valores.length; i++) {
            valores[i] = i + 1;
        }

// embaralha
        int temp = 0;
        int posicaoTroca = 0;
        for (int i = 0; i < valores.length; i++) {
            posicaoTroca = (int) (Math.random() * 60); // 0 a 59
            temp = valores[i];
            valores[i] = valores[posicaoTroca];
            valores[posicaoTroca] = temp;
        }

// cria os números sorteados
        int[] numerosSorteados = new int[6];
        for (int i = 0; i < numerosSorteados.length; i++) {
            numerosSorteados[i] = valores[i];
        }

        for (int i = 0; i < numerosApostados.length; i++) {
            for (int j = 0; j < numerosSorteados.length; j++) {
                if (numerosApostados[i] == numerosSorteados[j]) {
                    acerto++;
                    break;
                }
            }

        }
        String acertos= String.valueOf(acerto);


        textView2 =(TextView) findViewById(R.id.textView2);
        textView2.setText("Você Acerto :" + acertos);
        Toast.makeText(this, "Voce Acerto " + acertos, Toast.LENGTH_LONG).show();

    }

    public void limpar(View view){

        editText.setText(null);
        editText1.setText(null);
        editText2.setText(null);
        editText3.setText(null);
        editText4.setText(null);
        editText5.setText(null);
        textView2.setText(null);



        editText.setFocusableInTouchMode(true);
        editText.requestFocus();


    }



}
