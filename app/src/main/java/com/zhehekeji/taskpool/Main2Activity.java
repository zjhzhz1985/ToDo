package com.zhehekeji.taskpool;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TabWidget;
import android.widget.TextView;

import java.util.Random;

public class Main2Activity extends FragmentActivity {

    private static final String TAG = "AndroidDemos.SlideTabs3";
    private ViewPager mViewPager;
    private PagerAdapter mPagerAdapter;
    private TabWidget mTabWidget;
    private String[] addresses = { "DAY", "WEEK", "MONTH" };
    private Button[] mBtnTabs = new Button[addresses.length];
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        mTabWidget = (TabWidget) findViewById(R.id.tabWidget1);
        //底部下划线
        mTabWidget.setStripEnabled(false);
        mBtnTabs[0] = new Button(this);
        mBtnTabs[0].setFocusable(true);
        mBtnTabs[0].setText(addresses[0]);
        mBtnTabs[0].setTextColor(getResources().getColorStateList(R.color.button_bg_color_selector));
        mTabWidget.addView(mBtnTabs[0]);
        /*
         * Listener必须在mTabWidget.addView()之后再加入，用于覆盖默认的Listener，
         * mTabWidget.addView()中默认的Listener没有NullPointer检测。
         */
        mBtnTabs[0].setOnClickListener(mTabClickListener);
        mBtnTabs[1] = new Button(this);
        mBtnTabs[1].setFocusable(true);
        mBtnTabs[1].setText(addresses[1]);
        mBtnTabs[1].setTextColor(getResources().getColorStateList(R.color.button_bg_color_selector));
        mTabWidget.addView(mBtnTabs[1]);
        mBtnTabs[1].setOnClickListener(mTabClickListener);
        mBtnTabs[2] = new Button(this);
        mBtnTabs[2].setFocusable(true);
        mBtnTabs[2].setText(addresses[2]);
        mBtnTabs[2].setTextColor(getResources().getColorStateList(R.color.button_bg_color_selector));
        mTabWidget.addView(mBtnTabs[2]);
        mBtnTabs[2].setOnClickListener(mTabClickListener);

        mViewPager = (ViewPager) findViewById(R.id.viewPager1);
        mPagerAdapter = new MyPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(mPagerAdapter);
        mViewPager.setOnPageChangeListener(mPageChangeListener);

        mTabWidget.setCurrentTab(0);
    }
    private View.OnClickListener mTabClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v)
        {
            if (v == mBtnTabs[0])
            {
               //android.support.v4.view.ViewPager选中该项
                mViewPager.setCurrentItem(0);
            } else if (v == mBtnTabs[1])
            {
                mViewPager.setCurrentItem(1);
            } else if (v == mBtnTabs[2])
            {
                mViewPager.setCurrentItem(2);
            }
        }
    };

    private ViewPager.OnPageChangeListener mPageChangeListener = new ViewPager.OnPageChangeListener() {

        @Override
        public void onPageSelected(int arg0)
        {
            mTabWidget.setCurrentTab(arg0);
        }

        @Override
        public void onPageScrolled(int arg0, float arg1, int arg2)
        {

        }

        @Override
        public void onPageScrollStateChanged(int arg0)
        {

        }
    };
    private class MyPagerAdapter extends FragmentStatePagerAdapter
    {
        public MyPagerAdapter(FragmentManager fm)
        {
            super(fm);
        }
        @Override
        public Fragment getItem(int position)
        {
            return MyFragment.create(addresses[position]);
        }
        @Override
        public int getCount()
        {
            return addresses.length;
        }
    }
    public static class MyFragment extends Fragment
    {
        public static MyFragment create(String address)
        {
            MyFragment f = new MyFragment();
            Bundle b = new Bundle();
            b.putString("address", address);
            f.setArguments(b);
            return f;
        }
        @TargetApi(Build.VERSION_CODES.LOLLIPOP)
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState)
        {
            Random r = new Random(System.currentTimeMillis());
            Bundle b = getArguments();
            View v = inflater.inflate(R.layout.fragment_viewpager1_layout1, null);
            v.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
            TextView txvAddress = (TextView) v.findViewById(R.id.textView1);
            txvAddress.setTextColor(r.nextInt() >> 8 | 0xFF << 24);
            txvAddress.setBackgroundColor(r.nextInt() >> 8 | 0xFF << 24);
            txvAddress.setText(b.getString("app_name", ""));
            return v;
        }
    }
}
