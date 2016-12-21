package com.ram.trizio.matriz2017;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.SystemClock;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class Transmitir extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    DemoView demoview;
    int mCount = 0;
    int mListSize = 0;
    String direccion = "derecha";
    int duracion = 0;
    String titulo = "";
    ArrayList<Region> regiones;
    String dimensionx = "";
    String dimensiony = "";
    String dimensionancho = "";
    String dimensionaltura = "";
    String colorHexa = "";
    InternalView myView;
    @Override
    protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_transmitir);

        regiones = (ArrayList<Region>) getIntent().getSerializableExtra("regiones");
        titulo = getIntent().getExtras().getString("titulo");
        setTitle(titulo);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);


        // Spinner click listener
        spinner.setOnItemSelectedListener(this);



        // Spinner Drop down elements
        List<String> spinnerRegiones = new ArrayList<String>();
        for (int i = 0;i<regiones.size();i++){
            spinnerRegiones.add(regiones.get(i).getNombre());
        }


        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinnerRegiones);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        SeekBar seekBar = (SeekBar) findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            duracion = progress;
            actualizar(progress);
        }

        /**
         * El usuario inicia la interacción con la Seekbar.
         */
        @Override
        public void onStartTrackingTouch(SeekBar arg0) {
        }

        /**
         * El usuario finaliza la interacción con la Seekbar.
         */
        @Override
        public void onStopTrackingTouch(SeekBar arg0) {

        }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        dimensionx = String.valueOf(regiones.get(position).getX());
        dimensiony =String.valueOf(regiones.get(position).getY());
        dimensionancho = String.valueOf(regiones.get(position).getAncho());
        dimensionaltura = String.valueOf(regiones.get(position).getAltura());
        colorHexa = regiones.get(position).getColorBorde();
        myView = new InternalView(this);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.canvas);

        layout1.addView(myView);
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void actualizar(int progress){
        Double resultado = new Double(progress*10);
        int tiempo = resultado.intValue();
        mCount = 0;
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.canvas);

        Paint paint = new Paint();
        paint.setColor(Color.RED);

        List<Coords> coordList = new ArrayList<Coords>();
        if (direccion.equals("derecha")) {

            // Load up the coordinates
            coordList.add(new Coords(-440, 150));
            coordList.add(new Coords(-360, 150));
            coordList.add(new Coords(-280, 150));
            coordList.add(new Coords(-200, 150));
            coordList.add(new Coords(-120, 150));
            coordList.add(new Coords(-40, 150));
            coordList.add(new Coords(60, 150));
            coordList.add(new Coords(140, 150));
            coordList.add(new Coords(220, 150));
            coordList.add(new Coords(300, 150));
            coordList.add(new Coords(380, 150));
            coordList.add(new Coords(460, 150));
            coordList.add(new Coords(540, 150));
            coordList.add(new Coords(620, 150));
            coordList.add(new Coords(700, 150));
            coordList.add(new Coords(780, 150));
            coordList.add(new Coords(860, 150));
            coordList.add(new Coords(940, 150));
            coordList.add(new Coords(1200, 150));
        }else{
            if (direccion.equals("iaquierda")) {

                // Load up the coordinates
                coordList.add(new Coords(-440, 150));
                coordList.add(new Coords(-360, 150));
                coordList.add(new Coords(-280, 150));
                coordList.add(new Coords(-200, 150));
                coordList.add(new Coords(-120, 150));
                coordList.add(new Coords(-40, 150));
                coordList.add(new Coords(60, 150));
                coordList.add(new Coords(140, 150));
                coordList.add(new Coords(220, 150));
                coordList.add(new Coords(300, 150));
                coordList.add(new Coords(380, 150));
                coordList.add(new Coords(460, 150));
                coordList.add(new Coords(540, 150));
                coordList.add(new Coords(620, 150));
                coordList.add(new Coords(700, 150));
                coordList.add(new Coords(780, 150));
                coordList.add(new Coords(860, 150));
                coordList.add(new Coords(940, 150));
                coordList.add(new Coords(1200, 150));
            }else{
                if (direccion.equals("pause")) {

                    // Load up the coordinates
                    coordList.add(new Coords(-440, 150));
                    coordList.add(new Coords(-360, 150));
                    coordList.add(new Coords(-280, 150));
                    coordList.add(new Coords(-200, 150));
                    coordList.add(new Coords(-120, 150));
                    coordList.add(new Coords(-40, 150));
                    coordList.add(new Coords(60, 150));
                    coordList.add(new Coords(140, 150));
                    coordList.add(new Coords(220, 150));
                    coordList.add(new Coords(300, 150));
                    coordList.add(new Coords(380, 150));
                    coordList.add(new Coords(460, 150));
                    coordList.add(new Coords(540, 150));
                    coordList.add(new Coords(620, 150));
                    coordList.add(new Coords(700, 150));
                    coordList.add(new Coords(780, 150));
                    coordList.add(new Coords(860, 150));
                    coordList.add(new Coords(940, 150));
                    coordList.add(new Coords(1200, 150));
                }
            }
        }



        mListSize = coordList.size();

        demoview = new DemoView(this, paint, coordList);
        layout1.addView(demoview);

        Timer timer = new Timer();

        timer.schedule(new TimerTask() {
            public void run() {
                mCount++;
                demoview.postInvalidate();
                Log.d("LINES", "Timer triggered");
                if (mCount >= mListSize) {
                    //mCount = 0;
                    cancel();
                }
            }
        }, tiempo, tiempo);
    }

    private class InternalView extends View{
        public InternalView(Context context){

            super(context);

        }

        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);
            canvas.drawColor(Color.WHITE);
            Paint paint = new Paint();
            paint.setStyle(Paint.Style.STROKE);
            paint.setColor(Color.BLUE);


            try {
                canvas.drawLine(Float.parseFloat(dimensionx), Float.parseFloat(dimensiony),
                        Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho), Float.parseFloat(dimensiony)
                        , paint);

                canvas.drawLine(Float.parseFloat(dimensionx), Float.parseFloat(dimensiony),
                        Float.parseFloat(dimensionx), Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura)
                        , paint);

                canvas.drawLine(Float.parseFloat(dimensionx) , Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura),
                        Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho), Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura)
                        , paint);

                canvas.drawLine(Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho) , Float.parseFloat(dimensiony),
                        Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho), Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura)
                        , paint);

                int color = (int)Long.parseLong(colorHexa, 16);
                int r = (color >> 16) & 0xFF;
                int g = (color >> 8) & 0xFF;
                int b = (color >> 0) & 0xFF;

                //canvas.drawColor(Color.WHITE);
                paint = new Paint();
                paint.setStyle(Paint.Style.STROKE);
                paint.setColor(color);

                canvas.drawLine(Float.parseFloat(dimensionx) - 30, Float.parseFloat(dimensiony) - 30,
                        Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho) + 30, Float.parseFloat(dimensiony) - 30
                        , paint);

                canvas.drawLine(Float.parseFloat(dimensionx) - 30, Float.parseFloat(dimensiony) - 30,
                        Float.parseFloat(dimensionx) - 30, Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura) + 30
                        , paint);

                canvas.drawLine(Float.parseFloat(dimensionx) - 30 , Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura) + 30,
                        Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho) + 30, Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura) + 30
                        , paint);

                canvas.drawLine(Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho) + 30 , Float.parseFloat(dimensiony) - 30,
                        Float.parseFloat(dimensionx) + Float.parseFloat(dimensionancho) + 30, Float.parseFloat(dimensiony) + Float.parseFloat(dimensionaltura) + 30
                        , paint);

            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }



    private class DemoView extends View {

        Paint mPaint;
        List<Coords> mcList;

        public DemoView(Context context, Paint paint, List<Coords> cList) {
            super(context);
            mPaint = paint;
            mcList = cList;
            mPaint.setColor(Color.BLACK);
            mPaint.setTextSize(160);
        }
        @Override
        protected void onDraw(Canvas canvas) {

            super.onDraw(canvas);
            int count = 0;
            Log.d("LINES", "mcount" + mCount);
            for (Coords c : mcList) { // draw all the lines
                if (count >= mCount) {
                    break; // up to the number in mCount
                }else {
                    canvas.drawColor(Color.WHITE);
                    canvas.drawText("DAVID", c.mx, c.my, mPaint);

                    count++;
                }
            }

        }
    }

    private class Coords {
        // little class to hold the coordinates
        float mx; float my;

        public Coords(float x, float y) {
            mx = x;   my = y; // start/end x/y
        }
    }

    public void añadir(View v){
        Intent i = new Intent(Transmitir.this,Anadir.class);
        startActivity(i);
        //overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
    }


    public void filtroP(View v){
        direccion = "pause";
        cambiar("pause");
        actualizar(duracion);

    }

    public void filtroI(View v){
        direccion = "izquierda";
        cambiar("izq");
        actualizar(duracion);

    }

    public void filtroD(View v){
        direccion = "derecha";
        cambiar("der");
        actualizar(duracion);

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
}
