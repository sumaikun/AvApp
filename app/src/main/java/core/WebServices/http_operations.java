package core.WebServices;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.concurrent.ExecutionException;

public class http_operations {

    /*private HashMap<String, String> params;

    public void SetParams(HashMap<String, String> params)
    {
        this.params = params;
    }*/

    public String test()
    {
        String response = null;
        try {

            response = new RequestDispatcher().execute("http://avapp.seguridadycitofonos.com/index.php?controller=WebService&action=test").get();
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

    public String Login(HashMap<String, String> params)
    {
        RequestDispatcher dispatcher = new RequestDispatcher("POST");
        dispatcher.setParams(params);
        String response = null;
        try {

            response = dispatcher.execute("http://avapp.seguridadycitofonos.com/index.php?controller=WebService&action=login").get();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        try {
            System.out.println("verifiquemos response");
            System.out.println(response);

            JSONObject obj = new JSONObject(response);

            return obj.getString("message");
          
        } catch (JSONException e) {
            e.printStackTrace();
        }

        return null;
    }
}
