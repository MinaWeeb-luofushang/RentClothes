package com.example.rentclothes.fragment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;


import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.bumptech.glide.load.model.LazyHeaders;
import com.bumptech.glide.load.resource.bitmap.RoundedCorners;
import com.bumptech.glide.request.RequestOptions;
import com.example.rentclothes.MovieActivity;
import com.example.rentclothes.ProductDetailsActivity;
import com.example.rentclothes.R;
import com.example.rentclothes.adapter.HomeAdapter;
import com.example.rentclothes.entity.BannerItem;
import com.example.rentclothes.entity.HomeMvItem;
import com.geek.banner.Banner;
import com.geek.banner.loader.BannerEntry;
import com.geek.banner.loader.ImageLoader;
import com.shehuan.niv.NiceImageView;

import org.litepal.crud.DataSupport;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;


@ContentView(R.layout.fragment_home)
public class HomeFragment extends Fragment {

    @ViewInject(R.id.home_banner)
    Banner home_banner;
    @ViewInject(R.id.home_mv_rlv)
    RecyclerView home_mv_rlv;
    @ViewInject(R.id.home_like_niv1)
    NiceImageView home_like_niv1;
    @ViewInject(R.id.home_like_niv2)
    NiceImageView home_like_niv2;
    @ViewInject(R.id.home_like_niv3)
    NiceImageView home_like_niv3;

    private HomeAdapter homeAdapter;

    //??????????????????
    private List<BannerItem> mData = new ArrayList<>();

    //MV??????
    private List<HomeMvItem> getList = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        return x.view().inject(this,inflater,container);
    }


    @Event(value = {R.id.home_like_niv1,R.id.home_like_niv2,R.id.home_like_niv3})
    private void setClickListen(View view){
        switch (view.getId()){
            case R.id.home_like_niv1:
                openProductDetails();
                break;
            case R.id.home_like_niv2:
                openProductDetails();
                break;
            case R.id.home_like_niv3:
                openProductDetails();
                break;
            default:
                break;
        }
    }

    //????????????????????????
    private void openProductDetails(){
        startActivity(new Intent(getActivity(), ProductDetailsActivity.class));
    }

    //????????????mv ??????????????????
    private void setHomeMvLisData(){
//        List<HomeMvItem> list = DataSupport.findAll(HomeMvItem.class);
        List<HomeMvItem> list = new ArrayList<>();
        getList = list;
        HomeMvItem homeMvItem = new HomeMvItem("????????????","????????????",
                1999,"?????????????????????","10011","???????????????????????????");
        HomeMvItem homeMvItem1 = new HomeMvItem("????????????","????????????",
                1099,"?????????????????????","20011","?????????????????????????????????");
        HomeMvItem homeMvItem2 = new HomeMvItem("????????????","????????????",
                12099,"????????????","23011","???????????????????????? ??????");

        list.add(homeMvItem);
        list.add(homeMvItem1);
        list.add(homeMvItem2);
        list.add(homeMvItem);
        list.add(homeMvItem1);
        list.add(homeMvItem2);
        list.add(homeMvItem);
        list.add(homeMvItem1);
        list.add(homeMvItem2);

        homeAdapter = new HomeAdapter(getActivity(),list);
        home_mv_rlv.setAdapter(homeAdapter);
        System.out.println("??????"+list.size());
        homeAdapter.setOnMyClick(new HomeAdapter.ListenMvOnClick() {
            @Override
            public void myClick(HomeMvItem homeMvItem) {
                Toast.makeText(getActivity(), "????????????" + homeMvItem.getTypeName(), Toast.LENGTH_SHORT).show();
                startActivity(new Intent(getActivity(), MovieActivity.class));
            }
        });
    }

    //??????list view???????????? ???????????????????????? ????????????
    private void setCantScroll(){
        LinearLayout.LayoutParams linearParams =(LinearLayout.LayoutParams) home_mv_rlv.getLayoutParams();
        linearParams.height=((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 254*getList.size(), getResources().getDisplayMetrics()));

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext()){
            @Override
            public boolean canScrollVertically() {
                return false;
            }
        };
        home_mv_rlv.setLayoutManager(layoutManager);
        home_mv_rlv.setLayoutParams(linearParams);
    }

    //?????????
    private void initBanner(){
        if (mData.size()==0){
            initData();
        }
        //????????????????????????
        RoundedCorners roundedCorners = new RoundedCorners(30);
        // 1. ????????????BannerLoader
        home_banner.setBannerLoader(new ImageLoader() {
            @Override
            public void loadView(Context context, BannerEntry entry, int position, View imageView) {
                RequestOptions requestOptions = new RequestOptions()
                        .placeholder(R.drawable.banner_default)
                        .error(R.drawable.banner_default)
                        .diskCacheStrategy(DiskCacheStrategy.AUTOMATIC).bitmapTransform(roundedCorners).override(300, 300);
                Glide.with(getActivity()).load(entry.getBannerPath()).apply(requestOptions).into((ImageView) imageView);
            }
        });
        // 2 ????????????????????????
        home_banner.setOnBannerClickListener(new Banner.OnBannerClickListener() {
            @Override
            public void onBannerClick(int position) {
                Toast.makeText(getActivity(), "????????????" + position, Toast.LENGTH_SHORT).show();
            }
        });

        // 3 ????????????
        home_banner.setBannerPagerChangedListener(new Banner.OnBannerSimplePagerListener() {
            @Override
            public void onPageSelected(int position) {

            }
        });
        // 4 ??????????????????????????????
        home_banner.loadImagePaths(mData);
    }
    //????????????????????????
    private void initData() {
        mData.add(new BannerItem(R.drawable.banner_1,""));
        mData.add(new BannerItem(R.drawable.banner_2,""));
        mData.add(new BannerItem(R.drawable.banner_3, ""));
        mData.add(new BannerItem(R.drawable.banner_4, ""));
        mData.add(new BannerItem(R.drawable.banner_5, ""));
    }
    @Override
    public void onResume() {
        super.onResume();
        initBanner();
        home_banner.startAutoPlay();

        setHomeMvLisData();
        StaggeredGridLayoutManager linearLayoutManager= new StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL);
        home_mv_rlv.setLayoutManager(linearLayoutManager);
        setCantScroll();
    }
    @Override
    public void onPause() {
        super.onPause();
        home_banner.stopAutoPlay();
    }

}
