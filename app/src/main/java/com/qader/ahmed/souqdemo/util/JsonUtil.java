package com.qader.ahmed.souqdemo.util;

import com.qader.ahmed.souqdemo.model.CategoryModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ahmed AbdElQader on 21-Jun-18.
 */

public class JsonUtil {

    public static List CategoryData(String data) throws JSONException {

        ArrayList<CategoryModel> categoryList = new ArrayList<>();
        CategoryModel model;


        if (data == null || data.length() == 0)
            return null;

        JSONArray mainArray = new JSONArray(data);
        int length = mainArray.length();

        for (int i = 0 ; i < length ; i++){

            JSONObject mainObject = mainArray.getJSONObject(i);

            model = new CategoryModel();

            model.setId(mainObject.getInt("id"));
            model.setName(mainObject.getString("name"));
            model.setParent(mainObject.getInt("parent"));

            JSONObject image = mainObject.getJSONObject("image");
            model.setImage(image.getString("src"));

            categoryList.add(model);
        }

        return categoryList;

    }

}
