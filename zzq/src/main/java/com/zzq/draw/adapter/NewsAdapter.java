package com.zzq.draw.adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.zzq.draw.KeTuKeLeApplication;
import com.zzq.draw.R;
import com.zzq.draw.base.ListBaseAdapter;

/**
 * Created by antikvo on 14/12/7.
 */
public class NewsAdapter extends ListBaseAdapter{
    @Override
    protected boolean loadMoreHasBg() {
        return false;
    }

    @Override
    protected View getRealView(int position, View convertView, ViewGroup parent) {
        ViewHolder vh = null;
        if (convertView == null || convertView.getTag() == null) {
            convertView = getLayoutInflater(parent.getContext()).inflate(R.layout.news_list_item, null);
            vh = new ViewHolder(convertView);
            convertView.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }
        vh.iconView.setImageDrawable(parent.getResources().getDrawable(R.drawable.a));
        return convertView;
    }
    class ViewHolder{
        ImageView iconView;

        ViewHolder(View view) {
            iconView  = (ImageView) view.findViewById(R.id.iv_news_icon);
        }
    }
}
