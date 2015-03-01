package co.ingenieria.sigma.applevantamiento;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
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

import co.ingenieria.sigma.util.AlbumStorageDirFactory;
import co.ingenieria.sigma.util.BitmapManager;
import co.ingenieria.sigma.util.clsUtilidades;


public class CamaraActivity extends ActionBarActivity {


    private static final int TOMAR_FOTO = 1;
    private static final int SELECCIONAR_FOTO = 2;
    private static final String NOMBRE_ALBUM = "Levantamiento";

    private static final String BITMAP_STORAGE_KEY = "viewbitmap";
    private Bitmap mImagenBitmapCamara;
    private ImageView mImageView;
    private String pathFoto;

    //variables de clase "agregadas fabian"
    private TextView longitud;
    private  TextView latitud;

    //variable manager localizacion
    private LocationManager locManager;
    private LocationListener locListener;
    private AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);
        mImagenBitmapCamara = null;
        mImageView = (ImageView)findViewById(R.id.ImageCamara);
        latitud = (TextView)findViewById(R.id.Latitud);
        longitud = (TextView)findViewById(R.id.Longitud);
    }

    @Override
    protected void onResume(){
        super.onResume();
        comenzarLocalizacion();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_camara, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        switch (id){
            case R.id.camaraCamara:
                Toast.makeText(this, "Seleccionamos camara", Toast.LENGTH_LONG).show();
                TomarFotoCamara(findViewById(R.id.camara));
                return true;
            case R.id.editarCamara:
                Toast.makeText(this, "Seleccionamos Editar", Toast.LENGTH_LONG).show();
                return true;
            case R.id.action_settings:
                Toast.makeText(this, "Cerrar sesión", Toast.LENGTH_LONG).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    //Metodo que evalua el estado del GPS Actualizar posicion, GPS Desactivado, GPS Activado
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

    //Metodo que muestra la posicion obtenida por el GPS
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

    //Metodo que realiza el intent a las app de camara del dispositivo
    private void TomarFotoCamara(View v){
        if (clsUtilidades.isIntentAvailable(this, MediaStore.ACTION_IMAGE_CAPTURE)) {
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

    //Metodo que permito seleccionar una foto de la galeria de imagenes
    public void ObtenerFotodeGaleria(View v){
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(Intent.createChooser(intent,"Seleccione Fuente de Imagen"), SELECCIONAR_FOTO);
    }


    //Metodo que inserta la foto a la ruta /Levantamiento de la memoria interna del dispositivo
    private void addImagenGalleria() {
        Intent intent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
        File f = new File(pathFoto);
        Uri contentUri = Uri.fromFile(f);
        intent.setData(contentUri);
        this.sendBroadcast(intent);
    }

    //Metodo que obtiene el resultado de TomarFoto o Foto Seleccionada de la galeria para pintarla en el ImageView
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            switch (requestCode) {
                case TOMAR_FOTO: {
                    if (pathFoto != null) {
                        mImagenBitmapCamara = BitmapManager.setPic(mImageView, pathFoto);
                        mImageView.setImageBitmap(mImagenBitmapCamara);
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
}
