package com.example.rentclothes;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Build;
import android.os.Bundle;

import com.example.rentclothes.adapter.GuessAdapter;
import com.example.rentclothes.entity.MoreGuessItem;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

import java.util.ArrayList;
import java.util.List;

@ContentView(R.layout.activity_more_list)
public class MoreListActivity extends AppCompatActivity {

    @ViewInject(R.id.more_rlv)
    RecyclerView more_rlv;


    private GuessAdapter guessAdapter;
    private List<MoreGuessItem> getList = new ArrayList<>();

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
        getWindow().setStatusBarColor(getResources().getColor(R.color.clorStateHead));
    }

    @Override
    protected void onResume() {
        super.onResume();
        initPrams();
    }

    private void initPrams(){
        List<MoreGuessItem> list = new ArrayList<>();
        getList = list;
        MoreGuessItem guessItem = new MoreGuessItem("","","",9090);

        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);
        list.add(guessItem);list.add(guessItem); list.add(guessItem);

        guessAdapter = new GuessAdapter(this,list);
        more_rlv.setAdapter(guessAdapter);
        StaggeredGridLayoutManager linearLayoutManager= new StaggeredGridLayoutManager(3,StaggeredGridLayoutManager.VERTICAL);
        more_rlv.setLayoutManager(linearLayoutManager);
    }
}