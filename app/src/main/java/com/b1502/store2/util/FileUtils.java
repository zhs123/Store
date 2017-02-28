package com.b1502.store2.util;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * 项目名称：Moonlightteapeople
 * 类描述：
 * 创建人：${丁江楠}
 * 创建时间：2017/2/16 20:29
 * 修改人：${丁江楠}
 * 修改时间：2017/2/16 20:29
 * 修改备注：
 */
public class FileUtils {
    //判断是否本地有sd卡，确定是否保存在SD卡内
    String path;//文件存储的地方

    /**
     * 通过构造方法传入存储的路径
     */
    public FileUtils(Context context, String dirName) {
        //判断是否本地有sd卡，这里代表的是SD卡在就绪的状态
//这里判断相等状态要使用.equal，使用==会匹配不到？？？
        if (Environment.getExternalStorageState().equals( Environment.MEDIA_MOUNTED)) {
            ShowUtils.e("SD卡就绪状态");
            path = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + dirName;
        } else {
            ShowUtils.e("SD卡没有就绪状态");
            //保存在内部存储器中
            path = context.getCacheDir().getAbsolutePath() + "/" + dirName;
        }
        //创建文件
        new File(path).mkdirs();
    }

    /**
     * 文件的写入
     * 传入一个文件的名称和一个Bitmap对象
     * 最后的结果是保存一个图片
     */
    public void saveToSDCard(String key, Bitmap bmp) {
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(new File(path, key));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        //保存图片的设置
        bmp.compress(Bitmap.CompressFormat.PNG, 100, fos);
        try {
            fos.close();//关闭流
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 文件的读取，
     * 根据文件的名字，读取出一个Bitmap的对象，
     * 如果之前保存过就有值，否则是null
     */
    public Bitmap readFromSDCard(String key) {
        return BitmapFactory.decodeFile(new File(path, key).getAbsolutePath());
    }
}
