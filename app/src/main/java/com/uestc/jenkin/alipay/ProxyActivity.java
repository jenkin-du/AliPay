package com.uestc.jenkin.alipay;

import android.app.Activity;
import android.content.res.Resources;
import android.os.Bundle;

import androidx.annotation.Nullable;

import com.uestc.jenkin.alipayinterface.AliPayInterface;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/24
 *     desc   : 代理跳转
 *     version: 1.0
 * </pre>
 */
public class ProxyActivity extends Activity {

    //要跳转的淘票票的activity
    private String className;

    AliPayInterface aliPayInterface;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        className = getIntent().getStringExtra("className");

        try {
            Class clazz = getClassLoader().loadClass(className);
            Constructor constructor = clazz.getConstructor(new Class[]{});
            Object instance = constructor.newInstance(new Object[]{});

            aliPayInterface = (AliPayInterface) instance;
            aliPayInterface.attach(this);
            Bundle bundle = new Bundle();
            aliPayInterface.onCreate(bundle);

        } catch (ClassNotFoundException | NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onStart() {
        super.onStart();
        aliPayInterface.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        aliPayInterface.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        aliPayInterface.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        aliPayInterface.onDestroy();
    }

    @Override
    protected void onStop() {
        super.onStop();
        aliPayInterface.onStop();
    }

    @Override
    public ClassLoader getClassLoader() {
        return PluginManager.getInstance().getDexClassLoader();
    }


    @Override
    public Resources getResources() {
        return PluginManager.getInstance().getResources();
    }
}
