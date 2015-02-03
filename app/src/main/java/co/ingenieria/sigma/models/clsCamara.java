package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsCamara extends clsElemento{

    private String cam_codigo;
    private String cam_tapa;
    private String cam_diatap;
    private String cam_diacam;
    private String cam_config;
    private String cam_observ;

    public clsCamara(String ele_codigo, String ele_latutu, String ele_logitu, String ele_direcc,String cam_codigo,
                     String cam_tapa, String cam_diatap, String cam_diacam, String cam_config, String cam_observ){
        super(ele_codigo, ele_latutu, ele_logitu, ele_direcc);
        this.cam_codigo = cam_codigo;
        this.cam_tapa = cam_tapa;
        this.cam_diatap = cam_diatap;
        this.cam_diacam = cam_diacam;
        this.cam_config = cam_config;
        this.cam_observ = cam_observ;

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

}
