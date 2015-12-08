package com.stick.inaiapp.calculo;

import android.app.Activity;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.HorizontalScrollView;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

import com.stick.inaiapp.IntListas;
import com.stick.inaiapp.R;
import com.stick.inaiapp.SlidingTabLayout;
import com.stick.inaiapp.dialogs.DialogPreguntas;
import com.stick.inaiapp.dialogs.DialogResultado;

import java.util.ArrayList;

/**
 * Created by petu on 25/10/15.
 */
public class Calculo extends ActionBarActivity implements AdapterView.OnItemClickListener{
    SensibleFragment sensibleFragment;
    EstandarFragment estandarFragment;
    EspecialFragment especialFragment;
    ArrayList<Items> arrayOpcionesASeleccionar;
    ArrayList<Items> arrayOpcionesSeleccionadas;
    ListView listaOocionesSeleccionadas;
    LinearLayout viewHorizontal;
    AppSectionsPagerAdapter1 mAppSectionsPagerAdapter;
    SlidingTabLayout tabs;
    ViewPager mPager;
    ArrayList<Integer>valoresDatosSeleccionados;
    ArrayList<View> opcionesSeleccionadas;
    HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculo);
        final Activity activity=this;
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        IntListas.calculo = this;
        sensibleFragment = new SensibleFragment();
        estandarFragment = new EstandarFragment();
        especialFragment = new EspecialFragment();
        valoresDatosSeleccionados = new ArrayList<>();
        opcionesSeleccionadas = new ArrayList<>();
        horizontalScrollView = (HorizontalScrollView) findViewById(R.id.scroll_horizontal);
        arrayOpcionesASeleccionar = new ArrayList<>();
        arrayOpcionesSeleccionadas = new ArrayList<>();
        arrayOpcionesASeleccionar.add(new Items("Nombre", ContextCompat.getDrawable(this.getApplicationContext(), R.drawable.icono)));

        viewHorizontal = (LinearLayout) findViewById(R.id.linear_horizontal);
        mAppSectionsPagerAdapter = new AppSectionsPagerAdapter1(getSupportFragmentManager());

        ImageButton botonCalcular = (ImageButton) findViewById(R.id.boton_calcular);
        botonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogPreguntas dialogPreguntas = new DialogPreguntas(activity);
            }
        });

        mPager = (ViewPager) findViewById(R.id.pagerFragment);
        new setAdapterTaskPager().execute();
        tabs = (SlidingTabLayout) findViewById(R.id.tabsFragmet);
        tabs.setDistributeEvenly(true);

        tabs.setCustomTabColorizer(new SlidingTabLayout.TabColorizer() {
            @Override
            public int getIndicatorColor(int position) {
                switch (position){
                    case 0:
                        return getResources().getColor(R.color.verde_estadar);
                    case 1:
                        return getResources().getColor(R.color.naranja_sensible);
                    case 2:
                        return getResources().getColor(R.color.rojo_especial);
                    default:
                        return getResources().getColor(R.color.verde_estadar);
                }
            }
        });
        new setAdapterTask().execute();
    }


    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Log.e("Entro", "Onitdsadasdasem");
        LayoutInflater inflator = getLayoutInflater();
        arrayOpcionesSeleccionadas.add(arrayOpcionesASeleccionar.get(position));
        View view1 = inflator.inflate(R.layout.item_lista_horizontal, null);
        viewHorizontal.addView(view1);
        }


    public class AppSectionsPagerAdapter1 extends FragmentPagerAdapter {

        public AppSectionsPagerAdapter1(FragmentManager fragment) {
            super(fragment);
        }

        @Override
        public Fragment getItem(int i) {
            switch (i) {
                case 0:
                    return estandarFragment;
                case 1:
                    return sensibleFragment;
                case 2:
                    return especialFragment;
                default:
                    return especialFragment;
            }
        }

        @Override
        public int getCount() {
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    // The first section of the app is the most interesting -- it offers
                    // a launchpad into the other demonstrations in this example application.
                    return "ESTANDAR";
                case 1:
                    return "SENSIBLE";
                case 2:
                    return "ESPECIAL";
                default:
                    return "";
            }
        }

    }
    private class setAdapterTask extends AsyncTask<Void,Void,Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {

            tabs.setViewPager(mPager);
        }
    }
    private class setAdapterTaskPager extends AsyncTask<Void,Void,Void> {
        protected Void doInBackground(Void... params) {
            return null;
        }

        @Override
        protected void onPostExecute(Void result) {
            mPager.setAdapter(mAppSectionsPagerAdapter);
            mPager.setCurrentItem(0);
        }
    }
    public void agregaOpcion(String titulo, Drawable imagen, int valor, View itemSeleccionado, int tipo, int position){
        horizontalScrollView.scrollTo(viewHorizontal.getRight(), 0);
        LayoutInflater inflator = getLayoutInflater();
        View view1 = inflator.inflate(R.layout.item_lista_horizontal, null);
        TextView textView = (TextView) view1.findViewById(R.id.titulo_opcion_seleccionada);
        textView.setText(titulo);
        ImageView imageView= (ImageView) view1.findViewById(R.id.imagen_opcion_seleccionada);
        imageView.setImageDrawable(imagen);
        LinearLayout contenedor = (LinearLayout) view1.findViewById(R.id.contenedor_opcion_horizontal);
        final View finalview = view1;

        opcionesSeleccionadas.add(itemSeleccionado);
        TextView pos = (TextView) view1.findViewById(R.id.position);
        pos.setText(String.valueOf(position));
        TextView tipoT = (TextView) view1.findViewById(R.id.tipo);
        tipoT.setText(String.valueOf(tipo));
        valoresDatosSeleccionados.add(valor);

        contenedor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String positionString = ((TextView) view.findViewById(R.id.position)).getText().toString();
                int position = Integer.parseInt(positionString);
                String tipoString = ((TextView) view.findViewById(R.id.tipo)).getText().toString();
                int tipo = Integer.parseInt(tipoString);
                eliminarOpcion(finalview, position, tipo);
            }
        });
        viewHorizontal.addView(view1);
        horizontalScrollView.postDelayed(new Runnable() {
            public void run() {
                horizontalScrollView.fullScroll(HorizontalScrollView.FOCUS_RIGHT);
            }
        }, 100L);
    }

    //Agregar a version de la planta
    public void quitarOpcion(View view, int position){
        viewHorizontal.removeView(view);
        opcionesSeleccionadas.get(position).setEnabled(true);
        opcionesSeleccionadas.remove(position);
        valoresDatosSeleccionados.remove(position);
    }
    public void abrirCalculo(){
        viewHorizontal.removeAllViews();
        DialogResultado resultado = new DialogResultado(this);
    }


    public void eliminarOpcion(View view,int position, int tipo){
        viewHorizontal.removeView(view);
        switch (tipo){
            case 0:
                estandarFragment.arrayList.get(position).habilitado = true;
                IntListas.valorA--;
                break;
            case 1:
                sensibleFragment.arrayList.get(position).habilitado = true;
                IntListas.valorB--;
                break;
            case 2:
                especialFragment.arrayList.get(position).habilitado = true;
                IntListas.valorC--;
                break;
        }/*
        opcionesSeleccionadas.get(position).setEnabled(true);
        opcionesSeleccionadas.remove(position);
        valoresDatosSeleccionados.remove(position);*/
    }
    public class OpcionSeleccionada{
        View view;
        View viewLista;
        public OpcionSeleccionada(View view, View viewLista){
            this.view = view;
            this.viewLista = viewLista;
        }

    }

}
