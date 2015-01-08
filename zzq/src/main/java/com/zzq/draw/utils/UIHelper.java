package com.zzq.draw.utils;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;

import com.zzq.draw.activity.MainActivity;
import com.zzq.draw.activity.login.LoginActivity;

/**
 * 应用程序UI工具包：封装UI相关的一些操作
 * 
 * @author liux (http://my.oschina.net/liux)
 * @version 1.0
 * @created 2012-3-21
 */
@SuppressLint("SetJavaScriptEnabled")
public class UIHelper {

    /**
     * 发表页面
     */
    public static void showQuestionPub(Context context){

    }

    /**
     * 去登录activity
     */
    public static void goLogin(Context context){
        Intent _intent = new Intent(context, LoginActivity.class);
        context.startActivity(_intent);
    }


}
