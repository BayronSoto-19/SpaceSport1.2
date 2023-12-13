package com.example.spacesport1.Modelo;

public class Comentario {

    private String nombreDeporte;
    private String comentario;


    public Comentario() {
    }

    public Comentario(String nombreDeporte, String comentario) {
        this.nombreDeporte = nombreDeporte;
        this.comentario = comentario;
    }

    public String getNombreDeporte() {
        return nombreDeporte;
    }

    public void setNombreDeporte(String nombreDeporte) {
        this.nombreDeporte = nombreDeporte;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    @Override
    public String toString() {
        return "Comentario{" +
                "nombreDeporte='" + nombreDeporte + '\'' +
                ", comentario='" + comentario + '\'' +
                '}';
    }
}
