package co.ingenieria.sigma.applevantamiento;


import android.app.Activity;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.ConnectivityManager;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import co.ingenieria.sigma.models.clsLogin;
import co.ingenieria.sigma.util.clsServicio;
import co.ingenieria.sigma.util.clsUtilidades;


public class LoginActivity extends ActionBarActivity {

    private static String USUARIO = "johnaagudelo";
    private static String PASS = "123";
    private SharedPreferences splogin;
    private EditText edi_usuario;
    private EditText edi_pass;
    private AlertDialog.Builder alert;
    private ProgressDialog progress;
    private clsServicio servicio;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_login);
        servicio = new clsServicio();
        progress = new ProgressDialog(this);
        SharedPreferences splogin = getSharedPreferences("Login_Usuario", Context.MODE_PRIVATE);
        edi_usuario = (EditText) findViewById(R.id.usu);
        edi_pass = (EditText) findViewById(R.id.clave);
    }

    /*@Override
    protected void onResume(){
        super.onResume();

     if(this.splogin.getString("usuario", null) != null && !this.splogin.getString("clave", null).equals(""))
        {
            Intent intent = new Intent(getApplicationContext(), PrincipalActivity.class);
            startActivity(intent);
        }
    }*/

    public void login(View view){
        if(hayInternet()) {
            if (!edi_usuario.getText().toString().isEmpty() || !edi_pass.getText().toString().isEmpty()) {
                clsLogin datosLogueo = new clsLogin(edi_usuario.getText().toString(),edi_pass.getText().toString());
                new clsAsincTaskLogueo().execute(datosLogueo);
            } else {
                clsUtilidades.mostrarAlerta(this, getResources().getString(R.string.msn_datosLogin));
            }
        }else{
            clsUtilidades.mostrarAlerta(this, getResources().getString(R.string.msn_conexionInternet));
        }
    }

   private boolean hayInternet() {
        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isAvailable()
                && cm.getActiveNetworkInfo().isConnected()) {
            return true;
        } else {
            return false;
        }
    }

    public class clsAsincTaskLogueo extends AsyncTask<clsLogin, Void, Boolean>{

        @Override
        protected void onPreExecute() {
            progress.setTitle(getResources().getString(R.string.msn_titleLogin));
            progress.setMessage(getResources().getString(R.string.msn_mensajeLogin));
            progress.setCancelable(true);
            progress.show();
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(clsLogin... params) {
            //Construimos los datos de login formato JSON
            JSONObject datoLogin = new JSONObject();
            try {
                datoLogin.put("Usuario", params[0].getUsuario());
                datoLogin.put("pass", Integer.parseInt(params[0].getPass()));
                servicio.conectar(datoLogin.toString());
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(Boolean respuesta) {
            progress.dismiss();
            try {
                if (edi_usuario.getText().toString().equals(USUARIO) && edi_pass.getText().toString().equals(PASS)) {

                    SharedPreferences.Editor editor = splogin.edit();
                    editor.putString("usuario", edi_usuario.getText().toString());
                    editor.putString("clave", edi_pass.getText().toString());
                    editor.commit();

                    Intent abrirActividadPrincipal = new Intent(getApplicationContext(), PrincipalActivity.class);
                    startActivity(abrirActividadPrincipal);
                } else {
                    clsUtilidades.mostrarAlerta((Activity)getApplicationContext(), getResources().getString(R.string.msn_errorLogin));
                }
            }catch (Exception e) {
                e.printStackTrace();
            }
        }

    }


}
