package co.ingenieria.sigma.applevantamiento;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.ingenieria.sigma.models.clsLogin;


public class LoginActivity extends ActionBarActivity {

    static String USUARIO = "johnaagudelo";
    static String PASS = "123";
    EditText edi_usuario;
    EditText edi_pass;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        edi_usuario = (EditText) findViewById(R.id.usu);
        edi_pass = (EditText) findViewById(R.id.clave);
    }

    public void login(View view){
        if(!edi_usuario.getText().toString().isEmpty()) {
            if(!edi_pass.getText().toString().isEmpty()) {
                if (edi_usuario.getText().toString().equals(USUARIO) && edi_pass.getText().toString().equals(PASS)) {
                    SharedPreferences login = getSharedPreferences("Login_Usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = login.edit();
                    editor.putString("usuario", edi_usuario.getText().toString());
                    editor.putString("clave", edi_pass.getText().toString());
                    editor.commit();

                    Intent abrirActividadPrincipal = new Intent(this, PrincipalActivity.class);
                    startActivity(abrirActividadPrincipal);
                } else {
                    Toast.makeText(this, "Usuario Incorrecto", Toast.LENGTH_LONG).show();
                }
            }else{
                Toast.makeText(this, "Ingrese la contraseña", Toast.LENGTH_LONG).show();
            }
        }else{
            Toast.makeText(this, "Ingrese el Usuario", Toast.LENGTH_LONG).show();
        }
    }

    public class clsAsincTask extends AsyncTask<clsLogin, Void, Void>{

        @Override
        protected Void doInBackground(clsLogin... params) {
            return null;
        }
    }


}
