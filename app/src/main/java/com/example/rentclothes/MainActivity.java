package com.example.rentclothes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.rentclothes.fragment.CarFragment;
import com.example.rentclothes.fragment.HomeFragment;
import com.example.rentclothes.fragment.SelfFragment;
import com.example.rentclothes.fragment.SortFragment;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @ViewInject(R.id.clo_llt_home)
    LinearLayout clo_llt_home;
    @ViewInject(R.id.clo_llt_sort)
    LinearLayout clo_llt_sort;
    @ViewInject(R.id.clo_llt_car)
    LinearLayout clo_llt_car;
    @ViewInject(R.id.clo_llt_self)
    LinearLayout clo_llt_self;

    @ViewInject(R.id.clo_iv_home)
    ImageView clo_iv_home;
    @ViewInject(R.id.clo_iv_sort)
    ImageView clo_iv_sort;
    @ViewInject(R.id.clo_iv_car)
    ImageView clo_iv_car;
    @ViewInject(R.id.clo_iv_self)
    ImageView clo_iv_self;

    @ViewInject(R.id.clo_tv_home)
    TextView clo_tv_home;
    @ViewInject(R.id.clo_tv_sort)
    TextView clo_tv_sort;
    @ViewInject(R.id.clo_tv_car)
    TextView clo_tv_car;
    @ViewInject(R.id.clo_tv_self)
    TextView clo_tv_self;

    @ViewInject(R.id.clo_flt)
    FrameLayout clo_flt;
    @ViewInject(R.id.clo_flt_head)
    FrameLayout clo_flt_head;
    @ViewInject(R.id.clo_tv_head)
    TextView clo_tv_head;
    @ViewInject(R.id.clo_iv_head)
    ImageView clo_iv_head;

    private int setNvaTxIndex = 0;
    private FragmentManager fm = getSupportFragmentManager();
    private FragmentTransaction ft ;
    private HomeFragment homeFragment = new HomeFragment();
    private SortFragment sortFragment = new SortFragment();
    private CarFragment carFragment = new CarFragment();
    private SelfFragment selfFragment = new SelfFragment();
    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        //直接设置颜色
        getWindow().setStatusBarColor(getResources().getColor(R.color.clorStateHead));
        if (savedInstanceState==null){
            viewOnClick(clo_iv_home);
            navImgTvChange(setNvaTxIndex);
            ft.replace(R.id.clo_flt,homeFragment).commitNowAllowingStateLoss();
        }
//        initPrams();
    }

    public void start_more(View view){
        startActivity(new Intent(this,MoreListActivity.class));
    }


    //给导航栏改变颜色 和图片的切换
    private void navImgTvChange(int index){
        switch (index){
            case 0:
                clo_iv_home.setSelected(true);
                clo_tv_home.setTextColor(getResources().getColor(R.color.colorMainNavTxTrue));
                clo_iv_sort.setSelected(false);
                clo_tv_sort.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_car.setSelected(false);
                clo_tv_car.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_self.setSelected(false);
                clo_tv_self.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                break;
            case 1:
                clo_iv_home.setSelected(false);
                clo_tv_home.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_sort.setSelected(true);
                clo_tv_sort.setTextColor(getResources().getColor(R.color.colorMainNavTxTrue));
                clo_iv_car.setSelected(false);
                clo_tv_car.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_self.setSelected(false);
                clo_tv_self.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                break;
            case 2:
                clo_iv_home.setSelected(false);
                clo_tv_home.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_sort.setSelected(false);
                clo_tv_sort.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_car.setSelected(true);
                clo_tv_car.setTextColor(getResources().getColor(R.color.colorMainNavTxTrue));
                clo_iv_self.setSelected(false);
                clo_tv_self.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));;
                break;
            case 3:
                clo_iv_home.setSelected(false);
                clo_tv_home.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_sort.setSelected(false);
                clo_tv_sort.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_car.setSelected(false);
                clo_tv_car.setTextColor(getResources().getColor(R.color.colorMainNavTxFalse));
                clo_iv_self.setSelected(true);
                clo_tv_self.setTextColor(getResources().getColor(R.color.colorMainNavTxTrue));
                break;
            default:
                break;

        }
    }

    private void initPrams(){
        clo_tv_head.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("这里已经11走到了");
            }
        });
    }

    @Event(value = {R.id.clo_llt_home,R.id.clo_llt_sort,R.id.clo_llt_car,R.id.clo_llt_self,R.id.clo_tv_head})
    private void viewOnClick(View view){
        ft = fm.beginTransaction();
        switch (view.getId()){
            case R.id.clo_llt_home:
                setNvaTxIndex = 0;
                ft.replace(R.id.clo_flt,homeFragment).commitNowAllowingStateLoss();
                break;
            case R.id.clo_llt_sort:
                setNvaTxIndex = 1;
                ft.replace(R.id.clo_flt,sortFragment).commitNowAllowingStateLoss();
                break;
            case R.id.clo_llt_car:
                setNvaTxIndex = 2;
                ft.replace(R.id.clo_flt,carFragment).commitNowAllowingStateLoss();
                break;
            case R.id.clo_llt_self:
                setNvaTxIndex = 3;
                ft.replace(R.id.clo_flt,selfFragment).commitNowAllowingStateLoss();
                break;
            case R.id.clo_tv_head:
                startActivity(new Intent(this,SelectActivity.class));
                break;
            default:
                break;
        }
        navImgTvChange(setNvaTxIndex);
    }

    private AlertDialog dialog;
    //监听退出app
    @Override
    public void onBackPressed() {
//        super.onBackPressed();
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this,R.style.Transparent);
        dialog = builder.create();
        dialog.show();
        dialog.setCanceledOnTouchOutside(false);
        Window window = dialog.getWindow();
        window.setContentView(R.layout.exit_dialog);

        TextView textView = dialog.findViewById(R.id.exit_dialog_text);
        Button cancelBtn = dialog.findViewById(R.id.cancal_button);
        Button exitBtn = dialog.findViewById(R.id.exit_button);
        exitBtn.setText("确 认");
        cancelBtn.setText("取 消");


        textView.setText("不想再逛逛么 亲");
        Display d = getWindowManager().getDefaultDisplay();


        int h,w,tSp;
        tSp = (int)(d.getHeight() * 0.00936);

        if(d.getWidth() > d.getHeight()) {
            h = (int) (d.getHeight() * 0.67);
            //if (h >= 892) h = 892;
            w = (int) (h * 1.35);
            textView.setTextSize(15);
        }else{
            w = (int)(d.getWidth() * 0.8);
            h = (int)(w * 0.626);
            textView.setTextSize(15);

            cancelBtn.setTextSize((float) (tSp*0.6));
            exitBtn.setTextSize((float) (tSp*0.6));
        }

        dialog.getWindow().setLayout(w, h);

        return;
    }

    public void dismiss(View view){
        dialog.dismiss();
    }

    public void exit_true(View view){
        dialog.dismiss();
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        startActivity(intent);
        android.os.Process.killProcess(android.os.Process.myPid());
    }


}