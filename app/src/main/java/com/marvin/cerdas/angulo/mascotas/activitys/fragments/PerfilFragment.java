package com.marvin.cerdas.angulo.mascotas.activitys.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvin.cerdas.angulo.mascotas.R;
import com.marvin.cerdas.angulo.mascotas.activitys.adapters.AutoFitGridLayoutManager;
import com.marvin.cerdas.angulo.mascotas.activitys.adapters.PerfilAdapter;

import DataBase.ListaMascotas;

public class PerfilFragment extends Fragment {

    private ListaMascotas mascotas;
    private RecyclerView recyclerViewPerfil;
    private PerfilAdapter perfilAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_perfil, container, false);

        //mascotas = (ListaMascotas) getArguments().getSerializable("setDatos");
        mascotas = ListaMascotas.getInstance(getActivity());

        //Se setea el RecyclerView
        recyclerViewPerfil = (RecyclerView) view.findViewById(R.id.rv_instadog);
        AutoFitGridLayoutManager manager = new AutoFitGridLayoutManager(getActivity(), 300);
        recyclerViewPerfil.setLayoutManager(manager);
        perfilAdapter = new PerfilAdapter(mascotas, getActivity());
        recyclerViewPerfil.setAdapter(perfilAdapter);
        return view;
    }
}