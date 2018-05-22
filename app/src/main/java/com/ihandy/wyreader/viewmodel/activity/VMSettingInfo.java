package com.ihandy.wyreader.viewmodel.activity;

import android.content.Context;
import android.util.Log;

import com.allen.library.RxHttpUtils;
import com.allen.library.interceptor.Transformer;
import com.ihandy.wyreader.WYApplication;
import com.ihandy.wyreader.api.UserService;
import com.ihandy.wyreader.model.AppUpdateBean;
import com.ihandy.wyreader.utils.ToastUtils;
import com.ihandy.wyreader.utils.rxhelper.RxObserver;
import com.ihandy.wyreader.view.activity.ISetting;
import com.ihandy.wyreader.viewmodel.BaseViewModel;

/**
 * Created by cxh on 18/5/16.
 */

public class VMSettingInfo extends BaseViewModel {

	private ISetting mISetting;


	public VMSettingInfo(Context mContext, ISetting iSetting) {
		super(mContext);
		mISetting = iSetting;
	}

	public void appUpdate(boolean isTip){
		mISetting.showLoading();
		RxHttpUtils.getSInstance().addHeaders(tokenMap()).createSApi(UserService.class)
				.appUpdate()
				.compose(Transformer.switchSchedulers())
				.subscribe(new RxObserver<AppUpdateBean>() {
					@Override
					protected void onError(String errorMsg) {
						mISetting.stopLoading();
					}

					@Override
					protected void onSuccess(AppUpdateBean data) {
						mISetting.stopLoading();
						if (WYApplication.packageInfo.versionCode < data.getVersioncode()){
							mISetting.appUpdate(data);
						} else {
							if (isTip){
								ToastUtils.show("当前是最新版本");
							}
						}
					}
				});
	}
}
