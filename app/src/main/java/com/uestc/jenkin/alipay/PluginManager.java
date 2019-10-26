package com.uestc.jenkin.alipay;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Resources;

import java.io.File;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import dalvik.system.DexClassLoader;

/**
 * <pre>
 *     author : jenkin
 *     e-mail : jekin-du@foxmail.com
 *     time   : 2019/10/25
 *     desc   :
 *     version: 1.0
 * </pre>
 */
public class PluginManager {
    private static final PluginManager ourInstance = new PluginManager();


    private DexClassLoader dexClassLoader;

    private Resources resources;

    private Context context;

    public String entryActivityName;

    public static PluginManager getInstance() {
        return ourInstance;
    }

    private PluginManager() {
    }


    public void loadPath(String path) {

        File dexOutFile = context.getDir("dex", Context.MODE_PRIVATE);
        dexClassLoader = new DexClassLoader(path, dexOutFile.getAbsolutePath(), null, context.getClassLoader());

        //实例化Resource
//        AssetManager

        PackageManager packageManager = context.getPackageManager();
        PackageInfo info = packageManager.getPackageArchiveInfo(path, PackageManager.GET_ACTIVITIES);

        assert info != null;
        entryActivityName = info.activities[0].name;
        try {
            //反射实例化
            AssetManager assetManager = AssetManager.class.newInstance();

            Method addAssertPath = AssetManager.class.getMethod("addAssetPath", String.class);
            addAssertPath.invoke(assetManager, path);

            resources = new Resources(assetManager, context.getResources().getDisplayMetrics(), context.getResources().getConfiguration());

        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }

    }

    /**
     * clas 文件， 资源文件最重要
     *
     * @return
     */
    public DexClassLoader getDexClassLoader() {
        return dexClassLoader;
    }

    public Resources getResources() {
        return resources;
    }

    public String getEntryActivityName() {
        return entryActivityName;
    }

    public void setContext(Context context) {
        this.context = context.getApplicationContext();
    }
}
