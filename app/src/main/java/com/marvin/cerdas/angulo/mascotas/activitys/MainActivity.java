package com.marvin.cerdas.angulo.mascotas.activitys;

import android.content.Intent;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import com.marvin.cerdas.angulo.mascotas.R;
import com.marvin.cerdas.angulo.mascotas.activitys.adapters.MascotasAdpter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import DataBase.ListaMascotas;


public class MainActivity extends AppCompatActivity {

    private ListaMascotas listaMascotas;
    private RecyclerView recyclerViewMascotas;
    private MascotasAdpter mascotasAdpter;
    private ImageView bntMascotasFavoritas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Se crea el toolbar
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        //Se crea el Dataset
        listaMascotas = ListaMascotas.getInstance(getApplication());

        //Se crea el botón de las mascotasFaboritas
        bntMascotasFavoritas = (ImageView) findViewById(R.id.iv_mascotasFavoritas);
        bntMascotasFavoritas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Enviando el set de datos completo
                //Bundle bundle = new Bundle();
                //bundle.putSerializable("setDatos", listaMascotas);
                Intent intent = new Intent(MainActivity.this, MascotasFavoritas.class);
                //intent.putExtra("datos", bundle);
                startActivity(intent);
            }
        });

        //Se setea el RecyclerView
        recyclerViewMascotas = (RecyclerView) findViewById(R.id.rv_mascotas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMascotas.setLayoutManager(linearLayoutManager);
        mascotasAdpter = new MascotasAdpter(listaMascotas, this);
        recyclerViewMascotas.setAdapter(mascotasAdpter);

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.item_menu_about) {
            Intent intent = new Intent(MainActivity.this, About.class);
            startActivity(intent);
            return true;
        }
        if(id == R.id.item_menu_contacto){
            Intent intent = new Intent(MainActivity.this, Contacto.class);
            startActivity(intent);
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}