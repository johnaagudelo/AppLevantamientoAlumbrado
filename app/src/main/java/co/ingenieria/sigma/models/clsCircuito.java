package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsCircuito {

    private String cir_codigo;
    private String tra_codigo;

    public clsCircuito(String cir_codigo, String tra_codigo) {
        this.cir_codigo = cir_codigo;
        this.tra_codigo = tra_codigo;
    }

    public String getCir_codigo() {
        return cir_codigo;
    }

    public String getTra_codigo() {
        return tra_codigo;
    }
}
