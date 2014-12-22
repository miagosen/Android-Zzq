package com.zzq.draw.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.zzq.draw.R;
import com.zzq.draw.adapter.NewsAdapter;
import com.zzq.draw.base.ListBaseAdapter;

public class NewsFragment extends Fragment {

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
    View contextView = inflater.inflate(R.layout.fragment_item, container, false);
    TextView mTextView = (TextView) contextView.findViewById(R.id.textview);

    Bundle mBundle = getArguments();
    String title = mBundle.getString("arg");

    mTextView.setText(title);
    return contextView;
  }

    @Override
  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);
  }

}
