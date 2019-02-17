package com.gmail.tarasov1998.demoapplication.data;

import com.gmail.tarasov1998.demoapplication.model.UserModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class JsonParser {

    public static UserModel getUser(String data) throws JSONException {
        UserModel userModel = new UserModel();
        JSONArray jArr = new JSONArray(data);

        int length = jArr.length();

        for (int i = 0; i < length; i++) {
            JSONObject jObj = jArr.getJSONObject(i);


            userModel.setName(getString("name", jObj));
            userModel.setUsername(getString("username", jObj));
            userModel.setEmail(getString("email", jObj));
            userModel.setPhone(getString("phone", jObj));
            userModel.setWebsite(getString("website", jObj));

            JSONObject address = jObj.getJSONObject("address");
            JSONObject geo = address.getJSONObject("geo");
            userModel.setLat(getDouble("lat", geo));
            userModel.setLng(getDouble("lng", geo));

            JSONObject company = jObj.getJSONObject("company");
            userModel.setCatchPhrase(getString("catchPhrase", company));


        }


        return userModel;
    }
    private static String getString(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getString(tagName);
    }
    private static Double getDouble(String tagName, JSONObject jObj) throws JSONException {
        return jObj.getDouble(tagName);
    }

}
