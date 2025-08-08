package org.example;

public class Documento {
    private String titulo;
    private String contenido;
    private String fuenteOrigen;

    //constructor
    public Documento(String titulo, String contenido, String fuenteOrigen) {
        this.titulo = titulo;
        this.contenido = contenido;
        this.fuenteOrigen = fuenteOrigen;
    }

    //getters y Setters
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public String getContenido() {
        return contenido;
    }
    public void setContenido(String contenido) {
        this.contenido = contenido;
    }
    public String getFuenteOrigen() {
        return fuenteOrigen;
    }
    public void setFuenteOrigen(String fuenteOrigen) {
        this.fuenteOrigen = fuenteOrigen;
    }
    @Override
    public String toString () {
        return "Documento{" +
                "titulo='" + titulo + '\'' +
                ", contenido='" + contenido.substring(0,Math.min(50, contenido.length())) + "..." + '\'' +
                "fuenteOrigen=" + fuenteOrigen + '\'' +
                '}';
    }
}
