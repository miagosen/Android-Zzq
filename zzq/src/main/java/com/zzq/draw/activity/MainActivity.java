package com.zzq.draw.activity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;

import com.viewpagerindicator.TabPageIndicator;
import com.zzq.draw.R;
import com.zzq.draw.fragment.NewsFragment;

public class MainActivity extends FragmentActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    FragmentPagerAdapter adapter = new TabPageIndicatorAdapter(getSupportFragmentManager());
    ViewPager pager = (ViewPager) findViewById(R.id.pager);
    pager.setAdapter(adapter);

    TabPageIndicator indicator = (TabPageIndicator) findViewById(R.id.indicator);
    indicator.setViewPager(pager);

    indicator.setOnPageChangeListener(new OnPageChangeListener() {

      @Override
      public void onPageSelected(int arg0) {
      }

      @Override
      public void onPageScrolled(int arg0, float arg1, int arg2) {

      }

      @Override
      public void onPageScrollStateChanged(int arg0) {

      }
    });

  }

  class TabPageIndicatorAdapter extends FragmentPagerAdapter {
    public TabPageIndicatorAdapter(FragmentManager fm) {
      super(fm);
    }

    @Override
    public Fragment getItem(int position) {
      Fragment fragment = new NewsFragment();
      Bundle args = new Bundle();
      args.putString("arg", ActiveTab.getTitleByIndex(position));
      fragment.setArguments(args);
      return fragment;
    }

    @Override
    public CharSequence getPageTitle(int position) {
      return ActiveTab.getTitleByIndex(position);
    }

    @Override
    public int getCount() {
      return ActiveTab.getTotal();
    }
  }

}
