package com.example.rentclothes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.rentclothes.entity.BannerItem;
import com.geek.banner.Banner;
import com.geek.banner.loader.BannerEntry;
import com.geek.banner.loader.ImageLoader;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_product_details)
public class ProductDetailsActivity extends AppCompatActivity {

    @ViewInject(R.id.pro_det_banner)
    Banner pro_det_banner;
    @ViewInject(R.id.set_vr_llt)
    LinearLayout set_vr_llt;
    @ViewInject(R.id.detail_back_llt)
    LinearLayout detail_back_llt;
    @ViewInject(R.id.detail_set_order_tv)
    TextView detail_set_order_tv;

    //轮播数据图片
    private List<BannerItem> mData = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        initBanner();
    }
    //给轮播图添加数据
    private void initData() {
        mData.add(new BannerItem(R.drawable.suit,""));
        mData.add(new BannerItem(R.drawable.suit1,""));

    }



    @Event(value = {R.id.set_vr_llt,R.id.detail_back_llt,R.id.detail_set_order_tv})
    private void listenClick(View view){
        switch (view.getId()){
            case R.id.set_vr_llt:

//                startActivity(new Intent(this,VrtvActivity.class));
                break;
            case R.id.detail_back_llt:
                onBackPressed();
                this.finish();
                break;
            case R.id.detail_set_order_tv:
                startActivity(new Intent(this,SetOrderActivity.class));
                break;
            default:
                break;
        }
    }

    //轮播图
    private void initBanner(){
        if (mData.size()==0){
            initData();
        }
        //设置图片圆角角度
        RoundedCorners roundedCorners = new RoundedCorners(30);
        // 1. 创建设置BannerLoader
        pro_det_banner.setBannerLoader(new ImageLoader() {
            @Override
            public void loadView(Context context, BannerEntry entry, int position, View imageView) {
                RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.banner_default)
                        .error(R.drawable.banner_default)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).bitmapTransform(roundedCorners);
                Glide.with(ProductDetailsActivity.this).load(entry.getBannerPath()).apply(requestOptions).into((ImageView) imageView);
            }
        });
        // 2 设置页面点击事件
        pro_det_banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void onBannerClick(int position) {
                Toast.makeText(ProductDetailsActivity.this, "点击了：" + position, Toast.LENGTH_SHORT).show();
            }
        });

        // 3 翻页事件
        pro_det_banner.setBannerPagerChangedListener(new Banner.OnBannerSimplePagerListener() {
            @Override
            public void onPageSelected(int position) {

            }
        });
        // 4 最重要一步，加载数据
        pro_det_banner.loadImagePaths(mData);
    }

    @Override
    protected void onResume() {
        super.onResume();

    }
}