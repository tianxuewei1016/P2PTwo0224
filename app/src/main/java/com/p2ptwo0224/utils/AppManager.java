package com.p2ptwo0224.utils;

import android.app.Activity;

import java.util.Stack;

/**
 * 作者：田学伟 on 2017/6/20 19:55
 * QQ：93226539
 * 作用：
 */

public class AppManager {

    /**
     * 统一应用程序中所有的Activity的栈管理（单例）
     * 涉及到activity的添加、删除指定、删除当前、删除所有、返回栈大小的方法
     */

    private AppManager() {
    }

    ;
    private static AppManager appManager = new AppManager();

    public static AppManager getInstance() {
        return appManager;
    }

    private Stack<Activity> stack = new Stack<>();

    public void addActivity(Activity activity) {
        //校验
        if (activity != null) {
            stack.add(activity);
        }
    }

    public void removeActivity(Activity activity) {
        if (activity != null) {
            for (int i = stack.size() - 1; i >= 0; i--) {
                Activity currentActivity = stack.get(i);
                if (currentActivity.getClass().equals(activity.getClass())) {
                    currentActivity.finish();
                    stack.remove(currentActivity);
                }
            }
        }
    }

    public void removeAll() {
        for (int i = stack.size() - 1; i >= 0; i--) {
            Activity currentActivity = stack.get(i);
            currentActivity.finish();
            stack.remove(currentActivity);
        }
    }

    public void removeCurrentActivity() {
        Activity activity = stack.get(stack.size() - 1);
        activity.finish();
        stack.remove(activity);
    }

    public int getStackSize() {
        return stack.size();
    }
}
