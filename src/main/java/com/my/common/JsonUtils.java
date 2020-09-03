package com.my.common;

import com.google.gson.Gson;

import java.lang.reflect.Type;

public class JsonUtils {

    private static final Gson gson = new Gson();

    public static <T> T fromJson(final String json, Type typeOfT){
        return gson.fromJson(json, typeOfT);
    }

    public static String toJson(final Object src) {
        return gson.toJson(src);
    }

}
