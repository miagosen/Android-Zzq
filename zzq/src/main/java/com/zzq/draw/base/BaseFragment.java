package com.zzq.draw.base;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.View;

import com.zzq.draw.R;
import com.zzq.draw.ui.dialog.DialogControl;
import com.zzq.draw.ui.dialog.WaitDialog;


public class BaseFragment extends Fragment implements View.OnClickListener {
	protected static final int STATE_NONE = 0;
	protected static final int STATE_REFRESH = 1;
	protected static final int STATE_LOADMORE = 2;
	protected int mState = STATE_NONE;
	
	protected void hideWaitDialog() {
		FragmentActivity activity = getActivity();
		if (activity instanceof DialogControl) {
			((DialogControl) activity).hideWaitDialog();
		}
	}

	protected WaitDialog showWaitDialog() {
		return showWaitDialog(R.string.loading);
	}

	protected WaitDialog showWaitDialog(int resid) {
		FragmentActivity activity = getActivity();
		if (activity instanceof DialogControl) {
			return ((DialogControl) activity).showWaitDialog(resid);
		}
		return null;
	}

	@Override
	public void onClick(View v) {
	}

	public boolean onBackPressed() {
		return false;
	}
}
