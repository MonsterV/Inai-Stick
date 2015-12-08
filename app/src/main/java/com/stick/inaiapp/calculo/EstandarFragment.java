package com.stick.inaiapp.calculo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.stick.inaiapp.IntListas;
import com.stick.inaiapp.R;

import java.util.ArrayList;

/**
 * Created by petu on 9/11/15.
 */
public class EstandarFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView lista;
    ArrayList<Items> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.opcion_estandar,container, false);
        lista = (ListView) view.findViewById(R.id.lista_opcion_estandar);
        arrayList = new ArrayList<>();


        arrayList.add(new Items("Nombre", ContextCompat.getDrawable(getActivity(), R.drawable.nombre_estandar)));
        arrayList.add(new Items("Telefono", ContextCompat.getDrawable(getActivity(), R.drawable.telefono)));
        arrayList.add(new Items("Edad", ContextCompat.getDrawable(getActivity(), R.drawable.edad)));
        arrayList.add(new Items("Sexo", ContextCompat.getDrawable(getActivity(), R.drawable.sexo)));
        arrayList.add(new Items("RFC", ContextCompat.getDrawable(getActivity(), R.drawable.rfc)));
        arrayList.add(new Items("CURP", ContextCompat.getDrawable(getActivity(), R.drawable.curp)));
        arrayList.add(new Items("Estado civil", ContextCompat.getDrawable(getActivity(), R.drawable.estado_civil)));
        arrayList.add(new Items("Corre electrónico", ContextCompat.getDrawable(getActivity(), R.drawable.correo_electronico)));
        arrayList.add(new Items("Fecha de nacimiento", ContextCompat.getDrawable(getActivity(), R.drawable.fecha_cumple)));

        lista.setAdapter(new ListAdapter(getActivity(), arrayList));
        lista.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (arrayList.get(position).habilitado){
            arrayList.get(position).habilitado = false;
            IntListas.valorA++;
            ((Calculo)getActivity()).agregaOpcion(arrayList.get(position).titulo, arrayList.get(position).imagen, 1, view, 0, position);
        }
    }
}
