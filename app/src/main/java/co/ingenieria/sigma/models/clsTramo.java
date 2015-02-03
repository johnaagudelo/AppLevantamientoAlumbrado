package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsTramo {

    private String trm_apoini;
    private String trm_apofin;
    private String cir_codigo;
    private String trm_congig;
    private String trm_clase;
    private String trm_conduc;
    private String trm_distan;
    private String trm_estado;
    private String trm_observ;

    public clsTramo(String trm_apoini, String trm_apofin, String cir_codigo, String trm_congig, String trm_clase, String trm_conduc,
                    String trm_distan, String trm_estado, String trm_observ) {
        this.trm_apoini = trm_apoini;
        this.trm_apofin = trm_apofin;
        this.cir_codigo = cir_codigo;
        this.trm_congig = trm_congig;
        this.trm_clase = trm_clase;
        this.trm_conduc = trm_conduc;
        this.trm_distan = trm_distan;
        this.trm_estado = trm_estado;
        this.trm_observ = trm_observ;
    }

    public String getTrm_apoini() {
        return trm_apoini;
    }

    public String getTrm_apofin() {
        return trm_apofin;
    }

    public String getCir_codigo() {
        return cir_codigo;
    }

    public String getTrm_congig() {
        return trm_congig;
    }

    public String getTrm_clase() {
        return trm_clase;
    }

    public String getTrm_conduc() {
        return trm_conduc;
    }

    public String getTrm_distan() {
        return trm_distan;
    }

    public String getTrm_estado() {
        return trm_estado;
    }

    public String getTrm_observ() {
        return trm_observ;
    }
}
