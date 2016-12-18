package aaluti.login;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.widget.ImageView;

//import com.bumptech.glide.Glide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Detalle extends AppCompatActivity {

    public static final String EXTRA_PARAM_ID = "com.herprogramacion.coches2015.extra.ID";
    public static final String VIEW_NAME_HEADER_IMAGE = "imagen_compartida";
    private dibujos itemDetallado;
    private ImageView imagenExtendida;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle);
        getSupportActionBar().setTitle(R.string.tx_DiseñosDet);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //usarToolbar();

        // Obtener el coche con el identificador establecido en la actividad principal
        itemDetallado = dibujos.getItem(getIntent().getIntExtra(EXTRA_PARAM_ID, 0));

        imagenExtendida = (ImageView) findViewById(R.id.imagen_extendida);
        imagenExtendida.setImageResource(itemDetallado.getIdDrawable());
        //cargarImagenExtendida();
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
    }

//    private void cargarImagenExtendida() {
//        Glide.with(imagenExtendida.getContext())
//                .load(itemDetallado.getIdDrawable())
//                .into(imagenExtendida);
//    }

/*    private void usarToolbar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }*/
}
