package com.mobiledocker.mobiledocker.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

public class JSONUtil {

    public static boolean isVerifiedJSON(String stringJSON) {
        try {
            new Gson().fromJson(stringJSON, Object.class);
            return true;
        } catch (JsonSyntaxException jsonException) {
            return false;
        }
    }
}
