package com.example.testproject;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MyActivity";
    public EditText edtpesoAct,edtAltura;
    public TextView txtV;
    private Button btnCalIMC,btnSalir;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //asignar los campo del view
        edtpesoAct =(EditText) findViewById(R.id.TxtPesoActual);
        edtAltura = (EditText)findViewById(R.id.TxtAltura);
        txtV=findViewById(R.id.txtViewDisplay);

        btnCalIMC = findViewById(R.id.btnCalcularIMC);
        btnCalIMC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (TextUtils.isEmpty(edtpesoAct.getText().toString())){
                    txtV.setText("Empty field  Peso not allowed!");
                    Toast.makeText(MainActivity.this, "Empty field Peso not allowed!",
                    Toast.LENGTH_SHORT).show();
                }else
                    if(TextUtils.isEmpty(edtAltura.getText().toString())){
                        txtV.setText("Empty field  Altura not allowed!");
                        Toast.makeText(MainActivity.this, "Empty field  Altura not allowed!",Toast.LENGTH_SHORT).show();
                        }else{
                        verifyCampo(v);
                    }
            }
        });

        btnSalir = findViewById(R.id.btnSalir);
        btnSalir.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
                System.exit(0);
            }
        });



    }


    //Method to Display Result from txtView
    public void DisplayResultat(View v){
        Double d1 = 18.4d;
        txtV=findViewById(R.id.txtViewDisplay);
        //leer los dos  campo
        String getPesoAct=edtpesoAct.getText().toString();
        String getAltura=edtAltura.getText().toString();
        //conversion string to float
        int getPesotInt=Integer.parseInt(getPesoAct);
        float getAlturafloat = Float.parseFloat(getAltura);
        //float getAlturafloat = Double.valueOf(getAltura).floatValue();
        //Do  something
        double IMC=getPesotInt/(getAlturafloat*getAlturafloat);

        if(IMC<d1){

            //conversion float to string
            String txtR=String.valueOf(IMC);
            txtV.setText(String.format("IMC: %s Insuficiencia ponderal/bajo peso" ,txtR));
            Toast.makeText(MainActivity.this, "Insuficiencia ponderal/bajo peso", Toast.LENGTH_SHORT).show();

        }else
            if(IMC>=18.5 && IMC<=24.9){

                Toast.makeText(MainActivity.this, "NORMOPESO", Toast.LENGTH_SHORT).show();
                txtV.setText("NORMOPESO");
        }else
            if(IMC>=25.0 && IMC<=29.9){

                Toast.makeText(MainActivity.this, "Soberpepso", Toast.LENGTH_SHORT).show();
                txtV.setText("Soberpepso");
            }
            else
                if(IMC>=30.0 && IMC<=34.9){
                    Toast.makeText(MainActivity.this, "Obesidad grado I", Toast.LENGTH_SHORT).show();
                    txtV.setText("Obesidad grado I");
            }else
                if(IMC>=35.0 && IMC<=39.9){
                    Toast.makeText(MainActivity.this, "Obesidad grado II", Toast.LENGTH_SHORT).show();
                    txtV.setText("Obesidad grado II");
                }else
                    if(IMC>=40){
                        Toast.makeText(MainActivity.this, "Obesidad grado III o Morbida", Toast.LENGTH_SHORT).show();
                        txtV.setText("Obesidad grado III Morbida");
                    }
                    else{
                        txtV.setText("Gracias¡¡¡");
                    }



    }


    //Method to Verify los campo
    public void verifyCampo(View v) {
        edtpesoAct = findViewById(R.id.TxtPesoActual);
        edtAltura = findViewById(R.id.TxtAltura);
        String getPesoAct = edtpesoAct.getText().toString();
        String getAltura = edtAltura.getText().toString();
        double getAlturafloat = Double.valueOf(getAltura).floatValue();
        double getPesofloat = Double.valueOf(getPesoAct).floatValue();
        //verify si isEmpty los campo
            if (getAlturafloat < 0) {
                Toast.makeText(MainActivity.this, "Campo Altura no debe ser negativo", Toast.LENGTH_SHORT).show();
                txtV.setText(null);
            }else

            if (getPesofloat < 0) {
                Toast.makeText(MainActivity.this, "Campo peso no debe ser negativo", Toast.LENGTH_SHORT).show();
                txtV.setText(null);

            }else

            if (getPesofloat > 600) {

                Toast.makeText(MainActivity.this, "no debe ser sup. 600 kg", Toast.LENGTH_SHORT).show();
                txtV.setText(null);
            }else

            if (getAlturafloat > 3.0d) {
                //txtV.setError("no debe ser sup. 3mts");
                Toast.makeText(MainActivity.this, "no debe ser sup. 3mts", Toast.LENGTH_SHORT).show();
                txtV.setText(null);
                } else {
                DisplayResultat(v);
            }








    }





}
