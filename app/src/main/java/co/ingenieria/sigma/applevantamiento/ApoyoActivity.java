package co.ingenieria.sigma.applevantamiento;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Bitmap;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.File;
import java.io.IOException;
import java.util.List;

import co.ingenieria.sigma.util.AlbumStorageDirFactory;
import co.ingenieria.sigma.util.BitmapManager;
import co.ingenieria.sigma.util.clsUtilidades;


public class ApoyoActivity extends ActionBarActivity {


    private static final int TOMAR_FOTO = 1;
    private static final int SELECCIONAR_FOTO = 2;
    private static final String NOMBRE_ALBUM = "Levantamiento";

    private static final String BITMAP_STORAGE_KEY = "viewbitmap";
    private Bitmap mImagenBitmap;
    private ImageView mImageView;
    private String pathFoto;
    //variables de clase "agregadas fabian"
    private  TextView longitud;
    private  TextView latitud;
    private  TextView codApoyo;
    private  TextView direccion;
    private  TextView retenida;
    private  TextView ubicacion;
    private  TextView estado;
    private  TextView tipo;
    private  TextView configuracion;
    private  TextView marca;
    private  TextView carga;
    private  TextView base;
    private  TextView canasta;
    private  TextView material;
    private  TextView altura;

    //variable manager localizacion
    private LocationManager locManager;
    private LocationListener locListener;
    private AlertDialog.Builder adb;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoyo);
        mImagenBitmap = null;
        mImageView = (ImageView)findViewById(R.id.ImageApoyo);
        latitud = (TextView)findViewById(R.id.Latitud);
        longitud = (TextView)findViewById(R.id.Longitud);




    }

    @Override
    protected void onResume(){
        super.onResume();
            comenzarLocalizacion();
    }

    public void identifyObjectcs(View v){
        String LatitudDos = latitud.getText().toString();
        String LongitudDos = longitud.getText().toString();

    }

    private void comenzarLocalizacion()
    {
        locManager =(LocationManager)getSystemService(Context.LOCATION_SERVICE);
        //Obtenemos la última posición conocida
        Location loc = locManager.getLastKnownLocation(LocationManager.GPS_PROVIDER);
        //Mostramos la última posición conocida
        mostrarPosicion(loc);
        //Nos registramos para recibir actualizaciones de la posición
        locListener = new LocationListener() {
            public void onLocationChanged(Location location) {
                mostrarPosicion(location);
            }
            public void onProviderDisabled(String provider){
                latitud.setText("Sin GPS");
                longitud.setText("Sin GPS");
            }
            public void onProviderEnabled(String provider){
                latitud.setText("Obteniendo X");
                longitud.setText("Obteniendo Y");
            }
            public void onStatusChanged(String provider, int status, Bundle extras){
                Log.i("", "Estado Proveedor: " + status);
            }
        };

        locManager.requestLocationUpdates(
                LocationManager.GPS_PROVIDER, 1000, 1, locListener);
    }

    private void mostrarPosicion(Location loc) {
        if(loc != null)
        {
            latitud.setText(String.valueOf(loc.getLatitude()));
            longitud.setText(String.valueOf(loc.getLongitude()));
            Log.i("", String.valueOf(loc.getLatitude() + " - " + String.valueOf(loc.getLongitude())));
        }
        else
        {
            latitud.setText("(sin_datos)");
            longitud.setText("(sin_datos)");
        }
    }

    private void TomarFotoCamara(View v){
        if (isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE)) {
            Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
            File f = null;
            try {
                f = AlbumStorageDirFactory.setUpPhotoFile(NOMBRE_ALBUM);
                pathFoto = f.getAbsolutePath();
                intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(f));
            } catch (IOException e) {
                e.printStackTrace();
                f = null;
                pathFoto = null;
            }
            startActivityForResult(intent, TOMAR_FOTO);
        }
    }

    public void ObtenerFotodeGaleria(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Seleccione Fuente de Imagen"), SELECCIONAR_FOTO);
    }

    private void addImagenGalleria() {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(pathFoto);
        Uri contentUri = Uri.fromFile(f);
        intent.setData(contentUri);
        this.sendBroadcast(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TOMAR_FOTO: {
                    if (pathFoto != null) {
                        mImagenBitmap = BitmapManager.setPic(mImageView, pathFoto);
                        mImageView.setImageBitmap(mImagenBitmap);
                        addImagenGalleria();
                        pathFoto = null;
                    }
                    break;
                }
                case SELECCIONAR_FOTO: {
                    Uri selectedImageUri = data.getData();
                    pathFoto = AlbumStorageDirFactory.getImageFromGalleryPath(this, selectedImageUri);
                    mImageView.setImageURI(selectedImageUri);
                    break;
                }
            }
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_apoyo, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        switch (id){
            case R.id.camara:
                Toast.makeText(this, "Seleccionamos camara", Toast.LENGTH_LONG).show();
                TomarFotoCamara(findViewById(R.id.camara));
                return true;
            case R.id.editar:
                Toast.makeText(this, "Seleccionamos Editar", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }


    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putParcelable(BITMAP_STORAGE_KEY, mImagenBitmap);
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        mImagenBitmap = savedInstanceState.getParcelable(BITMAP_STORAGE_KEY);
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
