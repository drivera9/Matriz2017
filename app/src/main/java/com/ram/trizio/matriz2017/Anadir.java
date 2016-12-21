package com.ram.trizio.matriz2017;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Anadir extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir);
    }
    public void anadir (View v){
        Intent i = new Intent(Anadir.this,AnadirTexto.class);
        startActivity(i);
        finish();
    }
}
