package com.example.rentclothes.fragment;

import android.os.Build;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.fragment.app.Fragment;

import com.example.rentclothes.R;
import com.example.rentclothes.adapter.ShopCarAdapter;
import com.example.rentclothes.entity.HttpCom;
import com.example.rentclothes.entity.ShopCartItem;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.xutils.common.Callback;
import org.xutils.http.RequestParams;
import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.fragment_car)
public class CarFragment extends Fragment {

    @ViewInject(R.id.car_con_lv)
    ListView car_con_lv;


    private List<ShopCartItem> getList = new ArrayList<>();
    private ShopCarAdapter shopCarAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Override
    public void onResume() {
        super.onResume();
        setListData();
    }

    private void setListData(){
        List<ShopCartItem> list = new ArrayList<>();
        ShopCartItem shopCartItem = new ShopCartItem("美女性感内衣","999","男士牛皮真鞋");
        ShopCartItem shopCartItem1 = new ShopCartItem("美女性感内衣","999","男士牛皮真鞋");
        ShopCartItem shopCartItem2 = new ShopCartItem("美女性感内衣","999","假数据，不想说多累死了");

        list.add(shopCartItem);
        list.add(shopCartItem1);
        list.add(shopCartItem2);
        list.add(shopCartItem);
        list.add(shopCartItem1);
        list.add(shopCartItem2);
        list.add(shopCartItem);
        list.add(shopCartItem1);
        list.add(shopCartItem2);
        list.add(shopCartItem);
        list.add(shopCartItem1);
        list.add(shopCartItem2);

        getList = list;
        System.out.println(list.size());
        shopCarAdapter = new ShopCarAdapter(getActivity(),list);
        car_con_lv.setAdapter(shopCarAdapter);
    }


}
