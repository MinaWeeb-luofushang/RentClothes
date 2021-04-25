package com.example.rentclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.os.Bundle;
import android.util.Log;

import com.google.vr.sdk.widgets.pano.VrPanoramaEventListener;
import com.google.vr.sdk.widgets.pano.VrPanoramaView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

@ContentView(R.layout.activity_vrtv)
public class VrtvActivity extends AppCompatActivity {
    @ViewInject(R.id.vr_pan_view)
    VrPanoramaView vr_pan_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Override
    protected void onResume() {
        super.onResume();

        setVRImage();
    }
    private void setVRImage(){
//        InputStream open = null;
//        try {
//            open = getAssets().open("https://img.yihgj.com/uploads/210422/15-21042212443V50.jpg");
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        Bitmap bitmap =  DownloadImg("https://img.yihgj.com/uploads/210422/15-21042212443V50.jpg");
        Bitmap bitmap = BitmapFactory.decodeResource(this.getResources(), R.drawable.sexy);
//        bitmap = scaleBitmap(bitmap,100,70);
        bitmap = scaleBitmap(bitmap,0.3f);
        /**设置加载VR图片的相关设置**/
        VrPanoramaView.Options options = new VrPanoramaView.Options();
        options.inputType = VrPanoramaView.Options.TYPE_STEREO_OVER_UNDER;
        vr_pan_view.setEventListener(new VrPanoramaEventListener(){
            @Override
            public void onDisplayModeChanged(int newDisplayMode) {
                super.onDisplayModeChanged(newDisplayMode);
            }

            @Override
            public void onLoadError(String errorMessage) {
                super.onLoadError(errorMessage);
                Log.d(TAG, "onLoadError()->图片加载失败=" + errorMessage);
            }

            @Override
            public void onLoadSuccess() {
                super.onLoadSuccess();
                Log.d(TAG, "onLoadSuccess->图片加载成功");
            }
        });
        /**加载VR图片**/
        System.out.println("加载VR图片"+bitmap);
        vr_pan_view.loadImageFromBitmap(bitmap, options);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        vr_pan_view.shutdown();

    }
    private Bitmap scaleBitmap(Bitmap origin, float ratio) {
        if (origin == null) {
            return null;
        }
        int width = origin.getWidth();
        int height = origin.getHeight();
        Matrix matrix = new Matrix();
        matrix.preScale(ratio, ratio);
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (newBM.equals(origin)) {
            return newBM;
        }
        origin.recycle();
        return newBM;
    }
    private Bitmap scaleBitmap(Bitmap origin, int newWidth, int newHeight) {
        if (origin == null) {
            return null;
        }
        int height = origin.getHeight();
        int width = origin.getWidth();
        float scaleWidth = ((float) newWidth) / width;
        float scaleHeight = ((float) newHeight) / height;
        Matrix matrix = new Matrix();
        matrix.postScale(scaleWidth, scaleHeight);// 使用后乘
        Bitmap newBM = Bitmap.createBitmap(origin, 0, 0, width, height, matrix, false);
        if (!origin.isRecycled()) {
            origin.recycle();
        }
        return newBM;
    }

    private Bitmap DownloadImg(String imgPath) {
        Bitmap bm = null;
        try {
            URL iconUrl = new URL(imgPath);
            URLConnection conn = iconUrl.openConnection();
            HttpURLConnection http = (HttpURLConnection) conn;

            int length = http.getContentLength();

            conn.connect();
            // 获得图像的字符流
            InputStream is = conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(is, length);
            bm = BitmapFactory.decodeStream(bis);
            bis.close();
            is.close();// 关闭流
        }
        catch (Exception e) {
            e.printStackTrace();
        }
//        return scaleBitmap(bm,100,70);
        return scaleBitmap(bm,0.1f);
    }

    private final String TAG = "VrPanoramaView";
}