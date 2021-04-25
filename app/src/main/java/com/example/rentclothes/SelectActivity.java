package com.example.rentclothes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_select)
public class SelectActivity extends AppCompatActivity {
    @ViewInject(R.id.select_iv_head)
    ImageView select_iv_head;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //直接设置颜色
        getWindow().setStatusBarColor(getResources().getColor(R.color.clorStateHead));
    }
    @Event(value = {R.id.select_iv_head})
    private void viewOnClick(View view){
        switch (view.getId()){
            case R.id.select_iv_head:
                onBackPressed();
            default:
                break;
        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        finish();
    }
}