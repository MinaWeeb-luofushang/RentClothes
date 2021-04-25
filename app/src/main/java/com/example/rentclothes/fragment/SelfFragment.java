package com.example.rentclothes.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.rentclothes.LoginActivity;
import com.example.rentclothes.R;
import com.example.rentclothes.RegisterActivity;

import org.xutils.view.annotation.ContentView;
import org.xutils.view.annotation.Event;
import org.xutils.view.annotation.ViewInject;
import org.xutils.x;

@ContentView(R.layout.fragment_self)
public class SelfFragment extends Fragment {

    @ViewInject(R.id.self_user_llt)
    LinearLayout self_user_llt;
    @ViewInject(R.id.self_login_tv)
    TextView self_login_tv;
    @ViewInject(R.id.self_register_tv)
    TextView self_register_tv;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return x.view().inject(this,inflater,container);
    }

    @Event(value = {R.id.self_register_tv,R.id.self_login_tv})
    private void viewOnClick(View view){
        switch (view.getId()){
            case R.id.self_login_tv:
                startActivity(new Intent(getActivity(), LoginActivity.class));
                getActivity().finish();
                break;

            case R.id.self_register_tv:
                startActivity(new Intent(getActivity(), RegisterActivity.class));
                getActivity().finish();
                break;
            default:
                break;
        }
    }
}
