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
public class SensibleFragment extends Fragment implements AdapterView.OnItemClickListener{
    ListView lista;
    ArrayList<Items> arrayList;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.opcion_sensible, container, false);
        lista = (ListView) view.findViewById(R.id.lista_opcion_sensible);
        arrayList = new ArrayList<>();
        arrayList.add(new Items("Afiliación sindical", ContextCompat.getDrawable(getActivity(), R.drawable.afiliacion_sindical)));
        arrayList.add(new Items("Afore", ContextCompat.getDrawable(getActivity(), R.drawable.afore)));
        arrayList.add(new Items("Amparos", ContextCompat.getDrawable(getActivity(), R.drawable.amparos)));
        arrayList.add(new Items("Antecedentes penales", ContextCompat.getDrawable(getActivity(), R.drawable.antecedentes_penales)));
        arrayList.add(new Items("Bienes inmuebles", ContextCompat.getDrawable(getActivity(), R.drawable.bienes_inmuebles)));
        arrayList.add(new Items("Biométrica", ContextCompat.getDrawable(getActivity(), R.drawable.biometrica)));
        arrayList.add(new Items("Buro de crédito", ContextCompat.getDrawable(getActivity(), R.drawable.buro_credito)));
        arrayList.add(new Items("Contraseña", ContextCompat.getDrawable(getActivity(), R.drawable.password)));
        arrayList.add(new Items("Contrato", ContextCompat.getDrawable(getActivity(), R.drawable.contrato)));
        arrayList.add(new Items("Creencias religiosas", ContextCompat.getDrawable(getActivity(), R.drawable.creencias_religiosas)));
        arrayList.add(new Items("Cuenta de inversión", ContextCompat.getDrawable(getActivity(), R.drawable.cuenta_inversion)));
        arrayList.add(new Items("Demandas", ContextCompat.getDrawable(getActivity(), R.drawable.demandas)));
        arrayList.add(new Items("Egresos", ContextCompat.getDrawable(getActivity(), R.drawable.egresos)));
        arrayList.add(new Items("Estado de salud", ContextCompat.getDrawable(getActivity(), R.drawable.estado_salud)));
        arrayList.add(new Items("Finanzas", ContextCompat.getDrawable(getActivity(), R.drawable.finanzas)));
        arrayList.add(new Items("Firma digital", ContextCompat.getDrawable(getActivity(), R.drawable.firma_digital)));
        arrayList.add(new Items("Habitos sexuales", ContextCompat.getDrawable(getActivity(), R.drawable.habitos_sexuales)));
        arrayList.add(new Items("Historial crediticio", ContextCompat.getDrawable(getActivity(), R.drawable.historial_crediticio)));
        arrayList.add(new Items("Inf. genética", ContextCompat.getDrawable(getActivity(), R.drawable.info_genetica)));
        arrayList.add(new Items("Inf. fiscal", ContextCompat.getDrawable(getActivity(), R.drawable.informacion_fiscal)));
        arrayList.add(new Items("Ingresos", ContextCompat.getDrawable(getActivity(), R.drawable.ingresos)));
        arrayList.add(new Items("Juicio", ContextCompat.getDrawable(getActivity(), R.drawable.juicio)));
        arrayList.add(new Items("Número de cuenta", ContextCompat.getDrawable(getActivity(), R.drawable.numero_cuenta)));
        arrayList.add(new Items("Número de tarjeta bancaria", ContextCompat.getDrawable(getActivity(), R.drawable.numero_tarjeta_bancaria)));
        arrayList.add(new Items("Opiniones politicas", ContextCompat.getDrawable(getActivity(), R.drawable.opiniones_politicas)));
        arrayList.add(new Items("Origen racial", ContextCompat.getDrawable(getActivity(), R.drawable.origen_racial)));
        arrayList.add(new Items("Preferencias sexuales", ContextCompat.getDrawable(getActivity(), R.drawable.preferenciasexual)));
        arrayList.add(new Items("Presente y futuro", ContextCompat.getDrawable(getActivity(), R.drawable.presente_futuro)));
        arrayList.add(new Items("Saldo bancario", ContextCompat.getDrawable(getActivity(), R.drawable.saldobancario)));
        arrayList.add(new Items("Seguros", ContextCompat.getDrawable(getActivity(), R.drawable.seguros)));
        arrayList.add(new Items("Ubicación de la persona", ContextCompat.getDrawable(getActivity(), R.drawable.ubicacionpersona)));

        lista.setAdapter(new ListAdapter(getActivity(), arrayList));
        lista.setOnItemClickListener(this);
        return view;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        if (arrayList.get(position).habilitado){
            arrayList.get(position).habilitado=false;
            IntListas.valorB++;
            ((Calculo)getActivity()).agregaOpcion(arrayList.get(position).titulo, arrayList.get(position).imagen, 2, view, 1, position);
        }

    }
}
