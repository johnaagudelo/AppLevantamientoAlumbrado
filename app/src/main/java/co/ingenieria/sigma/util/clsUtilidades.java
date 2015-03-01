package co.ingenieria.sigma.util;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;

import java.util.List;

import co.ingenieria.sigma.applevantamiento.R;

/**
 * Created by John Agudelo on 08/02/2015.
 */
public class clsUtilidades {

    private static final String URL_SERVICIO = "https//www.alumbradospublicos.co";
    private static final String URL_DIR = URL_SERVICIO+"/Aplicacion/herramientas/operaciones/";
    public static final String URL_FACHADA = URL_DIR + "fachada.php";

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

    /**
     * Indicates whether the specified action can be used as an intent. This
     * method queries the package manager for installed packages that can
     * respond to an intent with the specified action. If no suitable package is
     * found, this method returns false.
     * http://android-developers.blogspot.com/2009/01/can-i-use-this-intent.html
     *
     * @param context The application's environment.
     * @param action The Intent action to check for availability.
     *
     * @return True if an Intent with the specified action can be sent and
     *         responded to, false otherwise.
     */
    public static boolean isIntentAvailable(Context context, String action) {
        final PackageManager packageManager = context.getPackageManager();
        final Intent intent = new Intent(action);
        List<ResolveInfo> list =
                packageManager.queryIntentActivities(intent,
                        PackageManager.MATCH_DEFAULT_ONLY);
        return list.size() > 0;
    }
}
