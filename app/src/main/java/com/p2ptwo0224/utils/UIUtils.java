package com.p2ptwo0224.utils;

import android.content.Context;
import android.view.View;

import com.p2ptwo0224.common.MyApplication;

/**
 * 作者：田学伟 on 2017/6/20 19:15
 * QQ：93226539
 * 作用：和UI相关的一些操作类
 */

public class UIUtils {
    public static Context getContext(){
        return MyApplication.getContext();
    }

    public static View getView(int layoutid){
        return View.inflate(getContext(),layoutid,null);
    }

    public static int getColor(int color){
        return getContext().getResources().getColor(color);
    }

    public static String[] getStringArrary(int stringid){
        return getContext().getResources().getStringArray(stringid);
    }

    //与屏幕分辨率相关的
    public static int dp2px(int dp){
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (density * dp + 0.5);

    }

    public static int px2dp(int px){
        float density = getContext().getResources().getDisplayMetrics().density;
        return (int) (px / density + 0.5);
    }


    public static void runOnUiThread(Runnable runnable) {
        //比较pid来判断是不是在主线程
        if (MyApplication.getThreadid()==android.os.Process.myPid()){
            runnable.run();
        }else{
            //给handler发送一个runnable
            MyApplication.getHandler().post(runnable);
        }
    }
}
