package com.wuyazhou.learn.ViewAndViewGroup;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.wuyazhou.learn.ViewAndViewGroup.anim.AnimPagerView;
import com.wuyazhou.learn.ViewAndViewGroup.layout.LayoutPagerView;
import com.wuyazhou.learn.ViewAndViewGroup.layoutParams.LayoutParamsPagerView;
import com.wuyazhou.learn.ViewAndViewGroup.offset.OffSetPagerView;
import com.wuyazhou.learn.ViewAndViewGroup.scroll.ScrollByPagerView;
import com.wuyazhou.learn.ViewAndViewGroup.scroller.ScrollerPagerView;
import com.wuyazhou.learn.logview.LogShowView;
import com.wuyazhou.pagerview.ModelPagerView;
import com.wuyazhou.pagerview.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewPager mViewPager = null;

    private List<View> mViews = new ArrayList<View>();
    private List<String> mViewTitle = new ArrayList<String>();
    private ViewPagerAdapter mViewPagerAdapter = null;

    private LogShowView mShowLogView = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initPager();
        initShowLogView();
    }

    private void initPager(){
        mViewPager = findViewById(R.id.view_pager);
        mViewPagerAdapter = new ViewPagerAdapter(mViews,mViewTitle, this);
        mViewPager.setAdapter(mViewPagerAdapter);
        addViewPagerView("layout()",new LayoutPagerView(this));
        addViewPagerView("offSet...()",new OffSetPagerView(this));
        addViewPagerView("LayoutParams",new LayoutParamsPagerView(this));
        addViewPagerView("anim",new AnimPagerView(this));
        addViewPagerView("scrollBy",new ScrollByPagerView(this));
        addViewPagerView("scroller",new ScrollerPagerView(this));
        addViewPagerView("标题二",new ModelPagerView(this));
        mViewPagerAdapter.notifyDataSetChanged();
        mViewPager.setCurrentItem(5);
    }

    private void addViewPagerView(String title, View view){
        mViewTitle.add(title);
        mViews.add(view);
    }

    private void initShowLogView(){
        mShowLogView = findViewById(R.id.show_log_view);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mViews.clear();
        mViews = null;
        mShowLogView.release();
    }
}
