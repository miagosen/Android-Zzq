package com.zzq.draw;

import com.zzq.draw.base.BaseApplication;

import android.app.Application;
import android.content.Context;

public class KeTuKeLeApplication extends BaseApplication {

  public static Context              mContext;
  private static KeTuKeLeApplication myApplication;

  @Override
  public void onCreate() {
    super.onCreate();
    mContext = this;
    myApplication = this;
  }

  public static KeTuKeLeApplication getInstance() {
    return myApplication;
  }
}
