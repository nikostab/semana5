package Logica;

import java.io.Serializable;

public class Perfil implements Serializable {

    private int imagen;
    private Integer rating;

    public Perfil(int imagen, Integer rating) {
        this.imagen = imagen;
        this.rating = rating;
    }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public Integer getRating() {
        return rating;
    }

    public void setRating(Integer rating) {
        this.rating = rating;
    }
}
