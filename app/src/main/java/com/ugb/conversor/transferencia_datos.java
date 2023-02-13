package com.ugb.conversor;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;

public class transferencia_datos extends AppCompatActivity {
    TextView temp;
    Spinner spn;
    Button btn;
    connv miConversor= new connv();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transferencia_datos);
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
class connv{
    double[][] valores = {

            {8e+6, 8000, 1000, 8, 1, 0.008, 0.001, 8e-6, 1e-6, 7.276e-6},

    };
    public double convertir(int opcion, int de, int a, double cantidad){
        return valores[opcion][a]/ valores[opcion][de] * cantidad;
    }
}