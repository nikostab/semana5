package DataBase;

import java.io.Serializable;

class DbConstantes implements Serializable {

    public static final String TABLA_MASCOTAS = "mascotas";
    public static final String MASCOTA_ID = "id_mascota";
    public static final String MASCOTA_NOMBRE = "nombre_mascota";
    public static final String MASCOTA_IMG_ = "img_mascota";

    public static final String TABLA_LIKES = "Likes";
    public static final String LIKE_ID = "id_like";
    public static final String FK_ID_MASCOTA = "fk_mascota";
    public static final String LIKES_MASCOTA = "likes_mascota";
}
