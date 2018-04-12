package core.WebServices;

import android.os.AsyncTask;
import android.util.Log;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by Jesus on 21/03/2018.
 */

public class RequestDispatcher extends AsyncTask<String, String, String> {

        HttpURLConnection urlConnection;
        private String RequestMethod = "GET";
        private int ConnectTimeout = 15000;
        private int ReadTimeout = 10000;

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

        @Override
        public String doInBackground(String... args) {

            StringBuilder result = new StringBuilder();

            try {
                URL url = new URL(args[0]);
                urlConnection = (HttpURLConnection) url.openConnection();
                urlConnection.setReadTimeout(this.ReadTimeout);
                urlConnection.setReadTimeout(this.ReadTimeout);
                InputStream in = new BufferedInputStream(urlConnection.getInputStream());

                BufferedReader reader = new BufferedReader(new InputStreamReader(in));

                String line;
                while ((line = reader.readLine()) != null) {
                    result.append(line);
                }

            }catch( Exception e) {
                e.printStackTrace();
            }
            finally {
                urlConnection.disconnect();
            }

            //System.out.println("response "+result.toString());
            //Log.d("response",result.toString());
            return result.toString();
        }

        @Override
        protected void onPostExecute(String result) {

            //Do something with the JSON string

        }

    }


