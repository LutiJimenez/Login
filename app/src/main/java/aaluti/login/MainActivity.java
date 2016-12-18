package aaluti.login;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaPlayer;
import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Cursor fila;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //login(); //funcion de logueo
        //ingresar();

        ImageView img = (ImageView) findViewById(R.id.ysabel_logo);
        final Animation slideUpIn = AnimationUtils.loadAnimation(MainActivity.this, R.anim.fade_in);
        assert img != null;
        img.startAnimation(slideUpIn);
    }

//    @NonNull
//    @SuppressWarnings({"NullableProblems"})
//    public void login() {
//
//        Button Login = (Button) findViewById(R.id.btnLogin);
//        assert Login != null;
//        Login.setOnClickListener (new View.OnClickListener() {
//
//            @Override
//            public void onClick(View view) {
//                EditText user=(EditText) findViewById(R.id.room);
//                String usuario = user.getText().toString();
//                EditText pass=(EditText) findViewById(R.id.pass);
//                TextView bad = (TextView) findViewById(R.id.badLog);
//                String password = pass.getText().toString();
//                String user_stored="admin";
//                String pass_stored="admin";
//
//                if(usuario.equals(user_stored) && password.equals(pass_stored)){
//                    change_activity();
//                }
//
//                else {
//                    Toast.makeText(getApplicationContext(), "Login Erroneo", Toast.LENGTH_SHORT).show();
//
//
//                }
//            }
//
//        });
//    }

    public void login2(View v) {

        if (v.getId() == R.id.login_button) {
            EditText user = (EditText) findViewById(R.id.room);
            String usuario = user.getText().toString();
            EditText pass = (EditText) findViewById(R.id.pass);
            TextView bad = (TextView) findViewById(R.id.badLog);
            String password = pass.getText().toString();
            String user_stored = "admin";
            String pass_stored = "admin";

            if (usuario.equals(user_stored) && password.equals(pass_stored)) {
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(this,R.raw.cancion);
                //mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();
                change_activity();

            } else {
                Toast.makeText(getApplicationContext(), "Login Erroneo", Toast.LENGTH_SHORT).show();
                MediaPlayer mediaPlayer;
                mediaPlayer = MediaPlayer.create(this,R.raw.pacman_muerte);
                //mediaPlayer.setLooping(true);
                mediaPlayer.setVolume(100,100);
                mediaPlayer.start();


            }
        }
    }

    public void change_activity () {
        Intent myIntent = new Intent(getApplicationContext(),SobreMi.class);
        startActivity(myIntent); // Cambio de aplicación
    }



    //metodo de ingreso
    public void ingresar(){
        DBHelper admin=new DBHelper(this,"instituto",null,1);
        SQLiteDatabase db=admin.getWritableDatabase();

        EditText user=(EditText) findViewById(R.id.room);
        String usuario = user.getText().toString();
        EditText pas=(EditText) findViewById(R.id.pass);
        String password = pas.getText().toString();

        fila=db.rawQuery("select usuario,contrasena from usuarios where usuario='"+usuario+"' and contrasena='"+ password +"'",null);
                //preguntamos si el cursor tiene algun valor almacenado
        if(fila.moveToFirst()==true){

            //capturamos los valores del cursos y lo almacenamos en variable
            String usua=fila.getString(0);
            String pass=fila.getString(1);

            //preguntamos si los datos ingresados son iguales
            if (usuario.equals(usua)&&password.equals(pass)){

                //si son iguales entonces vamos a otra ventana

                //Menu es una nueva actividad empty
                Intent myIntent = new Intent(getApplicationContext(),Log_In.class);
                startActivity(myIntent); // Cambio de aplicación

                //limpiamos las las cajas de texto
                user.setText("");
                pas.setText("");
            }

        }
    }
    public void salir(View v){
        finish();
        //System.exit(0);
    }


}
