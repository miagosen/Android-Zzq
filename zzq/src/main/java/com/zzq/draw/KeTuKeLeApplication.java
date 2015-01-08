package com.zzq.draw;

import com.zzq.draw.base.BaseApplication;

import android.app.Application;
import android.content.Context;
import android.util.Log;

public class KeTuKeLeApplication extends BaseApplication {

  public static Context mContext;
  private static KeTuKeLeApplication myApplication;
  private static final String USER_NAME = "user_name";
  private static final String PASSWORD = "password";
  private static final String TOKEN = "token";



  private static boolean isLogin = false;//用来判断用户是否已经登录
  public static String user_name;



    @Override
  public void onCreate() {
    super.onCreate();
    mContext = this;
    myApplication = this;
  }

    /**
     * 注销登录
     */
    public static void logoff_user(){
        isLogin = false;
        user_name = "";
    }

    public static KeTuKeLeApplication getInstance() {
      return myApplication;
    }

    public static void setIsLogin(boolean isLogin) {
        KeTuKeLeApplication.isLogin = isLogin;
    }

    public static boolean isIsLogin() {
        return isLogin;
    }

    public static String getUser_name() {
        return user_name;
    }

    public static void setUser_name(String user_name) {
        KeTuKeLeApplication.user_name = user_name;
    }
}
