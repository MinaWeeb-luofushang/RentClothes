package com.example.rentclothes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.rentclothes.R;
import com.example.rentclothes.entity.HomeMvItem;

import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {
    private List<HomeMvItem> listData;
    private Context context;
    private HomeMvItem item;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.home_mv_item,parent,false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item = listData.get(position);
        holder.item_label_tv.setText(item.getMvLabel());
//        holder.item_mv_niv.setImageURI(Uri.parse("https://fanyiapp.cdn.bcebos.com/cms/image/827151929f4b92b421e03396ead7b18c.jpg"));
        holder.item_mv_niv.setImageResource(R.drawable.banner_4);
        holder.item_number_tv.setText(item.getLookNumber()+"看过");

        holder.item_mv_niv.setOnClickListener(new View.OnClickListener() {
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
        ImageView item_mv_niv;
        TextView item_number_tv;
        TextView item_label_tv;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_mv_niv = itemView.findViewById(R.id.item_mv_niv);
            item_number_tv = itemView.findViewById(R.id.item_number_tv);
            item_label_tv = itemView.findViewById(R.id.item_label_tv);

        }
    }

    // 需要添加实体类
    public HomeAdapter(Context getContext, List<HomeMvItem> list){
        context = getContext;
        listData = list;
    }

    //添加事件监听
    private ListenMvOnClick listen;
    public void setOnMyClick(HomeAdapter.ListenMvOnClick listenOnClick){
        this.listen = listenOnClick;
    }
    public interface ListenMvOnClick{
        void myClick(HomeMvItem homeMvItem);
    }


}
