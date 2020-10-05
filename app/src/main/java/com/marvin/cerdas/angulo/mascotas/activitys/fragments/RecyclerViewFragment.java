package com.marvin.cerdas.angulo.mascotas.activitys.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.marvin.cerdas.angulo.mascotas.R;
import com.marvin.cerdas.angulo.mascotas.activitys.adapters.MascotasFavoritasAdapter;

import DataBase.ListaMascotas;

public class RecyclerViewFragment extends Fragment {

    private ListaMascotas mascotasFavoritas;
    private RecyclerView recyclerViewMascotasFavoritas;
    private MascotasFavoritasAdapter mascotasAdpter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recyclerview, container, false);
        // Se recupera el set de datos
        //mascotasFavoritas = (ListaMascotas) getArguments().getSerializable("setDatos");
        mascotasFavoritas = ListaMascotas.getInstance(getActivity());

        //Se setea el RecyclerView
        recyclerViewMascotasFavoritas = (RecyclerView) view.findViewById(R.id.rv_mascotasFavoritas);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerViewMascotasFavoritas.setLayoutManager(linearLayoutManager);
        mascotasAdpter = new MascotasFavoritasAdapter(mascotasFavoritas, getActivity());
        recyclerViewMascotasFavoritas.setAdapter(mascotasAdpter);
        return view;
    }
}