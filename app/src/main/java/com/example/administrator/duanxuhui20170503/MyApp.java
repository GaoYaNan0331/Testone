package com.example.administrator.duanxuhui20170503;

import android.app.Application;

import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;

import org.xutils.x;

/**
 * data 2017/5/3  9:27.
 * author:段旭晖(Administrator)
 * function:
 */

public class MyApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        x.Ext.init(this);
        x.Ext.setDebug(true);

        ImageLoaderConfiguration configuration=new ImageLoaderConfiguration.Builder(this)
                .diskCacheSize(50*1024*1024).memoryCacheSize(50*1024*1024).build();
        ImageLoader.getInstance().init(configuration);
    }
}
