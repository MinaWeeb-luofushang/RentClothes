package com.example.rentclothes.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rentclothes.R;
import com.example.rentclothes.entity.ShopCartItem;
import com.shehuan.niv.NiceImageView;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class ShopCarAdapter extends MyBaseAdapter<ShopCartItem>{

    public ShopCarAdapter(Context c, List<ShopCartItem> datas) {
        super(c, datas);
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        Entity entity = null;
        if (entity==null){
            entity = new Entity();
            view = layoutInflater.inflate(R.layout.car_list_item,null);
            x.view().inject(entity,view);
            view.setTag(entity);
        }else {
            view.clearAnimation();
            entity = (Entity) view.getTag();
        }


        return view;
    }

    private class Entity{
        @ViewInject(R.id.car_goods_tv)
        TextView car_goods_tv;
        @ViewInject(R.id.car_pays_tv)
        TextView car_pays_tv;
        @ViewInject(R.id.car_goods_iv)
        NiceImageView car_goods_iv;
        @ViewInject(R.id.car_con_tv)
        TextView car_con_tv;
        @ViewInject(R.id.car_money_tv)
        TextView car_money_tv;
        @ViewInject(R.id.car_pbtn_tv)
        TextView car_pbtn_tv;
        @ViewInject(R.id.car_delete_tv)
        TextView car_delete_tv;

    }
}
