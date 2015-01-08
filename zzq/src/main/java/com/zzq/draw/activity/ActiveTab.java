package com.zzq.draw.activity;

import com.zzq.draw.KeTuKeLeApplication;
import com.zzq.draw.R;
import com.zzq.draw.fragment.EventsFragment;
import com.zzq.draw.fragment.NewsFragment;
import com.zzq.draw.fragment.QuestionFragment;

public enum ActiveTab {
  NEWS(0, R.string.fragment_title_news, NewsFragment.class),
  QUESTION(1, R.string.fragment_title_question, QuestionFragment.class),
  MESSAGE(2, R.string.fragment_title_events, EventsFragment.class);

  private Class<?> clz;
  private int      idx;
  private int      title;

  private ActiveTab(int idx, int title, Class<?> clz) {
    this.idx = idx;
    this.setTitle(title);
    this.clz = clz;
  }
  public static String getTitleByIndex(int index) {
    ActiveTab tmp = ActiveTab.getActiveTab(index);
    if (tmp != null) {
      return KeTuKeLeApplication.mContext.getString(tmp.title);
    }
    return "";
  }
  public static ActiveTab getActiveTab(int index) {
    ActiveTab result = null;
    if (index >= 0 && index < values().length) {
      for (ActiveTab tab : values()) {
        if (tab.idx == index) {
          result = tab;
        }
      }
    }
    return result;
  }
  public static int getTotal() {
    return values().length;
  }
  public Class<?> getClz() {
    return clz;
  }

  public void setClz(Class<?> clz) {
    this.clz = clz;
  }

  public int getIdx() {
    return idx;
  }

  public void setIdx(int idx) {
    this.idx = idx;
  }

  public int getTitle() {
    return title;
  }

  public void setTitle(int title) {
    this.title = title;
  }

}
