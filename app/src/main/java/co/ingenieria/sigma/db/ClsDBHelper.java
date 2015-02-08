package co.ingenieria.sigma.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.provider.BaseColumns;

/**
 * Created by John Agudelo on 03/02/2015.
 */
public class ClsDBHelper extends SQLiteOpenHelper {

    public ClsDBHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
    }

    public static final String TAG = ClsDBHelper.class.getSimpleName();

    //Definicion de la base de datos
    public static final String DB_NAME = "levantamiento.db";
    public static final int DB_VERSION = 1;

    //definicion de la tabla elemento con sus columnas e indices
    public static final String TABLE_ELEMENTO = "t_elemento";
    public static final String C_ELE_CODIGO = "ele_codigo";
    public static final String C_ELE_LATITUD = "ele_latitu";
    public static final String C_ELE_LONGITUD = "ele_longit";
    public static final String C_ELE_DIRECCION = "ele_direcc";
    public static final String C_ELE_ESTADO_SINCRONIZACION= "ele_estsin";

    public static final int C_ELE_CODIGO_INDEX = 0;
    public static final int C_ELE_LATITUD_INDEX = 1;
    public static final int C_ELE_LONGITUD_INDEX = 2;
    public static final int C_ELE_DIRECCION_INDEX = 3;
    public static final int C_ELE_ESTADO_SINCRONIZACION_INDEX = 4;

    //definicion de la tabla Apoyo con sus columnas e indices
    public static final String TABLE_APOYO = "t_apoyo";
    public static final String C_APO_ELE_CODIGO = "ele_codigo";
    public static final String C_APO_CODIGO = "apo_codigo";
    public static final String C_APO_RETENIDA = "apo_reteni";
    public static final String C_APO_UBICACION = "apo_ubica";
    public static final String C_APO_ESTADO = "apo_estado";
    public static final String C_APO_TIPO = "apo_tipo";
    public static final String C_APO_CONFIGURACION = "apo_config";
    public static final String C_APO_MARCA = "apo_marca";
    public static final String C_APO_CARGA = "apo_carga";
    public static final String C_APO_BASE = "apo_base";
    public static final String C_APO_CANASTA = "apo_canast";
    public static final String C_APO_MATERIAL = "apo_materi";
    public static final String C_APO_ALTURA = "apo_altura";
    public static final String C_APO_ESTADO_SINCRONIZACION= "apo_estsin";

    public static final int C_APO_ELE_CODIGO_INDEX = 0 ;
    public static final int C_APO_CODIGO_INDEX = 1;
    public static final int C_APO_RETENIDA_INDEX = 2;
    public static final int C_APO_UBICACION_INDEX = 3;
    public static final int C_APO_ESTADO_INDEX = 4;
    public static final int C_APO_TIPO_INDEX = 5;
    public static final int C_APO_CONFIGURACION_INDEX = 6;
    public static final int C_APO_MARCA_INDEX = 7;
    public static final int C_APO_CARGA_INDEX = 8;
    public static final int C_APO_BASE_INDEX = 9;
    public static final int C_APO_CANASTA_INDEX = 10;
    public static final int C_APO_MATERIAL_INDEX = 11;
    public static final int C_APO_ALTURA_INDEX = 12;
    public static final int C_APO_ESTADO_SINCRONIZACION_INDEX = 13;

    //definicion de la tabla Transformador con sus columnas e indices
    public static final String TABLE_TRANSFORMADOR = "t_transformador";
    public static final String C_TRA_APO_CODIGO = "apo_codigo";
    public static final String C_TRA_CODIGO = "tra_codigo";
    public static final String C_TRA_ETIQUETA = "tra_etique";
    public static final String C_TRA_CAPACIDAD_KVA = "tra_capkva";
    public static final String C_TRA_VOLTAJE_PRIMARIO = "tra_volpri";
    public static final String C_TRA_VOLTAJE_SECUNDARIO = "tra_volseg";
    public static final String C_TRA_NUMERO_FASES = "tra_numfac";
    public static final String C_TRA_TIPO_MONTAJE = "tra_tipmon";
    public static final String C_TRA_USO = "tra_uso";
    public static final String C_TRA_FOTO_CONTROL = "tra_fotcon";
    public static final String C_TRA_LINEA_TIERRA = "tra_lintie";
    public static final String C_TRA_MARCA = "tra_marca";
    public static final String C_TRA_ESTADO_SINCRONIZACION= "tra_estsinc";

    public static final int C_TRA_APO_CODIGO_INDEX = 0;
    public static final int C_TRA_CODIGO_INDEX = 1;
    public static final int C_TRA_ETIQUETA_INDEX = 2;
    public static final int C_TRA_CAPACIDAD_KVA_INDEX = 3;
    public static final int C_TRA_VOLTAJE_PRIMARIO_INDEX = 4;
    public static final int C_TRA_VOLTAJE_SECUNDARIO_INDEX = 5;
    public static final int C_TRA_NUMERO_FASES_INDEX = 6;
    public static final int C_TRA_TIPO_MONTAJE_INDEX = 7;
    public static final int C_TRA_USO_INDEX = 8;
    public static final int C_TRA_FOTO_CONTROL_INDEX = 9;
    public static final int C_TRA_LINEA_TIERRA_INDEX = 10;
    public static final int C_TRA_MARCA_INDEX = 11;
    public static final int C_TRA_ESTADO_SINCRONIZACION_INDEX = 12;

    //definicion de la tabla Camara con sus columnas e indices
    public static final String TABLE_CAMARA = "t_camara";
    public static final String C_CAM_ELE_CODIGO = "ele_codigo";
    public static final String C_CAM_CODIGO = "cam_codigo";
    public static final String C_CAM_TAPA = "cam_tapa";
    public static final String C_CAM_DIAMETRO_TAPA = "cam_diatap";
    public static final String C_CAM_DIAMETRO_CAMARA = "cam_diacam";
    public static final String C_CAM_CONFIGURACION = "cam_config";
    public static final String C_CAM_OBSERVACIONES = "cam_observ";
    public static final String C_CAM_ESTADO_SINCRONIZACION= "cam_estsinc";

    public static final int C_CAM_ELE_CODIGO_INDEX = 0;
    public static final int C_CAM_CODIGO_INDEX = 1;
    public static final int C_CAM_TAPA_INDEX = 2;
    public static final int C_CAM_DIAMETRO_TAPA_INDEX = 3;
    public static final int C_CAM_DIAMETRO_CAMARA_INDEX = 4;
    public static final int C_CAM_CONFIGURACION_INDEX = 5;
    public static final int C_CAM_OBSERVACIONES_INDEX = 6;
    public static final int C_CAM_ESTADO_SINCRONIZACION_INDEX = 7;

    //definicion de la tabla Luminaria con sus columnas e indices
    public static final String TABLE_LUMINARIA = "t_luminaria";
    public static final String C_LUM_CODIGO = "ele_codigo";
    public static final String C_LUM_APO_CODIGO = "apo_codigo";
    public static final String C_LUM_CIR_CODIGO = "cir_codigo";
    public static final String C_LUM_PROTECCION = "lum_protec";
    public static final String C_LUM_CONECTOR = "lum_conect";
    public static final String C_LUM_ESTADO_BOMBILLO = "lum_estbom";
    public static final String C_LUM_ESTADO_LUMINARIA = "lum_estlum";
    public static final String C_LUM_FOTOCELDA = "lum_fotoce";
    public static final String C_LUM_USO = "lum_uso";
    public static final String C_LUM_TIPO_BRAZO = "lum_tipbra";
    public static final String C_LUM_OBSERVACIONES = "lum_observ";
    public static final String C_LUM_ESTADO_SINCRONIZACION= "lum_estsinc";

    public static final int C_LUM_CODIGO_INDEX = 0;
    public static final int C_LUM_APO_CODIGO_INDEX = 1;
    public static final int C_LUM_CIR_CODIGO_INDEX = 2;
    public static final int C_LUM_PROTECCION_INDEX = 3;
    public static final int C_LUM_CONECTOR_INDEX = 4;
    public static final int C_LUM_ESTADO_BOMBILLO_INDEX = 5;
    public static final int C_LUM_ESTADO_LUMINARIA_INDEX = 6;
    public static final int C_LUM_FOTOCELDA_INDEX = 7;
    public static final int C_LUM_USO_INDEX = 8;
    public static final int C_LUM_TIPO_BRAZO_INDEX = 9;
    public static final int C_LUM_OBSERVACIONES_INDEX = 10;
    public static final int C_LUM_ESTADO_SINCRONIZACION_INDEX = 11;

    //definicion de la tabla Luminaria con sus columnas e indices
    public static final String TABLE_CIRCUITO = "t_circuito";
    public static final String C_CIR_CODIGO = "cir_codigo";
    public static final String C_CIR_TRA_CODIGO = "tra_codigo";
    public static final String C_CIR_ESTADO_SINCRONIZACION= "cir_estsinc";

    public static final int C_CIR_CODIGO_INDEX = 0;
    public static final int C_CIR_TRA_CODIGO_INDEX = 1;
    public static final int C_CIR_ESTADO_SINCRONIZACION_INDEX = 2;

    //definicion de la tabla Tramo con sus columnas e indices
    public static final String TABLE_TRAMO = "t_tramo";
    public static final String C_TRM_CIR_CODIGO = "cir_codigo";
    public static final String C_TRM_APOYO_INICIAL = "trm_apoini";
    public static final String C_TRM_APOYO_FINAL = "trm_apofin";
    public static final String C_TRM_CONFIGURACION = "trm_config";
    public static final String C_TRM_CLASE = "trm_clase";
    public static final String C_TRM_CONDUCTOR = "trm_conduc";
    public static final String C_TRM_DISTANCIA = "trm_distan";
    public static final String C_TRM_ESTADO = "trm_estado";
    public static final String C_TRM_OBSERVACIONES = "trm_observ";
    public static final String C_TRM_ESTADO_SINCRONIZACION= "trm_estsinc";

    public static final int C_TRM_CIR_CODIGO_INDEX = 0;
    public static final int C_TRM_APOYO_INICIAL_INDEX = 1;
    public static final int C_TRM_APOYO_FINAL_INDEX = 2;
    public static final int C_TRM_CONFIGURACION_INDEX = 3;
    public static final int C_TRM_CLASE_INDEX = 4;
    public static final int C_TRM_CONDUCTOR_INDEX = 5;
    public static final int C_TRM_DISTANCIA_INDEX = 6;
    public static final int C_TRM_ESTADO_INDEX = 7;
    public static final int C_TRM_OBSERVACIONES_INDEX = 8;
    public static final int C_TRM_ESTADO_SINCRONIZACION_INDEX = 9;



    @Override
    public void onCreate(SQLiteDatabase db) {
        //creamos la tabla de elementos
        String sqlElemento = "create table "+ TABLE_ELEMENTO + "("+ C_ELE_CODIGO + " text primary key, " +
                C_ELE_LATITUD +" text, "+ C_ELE_LONGITUD + " text, "+ C_ELE_DIRECCION + " text, "+ C_ELE_ESTADO_SINCRONIZACION +" text)";
        db.execSQL(sqlElemento);

        //creamos la tabla de Apoyo
        String sqlApoyo = "create table "+ TABLE_APOYO + "("+ C_APO_ELE_CODIGO +" text primary key, "+
                C_APO_CODIGO+ " text, "+ C_APO_RETENIDA + "text, "+ C_APO_UBICACION + " text, "+ C_APO_ESTADO +" text, " +
                C_APO_TIPO + " text, "+ C_APO_CONFIGURACION + " text, "+ C_APO_MARCA + " text, " + C_APO_CARGA + " text, "+
                C_APO_BASE+" text, "+ C_APO_CANASTA +" text, "+ C_APO_MATERIAL +" text, "+ C_APO_ALTURA + " text, "+
                C_APO_ESTADO_SINCRONIZACION +" text) ";
        db.execSQL(sqlApoyo);

        //creamos la tabla de transformador
        String sqlTransformador = "create table "+ TABLE_TRANSFORMADOR + "("+ C_TRA_APO_CODIGO +" text primary key, "+
                C_TRA_CODIGO +" text, "+ C_TRA_ETIQUETA +" text, "+ C_TRA_CAPACIDAD_KVA +" text, "+
                C_TRA_VOLTAJE_PRIMARIO +" text, "+ C_TRA_VOLTAJE_SECUNDARIO +" text, "+ C_TRA_NUMERO_FASES +" text, "+
                C_TRA_TIPO_MONTAJE +" text, "+ C_TRA_USO +" text, "+ C_TRA_FOTO_CONTROL +" text, "+ C_TRA_LINEA_TIERRA +" text, "+
                C_TRA_MARCA +" text, "+ C_TRA_ESTADO_SINCRONIZACION +" text)";
        db.execSQL(sqlTransformador);

        //creamos la tabla de Camara
        String sqlCamara = "create table "+ TABLE_CAMARA + "("+ C_CAM_ELE_CODIGO +" text primary key, "+
                C_CAM_CODIGO +" text, "+ C_CAM_TAPA +" text, "+ C_CAM_DIAMETRO_TAPA +" text, "+ C_CAM_DIAMETRO_CAMARA +" text, "+
                C_CAM_CONFIGURACION +" text, "+ C_CAM_OBSERVACIONES +" text, "+ C_CAM_ESTADO_SINCRONIZACION +" text)";
        db.execSQL(sqlCamara);

        //creamos la tabla de Luminarias
        String sqlLuminaria = "create table "+ TABLE_LUMINARIA + "( "+ C_LUM_CODIGO +" text primary key, "+
                C_LUM_APO_CODIGO +" text, "+ C_LUM_CIR_CODIGO +" text, "+ C_LUM_PROTECCION +" text, "+ C_LUM_CONECTOR +" text, "+
                C_LUM_ESTADO_BOMBILLO +" text, "+ C_LUM_ESTADO_LUMINARIA +" text, "+ C_LUM_FOTOCELDA +" text, "+ C_LUM_USO +" text, "+
                C_LUM_TIPO_BRAZO +" text, "+ C_LUM_OBSERVACIONES +" text, "+ C_LUM_ESTADO_SINCRONIZACION +" text)";
        db.execSQL(sqlLuminaria);

        //creamos la tabla de circuito
        String sqlCircuito = "create table "+ TABLE_CIRCUITO + "("+ C_CIR_CODIGO +" text primary key, "+
                C_CIR_TRA_CODIGO +" text, "+ C_CIR_ESTADO_SINCRONIZACION +" text)";
        db.execSQL(sqlCircuito);

        //creamos la tabla tramo
        String sqlTramo = "create table "+ TABLE_TRAMO + "("+ C_TRM_CIR_CODIGO +" text primary key, " +
                C_TRM_APOYO_INICIAL +" text, " + C_TRM_APOYO_FINAL +" text, " + C_TRM_CONFIGURACION +" text, " + C_TRM_CLASE +" text, " +
                C_TRM_CONDUCTOR +" text, " + C_TRM_DISTANCIA +" text, " + C_TRM_ESTADO +" text, " + C_TRM_OBSERVACIONES +" text, " +
                C_TRM_ESTADO_SINCRONIZACION +" text)";
        db.execSQL(sqlTramo);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
