package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsCamara{

    private String cam_codigo;
    private String cam_tapa;
    private String cam_diatap;
    private String cam_diacam;
    private String cam_config;
    private String cam_observ;

    public clsCamara() {
    }

    public String getCam_codigo() {
        return cam_codigo;
    }

    public String getCam_config() {
        return cam_config;
    }

    public String getCam_diacam() {
        return cam_diacam;
    }

    public String getCam_diatap() {
        return cam_diatap;
    }

    public String getCam_observ() {
        return cam_observ;
    }

    public String getCam_tapa() {
        return cam_tapa;
    }

    public void setCam_codigo(String cam_codigo) {
        this.cam_codigo = cam_codigo;
    }

    public void setCam_tapa(String cam_tapa) {
        this.cam_tapa = cam_tapa;
    }

    public void setCam_diatap(String cam_diatap) {
        this.cam_diatap = cam_diatap;
    }

    public void setCam_diacam(String cam_diacam) {
        this.cam_diacam = cam_diacam;
    }

    public void setCam_config(String cam_config) {
        this.cam_config = cam_config;
    }

    public void setCam_observ(String cam_observ) {
        this.cam_observ = cam_observ;
    }
}
