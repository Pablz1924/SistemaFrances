package com.example.sistemafrances;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    public void Calcular(View view) {
        Intent intent = new Intent(MainActivity.this,Tabla.class);
        EditText P=findViewById(R.id.P);
        EditText N=findViewById(R.id.N);
        EditText Tem=findViewById(R.id.Tem);
        Switch sw=findViewById(R.id.switch1);
        TextView mensaje=findViewById(R.id.mensaje);
        int x = Integer.parseInt(P.getText().toString());
        if(x>1000&x<50000){
            intent.putExtra("P",P.getText().toString());
            intent.putExtra("N",N.getText().toString());
            intent.putExtra("Tem",Tem.getText().toString());
            if(sw.isChecked()){
                intent.putExtra("sw",true);
            }else{
                intent.putExtra("sw",false);
            }
            startActivity(intent);
        }
        if(x<1000&x>50000){
            mensaje.setText("Debes ingresar valores en P entre 1000 y 5000040");
        }
    }

    public void porcentaje(View view) {
        Switch sw= (Switch) view;
        LinearLayout ll=findViewById(R.id.linearLayoutporcentaje);
        if(sw.isChecked()){
            TextView tv=new TextView(this);
            tv.setText("%");
            tv.setTextColor(Color.WHITE);
            ll.addView(tv);
        }
        else{
           ll.removeViewAt(2);
        }
    }
}