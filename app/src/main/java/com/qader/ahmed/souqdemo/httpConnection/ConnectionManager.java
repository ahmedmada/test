package com.qader.ahmed.souqdemo.httpConnection;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Ahmed AbdElQader on 24-Jun-18.
 */

public class ConnectionManager {

    //check internet
    public static boolean isInternetConnected(Context context){

        ConnectivityManager connectivityManager = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();

        if (networkInfo != null && networkInfo.isAvailable())
            //internet is work
            return true;
        //internet not work
        return false;
    }

    //open connection
    public static HttpsURLConnection openConnection(String link) throws IOException {

        //url link
//        URL url = new URL(link);
//        //Returns a new connection to the resource referred to by this URL.
//        HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//
//        httpURLConnection.setRequestMethod("GET");
//
//        httpURLConnection.setRequestProperty("Consumer Key", "ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95");
//        httpURLConnection.setRequestProperty("Consumer Secret", "cs_10467bc00edd399bcd24e21f7f3c338c02975dd0");
//
//        //the maximum time in milliseconds to wait while connecting
//        httpURLConnection.setConnectTimeout(15000);
//        //the maximum time to wait for an input stream read to complete before giving up
//        httpURLConnection.setReadTimeout(15000);
//        httpURLConnection.setDoInput(true);
//        //Opens a connection to the resource
//        httpURLConnection.connect();


//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url()
//                .get()
//                .addHeader("", )
//                .addHeader("", "")
//                .addHeader("", "")
//                .build();
//
//        Response response = client.newCall(request).execute();


        URL url = new URL("http://fictionapps.com/demo/souq/wp-json/wc/v2/products/categories");
        HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
        urlConnection.setRequestMethod("GET");
        urlConnection.setRequestProperty("Authorization","OAuth oauth_consumer_key=\"ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1529914830\",oauth_nonce=\"z0wsxJUPnpm\",oauth_version=\"1.0\",oauth_signature=\"pokYIaP3JxbHswAH4R6GGXOuDzI%3D\"");
//        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
        urlConnection.setRequestProperty("Cache-Control","no-cache");
        urlConnection.setRequestProperty("Postman-Token","36608e64-6178-41ad-8d59-7eca83f73235");
        urlConnection.setDoOutput(true);

        return urlConnection;

    }

    //Read Data
    public static String getResult(HttpURLConnection httpURLConnection) throws IOException{

        InputStream inputStream = httpURLConnection.getInputStream();
        StringBuilder stringBuilder = new StringBuilder();
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String line;
        while ((line = bufferedReader.readLine()) != null)
            stringBuilder.append(line);

        return stringBuilder.toString();
    }

}
