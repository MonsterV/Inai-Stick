package com.stick.inaiapp.calculo;

import android.content.Context;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.stick.inaiapp.IntListas;
import com.stick.inaiapp.R;

import java.util.ArrayList;

/**
 * Created by petu on 25/10/15.
 */
public class ListAdapter extends ArrayAdapter<Items> {
    Context context;
    ArrayList<Items> arrayitems;
    LayoutInflater layoutInflater;
    public ListAdapter (Context context, ArrayList<Items> list){
        super(context,0, list);
        this.context = context;
        layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        arrayitems=list;

    }
    public int getCount() {
        // TODO Auto-generated method stub
        return arrayitems.size();
    }
    @Override
    public long getItemId(int position) {

        return position;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // TODO Auto-generated method stub
        Items item = arrayitems.get(position);
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.item_lista_calculo, null);

        TextView titulo = (TextView) convertView.findViewById(R.id.titulo_item_calcular);
        ImageView imagen = (ImageView) convertView.findViewById(R.id.imagen_item_calcular);
        titulo.setText(item.titulo);
        imagen.setImageDrawable(item.imagen);
        return convertView;
    }
}
