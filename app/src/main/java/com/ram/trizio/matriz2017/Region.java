package com.ram.trizio.matriz2017;

import java.io.Serializable;

/**
 * Created by MONO on 20/12/2016.
 */

public class Region implements Serializable {

    private String nombre;
    private int x;
    private int y;
    private int ancho;
    private int altura;
    private String colorBorde;

    public Region(String nombre , int x , int y , int ancho , int altura , String colorBorde){
        this.nombre = nombre;
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.altura = altura;
        this.colorBorde = colorBorde;
    }

    public String getNombre(){
        return nombre;
    }

    public int getX(){
        return x;
    }

    public int getY(){
        return y;
    }

    public int getAncho(){
        return ancho;
    }

    public int getAltura(){
        return altura;
    }

    public String getColorBorde(){
        return colorBorde;
    }
}
