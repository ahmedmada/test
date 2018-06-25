package com.qader.ahmed.souqdemo.httpConnection;

import android.content.Context;
import android.os.AsyncTask;
import android.util.Log;

import com.qader.ahmed.souqdemo.adapter.CategoryAdapter;
import com.qader.ahmed.souqdemo.model.CategoryModel;
import com.qader.ahmed.souqdemo.util.JsonUtil;

import org.json.JSONException;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.ArrayList;

import javax.net.ssl.HttpsURLConnection;

/**
 * Created by Ahmed AbdElQader on 24-Jun-18.
 */

public class FetchCategoryData  extends AsyncTask<String, Void, ArrayList> {

    Context context;
    ArrayList<CategoryModel> categoryList;
    CategoryAdapter adapter;

    public FetchCategoryData(Context context,CategoryAdapter adapter,int parentID){
        this.context = context;
        this.adapter = adapter;

        categoryList = new ArrayList<>();

        this.adapter = new CategoryAdapter(context, categoryList,parentID);

    }

    @Override
    protected ArrayList doInBackground(String... params) {

        String data = null;

        if (params.length == 0) {
            return null;
        }

        try {
            HttpsURLConnection conn = ConnectionManager.openConnection(params[0]);
            data = ConnectionManager.getResult(conn);
            Log.v("aaaaaaaaaaaaaa",data);
            Log.v("aaaaaaaaaaaaaa","bb");

        } catch (IOException e) {
            e.printStackTrace();
            Log.v("aaaaaaaaaaaaaa","erreo");
            Log.v("aaaaaaaaaaaaaa",e.getMessage());
            Log.v("aaaaaaaaaaaaaa",e.getMessage().toString());

        }

        try {
            JsonUtil.CategoryData(data);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return (ArrayList) categoryList;
    }


    @Override
    protected void onPostExecute(ArrayList l) {
        if (categoryList == null) {
            return;
        }

        Log.v("aaaaaaaaaaaaaa",l.size()+"");
        adapter.notifyDataSetChanged();
    }



}
