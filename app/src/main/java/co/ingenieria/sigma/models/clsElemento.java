package co.ingenieria.sigma.models;

/**
 * Clase elemento donde se almacena la ubicacion del elemento a levantar
 * Created by John Agudelo on 03/02/2015.
 */
public class clsElemento{

    private String ele_codigo;
    private String ele_longit;
    private String ele_latitu;
    private String ele_direcc;

    public clsElemento(String ele_codigo, String ele_longit, String ele_latitu,String ele_direcc){
        this.ele_codigo =ele_codigo;
        this.ele_latitu = ele_latitu;
        this.ele_longit = ele_longit;
        this.ele_direcc = ele_direcc;
    }

    public String getEle_codigo() {
        return ele_codigo;
    }

    public String getEle_latitu() {
        return ele_latitu;
    }

    public String getEle_direcc() {
        return ele_direcc;
    }

    public String getEle_longit() {
        return ele_longit;
    }
}
