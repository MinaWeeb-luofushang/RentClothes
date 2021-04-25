package com.example.rentclothes.fragment;

import android.annotation.SuppressLint;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.rentclothes.R;
import com.example.rentclothes.adapter.SortAdapter;
import com.example.rentclothes.adapter.SortLeftAdapter;
import com.example.rentclothes.entity.SortLeftItem;
import com.example.rentclothes.entity.SortRightItem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.fragment_sort)
public class SortFragment extends Fragment {

    @ViewInject(R.id.sort_right_rlv)
    RecyclerView sort_right_rlv;
    @ViewInject(R.id.sort_left_lv)
    ListView sort_left_lv;

    @ViewInject(R.id.sort_girl_tv)
    TextView sort_girl_tv;
    @ViewInject(R.id.sort_man_tv)
    TextView sort_man_tv;


    private List<SortRightItem> getList = new ArrayList<>();
    private SortAdapter sortAdapter;

    private List<SortLeftItem> getLeftList = new ArrayList<>();
    private SortLeftAdapter sortLeftAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @SuppressLint("ResourceAsColor")
    @Event(value = {R.id.sort_girl_tv,R.id.sort_man_tv})
    private void viewOnClick(View view){
        switch (view.getId()){
            case R.id.sort_girl_tv:
                setLeftListData("girl");
                sort_girl_tv.setBackgroundResource(R.drawable.fillet_check);
                sort_girl_tv.setTextColor(Color.parseColor("#F23C34"));
                sort_man_tv.setBackgroundResource(R.drawable.fillet);
                sort_man_tv.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case R.id.sort_man_tv:
                setLeftListData("man");
                sort_girl_tv.setBackgroundResource(R.drawable.fillet);
                sort_girl_tv.setTextColor(Color.parseColor("#FFFFFF"));
                sort_man_tv.setBackgroundResource(R.drawable.fillet_check);
                sort_man_tv.setTextColor(Color.parseColor("#F23C34"));
                break;
            default:
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SetRightListData();
        setLeftListData("girls");
    }
    //设置左侧列表
    private void setLeftListData(String sex){
        List<SortLeftItem> manList = new ArrayList<>();
        if (sex=="man"){
            SortLeftItem man_1 = new SortLeftItem("品牌皮鞋","321","4864");
            SortLeftItem man_2 = new SortLeftItem("国产西装","321","4864");
            SortLeftItem man_3 = new SortLeftItem("格子衣","321","4864");
            SortLeftItem man_4 = new SortLeftItem("绅士手表","321","4864");
            SortLeftItem man_5 = new SortLeftItem("名牌领带","321","4864");
            manList.add(man_1);
            manList.add(man_2);
            manList.add(man_3);
            manList.add(man_4);
            manList.add(man_5);
        }else {
            SortLeftItem girls_1 = new SortLeftItem("华丽裙子","5464","46");
            SortLeftItem girls_2 = new SortLeftItem("潮流高跟鞋","5464","46");
            SortLeftItem girls_3 = new SortLeftItem("格子装","5464","46");
            SortLeftItem girls_4 = new SortLeftItem("名牌领结","5464","46");
            SortLeftItem girls_5 = new SortLeftItem("西装外套","5464","46");
            SortLeftItem girls_6 = new SortLeftItem("项链  口红","5464","46");
            SortLeftItem girls_7 = new SortLeftItem("气质手表","5464","46");
            manList.add(girls_1);
            manList.add(girls_2);
            manList.add(girls_3);
            manList.add(girls_4);
            manList.add(girls_5);
            manList.add(girls_6);
            manList.add(girls_7);
        }
        getLeftList = manList;
        System.out.println(getLeftList.size());
        sortLeftAdapter = new SortLeftAdapter(getActivity(),getLeftList);
        sort_left_lv.setAdapter(sortLeftAdapter);
        sortLeftAdapter.setOnMyClick(new SortLeftAdapter.ListenMvOnClick() {
            @Override
            public void myClick(SortLeftItem sortLeftItem) {
//                sort_select_tv.setText("909090");
                Toast.makeText(getActivity(), "点击了：" + sortLeftItem.getShowTx(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    //设置右边的数据图片
    private void setStaticImageList(){
        List<SortRightItem> list = new ArrayList<>();
        SortRightItem rightItem = new SortRightItem("https://dss1.bdstatic.com/70cFuXSh_Q1YnxGkpoWK1HF6hhy/it/u=3576358313,3239146876&fm=26&gp=0.jpg","12123",
                "3408","男人想啥来啥");
        SortRightItem rightItem7 = new SortRightItem("http://img.netbian.com/file/2020/1028/small694c09532609dfd4780e61722a3eac1f1603894660.jpg","132154",
                "657465","链接二线");
        SortRightItem rightItem1 = new SortRightItem("https://dss2.bdstatic.com/70cFvnSh_Q1YnxGkpoWK1HF6hhy/it/u=1988570741,2155245393&fm=26&gp=0.jpg","12123",
                "3408","男孩想啥来啥");
        SortRightItem rightItem6 = new SortRightItem("http://img.netbian.com/file/2021/0107/smallcafbdb6ac163b25c6adfb3dc17b3921d1610030849.jpg","132154",
                "657465","链接二线");
        SortRightItem rightItem2 = new SortRightItem("https://dss0.bdstatic.com/70cFuHSh_Q1YnxGkpoWK1HF6hhy/it/u=2620060887,2204565383&fm=26&gp=0.jpg","12123",
                "3408","男生想啥来啥");
        SortRightItem rightItem3 = new SortRightItem("https://dss0.bdstatic.com/70cFvHSh_Q1YnxGkpoWK1HF6hhy/it/u=2745497348,358555300&fm=26&gp=0.jpg","132154",
                "657465","链接二线");
        SortRightItem rightItem5 = new SortRightItem("http://img.netbian.com/file/2021/0317/small9398baebee6da75ce10cc5dedc8f074f1615913170.jpg","132154",
                "657465","链接二线");
        SortRightItem rightItem4 = new SortRightItem("http://img.netbian.com/file/2021/0302/small7d3e65c1cce37cf31bc59987d2daf3b61614616224.jpg","132154",
                "657465","链接二线");
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);
        list.add(rightItem);

//        list.add(rightItem);
//        list.add(rightItem1);
//        list.add(rightItem2);
//        list.add(rightItem3);
//        list.add(rightItem4);
//        list.add(rightItem5);
//        list.add(rightItem6);
//        list.add(rightItem7);
//
//
//        list.add(rightItem);
//        list.add(rightItem7);
//        list.add(rightItem1);
//        list.add(rightItem6);
//        list.add(rightItem2);
//        list.add(rightItem3);
//        list.add(rightItem5);
//        list.add(rightItem4);
//
//        list.add(rightItem);
//        list.add(rightItem1);
//        list.add(rightItem2);
//        list.add(rightItem3);
//        list.add(rightItem4);
//        list.add(rightItem5);
//        list.add(rightItem6);
//        list.add(rightItem7);
//
//        list.add(rightItem);
//        list.add(rightItem7);
//        list.add(rightItem1);
//        list.add(rightItem6);
//        list.add(rightItem2);
//        list.add(rightItem3);
//        list.add(rightItem5);
//        list.add(rightItem4);

//        list.add(rightItem);
//        list.add(rightItem1);
//        list.add(rightItem2);
//        list.add(rightItem3);
//        list.add(rightItem4);
//        list.add(rightItem5);
//        list.add(rightItem6);
//        list.add(rightItem7);
        getList = list;
    }
    //设置右边的列表
    private void SetRightListData(){
        setStaticImageList();
        sortAdapter = new SortAdapter(getActivity(),getList);
        StaggeredGridLayoutManager linearLayoutManager= new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        linearLayoutManager.canScrollVertically();//设置不滚动
        sort_right_rlv.setLayoutManager(linearLayoutManager);
        sort_right_rlv.setAdapter(sortAdapter);

        sortAdapter.setOnMyClick(new SortAdapter.ListenMvOnClick() {
            @Override
            public void myClick(SortRightItem homeMvItem) {
                Toast.makeText(getActivity(), "点击了：" + homeMvItem.getSortLabel(), Toast.LENGTH_SHORT).show();
            }
        });
    }


}
