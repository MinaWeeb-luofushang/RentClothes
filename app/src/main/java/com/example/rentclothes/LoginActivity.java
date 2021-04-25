package com.example.rentclothes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.rentclothes.entity.HttpCom;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_login)
public class LoginActivity extends AppCompatActivity {

    @ViewInject(R.id.login_tv)
    TextView login_tv;
    @ViewInject(R.id.register_tv)
    TextView register_tv;



    private HttpCom com =new HttpCom();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //直接设置颜色
        getWindow().setStatusBarColor(getResources().getColor(R.color.clorStateHead));
    }

    @Event(value = {R.id.login_tv,R.id.register_tv})
    private void listenOnClick1(View view){
        switch (view.getId()){
            case R.id.login_tv:
                startActivity(new Intent(this,MainActivity.class));
                finish();
                break;
            case R.id.register_tv:
                startActivity(new Intent(this,RegisterActivity.class));
                finish();
                break;

            default:
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        finish();
    }
}