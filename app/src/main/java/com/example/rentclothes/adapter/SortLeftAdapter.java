package com.example.rentclothes.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.rentclothes.R;
import com.example.rentclothes.entity.SortLeftItem;

import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.List;

public class SortLeftAdapter extends MyBaseAdapter<SortLeftItem>{

    public SortLeftAdapter(Context c, List<SortLeftItem> datas) {
        super(c, datas);
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        EntityLeft entityLeft = null;
        if (entityLeft==null){
            entityLeft = new EntityLeft();
            convertView = layoutInflater.inflate(R.layout.sort_left_item,null);
            x.view().inject(entityLeft,convertView);
            convertView.setTag(entityLeft);
        }else {
            convertView.clearAnimation();
            entityLeft = (EntityLeft) convertView.getTag();
        }
        entityLeft.sort_left_tv.setText(datas.get(i).getShowTx());
        entityLeft.sort_left_tv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listen.myClick(datas.get(i));
            }
        });


        return convertView;
    }

    //添加事件监听
    private SortLeftAdapter.ListenMvOnClick listen;
    public void setOnMyClick(SortLeftAdapter.ListenMvOnClick listenOnClick){
        this.listen = listenOnClick;
    }
    public interface ListenMvOnClick{
        void myClick(SortLeftItem sortLeftItem);
    }



    private class EntityLeft{
        @ViewInject(R.id.sort_left_tv)
        TextView sort_left_tv;
    }
}
