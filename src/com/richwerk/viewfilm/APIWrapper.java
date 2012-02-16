package com.richwerk.viewfilm;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.InputStream;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;
import org.apache.http.HttpResponse;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.HttpClient; 


import android.util.Log;


public class APIWrapper {
       
    public String stringify(InputStream is) throws IOException {

        BufferedReader r = new BufferedReader(new InputStreamReader(is));
        String x = "";
        x = r.readLine();
        String total = "";
        while(x != null){
            total += x;
            x = r.readLine();
        }
        Log.v("BAR", total);
        
        return total;
        
    }

    public void call(String url) {

        HttpClient httpclient = new DefaultHttpClient();
        
        // Prepare a request object
        HttpGet httpget = new HttpGet(url); 
 
        try {
            HttpResponse response = httpclient.execute(httpget);
            // Examine the response status
            Log.v("FOO", response.getStatusLine().toString());
            HttpEntity ent = response.getEntity();
            InputStream is = ent.getContent();
            String enc = "UTF-8";
            String json_string = this.stringify(is);
            JSONObject json_o = new JSONObject(json_string);
            
            
            is.close();
            
        } catch (ClientProtocolException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();   
        } catch (IOException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        } catch (JSONException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }        
        
    }
}
