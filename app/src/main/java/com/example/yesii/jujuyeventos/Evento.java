package com.example.yesii.jujuyeventos;

import android.graphics.drawable.Drawable;
import android.net.Uri;

import java.io.Serializable;

/**
 * Created by Gisela on 02/11/2017.
 */

public class Evento implements Serializable {
    private String titulo;
    private String lugar1;
    private String fecha;
    private String hora1;
    private String detalle;
    private String precio1;
    private Drawable image;
    private Uri videoView;
    private String categoria;
    private String lugar2;
    private String hora2;
    private String precio2;

    public Evento(String titulo, String lugar1, String fecha, String hora1,
                  String detalle, String precio1, Drawable image, Uri videoView, String categoria,
                  String lugar2, String hora2, String precio2) {
        this.titulo = titulo;
        this.lugar1 = lugar1;
        this.fecha = fecha;
        this.hora1 = hora1;
        this.detalle = detalle;
        this.precio1 = precio1;
        this.image = image;
        this.videoView = videoView;
        this.categoria = categoria;
        this.lugar2 = lugar2;
        this.hora2 = hora2;
        this.precio2 = precio2;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getLugar1() {
        return lugar1;
    }

    public void setLugar1(String lugar1) {
        this.lugar1 = lugar1;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora1() {
        return hora1;
    }

    public void setHora1(String hora1) {
        this.hora1 = hora1;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public String getPrecio1() {
        return precio1;
    }

    public void setPrecio1(String precio1) {
        this.precio1 = precio1;
    }

    public Drawable getImage() {
        return image;
    }

    public void setImage(Drawable image) {
        this.image = image;
    }

    public Uri getVideoView() {
        return videoView;
    }

    public void setVideoView(Uri videoView) {
        this.videoView = videoView;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getLugar2() {
        return lugar2;
    }

    public void setLugar2(String lugar2) {
        this.lugar2 = lugar2;
    }

    public String getHora2() {
        return hora2;
    }

    public void setHora2(String hora2) {
        this.hora2 = hora2;
    }

    public String getPrecio2() {
        return precio2;
    }

    public void setPrecio2(String precio2) {
        this.precio2 = precio2;
    }
}
