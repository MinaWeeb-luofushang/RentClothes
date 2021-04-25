package com.example.rentclothes;

import android.app.Application;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import android.view.Window;

import androidx.appcompat.app.ActionBar;

import com.nostra13.universalimageloader.cache.disc.impl.UnlimitedDiskCache;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.utils.StorageUtils;

import org.xutils.x;

import java.io.File;

public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();

        x.Ext.init(this);
//        initImageLoader(getApplicationContext());
//        AVOSCloud.initialize(this,"{{appid}}","{{appkey}}");
    }


    private void initImageLoader(Context context) {
        File cacheDir = StorageUtils.getOwnCacheDirectory(context,"Kevin/");
        /**ImageLoader的配置**/
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context)
                .threadPriority(Thread.NORM_PRIORITY-2)//设置同时运行的线程
                .denyCacheImageMultipleSizesInMemory()//缓存显示不同大小的同一张图片
                .diskCacheSize(50*1024*1024)  //50MB SD卡本地缓存的最大值
                .diskCache(new UnlimitedDiskCache(cacheDir)) //SD卡缓存
                .memoryCache(new WeakMemoryCache()) //内存缓存
                .tasksProcessingOrder(QueueProcessingType.LIFO).build();
        //全局初始话配置
        ImageLoader.getInstance().init(config);
    }

    public static DisplayImageOptions setImageOptions(){
        //定义显示配置
        DisplayImageOptions options = new DisplayImageOptions.Builder()
                .showImageOnLoading(R.drawable.onloading)
                .showImageForEmptyUri(R.drawable.forempty)//图片为空
                .showImageOnFail(R.drawable.onfail)//图片加载乱码失败
                .cacheInMemory(true)
                .cacheOnDisk(true)
                .considerExifParams(true)
                .bitmapConfig(Bitmap.Config.RGB_565)
                .build();
        return options;
    }
}
