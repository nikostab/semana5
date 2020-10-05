package com.marvin.cerdas.angulo.mascotas.activitys.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marvin.cerdas.angulo.mascotas.R;

import DataBase.ListaMascotas;

public class PerfilAdapter extends RecyclerView.Adapter<PerfilAdapter.ProfileHolder> {

    private ListaMascotas datos;
    private Activity activity;

    public PerfilAdapter(ListaMascotas datos, Activity activity) {
        this.datos = datos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public ProfileHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.perfil_card, parent, false);
        return new PerfilAdapter.ProfileHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProfileHolder holder, int position) {
        holder.perfilImage.setImageResource(datos.getListPerfil().get(position).getImagen());
        holder.perfilLikesScore.setText(String.valueOf(datos.getListPerfil().get(position).getRating()));
    }

    @Override
    public int getItemCount() {
        return datos.getListPerfil().size();
    }

    public static class ProfileHolder extends RecyclerView.ViewHolder{

        private ImageView perfilImage;
        private TextView perfilLikesScore;

        public ProfileHolder(@NonNull View itemView) {
            super(itemView);
            perfilImage = (ImageView) itemView.findViewById(R.id.iv_perfilImage);
            perfilLikesScore = (TextView) itemView.findViewById(R.id.tv_perfilLikesScore);
        }
    }
}
