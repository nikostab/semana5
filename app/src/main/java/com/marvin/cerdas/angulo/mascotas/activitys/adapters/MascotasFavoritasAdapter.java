package com.marvin.cerdas.angulo.mascotas.activitys.adapters;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.marvin.cerdas.angulo.mascotas.R;

import DataBase.ListaMascotas;

public class MascotasFavoritasAdapter  extends RecyclerView.Adapter<MascotasFavoritasAdapter.MascotaViewHolder> {

    private ListaMascotas datos;
    private Activity activity;

    public MascotasFavoritasAdapter(ListaMascotas datos, Activity activity) {
        this.datos = datos;
        this.activity = activity;
    }

    @NonNull
    @Override
    public MascotaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.mascota_cardview, parent, false);
        return new MascotasFavoritasAdapter.MascotaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final MascotaViewHolder holder, final int position) {
        holder.mascotaImage.setImageResource(datos.getListaMascotasFavoritas().get(position).getImagen());
        holder.mascotaName.setText(datos.getListaMascotasFavoritas().get(position).getName());
        holder.mascotaScore.setText(String.valueOf(datos.getListaMascotasFavoritas().get(position).getRating()));
        holder.mascotaLikeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                datos.darLike(datos.getListaMascotas().get(position), position);
                Toast.makeText(activity, "Te gusta " + datos.getListaMascotasFavoritas().get(position).getName(), Toast.LENGTH_LONG).show();
                holder.mascotaScore.setText(String.valueOf(datos.getListaMascotasFavoritas().get(position).getRating()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datos.getListaMascotasFavoritas().size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView mascotaImage;
        private TextView mascotaName;
        private TextView mascotaScore;
        private ImageView mascotaLikeBtn;

        public MascotaViewHolder(@NonNull View itemView) {
            super(itemView);
            mascotaImage = (ImageView) itemView.findViewById(R.id.iv_mascotaImage);
            mascotaName = (TextView) itemView.findViewById(R.id.tv_mascotaName);
            mascotaScore = (TextView) itemView.findViewById(R.id.tv_mascotaLikesScore);
            mascotaLikeBtn = (ImageView) itemView.findViewById(R.id.iv_mascotaLikeBtn);
        }
    }
}
