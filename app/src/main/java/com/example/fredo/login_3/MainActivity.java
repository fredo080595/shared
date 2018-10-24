package com.example.fredo.login_3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editextemail;
    private EditText editextPass;
    private Switch recordar;
    private Button boton;

    private SharedPreferences Pref;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bindUI();
    Pref = getSharedPreferences("Preference", Context.MODE_PRIVATE);


        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String correo;
                String contra;
                    correo = editextemail.getText().toString();
                    contra = editextPass.getText().toString();
                if (login(correo,contra)){
                    GoToMain();
                    guardarPreferencia(correo,contra);
                }


            }
        });
    }

    private void bindUI(){

        editextemail = (EditText) findViewById(R.id.editextEmail);
        editextPass = (EditText) findViewById(R.id.editextPass);
        recordar = (Switch) findViewById(R.id.recordar);
        boton = (Button) findViewById(R.id.boton);

    }

    private void guardarPreferencia(String correo, String contra){
        if (recordar.isChecked()){
            SharedPreferences.Editor editor = Pref.edit();
            editor.putString("Correo", correo);
            editor.putString("Contraseña", contra);
            editor.apply();
        }
    }

    private boolean login(String correo, String contra){
        if (!correoValido(correo)){
            Toast.makeText(this, "El correo es invalido", Toast.LENGTH_SHORT);
            return false;
        } else if(!passContra(contra)){
            Toast.makeText(this, "La contraseña no es valida", Toast.LENGTH_SHORT);
            return false;
        }else {
            return true;
        }


    }

    private boolean correoValido(String correo){
        return !TextUtils.isEmpty(correo) && Patterns.EMAIL_ADDRESS.matcher(correo).matches();

    }

    private boolean passContra(String contra){

        return contra.length() >= 4;
    }

    private void GoToMain(){
        Intent intent = new Intent(this, PrincipalActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }
}
