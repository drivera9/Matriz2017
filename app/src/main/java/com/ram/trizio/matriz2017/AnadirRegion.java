package com.ram.trizio.matriz2017;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class AnadirRegion extends AppCompatActivity {

    ArrayList<Region> regiones = new ArrayList<>();
    String titulo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_region);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo = getIntent().getExtras().getString("titulo");
        setTitle(titulo);



        String[] leadsNames = new String[regiones.size()];
        for (int i = 0;i<regiones.size();i++){
            leadsNames[i] = regiones.get(i).getNombre();
        }

        ArrayAdapter mLeadsAdapter = new ArrayAdapter<>(
                this,
                R.layout.texto,
                R.id.list_content,
                leadsNames);



        ListView lista = (ListView) findViewById(R.id.listView);
        lista.setAdapter(mLeadsAdapter);

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                switch( position )
                {
                    case 0:
                        Intent i = new Intent(AnadirRegion.this,Transmitir.class);
                        i.putExtra("titulo",titulo + " - " + parent.getItemAtPosition(position).toString());
                        i.putExtra("regiones",regiones);
                        startActivity(i);

                        break;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(AnadirRegion.this, AnadirRegionDetalle.class);
                startActivityForResult(i, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if(resultCode == Activity.RESULT_OK){


                Region region = (Region) data.getSerializableExtra("region");

                regiones.add(region);

                String[] leadsNames = new String[regiones.size()];
                for (int i = 0;i<regiones.size();i++){
                    leadsNames[i] = regiones.get(i).getNombre();
                }

                ArrayAdapter mLeadsAdapter = new ArrayAdapter<>(
                        this,
                        R.layout.texto,
                        R.id.list_content,
                        leadsNames);



                ListView lista = (ListView) findViewById(R.id.listView);
                lista.setAdapter(mLeadsAdapter);

                lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    public void onItemClick(AdapterView<?> parent, View view,
                                            int position, long id) {
                        switch( position )
                        {
                            case 0:
                                Intent i = new Intent(AnadirRegion.this,Transmitir.class);
                                i.putExtra("titulo",titulo + " - " + parent.getItemAtPosition(position).toString());
                                i.putExtra("regiones",regiones);
                                startActivity(i);

                                break;
                        }
                    }
                });

            }
            if (resultCode == Activity.RESULT_CANCELED) {
                //Write your code if there's no result
            }
        }
    }//onActivityResult

}
