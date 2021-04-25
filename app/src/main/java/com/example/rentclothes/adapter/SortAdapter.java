package com.example.rentclothes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rentclothes.MyApplication;
import com.example.rentclothes.R;
import com.example.rentclothes.entity.HomeMvItem;
import com.example.rentclothes.entity.SortRightItem;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.shehuan.niv.NiceImageView;

import org.xutils.view.annotation.ContentView;

import java.util.List;

@ContentView(R.layout.sort_list_item)
public class SortAdapter extends RecyclerView.Adapter<SortAdapter.ViewHolder> {

    private List<SortRightItem> listData;
    private Context context;
    private SortRightItem item;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.sort_list_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item = listData.get(position);
        Glide.with(context).load(item.getImageUrl()).into(holder.item_sort_niv);

        holder.item_sort_niv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                listen.myClick(listData.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        NiceImageView item_sort_niv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_sort_niv = itemView.findViewById(R.id.item_sort_niv);
        }
    }

    // 需要添加实体类
    public SortAdapter(Context getContext, List<SortRightItem> list){
        context = getContext;
        listData = list;
    }

    //添加事件监听
    private ListenMvOnClick listen;
    public void setOnMyClick(SortAdapter.ListenMvOnClick listenOnClick){
        this.listen = listenOnClick;
    }
    public interface ListenMvOnClick{
        void myClick(SortRightItem sortRightItem);
    }

}
