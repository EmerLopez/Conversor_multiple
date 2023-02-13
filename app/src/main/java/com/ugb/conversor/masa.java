package com.ugb.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class masa extends AppCompatActivity {
    TextView temp;
    Spinner spn;
    Button btn;
    conv miConversor= new conv();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masa);
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
class conv{
    double[][] valores = {

            {1, 0.1, 0.01, 0.001, 1e-4, 1e-5, 1e-6, 2.2046e-6, 9.9998974e-9, 9.9998974e-10 },

    };
    public double convertir(int opcion, int de, int a, double cantidad){
        return valores[opcion][a]/ valores[opcion][de] * cantidad;
    }
}