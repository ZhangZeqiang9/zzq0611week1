package com.example.l.zzq0611week1.httputil;

import android.os.AsyncTask;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.l.zzq0611week1.MainActivity;

import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.sql.Connection;

/*
 * 工具类
 */
public class HttpUtil {
    /*
     * 单例模式
     */
   private HttpUtil(){}
   private static class Https{
       private static final HttpUtil httpUtil = new HttpUtil();
   }
   public static HttpUtil getInstance(){
       return Https.httpUtil;
   }
   public void getData(final String uri){
       AsyncTask<String,Void,String> asyncTask = new AsyncTask<String, Void, String>() {
           @Override
           protected String doInBackground(String... strings) {
               try {
                   URL url = new URL(strings[0]);


               } catch (Exception e) {
                   e.printStackTrace();
               }
               return null;
           }

           @Override
           protected void onPostExecute(String s) {

               super.onPostExecute(s);
           }
       }.execute(uri);
   }
    public void getDatas(String uri, final HttpUtilCallBack callBack){
        RequestQueue requestQueue = Volley.newRequestQueue(MainActivity.mcontext);
        StringRequest stringRequest = new StringRequest(Request.Method.GET, uri, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                callBack.getData(response);
            }
        }, null);
        requestQueue.add(stringRequest);
    }

   public interface HttpUtilCallBack{
       void getData(String data);
   }
}
