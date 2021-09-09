package br.com.salosoftwares.mobile.newlesson;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View btnAnchor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnAnchor = findViewById(R.id.btn_purple_anchor);

        btnAnchor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent calculate = new Intent(MainActivity.this,Calculate.class);
                startActivity(calculate);
            }
        });

        //Paramos no layout Calculate, precisamos ajustar as margens laterais dos botões,
        //Criar o botão Multiplication, criar "assert" para sinalizar que precisamos preencher
        //Usar o "banco de dados"
        // Aula "Criando estilos de componentes" , aplicar no projeto FitnessTrack tbm

    }
}