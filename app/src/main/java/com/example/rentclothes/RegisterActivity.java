package com.example.rentclothes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.activity_register)
public class RegisterActivity extends AppCompatActivity {

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //直接设置颜色
        getWindow().setStatusBarColor(getResources().getColor(R.color.clorStateHead));
    }

    public void tv_sent_info(View view){
        startActivity(new Intent(this,LoginActivity.class));
        finish();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

    }
}