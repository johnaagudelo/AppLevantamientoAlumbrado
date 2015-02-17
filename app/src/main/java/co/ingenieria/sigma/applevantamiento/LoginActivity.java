package co.ingenieria.sigma.applevantamiento;


import android.app.AlertDialog;
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

import co.ingenieria.sigma.models.clsLogin;
import co.ingenieria.sigma.util.clsUtilidades;


public class LoginActivity extends ActionBarActivity {

    private static String USUARIO = "johnaagudelo";
    private static String PASS = "123";
    private SharedPreferences splogin;
    private EditText edi_usuario;
    private EditText edi_pass;
    private AlertDialog.Builder alert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences splogin = getSharedPreferences("Login_Usuario", Context.MODE_PRIVATE);
        edi_usuario = (EditText) findViewById(R.id.usu);
        edi_pass = (EditText) findViewById(R.id.clave);
    }

    /*@Override
    protected void onResume() {
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
                if (edi_usuario.getText().toString().equals(USUARIO) && edi_pass.getText().toString().equals(PASS)) {

                    SharedPreferences.Editor editor = splogin.edit();
                    editor.putString("usuario", edi_usuario.getText().toString());
                    editor.putString("clave", edi_pass.getText().toString());
                    editor.commit();

                    Intent abrirActividadPrincipal = new Intent(this, PrincipalActivity.class);
                    startActivity(abrirActividadPrincipal);
                } else {
                    clsUtilidades.mostrarAlerta(this, getResources().getString(R.string.msn_errorLogin));
                }
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

    public class clsAsincTask extends AsyncTask<clsLogin, Void, Void>{

        @Override
        protected Void doInBackground(clsLogin... params) {

            return null;
        }

    }


}
