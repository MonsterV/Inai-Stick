package com.stick.inaiapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ListView;

import com.stick.inaiapp.Noticia.ItemNoticia;
import com.stick.inaiapp.Noticia.NoticiaAdapter;
import com.stick.inaiapp.calculo.Calculo;

import java.util.ArrayList;

/**
 * Created by petu on 24/10/15.
 */
public class InicioFragment extends Fragment {
    ArrayList<ItemNoticia> listaNoticias;
    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.inicio, container, false);
        ListView listaView = (ListView) view.findViewById(R.id.lista_noticias);
        ImageButton botonCalculadora = (ImageButton) view.findViewById(R.id.boton_calculadora);
        botonCalculadora.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), Calculo.class);
                getActivity().startActivity(intent);
            }
        });
        listaNoticias = new ArrayList<>();
        listaNoticias.add(new ItemNoticia("Leyes claras para los derechos de acceso a la información y protección de datos"));
        listaNoticias.add(new ItemNoticia("El valor de los datos para el consumidor"));
        listaNoticias.add(new ItemNoticia("El resguardo adecuado de los datos personales"));
        listaNoticias.add(new ItemNoticia("Como cuidar tus datos personales"));
        listaView.setAdapter(new NoticiaAdapter(getActivity(),listaNoticias));
        return view;
    }
}
