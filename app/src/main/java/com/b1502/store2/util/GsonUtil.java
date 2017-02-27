package com.b1502.store2.util;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

/**
 * @author JasonMiao
 * @date 2016-1-29
 */
public final class GsonUtil {

    private static Gson mGson = new Gson();

    public static <T> T parseJsonToObj(String jsonStr, TypeToken<T> token) {
        return mGson.fromJson(jsonStr, token.getType());
    }

    public static <T> String parseObjToJson(Object src, TypeToken<T> token) {
        return mGson.toJson(src, token.getType());
    }

}
