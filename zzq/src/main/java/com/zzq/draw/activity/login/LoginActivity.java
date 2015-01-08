package com.zzq.draw.activity.login;

import android.app.Activity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zzq.draw.KeTuKeLeApplication;
import com.zzq.draw.R;

/**
 * Created by chenrg on 2015/1/4.
 */
public class LoginActivity extends Activity implements View.OnClickListener {
    private KeTuKeLeApplication myApplication;
    private EditText _username_editText;
    private EditText _password_editText;
    private Button _login_button;
    private ImageView _clearUsername_ImageView;
    private ImageView _clearPassword_ImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.v2_activity_login);
        _username_editText = (EditText) findViewById(R.id.et_username);
        _password_editText = (EditText) findViewById(R.id.et_password);
        _clearUsername_ImageView = (ImageView) findViewById(R.id.iv_clear_username);
        _clearPassword_ImageView = (ImageView) findViewById(R.id.iv_clear_password);
        _login_button = (Button) findViewById(R.id.btn_login);

        _username_editText.addTextChangedListener(textWatcher);
        _password_editText.addTextChangedListener(textWatcher1);
        _clearUsername_ImageView.setOnClickListener(this);
        _clearPassword_ImageView.setOnClickListener(this);
        _login_button.setOnClickListener(this);
        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.iv_clear_username) {//点击清除用户名图标
            _username_editText.setText("");
            _clearUsername_ImageView.setVisibility(View.GONE);
        } else if (v.getId() == R.id.iv_clear_password) {//点击清除密码图标
            _password_editText.setText("");
            _clearPassword_ImageView.setVisibility(View.GONE);
        }else if(v.getId() == R.id.btn_login){//点击登录按钮
            myApplication = (KeTuKeLeApplication)getApplication();
            String user_name = _username_editText.getText()+"";
            String password = _password_editText.getText()+"";
            if(TextUtils.isEmpty(user_name)){
                myApplication.showToastShort(R.string.tip_please_input_username);
                _username_editText.setFocusable(true);
            }else if(TextUtils.isEmpty(password)){
                myApplication.showToastShort(R.string.tip_please_input_password);
                _password_editText.setFocusable(true);
            }else{
                myApplication.user_name = user_name;
                myApplication.setIsLogin(true);
                Toast.makeText(this,"登录成功!", Toast.LENGTH_LONG).show();
                finish();
            }
        }
    }

    private TextWatcher textWatcher = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String user_name = _username_editText.getText()+"";
            if(!TextUtils.isEmpty(user_name)){
                _clearUsername_ImageView.setVisibility(View.VISIBLE);
            }else{
                _clearUsername_ImageView.setVisibility(View.GONE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private TextWatcher textWatcher1 = new TextWatcher() {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String password = _password_editText.getText()+"";
            if(!TextUtils.isEmpty(password)){
                _clearPassword_ImageView.setVisibility(View.VISIBLE);
            }else{
                _clearPassword_ImageView.setVisibility(View.GONE);
            }
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };
}