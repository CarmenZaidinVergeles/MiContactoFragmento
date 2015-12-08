package com.example.carmen.micontactofragmento;

import android.app.Activity;
import android.app.Fragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Chrno on 02/12/2015.
 */
public class FragmentoLista extends Fragment{
    private List<Contacto> l;
    private List<String> telfs;
    private View fragView;
    private ListView lv;
    private Adaptador ad;
    private onFragmentoInteraccionListener listener;
    private final int ACTIVIDAD = 1;

    public FragmentoLista() {
        l = new ArrayList<>();
        telfs=new ArrayList<>();

        telfs.add("1234");
        telfs.add("5678");
        l.add(new Contacto("Fran",telfs));
        l.add(new Contacto("Ruben",telfs));
        l.add(new Contacto("Carmen", telfs));
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        fragView= inflater.inflate(R.layout.principal_port, container, false);
        inicio();
        return fragView;
    }

    private void inicio(){
        lv= (ListView) fragView.findViewById(R.id.lv);
        ad=new Adaptador(this.getActivity(),l);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                listener.onInteraccion(l.get(position));
            }
        });
        lv.setAdapter(ad);
    }

    @Override
    public void onActivityResult(int requestCode,int resultCode, Intent data) {
        if (resultCode == Activity.RESULT_OK && requestCode == 1) {
            Contacto aux = (Contacto) data.getSerializableExtra("aux");
            listener.onInteraccion(aux);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if(context instanceof onFragmentoInteraccionListener){
            listener= (onFragmentoInteraccionListener) context;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if(activity instanceof onFragmentoInteraccionListener){
            listener= (onFragmentoInteraccionListener) activity;
        }else{
            throw new ClassCastException("Solo acepto OnFragmentoInteraccionListener");
        }
    }

    public void lanzarContacto(Contacto c){
        Intent intent = new Intent(getActivity(), ActivitySecond.class);
        Bundle bundle = new Bundle();
        bundle.putSerializable("aux",c);
        intent.putExtras(bundle);
        startActivityForResult(intent,ACTIVIDAD);
    }
}

