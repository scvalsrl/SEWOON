package com.example.mingi.sewoon.Event;

import android.graphics.Color;
import android.support.v4.app.FragmentTabHost;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.widget.TabHost;
import android.widget.TextView;

import com.example.mingi.sewoon.Shop.Fragment_1F;
import com.example.mingi.sewoon.R;
import com.example.mingi.sewoon.Shop.Fragment_2F;

public class EventMenuActivity extends AppCompatActivity {
    FragmentTabHost host;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_menu);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        host = (FragmentTabHost) findViewById(android.R.id.tabhost);
        host.setup(this, getSupportFragmentManager(), R.id.content);

        TabHost.TabSpec tabSpec1 = host.newTabSpec("tab1"); // 구분자
        tabSpec1.setIndicator("투어"); // 탭 이름
        host.addTab(tabSpec1, Fragment_1F.class, null);

        TabHost.TabSpec tabSpec2 = host.newTabSpec("tab2");
        tabSpec2.setIndicator("행사");
        host.addTab(tabSpec2, Fragment_2F.class, null);

        TabHost.TabSpec tabSpec3 = host.newTabSpec("tab3");
        tabSpec3.setIndicator("교육");
        host.addTab(tabSpec3, Fragment_1F.class, null);


        host.getTabWidget().getChildAt(0)
                .setBackgroundColor(Color.parseColor("#FFFFFF"));
        host.getTabWidget().getChildAt(1)
                .setBackgroundColor(Color.parseColor("#FFFFFF"));
        host.getTabWidget().getChildAt(2)
                .setBackgroundColor(Color.parseColor("#FFFFFF"));


        host.setCurrentTab(0);
        TextView temp = (TextView) host.getTabWidget().getChildAt(0).findViewById(android.R.id.title);
        temp.setTextColor(Color.parseColor("#45555f"));

        host.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) { // 탭 변경시 리스너
                for (int i = 0; i < host.getTabWidget().getChildCount(); i++) {
                    TextView tv = (TextView) host.getTabWidget().getChildAt(i).findViewById(android.R.id.title); // 탭에 있는 TextView 지정후
                    if (i == host.getCurrentTab())
                        tv.setTextColor(Color.parseColor("#B8A892")); // 탭이 선택되어 있으면 FontColor를 검정색으로
                    else
                        tv.setTextColor(Color.parseColor("#45555f")); // 선택되지 않은 탭은 하얀색으로.
                }
            }
        });
    }
}
