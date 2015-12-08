package com.stick.inaiapp.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;

import com.stick.inaiapp.IntListas;
import com.stick.inaiapp.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

/**
 * Created by petu on 13/11/15.
 */
public class DialogResultado {
    Dialog dialog;
    Button guardar;
    TextView resultado;
    public DialogResultado(Activity activity){
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.resultado);
        dialog.setCancelable(false);
        resultado = (TextView) dialog.findViewById(R.id.etiqueta_resultado);

        DecimalFormat decimales = new DecimalFormat("0.0");
        String resul = decimales.format(IntListas.calcularValores(IntListas.valorA, IntListas.valorB, IntListas.valorC, IntListas.r1 + IntListas.r2 + IntListas.r3 + IntListas.r4))+" MXN";
        resultado.setText(resul);
        //Este boton guardara los cambios
        guardar = (Button) dialog.findViewById(R.id.boton_guardar);
        //Se calcularán los datos y se mostrarán en este ventana
        //IntListas.calcularValores()
        guardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntListas.valorA=0;
                IntListas.valorB=0;
                IntListas.valorC=0;

                dialog.dismiss();
            }
        });
        dialog.show();
    }
}
