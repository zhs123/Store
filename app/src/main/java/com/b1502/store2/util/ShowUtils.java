package com.b1502.store2.util;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

/**
 * 项目名称：Moonlightteapeople
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/2/16 20:30
 * 修改人：${丁江楠}
 * 修改时间：2017/2/16 20:30
 * 修改备注：
 */
public class ShowUtils {
    public static  boolean DEBUG = true;

    //各种Log打印
    public static void e(Object o) {
        if (DEBUG)
            Log.e("TAG", "打印：------      " + o.toString());
    }

    public static void e(int i) {
        if (DEBUG)
            Log.e("TAG", "打印：------      " + i);
    }

    public static void e(float i) {
        if (DEBUG)
            Log.e("TAG", "打印：------      " + i);
    }

    public static void e(boolean b) {
        if (DEBUG)
            Log.e("TAG", "打印：------      " + b);
    }

    //各种土司
    public static void ts(Context context, Object object) {
        if (DEBUG)
            Toast.makeText(context, object + "", Toast.LENGTH_SHORT).show();
    }

    public static void tsl(Context context, Object object) {
        if (DEBUG)
            Toast.makeText(context, object + "", Toast.LENGTH_LONG).show();
    }

}
