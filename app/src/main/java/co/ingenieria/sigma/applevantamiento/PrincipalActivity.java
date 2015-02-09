package co.ingenieria.sigma.applevantamiento;

import android.app.DialogFragment;
import android.content.Intent;
import android.content.res.Resources;
import android.location.LocationManager;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.webkit.WebView;
import android.widget.TabHost;
import android.widget.TabHost.OnTabChangeListener;


public class PrincipalActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.tabs);

        LocationManager locManager = (LocationManager)getSystemService(LOCATION_SERVICE);

        Resources res = getResources();

        TabHost tabs= (TabHost)findViewById(android.R.id.tabhost);
        tabs.setup();
        TabHost.TabSpec spec = tabs.newTabSpec("MAPA");
        spec.setContent(R.id.tab1);
        spec.setIndicator("MAPA", res.getDrawable(android.R.drawable.ic_menu_mylocation));
        tabs.addTab(spec);

        spec=tabs.newTabSpec("ELEMENTOS");
        spec.setContent(R.id.tab2);
        spec.setIndicator("ELEMENTOS",res.getDrawable(android.R.drawable.btn_star));
        tabs.addTab(spec);

        tabs.setCurrentTab(0);

        WebView myWebView = (WebView) findViewById(R.id.viewpage);
        myWebView.getSettings().setJavaScriptEnabled(true);
        myWebView.loadUrl("http://laofertaquequieres.co/Geomarketing/FUNLogin/PRELoginAutomatico?sistema=SIS_40&login=general&passwd=general");

        if (!locManager.isProviderEnabled(LocationManager.GPS_PROVIDER))
        {
            Intent settingsIntent = new Intent(android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
            settingsIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK |
                    Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
            startActivityForResult(settingsIntent, 0);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_principal, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
