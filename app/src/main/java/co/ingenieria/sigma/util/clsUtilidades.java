package co.ingenieria.sigma.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;

import co.ingenieria.sigma.applevantamiento.R;

/**
 * Created by John Agudelo on 08/02/2015.
 */
public class clsUtilidades {
    private static final String URL_BACKEND = "https//www.alumbradospublicos.co";
    private static final String URL_DIR = URL_BACKEND+"/Aplicacion/herramientas/opraciones/";
    private static final String URL_FACHADA = URL_DIR + "fachada.php";

    public static void mostrarAlerta(Activity activity, String message){
        AlertDialog.Builder alert = new AlertDialog.Builder(activity);
        alert.setTitle(message);
        alert.setPositiveButton(
                activity.getResources().getString(R.string.btn_aceptar),
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        alert.show();
    }
}
