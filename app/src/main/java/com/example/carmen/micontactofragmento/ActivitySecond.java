package com.example.carmen.micontactofragmento;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import java.io.Serializable;

public class ActivitySecond extends AppCompatActivity{
    Contacto aux;
    Intent i;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        aux = null;
        i = this.getIntent();
        if (savedInstanceState != null) {
            aux = (Contacto) savedInstanceState.getSerializable("aux");
        }
        if (getResources().getConfiguration().orientation == Configuration.ORIENTATION_PORTRAIT) {
            setContentView(R.layout.activity_second);
            i = getIntent();
            Bundle b = i.getExtras();
            aux = (Contacto) b.getSerializable("aux");
            FragmentoContacto fragmento = (FragmentoContacto)
                    getFragmentManager().findFragmentById(R.id.fragmentActividadSegunda);
            fragmento.setDato(aux);
        }else{

            Bundle b = new Bundle();
            b.putSerializable("aux", aux);
            i.putExtras(b);
            setResult(Activity.RESULT_OK,i);
            finish();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle guardaEstado) {
        super.onSaveInstanceState(guardaEstado);
        guardaEstado.getSerializable("aux");
        guardaEstado.putSerializable("aux", aux);
    }

    /*@Override
    protected void onRestoreInstanceState(Bundle recuperaEstado) {
        super.onRestoreInstanceState(recuperaEstado);
        recuperaEstado.getSerializable("aux");
        recuperaEstado.putSerializable("aux", aux);

    }*/


}


