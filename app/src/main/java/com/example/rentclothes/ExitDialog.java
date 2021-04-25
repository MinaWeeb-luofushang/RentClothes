package com.example.rentclothes;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.x;

@ContentView(R.layout.exit_dialog)
public class ExitDialog extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        x.view().inject(this);
    }
}
