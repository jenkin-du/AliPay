package com.uestc.jenkin.alipay;

import android.content.Intent;
import android.os.Bundle;
import android.os.Environment;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        PluginManager.getInstance().setContext(this);
    }


    /**
     * 点击
     *
     * @param view
     */
    public void click(View view) {

        Intent intent = new Intent(this, ProxyActivity.class);

        Log.i("TAG", "click: PluginManager.getInstance().entryActivityName:" + PluginManager.getInstance().entryActivityName);

        intent.putExtra("className", PluginManager.getInstance().entryActivityName);
        startActivity(intent);
    }

    /**
     * 加载
     *
     * @param view
     */
    public void load(View view) {

        File file = new File(Environment.getExternalStorageDirectory(), "plugin.apk");
        PluginManager.getInstance().loadPath(file.getAbsolutePath());
    }
}
