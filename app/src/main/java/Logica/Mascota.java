package Logica;

import java.io.Serializable;

public class Mascota implements Serializable, Comparable<Mascota> {

    private int id;
    private String name;
    private int imagen;
    private Integer rating;

    public Mascota(int id, String name, int imagen, int rating) {
        this.id = id;
        this.name = name;
        this.imagen = imagen;
        this.rating = rating;
    }

    public Mascota(String name, int imagen, int rating) {
        this.name = name;
        this.imagen = imagen;
        this.rating = rating;
    }

    public Mascota() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public void setRating(int rating) {
        this.rating = rating;
    }

    public void addRating(){
        this.rating = this.rating + 1;
    }

    // Se sobre escribe este metodo para poder hacer una comparación de Ratings
    @Override
    public int compareTo(Mascota mascota) {
        return this.getRating().compareTo(mascota.getRating());
    }
}
