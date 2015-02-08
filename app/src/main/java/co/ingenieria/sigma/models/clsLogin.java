package co.ingenieria.sigma.models;

/**
 * clase de login del app de levantamiento
 * Created by John Agudelo on 03/02/2015.
 */
public class clsLogin {

    private String usuario;
    private String pass;

    public clsLogin(String usu,String pass){
        this.usuario = usu;
        this.pass = pass;
    }

    public String getPass() {
        return pass;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }
}
