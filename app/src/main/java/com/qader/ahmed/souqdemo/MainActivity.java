package com.qader.ahmed.souqdemo;

import android.net.Proxy;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.qader.ahmed.souqdemo.adapter.CategoryAdapter;
import com.qader.ahmed.souqdemo.model.CategoryModel;

import java.io.IOException;
import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import okhttp3.Authenticator;
import okhttp3.Credentials;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.Route;


public class MainActivity extends AppCompatActivity {

    CategoryAdapter adapter;
    ArrayList<CategoryModel> list;




    private static final String OAUTH_CONSUMER_KEY = "oauth_consumer_key";
    private static final String OAUTH_CONSUMER_SECRET = "oauth_consumer_secret";
    private static final String OAUTH_SIGNATURE_METHOD = "oauth_signature_method";
    private static final String OAUTH_SIGNATURE_METHOD_VALUE = "HMAC-SHA1";
    private static final String OAUTH_VERSION = "oauth_version";
    private static final String OAUTH_VERSION_VALUE = "1.0";




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rvCategory);
        int numberOfColumns = 2;

        list = new ArrayList<>();

        recyclerView.setLayoutManager(new GridLayoutManager(this, numberOfColumns));
        recyclerView.setAdapter(adapter);

        Log.v("aaaaaaaaaaaaaa","start");

//        OkHttpClient client = new OkHttpClient();
//
//        Request request = new Request.Builder()
//                .url("http://fictionapps.com/demo/souq/wp-json/wc/v2/products/categories")
//                .get()
//                .addHeader("Authorization", "OAuth oauth_consumer_key=\"ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1529849741\",oauth_nonce=\"Kk2v64bCLhU\",oauth_version=\"1.0\",oauth_signature=\"oQa0YQmVzh%2FaY6I9NZAwe62a04E%3D\"")
//                .addHeader("Cache-Control", "no-cache")
//                .addHeader("Postman-Token", "454be2df-3166-4861-b366-41f8e5aafb10")
//                .build();
//
//        try {
//            Response response = client.newCall(request).execute();
//            Log.v("aaaaaaaaaaaaaa",response.toString());
//
//        } catch (IOException e) {
//            e.printStackTrace();
//            Log.v("aaaaaaaaaaaaaa","error");
//            Log.v("aaaaaaaaaaaaaa",e.getMessage());
//
//        }
//
//        Uri builtUri = Uri.parse("http://fictionapps.com/demo/souq/wp-json/wc/v2/products/categories").buildUpon()
//                .appendQueryParameter("Authorization", "OAuth oauth_consumer_key=\"ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1529844976\",oauth_nonce=\"mcAtI4RvK07\",oauth_version=\"1.0\",oauth_signature=\"%2B%2FTV98H0dvhmJS9lGIikCeLD%2Bvo%3D\"")
//                .appendQueryParameter("Cache-Control", "no-cache")
//                .appendQueryParameter("Postman-Token", "04976b1e-0a8a-467f-8b8f-6f874e784429")
//                .build();
//
//



//        Uri builtUri = Uri.parse("http://fictionapps.com/demo/souq/wp-json/wc/v2/products/categories").buildUpon()

//                .appendQueryParameter(OAUTH_SIGNATURE_METHOD, OAUTH_SIGNATURE_METHOD_VALUE)
//                .appendQueryParameter(OAUTH_CONSUMER_KEY, "ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95")
//                .appendQueryParameter(OAUTH_CONSUMER_KEY, "cs_10467bc00edd399bcd24e21f7f3c338c02975dd0")
//                .appendQueryParameter(OAUTH_VERSION, OAUTH_VERSION_VALUE)
//
//                .build();


