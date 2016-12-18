package aaluti.login;

import android.annotation.TargetApi;
import android.content.Intent;
import android.os.Build;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class Tecnologias extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tecnologias);
        getSupportActionBar().setTitle(R.string.tx_expe);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        final Animation slideUpIn = AnimationUtils.loadAnimation(Microsoft.this, R.anim.rotate);
//        fab.startAnimation(slideUpIn);



        //Relleno Array Info

        ArrayList<Lista_Entrada> datos = new ArrayList<Lista_Entrada>();

        datos.add(new Lista_Entrada(R.drawable.vs08, "Visual Studio 2008", "5 años de experiencia.", 1));
        datos.add(new Lista_Entrada(R.drawable.vs2010, "Visual Studio 2010", "2 años de experiencia.", 2));
        datos.add(new Lista_Entrada(R.drawable.vs2015, "Visual Studio 2015", "1 años de experiencia.", 3));
        datos.add(new Lista_Entrada(R.drawable.sp2007, "Sharepoint Server 2007", "1 años de experiencia.", 4));
        datos.add(new Lista_Entrada(R.drawable.sp2010, "Sharepoint Server 2010", "6 meses de experiencia.", 5));
        datos.add(new Lista_Entrada(R.drawable.sql2005, "SQL Server 2005", "5 años de experiencia",6));
        datos.add(new Lista_Entrada(R.drawable.sql2008, "SQL Server 2008", "3 años de experiencia",7));
        datos.add(new Lista_Entrada(R.drawable.iis7, "Microsoft IIS 7.0", "6 años de experiencia", 8));
        datos.add(new Lista_Entrada(R.drawable.pwc, "Power Center 8.1.1/8.6.1/9.1.0", "2 años de experiencia", 9));
        datos.add(new Lista_Entrada(R.drawable.spring, "Framework Spring", "6 meses de experiencia", 10));
        datos.add(new Lista_Entrada(R.drawable.androids, "Android Studio", "3 meses de experiencia", 11));
        datos.add(new Lista_Entrada(R.drawable.mongo, "Mongo 3.2", "6 meses de experiencia", 12));
        datos.add(new Lista_Entrada(R.drawable.wordpress, "WordPress", "1 año de experiencia", 13));

        ListView lista = (ListView) findViewById(R.id.tecnologias_list);
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



    }
}
