package core.WebServices;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Jesus on 21/03/2018.
 */

public class RequestDispatcher extends AsyncTask<String, String, String> {

        HttpURLConnection urlConnection;
        private String RequestMethod = "GET";
        private int ConnectTimeout = 15000;
        private int ReadTimeout = 10000;
        private HashMap<String, String> params;

        public RequestDispatcher(){};

        public RequestDispatcher(String RequestMethod)
        {
            this.RequestMethod = RequestMethod;
        }

        public RequestDispatcher(String RequestMethod, int ConnectTimeout, int ReadTimeout)
        {
            this.RequestMethod = RequestMethod;
            this.ConnectTimeout = ConnectTimeout;
            this.ReadTimeout = ReadTimeout;
        }

        public void setParams(HashMap<String, String> params) {
            this.params = params;
        }

    @Override
        public String doInBackground(String... args) {

            StringBuilder result = new StringBuilder();

            try {
                URL url = new URL(args[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setConnectTimeout(this.ConnectTimeout);
                urlConnection.setReadTimeout(this.ReadTimeout);
                urlConnection.setDoInput(true);


                if(this.RequestMethod.toUpperCase().equals("GET"))
                {
                    InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                    BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                    String line;
                    while ((line = reader.readLine()) != null) {
                        result.append(line);
                    }
                }

                if(this.RequestMethod.toUpperCase().equals("POST"))
                {
                    urlConnection.setDoOutput(true);
                    OutputStream os = urlConnection.getOutputStream();
                    BufferedWriter writer = new BufferedWriter(
                            new OutputStreamWriter(os, "UTF-8"));
                    writer.write(getPostDataString(this.params));

                    writer.flush();
                    writer.close();
                    os.close();
                    int responseCode=urlConnection.getResponseCode();

                    if (responseCode == HttpURLConnection.HTTP_OK) {
                        String line;
                        BufferedReader br=new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
                        while ((line=br.readLine()) != null) {
                            result.append(line);
                        }
                    }

                }




            }catch( Exception e) {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }


            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {

            //Do something with the JSON string

        }



    private String getPostDataString(HashMap<String, String> params) throws UnsupportedEncodingException {
        StringBuilder result = new StringBuilder();
        boolean first = true;
        for(Map.Entry<String, String> entry : params.entrySet()){
            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(entry.getKey(), "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(entry.getValue(), "UTF-8"));
        }

        return result.toString();
    }



}


