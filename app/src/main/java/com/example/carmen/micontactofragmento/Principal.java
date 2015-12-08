package com.example.carmen.micontactofragmento;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.io.Serializable;

public class Principal extends AppCompatActivity implements onFragmentoInteraccionListener {

    private onFragmentoInteraccionListener listener;
    private Intent i;
    private Contacto aux;

    @Override protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);

    }

    @Override
    public void onInteraccion(Contacto aux) {
        tostada(aux);
        FragmentoContacto fragmentoContacto = (FragmentoContacto) getFragmentManager().
                findFragmentById(R.id.fragmentoContacto);
        FragmentoLista fragmentoLista = (FragmentoLista)getFragmentManager().findFragmentById(R.id.fragmentoLista);

        if (fragmentoContacto == null || !fragmentoContacto.isInLayout()) {
            //Vertical
            fragmentoLista.lanzarContacto(aux);

        }else{
        //Horizontal
            fragmentoContacto.setDato(aux);
        }
    }

    public void tostada(Contacto s){
        Toast.makeText(this, s.toString(), Toast.LENGTH_SHORT).show();
    }
}
