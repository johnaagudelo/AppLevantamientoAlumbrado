package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsTransformador {

    private String tra_codigo;
    private String apo_codigo;
    private String tra_etique;
    private String tra_capkva;
    private String tra_volpri;
    private String tra_volseg;
    private String tra_numfac;
    private String tra_tipmen;
    private String tra_usu;
    private String tra_fotcon;
    private String tra_lintie;
    private String tra_marca;

    public clsTransformador(String tra_codigo,String apo_codigo, String tra_etique, String tra_capkva, String tra_volpri,
                            String tra_volseg, String tra_numfac, String tra_tipmen, String tra_usu, String tra_fotcon,
                            String tra_lintie, String tra_marca){
        this.tra_codigo = tra_codigo;
        this.apo_codigo = apo_codigo;
        this.tra_etique = tra_etique;
        this.tra_capkva = tra_capkva;
        this.tra_volpri = tra_volpri;
        this.tra_volseg = tra_volseg;
        this.tra_numfac = tra_numfac;
        this.tra_tipmen = tra_tipmen;
        this.tra_usu = tra_usu;
        this.tra_fotcon = tra_fotcon;
        this.tra_lintie = tra_lintie;
        this.tra_marca = tra_marca;
    }

    public String getApo_codigo() {
        return apo_codigo;
    }

    public String getTra_capkva() {
        return tra_capkva;
    }

    public String getTra_codigo() {
        return tra_codigo;
    }

    public String getTra_etique() {
        return tra_etique;
    }

    public String getTra_fotcon() {
        return tra_fotcon;
    }

    public String getTra_lintie() {
        return tra_lintie;
    }

    public String getTra_marca() {
        return tra_marca;
    }

    public String getTra_numfac() {
        return tra_numfac;
    }

    public String getTra_tipmen() {
        return tra_tipmen;
    }

    public String getTra_usu() {
        return tra_usu;
    }

    public String getTra_volpri() {
        return tra_volpri;
    }

    public String getTra_volseg() {
        return tra_volseg;
    }

}



