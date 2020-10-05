package com.marvin.cerdas.angulo.mascotas.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;

import com.google.android.material.snackbar.Snackbar;
import com.marvin.cerdas.angulo.mascotas.R;

public class Contacto extends AppCompatActivity {

    private EditText nombre;
    private EditText correo;
    private EditText mensaje;
    private Button boton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contacto);

        // Se crea la barra de personalizada
        Toolbar toolbar = findViewById(R.id.toolbar_contacto);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        nombre = (EditText) findViewById(R.id.et_contacto_nombre);
        correo = (EditText) findViewById(R.id.et_contacto_correo);
        mensaje = (EditText) findViewById(R.id.et_contacto_mensaje);
        boton = (Button) findViewById(R.id.btn_enviar);

        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Enviar correo - TODO
                clearMenu();
                Snackbar.make(view, R.string.contacto_mensaje_enviado, Snackbar.LENGTH_LONG).show();
            }
        });
    }

    private void clearMenu(){
        nombre.setText("");
        nombre.clearFocus();
        correo.setText("");
        correo.clearFocus();
        mensaje.setText("");
        mensaje.clearFocus();
        InputMethodManager imm = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(boton.getWindowToken(), InputMethodManager.RESULT_UNCHANGED_SHOWN);

    }
}