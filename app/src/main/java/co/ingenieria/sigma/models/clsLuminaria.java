package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsLuminaria {

    private String lum_codigo;
    private String apo_codigo;
    private String cir_codigo;
    private String lum_protec;
    private String lum_conect;
    private String lum_estbom;
    private String lum_estlum;
    private String lum_fotoce;
    private String lum_usu;
    private String lum_tipbra;
    private String lum_observ;

    public clsLuminaria(String apo_codigo, String cir_codigo, String lum_codigo, String lum_protec, String lum_estbom,
                        String lum_conect, String lum_estlum, String lum_fotoce, String lum_usu, String lum_tipbra,
                        String lum_observ) {
        this.apo_codigo = apo_codigo;
        this.cir_codigo = cir_codigo;
        this.lum_codigo = lum_codigo;
        this.lum_protec = lum_protec;
        this.lum_estbom = lum_estbom;
        this.lum_conect = lum_conect;
        this.lum_estlum = lum_estlum;
        this.lum_fotoce = lum_fotoce;
        this.lum_usu = lum_usu;
        this.lum_tipbra = lum_tipbra;
        this.lum_observ = lum_observ;
    }

    public String getApo_codigo() {
        return apo_codigo;
    }

    public String getCir_codigo() {
        return cir_codigo;
    }

    public String getLum_codigo() {
        return lum_codigo;
    }

    public String getLum_conect() {
        return lum_conect;
    }

    public String getLum_estbom() {
        return lum_estbom;
    }

    public String getLum_estlum() {
        return lum_estlum;
    }

    public String getLum_fotoce() {
        return lum_fotoce;
    }

    public String getLum_observ() {
        return lum_observ;
    }

    public String getLum_protec() {
        return lum_protec;
    }

    public String getLum_tipbra() {
        return lum_tipbra;
    }

    public String getLum_usu() {
        return lum_usu;
    }
}
