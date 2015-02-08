package co.ingenieria.sigma.applevantamiento;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import co.ingenieria.sigma.models.clsLogin;


public class LoginActivity extends ActionBarActivity {

    private static String usuario = "johnaagudelo";
    private static String pass = "123";
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
        if(edi_usuario.getText().equals("")) {
            if(edi_pass.getText().equals("")) {
                if (edi_usuario.getText().equals(usuario) && edi_pass.getText().equals(pass)) {
                    SharedPreferences login = getSharedPreferences("Login_Usuario", Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor = login.edit();
                    editor.putString("usuario", edi_usuario.getText().toString());
                    editor.putString("clave", edi_pass.getText().toString());
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
