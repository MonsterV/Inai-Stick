package com.stick.inaiapp;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

/**
 * Created by petu on 24/10/15.
 */
public class Monitoreo extends Fragment {
    ImageView circuloGiratorio;
    TextView textViewRoot;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.monitoreo, container, false);
        circuloGiratorio = (ImageView)view.findViewById(R.id.monitoreo_circulo_giratorio);
        ImageButton botonAnalaizar = (ImageButton) view.findViewById(R.id.boton_analizar);
        textViewRoot = (TextView) view.findViewById(R.id.monitoreo_root);
        StringBuilder builder = new StringBuilder();

        Field[] fields = Build.VERSION_CODES.class.getFields();
        for (Field field : fields) {
            String fieldName = field.getName();
            int fieldValue = -1;

            try {
                fieldValue = field.getInt(new Object());
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            } catch (NullPointerException e) {
                e.printStackTrace();
            }

            if (fieldValue == Build.VERSION.SDK_INT) {
                builder.append(fieldName);
            }
        }
        builder.append(" SDK = ").append(Build.VERSION.SDK_INT);
        TextView versionAndroid = (TextView) view.findViewById(R.id.monitoreo_version_so);
        versionAndroid.setText(builder.toString().substring(1));
        Log.d("TAG", "OS: " + builder.toString());
        botonAnalaizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Analizar().execute();
            }
        });


        return view;
    }
    public class Analizar extends AsyncTask<Void, Integer, Void>{
        Boolean esRoot;
        @Override
        protected Void doInBackground(Void... params) {
            Log.d("app","ejecutando hilo");
            esRoot = isDeviceRooted();
            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            if (esRoot){
                textViewRoot.setVisibility(View.VISIBLE);
                textViewRoot.setText("Root detectado");
            }
        }
    }
        public static boolean isDeviceRooted() {
            return checkRootMethod1() || checkRootMethod2() || checkRootMethod3();
        }

        private static boolean checkRootMethod1() {
            String buildTags = android.os.Build.TAGS;
            return buildTags != null && buildTags.contains("test-keys");
        }

        private static boolean checkRootMethod2() {
            String[] paths = { "/system/app/Superuser.apk", "/sbin/su", "/system/bin/su", "/system/xbin/su", "/data/local/xbin/su", "/data/local/bin/su", "/system/sd/xbin/su",
                    "/system/bin/failsafe/su", "/data/local/su" };
            for (String path : paths) {
                if (new File(path).exists()) return true;
            }
            return false;
        }

        private static boolean checkRootMethod3() {
            Process process = null;
            try {
                process = Runtime.getRuntime().exec(new String[] { "/system/xbin/which", "su" });
                BufferedReader in = new BufferedReader(new InputStreamReader(process.getInputStream()));
                if (in.readLine() != null) return true;
                return false;
            } catch (Throwable t) {
                return false;
            } finally {
                if (process != null) process.destroy();
            }
        }

}
