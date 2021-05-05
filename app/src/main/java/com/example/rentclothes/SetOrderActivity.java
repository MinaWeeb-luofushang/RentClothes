package com.example.rentclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_set_order)
public class SetOrderActivity extends AppCompatActivity {

    @ViewInject(R.id.order_back_iv)
    ImageView order_back_iv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }

    @Event(value = {R.id.order_back_iv})
    private void listenClick(View view){
        switch (view.getId()){
            case R.id.order_back_iv:
                onBackPressed();
                finish();
            default:
                break;
        }
    }
}