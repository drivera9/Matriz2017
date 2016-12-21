package com.ram.trizio.matriz2017;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.flask.colorpicker.ColorPickerView;
import com.flask.colorpicker.OnColorSelectedListener;
import com.flask.colorpicker.builder.ColorPickerClickListener;
import com.flask.colorpicker.builder.ColorPickerDialogBuilder;

import java.io.Serializable;

public class AnadirRegionDetalle extends AppCompatActivity {
    InternalView myView;
    String dimensionx = "";
    String dimensiony = "";
    String dimensionancho = "";
    String dimensionaltura = "";
    String colorHexa = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anadir_region_detalle);


    }

    public void previsualizar(View v){
        EditText x = (EditText) findViewById(R.id.editX);
        EditText y = (EditText) findViewById(R.id.editY);
        EditText ancho = (EditText) findViewById(R.id.editAncho);
        EditText altura = (EditText) findViewById(R.id.editAltura);

        dimensionx = x.getText().toString();
        dimensiony = y.getText().toString();
        dimensionancho = ancho.getText().toString();
        dimensionaltura = altura.getText().toString();
        myView = new InternalView(this);
        RelativeLayout layout1 = (RelativeLayout) findViewById(R.id.canvas);

        layout1.addView(myView);
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

    public void palette(View v){
        ColorPickerDialogBuilder
                .with(this)
                .setTitle("Choose color")
                .initialColor(R.color.colorAccent)
                .wheelType(ColorPickerView.WHEEL_TYPE.FLOWER)
                .density(12)
                .setOnColorSelectedListener(new OnColorSelectedListener() {
                    @Override
                    public void onColorSelected(int selectedColor) {
                        //Toast.makeText(AnadirRegionDetalle.this, Integer.toHexString(selectedColor) + "", Toast.LENGTH_SHORT).show();

                    }
                })
                .setPositiveButton("ok", new ColorPickerClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int selectedColor, Integer[] allColors) {
                        colorHexa =  Integer.toHexString(selectedColor);
                        //Toast.makeText(AnadirRegionDetalle.this, Integer.toHexString(selectedColor) + "", Toast.LENGTH_SHORT).show();
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

    public void ok(View v){
        EditText nombre = (EditText) findViewById(R.id.editNombre);

        try{
            Region region = new Region(nombre.getText().toString(),Integer.parseInt(dimensionx)
                    ,Integer.parseInt(dimensiony),Integer.parseInt(dimensionancho),Integer.parseInt(dimensionaltura),colorHexa);

            Intent mIntent = new Intent();
            Bundle mBundle = new Bundle();
            mBundle.putSerializable("region",  region);
            mIntent.putExtras(mBundle);
            setResult(Activity.RESULT_OK, mIntent);

            finish();

        }catch (Exception e){
            Toast.makeText(this, "Por favor digite el nombre de la region!", Toast.LENGTH_SHORT).show();
            e.printStackTrace();
        }

    }
}
