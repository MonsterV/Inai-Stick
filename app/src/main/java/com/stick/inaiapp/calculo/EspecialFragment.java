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
 * Created by petu on 10/11/15.
 */
public class EspecialFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView lista;
    ArrayList<Items> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.opcion_especial, container, false);
        lista = (ListView) view.findViewById(R.id.lista_opcion_especial);
        arrayList = new ArrayList<>();
        arrayList.add(new Items("Codigo de seguridad", ContextCompat.getDrawable(getActivity(),R.drawable.codigo_seguridad)));
        arrayList.add(new Items("Datos de banda magnética", ContextCompat.getDrawable(getActivity(),R.drawable.datos_banda_magnetica)));
        arrayList.add(new Items("Fecha de vencimiento de tarjeta", ContextCompat.getDrawable(getActivity(),R.drawable.fecha_vencimiento_tarjeta)));
        arrayList.add(new Items("Número de id personal", ContextCompat.getDrawable(getActivity(),R.drawable.numero_id_personal)));
        arrayList.add(new Items("Tipo de tarjeta", ContextCompat.getDrawable(getActivity(),R.drawable.tipo_tarjeta)));
        lista.setAdapter(new ListAdapter(getActivity(), arrayList));
        lista.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        if (arrayList.get(position).habilitado){
            arrayList.get(position).habilitado=false;
            IntListas.valorC++;
            ((Calculo) getActivity()).agregaOpcion(arrayList.get(position).titulo, arrayList.get(position).imagen, 3, view,2,position);
        }
    }
}
