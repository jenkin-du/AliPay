package com.uestc.jenkin.taopiaopaio;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import androidx.annotation.NonNull;

import com.uestc.jenkin.alipayinterface.AliPayInterface;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
@SuppressLint("Registered")
public class BaseActivity extends Activity implements AliPayInterface {

    protected Activity that;

    @Override
    public void setContentView(View view) {
        if (that == null) {
            super.setContentView(view);
        } else {
            that.setContentView(view);
        }
    }

    @Override
    public <T extends View> T findViewById(int id) {
        if (that == null) {
            return super.findViewById(id);
        } else {
            return that.findViewById(id);
        }
    }

    @Override
    public ApplicationInfo getApplicationInfo() {
        if (that == null) {
            return super.getApplicationInfo();
        } else {
            return that.getApplicationInfo();
        }
    }


    @Override
    public ClassLoader getClassLoader() {
        if (that == null) {
            return super.getClassLoader();
        } else {
            return that.getClassLoader();
        }
    }

    @NonNull
    @Override
    public LayoutInflater getLayoutInflater() {
        if (that == null) {
            return super.getLayoutInflater();
        } else {
            return that.getLayoutInflater();
        }
    }

    @Override
    public Window getWindow() {
        if (that == null) {
            return super.getWindow();
        } else {
            return that.getWindow();
        }
    }

    @Override
    public WindowManager getWindowManager() {
        if (that == null) {
            return super.getWindowManager();
        } else {
            return that.getWindowManager();
        }
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
    }

    @Override
    public void onStart() {
//        super.onStart();
    }

    @Override
    public void onDestroy() {
//        super.onDestroy();
    }

    @Override
    public void onStop() {
//        super.onStop();
    }

    @Override
    public void onResume() {
//        super.onResume();
    }

    @Override
    public void onRestart() {
//        super.onRestart();
    }

    @Override
    public void attach(Activity activity) {
        that = activity;
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
    }
}
