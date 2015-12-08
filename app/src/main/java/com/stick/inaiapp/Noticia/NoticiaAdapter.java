package com.stick.inaiapp.Noticia;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.stick.inaiapp.R;
import com.stick.inaiapp.calculo.Items;

import java.util.ArrayList;

/**
 * Created by petu on 18/11/15.
 */
public class NoticiaAdapter extends ArrayAdapter<ItemNoticia> {
    Context context;
    ArrayList<ItemNoticia> arrayitems;
    LayoutInflater layoutInflater;
    public NoticiaAdapter(Context context, ArrayList<ItemNoticia> list){
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
        ItemNoticia item = arrayitems.get(position);
        if (convertView == null)
            convertView = layoutInflater.inflate(R.layout.item_noticias, null);

        TextView titulo = (TextView) convertView.findViewById(R.id.titulo_noticia);
        titulo.setText(item.titulo);
        return convertView;
    }
}
