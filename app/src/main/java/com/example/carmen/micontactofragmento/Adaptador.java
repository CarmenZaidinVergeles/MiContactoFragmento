package com.example.carmen.micontactofragmento;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 2dam on 30/09/2015.
 */
public class Adaptador extends ArrayAdapter<Contacto> {

    private Context contexto;//la actividad que va a contener el listview
    private int recurso;//el layout que se usa para rellenar cada uno de los item del liestview
    private List<Contacto> lista;//lista de valores que va a mosrtrar
    private TextView tv,tv2;

    private LayoutInflater i;

    public Adaptador(Context contexto, List<Contacto> lista) {
        super(contexto, R.layout.item,lista);

        this.contexto=contexto;
        this.recurso=R.layout.item;
        this.lista=lista;
        i = (LayoutInflater) contexto.getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
    }

    static class ViewHolder{
        private TextView tv,tv2;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh;
        if (convertView==null){
            vh=new ViewHolder();
            convertView = i.inflate(recurso, null);
            tv = (TextView) convertView.findViewById(R.id.tvNombre);
            tv2 = (TextView) convertView.findViewById(R.id.tvTelefonos);
            vh.tv=tv;
            vh.tv2=tv2;
            convertView.setTag(vh);
        }else{
            vh= (ViewHolder) convertView.getTag();
        }

        Contacto aux=lista.get(position);
        tv.setText(aux.getNombre());
        tv2.setText(aux.getStringTelefonos());

        return convertView;
    }
}
