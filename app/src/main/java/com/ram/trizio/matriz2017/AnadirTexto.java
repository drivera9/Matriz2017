package com.ram.trizio.matriz2017;

import android.app.Activity;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

public class AnadirTexto extends Activity {

    boolean botonClick = true;
    boolean botonIzq = true;
    boolean botonDer = true;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_texto);
    }

    public void anadirColorTexto(View v){
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(R.color.colorAccent)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        Toast.makeText(AnadirTexto.this, Integer.toHexString(selectedColor) + "", Toast.LENGTH_SHORT).show();

                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {

                        Toast.makeText(AnadirTexto.this, Integer.toHexString(selectedColor) + "", Toast.LENGTH_SHORT).show();
                    }
                })
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                })
                .build()
                .show();
    }

    public void filtroP(View v){
        cambiar("pause");
    }

    public void filtroI(View v){
        cambiar("izq");
    }

    public void filtroD(View v){
        cambiar("der");
    }

    public void cambiar (String parametro){
        Button pause = (Button) findViewById(R.id.boton_pause);
        Button izq = (Button) findViewById(R.id.izquierda);
        Button der = (Button) findViewById(R.id.derecha);
        if (parametro.equals("izq")){
            izq.setBackgroundResource(R.drawable.izquierdared);
            der.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_white_48dp);
            pause.setBackgroundResource(R.drawable.ic_pause_circle_outline_white_48dp);
        }
        if (parametro.equals("der")){
            der.setBackgroundResource(R.drawable.derechared);
            izq.setBackgroundResource(R.drawable.ic_keyboard_arrow_left_white_48dp);
            pause.setBackgroundResource(R.drawable.ic_pause_circle_outline_white_48dp);
        }
        if (parametro.equals("pause")){
            pause.setBackgroundResource(R.drawable.pausered);
            der.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_white_48dp);
            izq.setBackgroundResource(R.drawable.ic_keyboard_arrow_left_white_48dp);
        }
    }

    public void cambiarPause(View v){
        Button pause = (Button) findViewById(R.id.boton_pause);
        Button izq = (Button) findViewById(R.id.izquierda);
        Button der = (Button) findViewById(R.id.derecha);
        if(!botonDer || !botonIzq) botonClick = true;
        if (botonClick){
            pause.setBackgroundResource(R.drawable.pausered);
            botonClick = false;
        }else{
            //if (pause.getBackground().toString().equals("pausered")){
            pause.setBackgroundResource(R.drawable.ic_pause_circle_outline_white_48dp);
            botonClick = true;
            //}

        }

        izq.setBackgroundResource(R.drawable.ic_keyboard_arrow_left_white_48dp);
        der.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_white_48dp);

        botonDer = false;
        botonIzq = false;

    }

    public void cambiarIzq(View v){
        Button pause = (Button) findViewById(R.id.boton_pause);
        Button izq = (Button) findViewById(R.id.izquierda);
        Button der = (Button) findViewById(R.id.derecha);
        if(!botonClick || !botonDer) botonIzq = true;
        if (botonIzq){
            izq.setBackgroundResource(R.drawable.izquierdared);
            botonIzq = false;
        }else{
            //if (pause.getBackground().toString().equals("pausered")){
            izq.setBackgroundResource(R.drawable.ic_keyboard_arrow_left_white_48dp);
            botonIzq = true;
            //}

        }

        pause.setBackgroundResource(R.drawable.ic_pause_circle_outline_white_48dp);
        der.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_white_48dp);

        botonDer = false;
        botonClick = false;

    }

    public void cambiarDer(View v){
        Button pause = (Button) findViewById(R.id.boton_pause);
        Button izq = (Button) findViewById(R.id.izquierda);
        Button der = (Button) findViewById(R.id.derecha);
        if(!botonClick || !botonIzq) botonDer = true;
        if (botonDer){
            der.setBackgroundResource(R.drawable.derechared);
            botonDer = false;
        }else{
            //if (pause.getBackground().toString().equals("pausered")){
            der.setBackgroundResource(R.drawable.ic_keyboard_arrow_right_white_48dp);
            botonDer = true;
            //}

        }

        izq.setBackgroundResource(R.drawable.ic_keyboard_arrow_left_white_48dp);
        pause.setBackgroundResource(R.drawable.ic_pause_circle_outline_white_48dp);

        botonClick = false;
        botonIzq = false;

    }
}
