package com.example.rentclothes;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;


import com.universalvideoview.UniversalMediaController;
import com.universalvideoview.UniversalVideoView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.HashMap;
import java.util.Map;

@ContentView(R.layout.activity_movie)
public class MovieActivity extends AppCompatActivity {
    @ViewInject(R.id.movie_u_video)
    UniversalVideoView movie_u_video;
    @ViewInject(R.id.movie_media)
    UniversalMediaController movie_media;

    @ViewInject(R.id.video_layout)
    FrameLayout mVideoLayout;

    private static final String TAG = "MovieActivity";
    private static final String SEEK_POSITION_KEY = "SEEK_POSITION_KEY";
    private static final String VIDEO_URL = "http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4";

//    private int mSeekPosition;
    private boolean isFullscreen1;
    private int cachedHeight;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //直接设置颜色
        getWindow().setStatusBarColor(getResources().getColor(R.color.clorStateHead));
        initPrams();
    }

    private void initPrams() {
        movie_u_video.setMediaController(movie_media);
        movie_u_video.setVideoPath(VIDEO_URL);
        movie_u_video.requestFocus();
        setVideoAreaSize();
        setMovieUVideo();
//        movie_u_video.start();
    }
    //设置全屏
    private void setMovieUVideo(){
        movie_u_video.setVideoViewCallback(new UniversalVideoView.VideoViewCallback() {
            @Override
            public void onScaleChange(boolean isFullscreen) {
                System.out.println("设置全屏时");
                isFullscreen1 = isFullscreen;
                if (isFullscreen) {
                    ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = ViewGroup.LayoutParams.MATCH_PARENT;
                    mVideoLayout.setLayoutParams(layoutParams);
                    //设置全屏时,无关的View消失,以便为视频控件和控制器控件留出最大化的位置

                } else {
                    ViewGroup.LayoutParams layoutParams = mVideoLayout.getLayoutParams();
                    layoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                    layoutParams.height = cachedHeight;
                    mVideoLayout.setLayoutParams(layoutParams);

                }
            }

            @Override
            public void onPause(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingStart(MediaPlayer mediaPlayer) {

            }

            @Override
            public void onBufferingEnd(MediaPlayer mediaPlayer) {

            }
        });
    }

    /**
     * 设置当不是全屏时候视频区域大小
     */
    private void setVideoAreaSize() {
        mVideoLayout.post(new Runnable() {
            @Override
            public void run() {
                int width = mVideoLayout.getWidth();
                cachedHeight = (int) (width * 405f / 720f);
//                cachedHeight = (int) (width * 3f / 4f);
//                cachedHeight = (int) (width * 9f / 16f);
                ViewGroup.LayoutParams videoLayoutParams = mVideoLayout.getLayoutParams();
                videoLayoutParams.width = ViewGroup.LayoutParams.MATCH_PARENT;
                videoLayoutParams.height = cachedHeight;
                mVideoLayout.setLayoutParams(videoLayoutParams);
                movie_u_video.setVideoPath(VIDEO_URL);
                movie_u_video.requestFocus();
            }
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        movie_u_video.pause();
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState, @NonNull PersistableBundle outPersistentState) {
        super.onSaveInstanceState(outState, outPersistentState);
//        outState.putInt(SEEK_POSITION_KEY, mSeekPosition);
    }

    private String getUrl() {
        return "http://9890.vod.myqcloud.com/9890_4e292f9a3dd011e6b4078980237cc3d3.f20.mp4";
    }


    private void switchTitleBar(boolean show) {
        ActionBar supportActionBar = getSupportActionBar();
        if (supportActionBar != null) {
            if (show) {
                supportActionBar.show();
            } else {
                supportActionBar.hide();
            }
        }
    }


    @Override
    public void onBackPressed() {
        if (this.isFullscreen1) {
            movie_u_video.setFullscreen(false);
        } else {
            super.onBackPressed();
        }
    }
}