package com.stick.inaiapp.calculo;

import android.graphics.drawable.Drawable;

/**
 * Created by petu on 25/10/15.
 */
public class Items {
    public String titulo;
    public Drawable imagen;
    public boolean habilitado;
    public int valor;
    public Items(String titulo, Drawable imagen){
        this.titulo = titulo;
        this.imagen = imagen;
        habilitado = true;
        valor = 0;
    }
}
