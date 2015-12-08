package com.flyco.tablayoutsamples.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.flyco.tablayout.SegmentTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.flyco.tablayoutsamples.R;
import com.flyco.tablayoutsamples.entity.TabEntity;
import com.flyco.tablayoutsamples.utils.ViewFindUtils;

import java.util.ArrayList;

public class SegmentTabActivity extends AppCompatActivity {
    private Context context = this;
    private ArrayList<Fragment> fragments = new ArrayList<>();
    private ArrayList<Fragment> fragments2 = new ArrayList<>();

    private String[] titles = {"首页", "消息"};
    private String[] titles_2 = {"首页", "消息", "联系人"};
    private String[] titles_3 = {"首页", "消息", "联系人", "更多"};
    private int[] iconUnselectIds = {
            R.mipmap.tab_home_unselect, R.mipmap.tab_speech_unselect,
            R.mipmap.tab_contact_unselect, R.mipmap.tab_more_unselect};
    private int[] iconSelectIds = {
            R.mipmap.tab_home_select, R.mipmap.tab_speech_select,
            R.mipmap.tab_contact_select, R.mipmap.tab_more_select};
    private ArrayList<CustomTabEntity> tabs = new ArrayList<>();
    private View decorView;
    private SegmentTabLayout tl_3;
    //    private CommonTabLayout tl_4;
//    private CommonTabLayout tl_5;
//    private CommonTabLayout tl_6;
//    private CommonTabLayout tl_7;
//    private CommonTabLayout tl_8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segment_tab);

        for (String title : titles_2) {
            fragments2.add(SimpleCardFragment.getInstance("Switch Fragment " + title));
        }

        for (String title : titles_3) {
            fragments.add(SimpleCardFragment.getInstance("Switch ViewPager " + title));
        }


        for (int i = 0; i < titles.length; i++) {
            tabs.add(new TabEntity(titles[i], iconSelectIds[i], iconUnselectIds[i]));
        }

        decorView = getWindow().getDecorView();

        SegmentTabLayout tl_1 = ViewFindUtils.find(decorView, R.id.tl_1);
        SegmentTabLayout tl_2 = ViewFindUtils.find(decorView, R.id.tl_2);
        tl_3 = ViewFindUtils.find(decorView, R.id.tl_3);
        SegmentTabLayout tl_4 = ViewFindUtils.find(decorView, R.id.tl_4);
        SegmentTabLayout tl_5 = ViewFindUtils.find(decorView, R.id.tl_5);

        tl_1.setTabData(titles);
        tl_2.setTabData(titles_2);
        tl_3();
        tl_4.setTabData(titles_2, this, R.id.fl_change, fragments2);
        tl_5.setTabData(titles_3);
//        /** indicator固定宽度 */
//        tl_5 = ViewFindUtils.find(decorView, R.id.tl_5);
//        /** indicator矩形圆角 */
//        tl_6 = ViewFindUtils.find(decorView, R.id.tl_6);
//        /** indicator三角形 */
//        tl_7 = ViewFindUtils.find(decorView, R.id.tl_7);
//        /** indicator圆角色块 */
//        tl_8 = ViewFindUtils.find(decorView, R.id.tl_8);


//        tl_3.setTabData(tabs, this, R.id.fl_change, fragments2);
//        tl_4.setTabData(tabs);
//        tl_5.setTabData(tabs);
//        tl_6.setTabData(tabs);
//        tl_7.setTabData(tabs);
//        tl_8.setTabData(tabs);
//
//        tl_3.setOnTabSelectListener(new OnTabSelectListener() {
//            @Override
//            public void onTabSelect(int position) {
//                tl_1.setCurrentTab(position);
//                tl_3.setCurrentTab(position);
//                tl_4.setCurrentTab(position);
//                tl_5.setCurrentTab(position);
//                tl_6.setCurrentTab(position);
//                tl_7.setCurrentTab(position);
//                tl_8.setCurrentTab(position);
//            }
//
//            @Override
//            public void onTabReselect(int position) {
//
//            }
//        });
//
//        //显示未读红点
//        tl_1.showDot(2);
//        tl_3.showDot(1);
//        tl_4.showDot(1);
//
//        //两位数
//        tl_3.showMsg(0, 55);
//        tl_3.setMsgMargin(0, -5, 5);
//
//        //三位数
//        tl_3.showMsg(1, 100);
//        tl_3.setMsgMargin(1, -5, 5);
//
//        //设置未读消息红点
//        tl_3.showDot(2);
//        RoundTextView rtv_2_2 = tl_3.getMsgView(2);
//        if (rtv_2_2 != null) {
//            rtv_2_2.setWidth(dp2px(7.5f));
//        }
//
//        //设置未读消息背景
//        tl_3.showMsg(3, 5);
//        tl_3.setMsgMargin(3, 0, 5);
//        RoundTextView rtv_2_3 = tl_3.getMsgView(3);
//        if (rtv_2_3 != null) {
//            rtv_2_3.getDelegate().setBackgroundColor(Color.parseColor("#6D8FB0"));
//        }
    }

    private void tl_3() {
        final ViewPager vp_3 = ViewFindUtils.find(decorView, R.id.vp_2);
        vp_3.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));

        tl_3.setTabData(titles_3);
        tl_3.setOnTabSelectListener(new OnTabSelectListener() {
            @Override
            public void onTabSelect(int position) {
                vp_3.setCurrentItem(position);
            }

            @Override
            public void onTabReselect(int position) {
            }
        });

        vp_3.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                tl_3.setCurrentTab(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        vp_3.setCurrentItem(1);
    }

    private class MyPagerAdapter extends FragmentPagerAdapter {
        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return fragments.size();
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles_3[position];
        }

        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }

    protected int dp2px(float dp) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dp * scale + 0.5f);
    }
}