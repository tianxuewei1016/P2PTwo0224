package com.p2ptwo0224.fragment;

import android.content.Context;
import android.os.SystemClock;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSON;
import com.p2ptwo0224.R;
import com.p2ptwo0224.base.BaseFragment;
import com.p2ptwo0224.bean.HomeBean;
import com.p2ptwo0224.common.AppNetConfig;
import com.p2ptwo0224.utils.ThreadPool;
import com.p2ptwo0224.view.MyProgress;
import com.squareup.picasso.Picasso;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * 作者：田学伟 on 2017/6/20 19:00
 * QQ：93226539
 * 作用：
 */

public class HomeFragment extends BaseFragment {
    @Bind(R.id.base_title)
    TextView baseTitle;
    @Bind(R.id.base_back)
    ImageView baseBack;
    @Bind(R.id.base_setting)
    ImageView baseSetting;
    @Bind(R.id.banner)
    Banner banner;
    @Bind(R.id.tv_home_product)
    TextView tvHomeProduct;
    @Bind(R.id.tv_home_yearrate)
    TextView tvHomeYearrate;
    @Bind(R.id.home_progress)
    MyProgress homeProgress;

    @Override
    public int getLayoutid() {
        return R.layout.fragment_home;
    }

    @Override
    public String getChildUrl() {
        return AppNetConfig.INDEX;
    }

    public void initListener() {
        baseTitle.setText("首页");
        baseBack.setVisibility(View.INVISIBLE);
        baseSetting.setVisibility(View.INVISIBLE);
    }


//    public void initData() {
//        /*
//        * 二次封装
//        * 为什么要二次封装
//        *
//        * 第一  调用的方便
//        * 第二  修改和维护方便
//        * */
//        LoadNet.getDataPost(AppNetConfig.INDEX, new LoadNetHttp() {
//            @Override
//            public void success(String content) {
//                Log.i("http", "success: " + "context");
//                HomeBean homeBean = JSON.parseObject(content, HomeBean.class);
//                tvHomeYearrate.setText(homeBean.getProInfo().getYearRate() + "%");
//                tvHomeProduct.setText(homeBean.getProInfo().getName());
//                //注意：展示UI一定要判断是不是主线程
//                initProgress(homeBean.getProInfo());
//                initBanner(homeBean);
//            }
//
//            @Override
//            public void failure(String error) {
//                Log.i("http", "failure: " + error);
//            }
//        });
//    }


    @Override
    public void initData(String json) {
        HomeBean homeBean = JSON.parseObject(json, HomeBean.class);
        //Log.i("http", "success: "+homeBean.getImageArr().size());
        tvHomeYearrate.setText(homeBean.getProInfo().getYearRate() + "%");
        tvHomeProduct.setText(homeBean.getProInfo().getName());
        //注意：展示UI一定要判断是不是主线程
        initProgress(homeBean.getProInfo());
        initBanner(homeBean);
    }

    private void initProgress(final HomeBean.ProInfoBean proInfo) {
        ThreadPool.getInstance().getGlobalThread().execute(new Runnable() {
            @Override
            public void run() {
                int progress = Integer.parseInt(proInfo.getProgress());
                for (int i = 0; i < progress; i++) {
                    SystemClock.sleep(20);
                    homeProgress.setProgress(i);
                }
            }
        });
    }


    private void initBanner(HomeBean homeBean) {
        //设置图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //转化成url集合
        List<String> urls = new ArrayList<>();
        for (int i = 0; i < homeBean.getImageArr().size(); i++) {
            urls.add(AppNetConfig.BASE_URL + homeBean.getImageArr().get(i).getIMAURL());
        }
        //设置图片集合
        banner.setImages(urls);
        //banner设置方法全部调用完毕时最后调用
        banner.start();
    }

    public class GlideImageLoader extends ImageLoader {
        @Override
        public void displayImage(Context context, Object path, ImageView imageView) {
            /**
             注意：
             1.图片加载器由自己选择，这里不限制，只是提供几种使用方法
             2.返回的图片路径为Object类型，由于不能确定你到底使用的那种图片加载器，
             传输的到的是什么格式，那么这种就使用Object接收和返回，你只需要强转成你传输的类型就行，
             切记不要胡乱强转！
             */
            //Picasso 加载图片简单用法
            Picasso.with(context).load((String) path).into(imageView);
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        ButterKnife.unbind(this);
    }
}

