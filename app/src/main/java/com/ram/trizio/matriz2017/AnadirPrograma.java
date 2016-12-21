package com.ram.trizio.matriz2017;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.password;

public class AnadirPrograma extends AppCompatActivity {

    ArrayList<String> programas = new ArrayList<>();
    String titulo = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_programa);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titulo = getIntent().getExtras().getString("titulo");
        setTitle(titulo);

        String[] leadsNames = new String[programas.size()];
        for (int i = 0;i<programas.size();i++){
            leadsNames[i] = programas.get(i).trim();
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
                        Intent i = new Intent(AnadirPrograma.this,AnadirRegion.class);
                        startActivity(i);

                        break;
                }
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(AnadirPrograma.this);
                alertDialog.setTitle("Nombre del programa");
                alertDialog.setMessage("Entre el nombre");

                final EditText input = new EditText(AnadirPrograma.this);
                input.setGravity(Gravity.CENTER);
                LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                        LinearLayout.LayoutParams.MATCH_PARENT,
                        LinearLayout.LayoutParams.MATCH_PARENT);
                input.setLayoutParams(lp);
                alertDialog.setView(input); // uncomment this line

                alertDialog.setPositiveButton("YES",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                actualizar(input.getText().toString());
                            }
                        });

                alertDialog.setNegativeButton("NO",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });

                alertDialog.show();
            }

        });
    }
    public void actualizar(String nombre){

        programas.add(nombre);

        String[] leadsNames = new String[programas.size()];
        for (int i = 0;i<programas.size();i++){
            leadsNames[i] = programas.get(i).trim();
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
                        Intent i = new Intent(AnadirPrograma.this,AnadirRegion.class);
                        i.putExtra("titulo",titulo + " - " + parent.getItemAtPosition(position).toString());
                        startActivity(i);

                        break;
                }
            }
        });
    }

}
