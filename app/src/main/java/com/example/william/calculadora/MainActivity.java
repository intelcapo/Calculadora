package com.example.william.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvInputUser, tvOperacion;
    double numeroUno = 0, numeroDos = 0;
    char operador = '+';
    Button auxiliar;
    char opera = '+';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se mapea los textView para poder acceder a sus propiedades.
        tvInputUser = (TextView) findViewById(R.id.tvInputUser);
        tvOperacion = (TextView) findViewById(R.id.tvOperacion);
    }

    public void btnClick(View btn) {
        /*Se asigna método desde XML para que cuando se de click en algún botón capture su cadena
        * y se asigne al tvInputUser
        **/
        auxiliar = (Button) findViewById(btn.getId());
        tvInputUser.append(auxiliar.getText());
    }

    public void btnLimpiar(View v) {
        /*
        * Método asignado desde xml para limpiar las entradas del usuario
        * */
        tvInputUser.setText("");
        tvOperacion.setText("");
        numeroUno = 0;
        numeroDos = 0;
        opera = '=';
        //TODO pendiente corregir bug de primer número ingresado después de limpiar ya que queda en 0.0
    }

    public void clickBtnOperar(View v) {
        /*
        * Método asignado a los botones de operaciones básicas y al botón igual para indicar que operación se
        * va a hacer
        * */
        try {
            auxiliar = (Button) findViewById(v.getId());
            operador = auxiliar.getText().charAt(0);
            String cadenaTvInpUser = tvInputUser.getText().toString();
            tvOperacion.append(cadenaTvInpUser + operador);
            calcular(operador);

        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }
    }

    public void calcular(char operador) {
        /*
        * Método encargado de realizar los cálculos mediante la validación del caracter de la operacion
        *
        * Se guarda el valor de la  variable numeroUno en la variable de resultado
        * para que cada vez que el usuario ingrese un nuevo valir este se almacene allí
        * */
        double resultado = numeroUno;
        try {
            numeroDos = Double.valueOf(tvInputUser.getText().toString());
            tvInputUser.setText("");
            switch (opera) {
                case '+':
                    resultado = numeroUno + numeroDos;
                    break;
                case '-':
                    resultado = numeroUno - numeroDos;
                    break;
                case '*':
                    resultado = numeroUno * numeroDos;
                    break;
                case '/':
                    resultado = numeroUno / numeroDos;
                    break;
            }
            numeroUno = resultado;
            opera = operador;

            /*
            * se valida si el usuario selecciona el boton de igual, mostramos el valor del número uno
            * en el tvInputUser*/
            if (operador == '=') {
                tvInputUser.setText("" + numeroUno);
                tvOperacion.setText("" + numeroUno);
            } else {
                tvInputUser.setText("");
                tvOperacion.setText(numeroUno + " " + opera);
            }

        } catch (Exception e) {
            Toast.makeText(this, e.toString(), Toast.LENGTH_SHORT).show();
        }

    }


}
