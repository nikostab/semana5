package com.marvin.cerdas.angulo.mascotas.activitys;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;

import com.google.android.material.tabs.TabLayout;
import com.marvin.cerdas.angulo.mascotas.R;
import com.marvin.cerdas.angulo.mascotas.activitys.adapters.MascotasFavoritasAdapter;
import com.marvin.cerdas.angulo.mascotas.activitys.adapters.PageAdapter;
import com.marvin.cerdas.angulo.mascotas.activitys.fragments.PerfilFragment;
import com.marvin.cerdas.angulo.mascotas.activitys.fragments.RecyclerViewFragment;


import java.util.ArrayList;

import DataBase.ListaMascotas;

public class MascotasFavoritas extends AppCompatActivity {

    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private  ArrayList<Fragment> fragments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mascotas_favoritas);

        // Se crean el Tab y el ViewPager
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        // Se crea la barra de personalizada
        toolbar = findViewById(R.id.toolbar_mf);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        setUpViewPager();
    }

    private ArrayList<Fragment> agragarFragment(){
        // Se crea una lista de fragmentos
        fragments = new ArrayList<Fragment>();
        RecyclerViewFragment recyclerFavoritos = new RecyclerViewFragment();
        fragments.add(recyclerFavoritos);
        PerfilFragment perfilFragment = new PerfilFragment();
        fragments.add(perfilFragment);
        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(), agragarFragment()));
        tabLayout.setupWithViewPager(viewPager);
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_star2);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_account_circle);
    }

}