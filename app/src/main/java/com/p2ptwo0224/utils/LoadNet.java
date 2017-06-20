package com.p2ptwo0224.utils;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

/**
 * 作者：田学伟 on 2017/6/20 20:49
 * QQ：93226539
 * 作用：
 */

public class LoadNet {

    public static void getDataPost(String url, final LoadNetHttp http) {
        AsyncHttpClient httpClient = new AsyncHttpClient();

        httpClient.post(url, new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(String content) {
                super.onSuccess(content);
                if (http != null) {
                    http.success(content);
                }
            }

            @Override
            public void onFailure(Throwable error, String content) {
                super.onFailure(error, content);
                if (http != null) {
                    http.failure(content);
                }
            }
        });
    }
}
