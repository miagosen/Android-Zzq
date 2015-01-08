package com.zzq.draw.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.zzq.draw.KeTuKeLeApplication;
import com.zzq.draw.R;

import java.util.List;

/**
 * Created by chenrg on 2015/1/4.
 */
public class MenuAdapter extends BaseAdapter{
    private Context context;
    private KeTuKeLeApplication myApplication;

    public MenuAdapter(Context context) {
        this.context = context;
    }

    @Override
    public int getCount() {
        return 4;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.v2_list_cell_popup_menu_userinfo,null);
        TextView _textView = _textView = (TextView) convertView.findViewById(R.id.tv_name);
        ImageView _imageView =  _imageView = (ImageView) convertView.findViewById(R.id.iv_avatar);
        int iconResId = 0;
        if(position == 0){
            if(myApplication.isIsLogin()){
                String user_name = myApplication.user_name;
                String welcome = context.getResources().getString(R.string.welcome_word);
                _textView.setText(welcome+user_name);
            }
            return convertView;
        }else if(position == 1){
            _textView.setText(R.string.main_menu_software);
            iconResId = R.drawable.actionbar_menu_icn_software;
        }else if(position == 2){
            _textView.setText(R.string.main_menu_setting);
            iconResId = R.drawable.actionbar_menu_icn_set;
        }else if(position == 3){
            _textView.setText(R.string.main_menu_exit);
            iconResId = R.drawable.actionbar_menu_icn_exit;
        }else{
            return null;
        }
        _imageView.setImageResource(iconResId);
        return convertView;
    }
}
