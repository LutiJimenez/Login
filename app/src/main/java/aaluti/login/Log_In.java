package aaluti.login;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class Log_In extends AppCompatActivity  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_log_in);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.titulo_cv);



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginfaqs, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();
        Intent about;
        switch (id) {
            case R.id.action_settings:
                Log.i("ActionBar", "Settings!");
                //finish(); finaliza log_in y vuelve a principal
                about = new Intent(getApplicationContext(), SettingsActivity.class);
                startActivity(about);
                return true;
            case R.id.action_about:
                //return true;
                // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
                Log.i("ActionBar", "About!");
                //finish(); finaliza log_in y vuelve a principal
                about = new Intent(getApplicationContext(), SobreMi.class);
                startActivity(about);
                return true;
            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
                Log.i("ActionBar", "Atrás!");
                finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }

        /*if (id == R.id.action_settings) {
            //return true;
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
                Log.i("ActionBar", "Settings!");
            //finish(); finaliza log_in y vuelve a principal
            Intent about = new Intent(getApplicationContext(), SettingsActivity.class);
            startActivity(about);
            return true;
        }
        if (id == R.id.action_about) {
            //return true;
            // lo ideal aquí sería hacer un intent para abrir una nueva clase como lo siguiente
            Log.i("ActionBar", "About!");
            //finish(); finaliza log_in y vuelve a principal
            Intent about = new Intent(getApplicationContext(), SobreMi.class);
            startActivity(about);
            return true;
        }*/
        //return super.onOptionsItemSelected(item);

    }


    public void Cambiar(View v) {
        Intent myIntent;
        /*Comprobamos a que id pertenece el id del botón pulsado, en este caso como solo tenemos 1
        siempre va a ser el mismo pero se puede dar el caso de que haya más de un botón, entonces aquí se controlaría que botón se ha pulsado.
        */
        //Toast.makeText(getApplicationContext(), "Llega", Toast.LENGTH_SHORT).show();
        switch(v.getId()){
            case R.id.microsoft_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                myIntent = new Intent(getApplicationContext(),Microsoft.class);
                startActivity(myIntent); // Cambio de aplicación
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                break;
            case R.id.android_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                myIntent = new Intent(getApplicationContext(),Android.class);
                startActivity(myIntent); // Cambio de aplicación
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                break;
            case R.id.tecnologias_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                myIntent = new Intent(getApplicationContext(),Tecnologias.class);
                startActivity(myIntent); // Cambio de aplicación
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                break;
            case R.id.curso_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                myIntent = new Intent(getApplicationContext(),Cursos.class);
                startActivity(myIntent); // Cambio de aplicación
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                break;
            case R.id.disen_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                myIntent = new Intent(getApplicationContext(),VisorImagenes.class);
                startActivity(myIntent); // Cambio de aplicación
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_forward_out);
                break;
        }

    }



}
