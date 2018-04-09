package core.WebServices;

import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.concurrent.ExecutionException;

public class http_operations {

    public String test()
    {
        String response = null;
        try {
            response = new getData().execute("http://avapp.seguridadycitofonos.com/index.php?controller=WebService&action=test").get();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            JSONObject obj = new JSONObject(response);
            return obj.getString("message");
           // Log.d("JsonGotit",obj.getString("message"));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
