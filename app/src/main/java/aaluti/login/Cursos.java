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
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Cursos extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cursos);
        getSupportActionBar().setTitle(R.string.tx_cursos);
        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        //Relleno Array Info

        ArrayList<Lista_Entrada> datos = new ArrayList<Lista_Entrada>();

        datos.add(new Lista_Entrada(R.drawable.lapiz, "Metodología de Ciclo de SW ", "Impartido por ISBAN, enero 2013", 1));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "Arquitectura funcional y técnica", "Impartido por ISBAN, enero 2013", 2));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "Arquitectura funcional I ", "Impartido por ISBAN, bloque de certificación, enero 2014", 3));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "Curso básico de Marketing Digital ", "Impartido por EOI, Escuela de Organización Industrial, noviembre 2015", 4));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "Curso de analítica web", "Impartido por EOI, Escuela de Organización Industrial, diciembre 2015", 5));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "Curso de programación de apps móviles", "Impartido por Universidad Complutense de Madrid, enero 2016",6));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "SCRUM", "Impartido por ALTRAN, 18h, mayo 2016",7));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "MOOC Procesos de prueba ISTQB", "Impartido por Altran, 21h, mayo 2016", 8));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "[NoSQL] MongoDB", "Impartido por Altran, 16h, junio 2016", 9));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "MOOC-Android básico", "Impartido por Altran, 13h, Junio 2016", 10));
        datos.add(new Lista_Entrada(R.drawable.lapiz, "Frameworks(It Desarrollo Software Java)", "Impartido por Altran, 20h, Julio 2016", 11));

        ListView lista = (ListView) findViewById(R.id.cursos_list);
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

            CharSequence texto = elegido.get_textoDebajo();
            Toast toast = Toast.makeText(Cursos.this, texto, Toast.LENGTH_LONG);
            toast.show();


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
