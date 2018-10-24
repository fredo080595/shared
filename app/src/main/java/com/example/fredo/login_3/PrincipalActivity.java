package com.example.fredo.login_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class PrincipalActivity extends AppCompatActivity {
    private EditText nombre;
    private EditText apellido;
    private EditText correo;
    private RadioButton H;
    private RadioButton M;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);

        BindUI();



    }


    public void BindUI(){
        nombre = (EditText) findViewById(R.id.editTextNombre);
        apellido = (EditText) findViewById(R.id.editTextApellido);
        correo = (EditText) findViewById(R.id.editTextCorreo);
        H = (RadioButton) findViewById(R.id.hombre);
        M = (RadioButton) findViewById(R.id.mujer);
        boton = (Button) findViewById(R.id.boton);
    }


}
