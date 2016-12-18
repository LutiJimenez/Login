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
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class SqlServer extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql_server);
        getSupportActionBar().setTitle(R.string.tx_sql);
        //Relleno Array Info

        ArrayList<Lista_Entrada_Exp> datos = new ArrayList<Lista_Entrada_Exp>();

        datos.add(new Lista_Entrada_Exp("ISBAN", "Desarrollo, implantación y mantenimiento de la Base de datos de aplicación bancaria propia del Banco Santander (NILO), SQL Server 2005."));
        datos.add(new Lista_Entrada_Exp("ISBAN", "Desarrollo, implantación y mantenimiento de la Base de datos de aplicación bancaria propia del Banco Santander (Bibliote de Informes), SQL Server 2008."));
        datos.add(new Lista_Entrada_Exp("Randstad", "Desarrollo e implantación de agente para migración de lista de usuarios dados de alta en SQL 2005 a Directorio Activo mediante las propiedades de LDAP . Desarrollo a medida en VS 2008.NET y C#."));


        ListView lista = (ListView) findViewById(R.id.sql_list_exp);
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
