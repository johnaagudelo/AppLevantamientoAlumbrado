package co.ingenieria.sigma.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;

import co.ingenieria.sigma.models.clsApoyo;

/**
 * Created by John Agudelo on 08/02/2015.
 */
public class clsDBOperaciones {

    private static final String TAG = clsDBOperaciones.class.getSimpleName();
    private ClsDBHelper dbHelper;

    public clsDBOperaciones(Context context){
        dbHelper = new ClsDBHelper(context);
    }

    public void insertar(ContentValues valores, String tabla){
        Log.d(TAG, "Insertando Valores en "+ tabla +" valores "+ valores);
        SQLiteDatabase baseDatos = dbHelper.getWritableDatabase();
        try {
            baseDatos.insertWithOnConflict(tabla, null,valores,SQLiteDatabase.CONFLICT_IGNORE);
        }finally {
            baseDatos.close();
        }
    }

    public Cursor Consultar(String sql){
        ArrayList listaElemento = new ArrayList();
        SQLiteDatabase baseDatos = dbHelper.getReadableDatabase();
        Cursor datos = baseDatos.rawQuery(sql,null);

        return datos;
    }

    public void Actualizar(String sql){
        Log.d(TAG, "Actualizamos sql"+ sql);
        SQLiteDatabase basedatos = dbHelper.getWritableDatabase();
        try {
            basedatos.execSQL(sql);
        }finally {
            basedatos.close();
        }
    }

}
