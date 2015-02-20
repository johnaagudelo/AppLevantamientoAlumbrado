package co.ingenieria.sigma.util;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by John Agudelo on 14/02/2015.
 */
public class clsServicio {

    private String resultado;
    private JSONArray jArray;
    private InputStream stream;

    public JSONArray conectar(String datos) {
        try {

            DefaultHttpClient client = new DefaultHttpClient();
            HttpPost post = new HttpPost(clsUtilidades.URL_FACHADA);
            StringEntity entity = new StringEntity(datos);
            post.setEntity(entity);
            HttpResponse response = client.execute(post);
            HttpEntity respuesta = response.getEntity();
            stream = respuesta.getContent();
            BufferedReader reader = new BufferedReader(new InputStreamReader(stream, "UTF-8"), 8);
            StringBuilder sb = new StringBuilder();
            sb.append(reader.readLine() + "\n");
            String line = "0";
            while ((line = reader.readLine()) != null) {
                sb.append(line + "\n");
            }
            this.stream.close();
            this.resultado = sb.toString();

            try {
                this.jArray = new JSONArray(resultado);
            } catch (Exception e) {
                this.resultado="["+this.resultado+"]";
                this.jArray = new JSONArray(resultado);
            }
        }catch (ClientProtocolException e) {
            try {
                this.jArray = new JSONArray("[{'respuesta':0}]");
            } catch (JSONException e1) {
            }
        }catch (IOException e) {
            e.printStackTrace();
            try {
                this.jArray = new JSONArray("[{'respuesta':0}]");
            } catch (JSONException e1) {
            }
        }catch (Exception e) {
            try {
                this.jArray = new JSONArray("[{'respuesta':0}]");
            }catch (JSONException e1) {
            }
        }
        return this.jArray;
    }
}