//        url("https://api.yourapi...")
//                .header("ApiKey", "xxxxxxxx")
//                .build();
//        new FetchCategoryData(MainActivity.this,adapter,0).execute(builtUri.toString());

        load_data_from_server();

    }


    private void load_data_from_server() {
        Log.v("aaaaaaaaaaaaaaaa","Method");

        AsyncTask<String, Integer, String> task = new AsyncTask<String, Integer, String>() {
            @Override
            protected String doInBackground(String... params) {
//                Log.v("aaaaaaaaaaaaaaaa","do in background");
//
//                BufferedReader reader = null;
//                Log.e("aaaaaaaaaaaaa","1");
//                try {
//                    Log.v("aaaaaaaaaaaaaaaa","1");
//
//                    URL url = new URL("http://fictionapps.com/demo/souq/wp-json/wc/v2/products/categories");
//                    HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
//                    Log.v("aaaaaaaaaaaaaaaa","22");
//                    urlConnection.setRequestMethod("GET");
//                    urlConnection.setRequestProperty("Authorization","OAuth oauth_consumer_key=\"ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1529914830\",oauth_nonce=\"z0wsxJUPnpm\",oauth_version=\"1.0\",oauth_signature=\"pokYIaP3JxbHswAH4R6GGXOuDzI%3D\"");
////        urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
//                    urlConnection.setRequestProperty("Cache-Control","no-cache");
//                    Log.v("aaaaaaaaaaaaaaaa","222");
//                    urlConnection.setRequestProperty("Postman-Token","36608e64-6178-41ad-8d59-7eca83f73235");
////                    urlConnection.setDoOutput(true);
//                    Log.v("aaaaaaaaaaaaaaaa","2");
//
//
////                    URL url = new URL("www.howdoyousee.me/tadawalapi/api/getallpredicts");
////                    HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
////                    urlConnection.setRequestMethod("POST");
////                    urlConnection.setRequestProperty("X-API-KEY","gkhbmcd56#455*$hljvbn45667@6");
////                    urlConnection.setRequestProperty("Content-Type", "application/x-www-form-urlencoded");
////                    urlConnection.setRequestProperty("Cache-Control","no-cache");
////                    urlConnection.setRequestProperty("Postman-Token","b0f3460f-619b-4adb-2b53-ad902b2601a3");
////                    urlConnection.setDoOutput(true);
//                    try {
//                        Log.v("aaaaaaaaaaaaaaaa","3");
//
//                        reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
//                        Log.v("aaaaaaaaaaaaaaaaa",reader.toString());
//                    }catch (IOException e){
//                        e.printStackTrace();
//                        Log.v("aaaaaaaaaaaaaaaaa","first error");
//                    }
//                    StringBuilder stringBuilder = new StringBuilder();
//                    String line = null;
//                    while ((line = reader.readLine()) != null) {
//                        stringBuilder.append(line + "\n");
//
//                    }
//                    if(reader!=null){
//                        Log.v("aaaaaaaaaaaaaaaa","null");
//                        reader.close();
//                    }
//                    String result = stringBuilder.toString();
//
//                    Log.v("aaaaaaaaaaaaaaaa",result);
//                    if(result.length()==0) {
//                        return null;
//                    }else{
//                        return result;
//                    }
//                }catch (Exception e) {
//                    e.printStackTrace();
//                    Log.v("aaaaaaaaaaaaaaaa","error");
//
//                    return e.toString();
//                }


                OkHttpClient client = new OkHttpClient();


                Request request = new Request.Builder()
                        .url("http://fictionapps.com/demo/souq/wp-json/wc/v2/products/categories?username='admin'&password='admin'")
                        .get()
                        .addHeader("Authorization", "OAuth oauth_consumer_key=\"ck_baeba18c4bf961af446ad4aad1aaf50b46b16e95\",oauth_signature_method=\"HMAC-SHA1\",oauth_timestamp=\"1529918155\",oauth_nonce=\"tUWHX5Sfyyo\",oauth_version=\"1.0\",oauth_signature=\"P2%2FwwjvSDp2LDjSOMcI%2Fw7td9nE%3D\"")
                        .addHeader("Cache-Control", "no-cache")
                        .addHeader("Postman-Token", "d8600462-0f0e-4886-a43a-0c9a6eece08b")
                        .build();

                try {
                    Response response = client.newCall(request).execute();
                    Log.v("aaaaaaaaaaaaaaaa","done");
                    Log.v("aaaaaaaaaaaaaaaa",response.toString());
                    Log.v("aaaaaaaaaaaaaaaa",response.body().string());


                } catch (IOException e) {
                    e.printStackTrace();
                    Log.v("aaaaaaaaaaaaaaaa",e.getMessage());
                    Log.v("aaaaaaaaaaaaaaaa","error");
                }


                return null;
            }

            @Override
            protected void onPostExecute(String result) {
                super.onPostExecute(result);

//                try {
//                    JSONObject object = new JSONObject(result);
//                    Log.v("aaaaaaaaaa",object.toString());
//                    Log.v("aaaaaaaaaa",object.getString("message"));
//                    Log.v("aaaaaaaaaa",object.getString("userssortponit"));
//                    JSONArray sortArray = object.getJSONArray("userssortponit");
//                    Log.v("aaaaaaaaaa",sortArray.toString());
//
//                    Log.v("aaaaaaaaaa","aaaaaa");
////                    sortList = new ArrayList<>();
//                    for (int i = 0; i < sortArray.length(); i++) {
//                        Log.v("aaaaaaaaaa","2");
//                        JSONObject currentObject = sortArray.getJSONObject(i);
//                        ExpectModel model = new ExpectModel();
//                        Log.v("aaaaaaaaaa","3");
//                        model.setSahamname(currentObject.getString("sahimname"));
//                        Log.v("aaaaaaaaaa","4");
//                        Log.v("aaaaaaaaaaaaaaaa",currentObject.getString("sahimname"));
//
//                        model.setStatus(currentObject.getString("status"));
//                        Log.v("aaaaaaaaaaaaaaaa",currentObject.getString("status"));
//
//                        model.setTarget(currentObject.getString("target"));
//                        Log.v("aaaaaaaaaaaaaaaa",currentObject.getString("target"));
//
//                        model.setCreated_at(currentObject.getString("created_at"));
//                        Log.v("aaaaaaaaaaaaaaaa",currentObject.getString("created_at"));
//
//                        model.setNote(currentObject.getString("note"));
//                        Log.v("aaaaaaaaaaaaaaaa",currentObject.getString("note"));
//
//
////                        data_list.add(model);
////                        adapter.notifyDataSetChanged();
//                    }
//                    Log.v("aaaaaaaaaa","3");
//
//                } catch (Exception e) {
//                    Log.v("aaaaaaaaaa","error");
//
//                }
            }
        };
        task.execute("");
    }


}
