package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.os.Parcel;
import android.os.Parcelable;

import com.marvin.cerdas.angulo.mascotas.R;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collections;

import Logica.Mascota;
import Logica.Perfil;

public class ListaMascotas implements Serializable {

    private static ListaMascotas instancia = null;
    private ArrayList<Mascota> listaMascotas;
    private ArrayList<Mascota> listaMascotasFavoritas = null;
    private ArrayList<Perfil> listPerfil;
    private Context context;
    private DataBase dataBase;

    private ListaMascotas(Context context) {
        this.listaMascotas = new ArrayList<Mascota>();
        this.context = context;
        creaMascotas();
        crearListPerfil();
        llamarDatos();
    }

    public static ListaMascotas getInstance(Context context){
        if(instancia == null){
            instancia = new ListaMascotas(context);
        }
        return instancia;
    }

    private void creaMascotas(){
        dataBase = new DataBase(this.context);
        ContentValues values = new ContentValues();
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Meau");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.gato0);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Manu");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.perro0);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Juancho");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.gato1);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Lucho");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.perro1);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Chichi");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.gato2);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Seus");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.perro2);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Ricardo");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.gato3);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Firulais");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.perro3);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Minina");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.gato4);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Pedrito");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.perro4);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Bigotes");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.gato5);
        dataBase.insertarMascota(values);
        // Se inserta una mascota
        values.put(DbConstantes.MASCOTA_NOMBRE, "Luna");
        values.put(DbConstantes.MASCOTA_IMG_, R.drawable.perro5);
        dataBase.insertarMascota(values);
    }

    public void darLike(Mascota mascota, int position){
        ContentValues values = new ContentValues();
        values.put(DbConstantes.FK_ID_MASCOTA, mascota.getId());
        values.put(DbConstantes.LIKES_MASCOTA, 1);
        dataBase.insertarLike(values);
        listaMascotas.get(position).addRating();
    }

    private void llamarDatos(){
        listaMascotas = dataBase.listarMascotas();
    }

    private void creaMascotasFavoritas() {
        if(listaMascotasFavoritas == null) {
            this.listaMascotasFavoritas = new ArrayList<Mascota>();
            Collections.sort(listaMascotas, Collections.reverseOrder());
            if (listaMascotas.size() < 5) {
                listaMascotasFavoritas = new ArrayList<Mascota>(listaMascotas.subList(0, listaMascotas.size()));
            } else
                listaMascotasFavoritas = new ArrayList<Mascota>(listaMascotas.subList(0, 5));
        }
    }

    public ArrayList<Mascota> getListaMascotas() {
        return listaMascotas;
    }

    public ArrayList<Mascota> getListaMascotasFavoritas() {
        creaMascotasFavoritas();
        return listaMascotasFavoritas;
    }

    private void crearListPerfil(){
        listPerfil = new ArrayList<Perfil>();
        listPerfil.add(new Perfil(R.drawable.instadog1, 52));
        listPerfil.add(new Perfil(R.drawable.instadog2, 20));
        listPerfil.add(new Perfil(R.drawable.instadog3, 16));
        listPerfil.add(new Perfil(R.drawable.instadog4, 14));
        listPerfil.add(new Perfil(R.drawable.instadog5, 19));
        listPerfil.add(new Perfil(R.drawable.instadog6, 82));
        listPerfil.add(new Perfil(R.drawable.instadog7, 71));
        listPerfil.add(new Perfil(R.drawable.instadog8, 100));
        listPerfil.add(new Perfil(R.drawable.instadog9, 12));
        listPerfil.add(new Perfil(R.drawable.instadog11, 60));
        listPerfil.add(new Perfil(R.drawable.instadog12, 80));
    }

    public ArrayList<Perfil> getListPerfil() {
        return listPerfil;
    }

}
