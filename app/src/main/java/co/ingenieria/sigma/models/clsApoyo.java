package co.ingenieria.sigma.models;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class clsApoyo extends clsElemento{

    private String apo_codigo;
    private String apo_reteni;
    private String apo_ubicac;
    private String apo_estado;
    private String apo_tipo;
    private String apo_config;
    private String apo_marca;
    private String apo_carga;
    private String apo_base;
    private String apo_canast;
    private String apo_materi;
    private String apo_altura;

    public clsApoyo(String ele_codigo, String ele_longit, String ele_latitu, String ele_direcc, String apo_codigo, String apo_reteni,
                    String apo_ubicac, String apo_estado, String apo_tipo, String apo_config, String apo_marca, String apo_carga,
                    String apo_base,String apo_canast,String apo_materi, String apo_altura) {
        super(ele_codigo, ele_longit, ele_latitu, ele_direcc);
        this.apo_codigo = apo_codigo;
        this.apo_reteni = apo_reteni;
        this.apo_ubicac = apo_ubicac;
        this.apo_estado = apo_estado;
        this.apo_tipo = apo_tipo;
        this.apo_config = apo_config;
        this.apo_marca = apo_marca;
        this.apo_carga = apo_carga;
        this.apo_base = apo_base;
        this.apo_canast = apo_canast;
        this.apo_materi = apo_materi;
        this.apo_altura = apo_altura;
    }


    public String getApo_altura() {
        return apo_altura;
    }

    public String getApo_base() {
        return apo_base;
    }

    public String getApo_canast() {
        return apo_canast;
    }

    public String getApo_carga() {
        return apo_carga;
    }

    public String getApo_codigo() {
        return apo_codigo;
    }

    public String getApo_config() {
        return apo_config;
    }

    public String getApo_estado() {
        return apo_estado;
    }

    public String getApo_marca() {
        return apo_marca;
    }

    public String getApo_materi() {
        return apo_materi;
    }

    public String getApo_reteni() {
        return apo_reteni;
    }

    public String getApo_tipo() {
        return apo_tipo;
    }

    public String getApo_ubicac() {
        return apo_ubicac;
    }

}
