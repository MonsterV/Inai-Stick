package com.stick.inaiapp.dialogs;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.Button;

import com.stick.inaiapp.IntListas;
import com.stick.inaiapp.R;

/**
 * Created by petu on 12/11/15.
 */
public class DialogPreguntas {
    Button botonOK;
    Dialog dialog;
    public DialogPreguntas(final Activity activity){
        IntListas.r1 = 0;
        IntListas.r2 = 0;
        IntListas.r3 = 0;
        IntListas.r4 = 0;
        dialog = new Dialog(activity);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.preguntas);
        botonOK = (Button) dialog.findViewById(R.id.boton_ok);
        botonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                IntListas.calculo.abrirCalculo();
            }
        });
        final Button botonN1 = (Button) dialog.findViewById(R.id.boton_no_pregunta1);
        final Button botonN2 = (Button) dialog.findViewById(R.id.boton_no_pregunta2);
        final Button botonN3 = (Button) dialog.findViewById(R.id.boton_no_pregunta3);
        final Button botonN4 = (Button) dialog.findViewById(R.id.boton_no_pregunta4);

        final Button botonS1 = (Button) dialog.findViewById(R.id.boton_si_pregunta1);
        final Button botonS2 = (Button) dialog.findViewById(R.id.boton_si_pregunta2);
        final Button botonS3 = (Button) dialog.findViewById(R.id.boton_si_pregunta3);
        final Button botonS4 = (Button) dialog.findViewById(R.id.boton_si_pregunta4);

        botonN1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN1.setClickable(false);
                botonS1.setClickable(true);
                IntListas.r1 = 1;

                botonN1.setBackgroundResource(R.color.base_color);
                botonN1.setTextColor(Color.WHITE);
                botonS1.setBackgroundResource(R.color.gris_botones);
                botonS1.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        botonN2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN2.setClickable(false);
                botonS2.setClickable(true);
                IntListas.r2 = 1;

                botonN2.setBackgroundResource(R.color.base_color);
                botonN2.setTextColor(Color.WHITE);
                botonS2.setBackgroundResource(R.color.gris_botones);
                botonS2.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        botonN3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN3.setClickable(false);
                botonS3.setClickable(true);
                IntListas.r3 = 1;

                botonN3.setBackgroundResource(R.color.base_color);
                botonN3.setTextColor(Color.WHITE);
                botonS3.setBackgroundResource(R.color.gris_botones);
                botonS3.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        botonN4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN4.setClickable(false);
                botonS4.setClickable(true);
                IntListas.r4 = 1;

                botonN4.setBackgroundResource(R.color.base_color);
                botonN4.setTextColor(Color.WHITE);
                botonS4.setBackgroundResource(R.color.gris_botones);
                botonS4.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });

        botonS1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN1.setClickable(true);
                botonS1.setClickable(false);
                IntListas.r1 = 0;

                Log.e("Entro", "Desbloqueo n1");
                botonS1.setBackgroundResource(R.color.base_color);
                botonS1.setTextColor(Color.WHITE);
                botonN1.setBackgroundResource(R.color.gris_botones);
                botonN1.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        botonS2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN2.setClickable(true);
                botonS2.setClickable(false);

                IntListas.r2 = 0;

                botonS2.setBackgroundResource(R.color.base_color);
                botonS2.setTextColor(Color.WHITE);
                botonN2.setBackgroundResource(R.color.gris_botones);
                botonN2.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        botonS3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN3.setClickable(true);
                botonS3.setClickable(false);
                IntListas.r3 = 0;

                botonS3.setBackgroundResource(R.color.base_color);
                botonS3.setTextColor(Color.WHITE);
                botonN3.setBackgroundResource(R.color.gris_botones);
                botonN3.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        botonS4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                botonN4.setClickable(true);
                botonS4.setClickable(false);
                IntListas.r4 = 0;

                botonS4.setBackgroundResource(R.color.base_color);
                botonS4.setTextColor(Color.WHITE);
                botonN4.setBackgroundResource(R.color.gris_botones);
                botonN4.setTextColor(activity.getResources().getColor(R.color.base_color));
            }
        });
        dialog.show();
    }
}
