package com.example.rentclothes.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.rentclothes.R;
import com.example.rentclothes.entity.MoreGuessItem;
import com.shehuan.niv.NiceImageView;

import org.xutils.view.annotation.ContentView;

import java.util.List;

@ContentView(R.layout.guess_list_item)
public class GuessAdapter extends RecyclerView.Adapter<GuessAdapter.ViewHolder> {
    private Context context;
    private List<MoreGuessItem> listData;
    private MoreGuessItem item;

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.guess_list_item,parent,false);
        GuessAdapter.ViewHolder holder = new GuessAdapter.ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        item = listData.get(position);
//        holder.list_title_tx.setText(item.getGuessTitle());
//        Glide.with(context).load(item.getGuessUrl()).into(holder.list_niv);

    }

    @Override
    public int getItemCount() {
        return listData.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        NiceImageView list_niv;
        TextView list_title_tx;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            list_niv = itemView.findViewById(R.id.list_niv);
            list_title_tx = itemView.findViewById(R.id.list_title_tx);

        }
    }

    public GuessAdapter(Context getContext,List<MoreGuessItem> list){
        context = getContext;
        listData = list;
    }
}
