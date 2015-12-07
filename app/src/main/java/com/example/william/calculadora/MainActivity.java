package com.example.william.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tvInputUser;
    String numeroUno, numeroDos;
    Button auxiliar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tvInputUser = (TextView) findViewById(R.id.tvInputUser);
    }

    public void btnClick(View btn) {
        auxiliar = (Button) findViewById(btn.getId());
        tvInputUser.append(auxiliar.getText());
    }

    public void btnLimpiar(View v){
        tvInputUser.setText("");
    }


}
