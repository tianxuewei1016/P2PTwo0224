package com.p2ptwo0224.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.KeyEvent;
import android.widget.FrameLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.p2ptwo0224.R;
import com.p2ptwo0224.fragment.HomeFragment;
import com.p2ptwo0224.fragment.InvestFragment;
import com.p2ptwo0224.fragment.MoreFragment;
import com.p2ptwo0224.fragment.PropertyFragment;
import com.p2ptwo0224.utils.AppManager;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @Bind(R.id.main_fl)
    FrameLayout mainFl;
    @Bind(R.id.main_rg)
    RadioGroup mainRg;
    private HomeFragment homeFragment;
    private InvestFragment investFragment;
    private MoreFragment moreFragment;
    private PropertyFragment propertyFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        //添加到APPManager
        AppManager.getInstance().addActivity(this);

        initView();
        initData();
        initListener();
    }

    private void initListener() {
        mainRg.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                swithFragment(checkedId);
            }
        });
    }

    private void swithFragment(int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        hiddenFragment(transaction);

        switch (checkedId) {
            case R.id.rb_invest:
                if (investFragment == null) {
                    investFragment = new InvestFragment();
                    transaction.add(R.id.main_fl, investFragment);
                } else {
                    transaction.show(investFragment);
                }
                break;
            case R.id.rb_main:
                if (homeFragment == null) {
                    homeFragment = new HomeFragment();
                    transaction.add(R.id.main_fl, homeFragment);
                } else {
                    transaction.show(homeFragment);
                }
                break;
            case R.id.rb_more:
                if (moreFragment == null) {
                    moreFragment = new MoreFragment();
                    transaction.add(R.id.main_fl, moreFragment);
                } else {
                    transaction.show(moreFragment);
                }
                break;
            case R.id.rb_propert:
                if (propertyFragment == null) {
                    propertyFragment = new PropertyFragment();
                    transaction.add(R.id.main_fl, propertyFragment);
                } else {
                    transaction.show(propertyFragment);
                }
                break;
        }
        transaction.commit();
    }

    /**
     * 隐藏所有的fragment
     *
     * @param transaction
     */
    private void hiddenFragment(FragmentTransaction transaction) {
        if (homeFragment != null) {
            transaction.hide(homeFragment);
        }
        if (investFragment != null) {
            transaction.hide(investFragment);
        }
        if (moreFragment != null) {
            transaction.hide(moreFragment);
        }
        if (propertyFragment != null) {
            transaction.hide(propertyFragment);
        }
    }

    private void initData() {
        swithFragment(R.id.rb_main);
    }

    private void initView() {

    }

    private boolean isExit = false;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (isExit) {
                finish();
            }
            Toast.makeText(MainActivity.this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
            isExit = true;
            //两秒之内有效
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    isExit = false;
                }
            }, 2000);
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}
