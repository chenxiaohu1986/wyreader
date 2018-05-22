package com.ihandy.wyreader.viewmodel.activity;

import android.content.Context;

import com.allen.library.RxHttpUtils;
import com.allen.library.interceptor.Transformer;
import com.ihandy.wyreader.api.UserService;
import com.ihandy.wyreader.db.entity.UserBean;
import com.ihandy.wyreader.db.helper.UserHelper;
import com.ihandy.wyreader.utils.SharedPreUtils;
import com.ihandy.wyreader.utils.ToastUtils;
import com.ihandy.wyreader.utils.rxhelper.RxObserver;
import com.ihandy.wyreader.view.base.BaseActivity;
import com.ihandy.wyreader.viewmodel.BaseViewModel;

/**
 * Created by cxh on 18/5/21.
 */

public class VMUserLoginInfo extends BaseViewModel {

	public VMUserLoginInfo(Context mContext) {
		super(mContext);
	}

	public void login(String username, String password) {
		RxHttpUtils.getSInstance().addHeaders(tokenMap())
				.createSApi(UserService.class)
				.login(username,password)
				.compose(Transformer.switchSchedulers())
				.subscribe(new RxObserver<UserBean>() {
					@Override
					protected void onError(String errorMsg) {

					}

					@Override
					protected void onSuccess(UserBean userBean) {
						ToastUtils.show("登录成功");
						UserHelper.getsInstance().saveUser(userBean);
						SharedPreUtils.getInstance().putString("token", userBean.getToken());
						SharedPreUtils.getInstance().putString("username", userBean.name);
						((BaseActivity)mContext).finish();
					}
				});

	}


}
