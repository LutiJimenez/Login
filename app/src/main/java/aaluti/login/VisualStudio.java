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

public class VisualStudio extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visual_studio);
        getSupportActionBar().setTitle(R.string.tx_microsoft);
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //Relleno el listview
        //Relleno Array Info

        ArrayList<Lista_Entrada_Exp> datos = new ArrayList<Lista_Entrada_Exp>();

        datos.add(new Lista_Entrada_Exp("ISBAN", "Desarrollo, implantación y mantenimiento de aplicación bancaria propia del Banco Santander (Biblioteca de Informes). Desarrollo a medida en VS 2014.NET."));
        datos.add(new Lista_Entrada_Exp("ISBAN", "Desarrollo, implantación y mantenimiento de aplicación bancaria propia del Banco Santander. Desarrollo a medida en VS 2008.NET."));
        datos.add(new Lista_Entrada_Exp("ITP", "Desarrollo e implantación de un buscador avanzado en base al estandar de SharePoint. Desarrollo a medida en VS 2008.NET y MOSS 2007 y correspondiente migración a VS 2010 y MOSS 2010."));
        datos.add(new Lista_Entrada_Exp("Randstad", "Desarrollo e implantación de agente para migración de lista de usuarios dados de alta en SQL 2005 a Directorio Activo mediante las propiedades de LDAP . Desarrollo a medida en VS 2008.NET y C#."));
        datos.add(new Lista_Entrada_Exp("Randstad", "Desarrollo e implantación de agente para migración de los usuarios dados de alta en el Directorio Activo al perfil de usuarios de SharePoint. Desarrollo a medida en VS 2010.NET, C# y MOSS 2010."));
        datos.add(new Lista_Entrada_Exp("Banco Popular", "Desarrollo e implantación del portal  de Aliseda encargado de la gestión de los inmuebles pertenecientes al Banco Popular. Desarrollo a medida en VS 2008.NET, C# y MOSS 2007."));
        datos.add(new Lista_Entrada_Exp("AENA", "Servicio AM de Tecnologías de S.I. Corporativos de AENA. Desarrollo en VS 2008.NET y Microsoft Enterprise Project Management 2007."));
        datos.add(new Lista_Entrada_Exp("ENRESA", "Diseño, desarrollo e implantación del Sistema de Gestión de Desmantelamiento del Portal de Enresa. Desarrollo en VS 2008.NET y Microsoft Enterprise Project Management 2007."));
        datos.add(new Lista_Entrada_Exp("Gas Natural", "Desarrollo e implantación de la intranet de Gas Natural. Desarrollo a medida en VS 2008.NET y MOSS 2007."));

        ListView lista = (ListView) findViewById(R.id.microsoft_list_exp);
        lista.setAdapter(new Lista_adaptador(this, R.layout.lista_detalle_exp, datos){
            @Override
            public void onEntrada(Object entrada, View view) {
                TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior);
                texto_superior_entrada.setText(((Lista_Entrada_Exp) entrada).get_textoEncima());

                TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior);
                texto_inferior_entrada.setText(((Lista_Entrada_Exp) entrada).get_textoDebajo());

            }
        });






        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Muestro oculto el boton
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

//        final Animation slideUpIn = AnimationUtils.loadAnimation(Microsoft.this, R.anim.rotate);
//        fab.startAnimation(slideUpIn);
        fab.setImageResource(R.drawable.mobile_menu_close2);

        fab.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.LOLLIPOP)
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "Se presionó el FAB", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                finish();
                overridePendingTransition(R.anim.right_in, R.anim.right_out);
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
}
