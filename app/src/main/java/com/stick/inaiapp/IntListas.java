package com.stick.inaiapp;

import android.graphics.drawable.Drawable;
import android.util.Log;
import android.widget.ListView;

import com.stick.inaiapp.calculo.Calculo;
import com.stick.inaiapp.calculo.EstandarFragment;

/**
 * Created by petu on 10/11/15.
 */
public class IntListas {
    public static Calculo calculo;
    public static int r1 = 0,r2 = 0,r3 = 0,r4 = 0;
    public static int valorA=0, valorB=0, valorC=0;


    public static double calcularValores (int a, int b, int c, int numRespuestasNo){
        int EP = numRespuestasNo+1;
        Log.e("Valores","a: "+a+" b:"+b+" c:"+c);
        float sum = a+b+c;
        float producto = (a+(b*2)+(c*3));
        double division = producto/sum;
        Log.e("Div:0"," d:"+division);
        double v =division * EP * 150;
        return v;
    }
}
