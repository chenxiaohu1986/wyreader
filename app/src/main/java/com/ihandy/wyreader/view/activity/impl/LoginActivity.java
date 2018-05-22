package com.ihandy.wyreader.view.activity.impl;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.text.TextUtils;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;

import com.allen.library.RxHttpUtils;
import com.ihandy.wyreader.R;
import com.ihandy.wyreader.api.UserService;
import com.ihandy.wyreader.utils.ToastUtils;
import com.ihandy.wyreader.view.base.BaseActivity;
import com.ihandy.wyreader.viewmodel.activity.VMUserLoginInfo;
import com.ihandy.wyreader.widget.theme.ColorTextView;

import butterknife.BindView;
import butterknife.OnClick;

/**
 * Created by cxh on 18/5/16.
 */

public class LoginActivity extends BaseActivity {

	@BindView(R.id.actv_username)
	AutoCompleteTextView mActvUsername;
	@BindView(R.id.et_password)
	EditText mEtPassword;
	@BindView(R.id.ctv_register)
	ColorTextView mCtvRegister;
	@BindView(R.id.fab)
	FloatingActionButton mFab;
	private VMUserLoginInfo mModel;

	@Override
	public void onCreate(@Nullable Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mModel = new VMUserLoginInfo(this);
		setBinddingView(R.layout.activity_login,NO_BINDDING,mModel);

	}

	@Override
	protected void initView() {
		super.initView();
		initThemeToolBar("用户登录");
	}

	@OnClick({R.id.ctv_register, R.id.fab})
	public void onViewClicked(View view){
		switch (view.getId()){
			case R.id.ctv_register:

				break;
			case R.id.fab:
				String username = mActvUsername.getText().toString();
				String password = mEtPassword.getText().toString();
				if (TextUtils.isEmpty(username)) {
					ToastUtils.show("用户名不能为空");
					return;
				}
				if (TextUtils.isEmpty(password)) {
					ToastUtils.show("密码不能为空");
					return;
				}
				mModel.login(username, password);
				break;
		}
	}


}
