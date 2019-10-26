package com.uestc.jenkin.alipayinterface;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;

import androidx.annotation.NonNull;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/24
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public interface AliPayInterface {


    public void onCreate(Bundle savedInstanceState);

    public void onStart();

    public void onDestroy();

    public void onStop();

    public void onResume();

    public void onRestart();

    public void onBackPressed();

    public void attach(Activity activity);

    public void onSaveInstanceState(@NonNull Bundle outState);

    public boolean onTouchEvent(MotionEvent event);
}
