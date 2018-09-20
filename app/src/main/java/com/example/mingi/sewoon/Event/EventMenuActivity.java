package com.example.mingi.sewoon.Event;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.widget.FrameLayout;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;
import android.widget.TabHost;
import android.widget.TabWidget;
import android.widget.TextView;

import com.example.mingi.sewoon.R;
import com.example.mingi.sewoon.Shop.Fragment_1F;

public class EventMenuActivity extends FragmentActivity {
    private String[] tabs;
    FragmentTabHost tabHost;
    ViewPagerAdapter pagerAdapter;
    ViewPager viewPager;
    private TabWidget tabWidget;
    private HorizontalScrollView horizontalScrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_event_menu);

        viewPager = (ViewPager) findViewById(R.id.viewPager);
        tabHost = (FragmentTabHost) findViewById(android.R.id.tabhost);
        tabWidget = (TabWidget) findViewById(android.R.id.tabs);
        tabHost.setup(this, getSupportFragmentManager(), R.id.realTabContent);

        initializeHorizontalTabs();
        initializeTabs();
        setupTabHost();

        pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager(), tabs);
        viewPager.setAdapter(pagerAdapter);

        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            /**
             * on swipe select the respective tab
             * */
            @Override
            public void onPageSelected(int position) {
                invalidateOptionsMenu();
                tabHost.setCurrentTab(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                invalidateOptionsMenu();
            }
        });



        TextView temp = (TextView) tabHost.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.rgb(185,167,146), PorterDuff.Mode.MULTIPLY);
        temp.setTextColor(Color.parseColor("#b9a792")); // 탭이 선택되어 있으면 FontColor를 검정색으로



        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) { // 탭 변경시 리스너
                viewPager.setCurrentItem(tabHost.getCurrentTab());
                scrollToCurrentTab();
                for (int i = 0; i < tabHost.getTabWidget().getChildCount(); i++) {
                    TextView tv = (TextView) tabHost.getTabWidget().getChildAt(i).findViewById(android.R.id.title); // 탭에 있는 TextView 지정후
                    if (i == tabHost.getCurrentTab()) {
                        tv.setTextColor(Color.parseColor("#b9a792")); // 탭이 선택되어 있으면 FontColor를 검정색으로
                        tv.setTypeface(tv.getTypeface(), Typeface.BOLD);
                        tabHost.getTabWidget().getChildAt(tabHost.getCurrentTab()).getBackground().setColorFilter(Color.rgb(185,167,146), PorterDuff.Mode.MULTIPLY);
                    }
                    else
                        tv.setTextColor(Color.parseColor("#45555f")); // 선택되지 않은 탭은 하얀색으로.
                }
            }
        });


    }

    private void initializeHorizontalTabs() {
        LinearLayout ll = (LinearLayout) tabWidget.getParent();
        horizontalScrollView = new HorizontalScrollView(this);
        horizontalScrollView.setLayoutParams(new FrameLayout.LayoutParams(
                FrameLayout.LayoutParams.MATCH_PARENT,
                FrameLayout.LayoutParams.WRAP_CONTENT));
        ll.addView(horizontalScrollView, 0);
        ll.removeView(tabWidget);
        horizontalScrollView.addView(tabWidget);
        horizontalScrollView.setHorizontalScrollBarEnabled(false);
    }

    private void scrollToCurrentTab() {
        final int screenWidth = getWindowManager().getDefaultDisplay().getWidth();
        final int leftX = tabWidget.getChildAt(tabHost.getCurrentTab()).getLeft();
        int newX = 0;

        newX = leftX + (tabWidget.getChildAt(tabHost.getCurrentTab()).getWidth() / 2) - (screenWidth / 2);
        if (newX < 0) {
            newX = 0;
        }
        horizontalScrollView.scrollTo(newX, 0);
    }
    private void initializeTabs() {
        tabs = new String[] { "투어", "행사", "교육" };
    }

    private void setupTabHost() {


        TabHost.TabSpec tabSpec1 = tabHost.newTabSpec(String.format("%sTab", tabs[0].replace(" ","").toLowerCase())); // 구분자
        tabSpec1.setIndicator("투어"); // 탭 이름
        tabHost.addTab(tabSpec1, Fragment_1F.class, null);
        TabHost.TabSpec tabSpec2 = tabHost.newTabSpec(String.format("%sTab", tabs[1].replace(" ","").toLowerCase())); // 구분자
        tabSpec2.setIndicator("행사"); // 탭 이름
        tabHost.addTab(tabSpec2, Fragment_1F.class, null);
        TabHost.TabSpec tabSpec3 = tabHost.newTabSpec(String.format("%sTab", tabs[2].replace(" ","").toLowerCase())); // 구분자
        tabSpec3.setIndicator("교육"); // 탭 이름
        tabHost.addTab(tabSpec3, Fragment_1F.class, null);

        /*
        for(int i=0; i<tabs.length; i++) {
            tabHost.addTab(tabHost.newTabSpec(String.format("%sTab", tabs[i].replace(" ","").toLowerCase())).setIndicator(tabs[i]), MyFragment.class, null);

        }
        */


    }
}