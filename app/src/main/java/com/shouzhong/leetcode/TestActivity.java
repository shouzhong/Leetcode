package com.shouzhong.leetcode;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.shouzhong.annotation.BindView;
import com.shouzhong.annotation.OnClick;
import com.shouzhong.binder.Binding;

public class TestActivity extends AppCompatActivity {
    @BindView(R.id.tv)
    TextView tv;

    private int num;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        Binding.bind(this);
    }

    @OnClick(R.id.btn)
    void onClick(View v) {
        tv.setText("点击了" + (++num) + "次");
    }
}
