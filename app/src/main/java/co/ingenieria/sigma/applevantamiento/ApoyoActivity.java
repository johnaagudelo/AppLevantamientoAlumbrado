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
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.List;

import co.ingenieria.sigma.util.AlbumStorageDirFactory;
import co.ingenieria.sigma.util.BitmapManager;
import co.ingenieria.sigma.util.clsUtilidades;


public class ApoyoActivity extends ActionBarActivity {

    private static final String LOG_APO = ApoyoActivity.class.getSimpleName();
    private static final int TOMAR_FOTO = 1;
    private static final int SELECCIONAR_FOTO = 2;
    private static final String NOMBRE_ALBUM = "Levantamiento";

    private static final String BITMAP_STORAGE_KEY = "viewbitmap";
    private Bitmap mImagenBitmapApoyo;
    private ImageView mImageView;
    private String pathFoto;

    //variables de clase "agregadas fabian"
    private  TextView longitud;
    private  TextView latitud;
    private  TextView codApoyo;
    private  TextView direccion;
    private  Spinner retenida;
    private  TextView ubicacion;
    private  Spinner estado;
    private  Spinner tipo;
    private  Spinner configuracion;
    private  Spinner marca;
    private  Spinner carga;
    private  Spinner base;
    private  Spinner canasta;
    private  Spinner material;
    private  Spinner altura;

    //variable manager localizacion
    private LocationManager locManager;
    private LocationListener locListener;
    private AlertDialog.Builder adb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apoyo);
        mImagenBitmapApoyo = null;
        mImageView = (ImageView)findViewById(R.id.ImageApoyo);
        latitud = (TextView)findViewById(R.id.Latitud);
        longitud = (TextView)findViewById(R.id.Longitud);
        codApoyo = (TextView) findViewById(R.id.apoCodigo);
        direccion = (TextView) findViewById(R.id.apoDireccion);
        retenida = (Spinner) findViewById(R.id.apoRetenida);
        ubicacion = (TextView) findViewById(R.id.apoUbicacion);
        estado = (Spinner) findViewById(R.id.apoEstado);
        tipo = (Spinner) findViewById(R.id.apoTipo);
        configuracion = (Spinner) findViewById(R.id.apoConfiguracion);
        marca = (Spinner) findViewById(R.id.apoMarca);
        carga = (Spinner) findViewById(R.id.apoCarga);
        base = (Spinner) findViewById(R.id.apoBase);
        canasta = (Spinner) findViewById(R.id.apoCanasta);
        material = (Spinner) findViewById(R.id.apoMaterial);
        altura = (Spinner) findViewById(R.id.apoAltura);
    }

    @Override
    protected void onResume(){
        super.onResume();
            comenzarLocalizacion();
    }

    public void GuardarApoyo(View v){

        String Latitud = latitud.getText().toString();
        String Longitud = longitud.getText().toString();
        String codapo = codApoyo.getText().toString();
        String dirapo = direccion.getText().toString();
        String retapo = retenida.getSelectedItem().toString();
        String ubiapo = ubicacion.getText().toString();
        String estapo = estado.getSelectedItem().toString();
        String tipapo = tipo.getSelectedItem().toString();
        String confapo = configuracion.getSelectedItem().toString();
        String martapo = marca.getSelectedItem().toString();
        String carapo = carga.getSelectedItem().toString();
        String basapo = base.getSelectedItem().toString();
        String canapo = canasta.getSelectedItem().toString();
        String matapo = material.getSelectedItem().toString();
        String altapo = altura.getSelectedItem().toString();


        JSONObject Elemento = new JSONObject();
        JSONObject Apoyo = new JSONObject();

        try {
            Elemento.put("Latitud", Latitud);
            Elemento.put("Longitud", Longitud);
            Elemento.put("Direccion", dirapo);
            Elemento.put("Direccion", dirapo);
            Apoyo.put("codigo", codapo);
            Apoyo.put("Imagen", mImagenBitmapApoyo);
            Apoyo.put("retenida", "retenida");
            Apoyo.put("ubicacion", "ubicacion");
            Apoyo.put("estado", "estado");
            Apoyo.put("tipo", "tipo");
            Apoyo.put("configuracion", "configuracion");
            Apoyo.put("marca", "marca");
            Apoyo.put("carga", "carga");
            Apoyo.put("base", "base");
            Apoyo.put("canasta", "canasta");
            Apoyo.put("material", "material");
            Apoyo.put("altura", "altura");
            Elemento.put("Apoyo", Apoyo);

            Log.d(LOG_APO, "Json Apoyo"+ Elemento.toString());

        } catch (JSONException e) {
            e.printStackTrace();
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
                        mImagenBitmapApoyo = BitmapManager.setPic(mImageView, pathFoto);
                        mImageView.setImageBitmap(mImagenBitmapApoyo);
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

}
