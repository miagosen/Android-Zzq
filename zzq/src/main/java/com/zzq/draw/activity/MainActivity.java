package com.zzq.draw.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.app.FragmentTabHost;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.support.v7.internal.widget.ListPopupWindow;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;

import com.viewpagerindicator.TabPageIndicator;
import com.zzq.draw.KeTuKeLeApplication;
import com.zzq.draw.R;
import com.zzq.draw.adapter.MenuAdapter;
import com.zzq.draw.base.BaseActivity;
import com.zzq.draw.fragment.NewsFragment;
import com.zzq.draw.utils.UIHelper;

public class MainActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    private FragmentTabHost mTabHost;
    private ListPopupWindow popWindow;
    private MenuAdapter menuAdapter;
    private KeTuKeLeApplication myapplication;


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int item_id = item.getItemId();
        switch (item_id){
            case R.id.main_menu_post:
                UIHelper.showQuestionPub(this);//发表页面
                break;
            case R.id.main_menu_today:
//                UIHelper.showEveryPub(this);//每日一句页面
                break;
            case R.id.main_menu_search:
//                UIHelper.showSearchPub(this);//搜索
                break;
            case R.id.main_menu_more://更多
                showMoreMenu();
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * 展示更多下拉菜单
     */
    public void showMoreMenu(){
        if(menuAdapter == null){
            menuAdapter = new MenuAdapter(this);
        }
        if(popWindow == null){
            popWindow = new ListPopupWindow(this);
            popWindow.setModal(true);
            popWindow.setContentWidth(getResources().getDimensionPixelSize(
                    R.dimen.popo_menu_dialog_width));
            popWindow.setAdapter(menuAdapter);
            popWindow.setOnItemClickListener(this);
            popWindow.setAnchorView(findViewById(R.id.main_menu_more));
            popWindow.show();
            popWindow.getListView().setDividerHeight(1);
        }else{
            if(popWindow.isShowing()){
                popWindow.dismiss();
            }else{
                popWindow.show();
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return super.onCreateOptionsMenu(menu);
    }

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

    /**
     * 销毁popwin和menuAdapter
     */
    public void destoryWin(){
        if(popWindow != null){
            popWindow.dismiss();
            popWindow = null;
        }
        if(menuAdapter != null){
            menuAdapter = null;
        }
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        switch (position){
            case(0):
                //这里要判断是否已经登录
                if(myapplication.isIsLogin()){
                    AlertDialog _dialog = new AlertDialog.Builder(this).setTitle(R.string.logoff_dialog_title).
                            setMessage(R.string.logoff_dialog_message).
                            setPositiveButton(R.string.logff_user,new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    myapplication.logoff_user();    //注销用户
                                    UIHelper.goLogin(MainActivity.this); //前往登录页面
                                };
                            }).
                            setNegativeButton(R.string.logoff_close,new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    AlertDialog _dialog = (AlertDialog) dialog;
                                    _dialog.dismiss();
                                };
                            }).show();
                }else{
                    UIHelper.goLogin(this); //前往登录
                }
                destoryWin();
                break;
            case(1):
                break;
            case(2):
                break;
            case(3):
                break;
        }
        if(popWindow != null && popWindow.isShowing()){
            popWindow.dismiss();
        }
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
