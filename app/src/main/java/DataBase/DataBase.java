package DataBase;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;

import java.util.ArrayList;

import Logica.Mascota;

class DataBase extends SQLiteOpenHelper {

    private static String DB_PATH = "";
    private static final String DB_NAME = "Mascotas";
    private Context context;

    public DataBase(@Nullable Context context) {
        super(context, DB_NAME, null, 1);
        // Se define la ruta de la base de datos
        if(Build.VERSION.SDK_INT >= 17){
            DB_PATH = context.getApplicationInfo().dataDir + "/database/";
        } else {
            DB_PATH = "/data/data/" + context.getPackageName() + "/database/";
        }
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        //if(!existeDB()){
            // Se crea la tabla Mascota
            String queryCreaTablaMascotas = "CREATE TABLE " + DbConstantes.TABLA_MASCOTAS + "(" +
                    DbConstantes.MASCOTA_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DbConstantes.MASCOTA_NOMBRE + " TEXT," +
                    DbConstantes.MASCOTA_IMG_ + " INTEGER" +
                    ")";
            sqLiteDatabase.execSQL(queryCreaTablaMascotas);
            // Se crea la tabla de likes
            String queryCreaTablaLikes = "CREATE TABLE " + DbConstantes.TABLA_LIKES + "(" +
                    DbConstantes.LIKE_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    DbConstantes.FK_ID_MASCOTA + " INTEGER, " +
                    DbConstantes.LIKES_MASCOTA + " INTEGER, " +
                    "FOREIGN KEY (" + DbConstantes.FK_ID_MASCOTA + ") " +
                    "REFERENCES "+ DbConstantes.TABLA_MASCOTAS + "(" +
                    DbConstantes.MASCOTA_ID + ")" +
                    ")";
            sqLiteDatabase.execSQL(queryCreaTablaLikes);
        //}
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + DbConstantes.TABLA_MASCOTAS);
        sqLiteDatabase.execSQL("DROP TABLE IF EXIST " + DbConstantes.TABLA_LIKES);
        onCreate(sqLiteDatabase);
    }

    private boolean existeDB(){
        SQLiteDatabase temp = null;
        try {
            String path = DB_PATH + DB_NAME;
            temp = SQLiteDatabase.openDatabase(path, null, SQLiteDatabase.OPEN_READWRITE);
        } catch (Exception ex){
            System.out.print("Error db" + ex.getMessage());
        }
        if(temp != null)
            temp.close();
        return temp!= null ? true : false; // Si la base exites envía true de lo contrario envia false
    }

    public ArrayList<Mascota> listarMascotas(){
        ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>();
        String selectQuery = "SELECT * FROM " + DbConstantes.TABLA_MASCOTAS;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor datos = database.rawQuery(selectQuery, null);
        while (datos.moveToNext()){
            Mascota mascota = new Mascota();
            mascota.setId(datos.getInt(0));
            mascota.setName(datos.getString(1));
            mascota.setImagen(datos.getInt(2));
            mascota.setRating(getLikes(datos.getInt(0)));
            listaMascotas.add(mascota);
        }
        database.close();
        return  listaMascotas;
    }

    public int getLikes(int idMascota){
        int likes = 0;
        String query = "SELECT COUNT("+ DbConstantes.LIKES_MASCOTA + ")" +
                 " FROM " + DbConstantes.TABLA_LIKES +
                 " WHERE " + DbConstantes.FK_ID_MASCOTA + " = " + idMascota;
        SQLiteDatabase database = this.getWritableDatabase();
        Cursor datos = database.rawQuery(query, null);
        if(datos.moveToNext()){
            likes = datos.getInt(0);
        }
        datos.close();
        return  likes;
    }

    public void insertarMascota(ContentValues contentValues){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(DbConstantes.TABLA_MASCOTAS, null, contentValues);
        database.close();
    }

    public void insertarLike(ContentValues contentValues){
        SQLiteDatabase database = this.getWritableDatabase();
        database.insert(DbConstantes.TABLA_LIKES, null, contentValues);
        database.close();
    }
}
