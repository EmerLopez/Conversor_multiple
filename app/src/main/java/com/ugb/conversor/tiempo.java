package com.ugb.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class tiempo extends AppCompatActivity {
    TextView temp;
    Spinner spn;
    Button btn;
    cv miConversor= new cv();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tiempo);
        btn=findViewById(R.id.btnConvertir);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                spn = findViewById(R.id.spnDe);
                int de = spn.getSelectedItemPosition();

                spn = findViewById(R.id.spna);
                int a = spn.getSelectedItemPosition();

                temp = (TextView) findViewById(R.id.txtCantidad);
                double cantidad = Double.parseDouble(temp.getText().toString());

                double respuesta = miConversor.convertir(0, de, a, cantidad);
                temp = findViewById(R.id.lblRespuesta);
                temp.setText("Respuesta: "+ respuesta);
            }

        });
    }
    public void Regresar(View view){
        Intent Regresar = new Intent(this, MainActivity.class);
        startActivity(Regresar);
    }
}
class cv{
    double[][] valores = {
            {1, 1000000, 0.001, 1.666667e-5, 2.777778333e-7, 1.15740763875e-8, 1.65343948392857e-9, 8.26719741964284909e-10, 3.805171628579033911e-10, 3.170979832191778154e-11 },

    };
    public double convertir(int opcion, int de, int a, double cantidad){
        return valores[opcion][a]/ valores[opcion][de] * cantidad;
    }
}