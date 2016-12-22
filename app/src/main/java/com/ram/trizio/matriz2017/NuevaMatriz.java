package com.ram.trizio.matriz2017;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.Spinner;

import java.util.ArrayList;
import java.util.List;

public class NuevaMatriz extends Activity  implements AdapterView.OnItemSelectedListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nueva_matriz);

        Spinner spinnerRef = (Spinner) findViewById(R.id.spinnerRefMatriz);
        Spinner spinnerTipo = (Spinner) findViewById(R.id.spinnerTipoMatriz);
        // Spinner click listener
        spinnerRef.setOnItemSelectedListener(this);
        spinnerTipo.setOnItemSelectedListener(this);

        List<String> listRef = new ArrayList<String>();
        listRef.add("Seleccione una referencia ..");
        listRef.add("C10");

        List<String> listTipo = new ArrayList<String>();
        listTipo.add("Seleccione un tipo ..");
        listTipo.add("Interior");
        listTipo.add("Exterior");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapterRef = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listRef);
        ArrayAdapter<String> dataAdapterTipo = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, listTipo);

        // Drop down layout style - list view with radio button
        dataAdapterRef.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        dataAdapterTipo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinnerRef.setAdapter(dataAdapterRef);
        spinnerTipo.setAdapter(dataAdapterTipo);




    }

    public void checkRGB (View v){
        CheckBox checkMono = (CheckBox) findViewById(R.id.checkMono);

        checkMono.setChecked(false);
    }

    public void checkMono (View v){
        CheckBox checkRGB = (CheckBox) findViewById(R.id.checkRgb);

        checkRGB.setChecked(false);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
