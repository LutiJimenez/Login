package aaluti.login;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.DrawableRes;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

public class SobreMi extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sobre_mi);
        getSupportActionBar().setTitle(R.string.action_about);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.loginfaqs, menu);
        //menu.getItem(0).setIcon(getResources().getDrawable(R.drawable.menu_item,null));
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
    }

    public void mail(View v) {
        // Reemplazamos el email por algun otro real
        String[] to = {"lutgardo1983@hotmail.com"};
        String[] cc = {};
        enviar(to, cc, "Hola",
                "Esto es un email enviado desde una app de Android");
    }

    private void enviar(String[] to, String[] cc,
                        String asunto, String mensaje) {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        //String[] to = direccionesEmail;
        //String[] cc = copias;
        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_CC, cc);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, asunto);
        emailIntent.putExtra(Intent.EXTRA_TEXT, mensaje);
        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
    }

    public void exper(View v) {
        switch (v.getId()) {
            case R.id.experiencia_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                Intent myIntent = new Intent(getApplicationContext(), Log_In.class);
                startActivity(myIntent); // Cambio de aplicación

        }
    }

    public void linkedin(View v) {
        switch (v.getId()) {
            case R.id.lin_button:
                Uri uri = Uri.parse("https://www.linkedin.com/in/lutgardo-jimenez-gomez");
                Intent intent = new Intent(Intent.ACTION_VIEW, uri);
                startActivity(intent);

        }
    }

    public void telefono(View v) {
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:699221787"));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        startActivity(intent);
    }
    public void masinfo(View v) {
        switch (v.getId()) {
            case R.id.mas_button://Si el id del botón pulsado se corresponde con el id que tenemos aquí entraría dentro del case.
                //Aquí va el código que se va a ejecutar cuando se pulse el botón.
                Intent myIntent = new Intent(getApplicationContext(), Detalle.class);
                startActivity(myIntent); // Cambio de aplicación

        }
    }
}
