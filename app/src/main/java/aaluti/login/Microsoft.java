package aaluti.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class Microsoft extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_microsoft);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle(R.string.tx_microsoft);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        final Animation slideUpIn = AnimationUtils.loadAnimation(Microsoft.this, R.anim.rotate);
//        fab.startAnimation(slideUpIn);



        //Relleno Array Info

        ArrayList<Lista_Entrada> datos = new ArrayList<Lista_Entrada>();

        datos.add(new Lista_Entrada(R.drawable.microsoft_visual_studio_icon, "Visual Studio", "Desarrollo, implantación y mantenimiento de aplicación bancaria propia del Banco Santander. Desarrollo a medida en VS 2008.NET, SQL SERVER 2005, Team foundation server, Reporting Services", 1));
        datos.add(new Lista_Entrada(R.drawable.icon_mssql, "SQL Server", "Desarrollo, implantación y mantenimiento de aplicaciones realizadas con Power Center que consiste en la integración de datos entre aplicaciones",2));
        datos.add(new Lista_Entrada(R.drawable.gear_icon, "IIS", "Actualmente en el grupo de mantenimiento de ISBAN como responsable de las aplicaciones de .NET de la rama de Riesgos y de PWC de la rama de Riesgos.", 3));

        ListView lista = (ListView) findViewById(R.id.microsoft_list);
        lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                texto_superior_entrada.setText(((Lista_Entrada) entrada).get_textoEncima());

                TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                texto_inferior_entrada.setText(((Lista_Entrada) entrada).get_textoDebajo());

                ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen);
                imagen_entrada.setImageResource(((Lista_Entrada) entrada).get_idImagen());
            }
        });

        lista.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> pariente, View view, int posicion, long id) {
                final Lista_Entrada elegido = (Lista_Entrada) pariente.getItemAtPosition(posicion);
/*
CharSequence texto = "Seleccionado: " + elegido.get_textoDebajo();
Toast toast = Toast.makeText(Microsoft.this, texto, Toast.LENGTH_LONG);
toast.show();
*/
                final int actividad = elegido.get_activity();
                new Thread(new Runnable() {

                    @Override
                    public void run() {
                        Intent detalle;

                        try {
                            switch (actividad) {
                                case 1:
                                    detalle = new Intent(getApplicationContext(), VisualStudio.class);
                                    startActivity(detalle);
                                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                    break;
                                case 2:
                                    detalle = new Intent(getApplicationContext(), SqlServer.class);
                                    startActivity(detalle);
                                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                    break;
                                case 3:
                                    detalle = new Intent(getApplicationContext(), iis.class);
                                    startActivity(detalle);
                                    overridePendingTransition(R.anim.left_in, R.anim.left_out);
                                    break;
                                default:

                            }
                        } catch (Exception e) {
                        }
                        runOnUiThread(new Runnable() {
                            @Override
                            public void run() {


                            }
                        });
                    }
                }).start();

            }
        });
/*Se muestra oculta el boton segun el scroll del list view*/
        OnScrollUpDownListener.Action scrollAction = new OnScrollUpDownListener.Action() {

            @Override
            public void up() {
                fab.hide();
            }

            @Override
            public void down() {
                fab.show();
            }

        };
        lista.setOnScrollListener(new OnScrollUpDownListener(lista, 8, scrollAction));
        fab.setImageResource(R.drawable.mobile_menu_close2);

        fab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
                overridePendingTransition(R.anim.zoom_forward_in, R.anim.zoom_back_out);
            }
        });
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
//            case android.R.id.home: //hago un case por si en un futuro agrego mas opciones
//                Log.i("ActionBar", "Atrás!");
//                finish();
//                return true;
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



}
