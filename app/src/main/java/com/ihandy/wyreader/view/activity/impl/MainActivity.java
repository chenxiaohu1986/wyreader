package com.ihandy.wyreader.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.ihandy.wyreader.R;
import com.ihandy.wyreader.model.AppUpdateBean;
import com.ihandy.wyreader.utils.AppUpdateUtils;
import com.ihandy.wyreader.view.activity.ISetting;
import com.ihandy.wyreader.view.base.BaseActivity;

public class MainActivity extends BaseActivity implements ColorChooserDialog.ColorCallback, ISetting {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	}






	@Override
	public void onBackPressed() {
		super.onBackPressed();
	}

	@Override
	public void onColorSelection(@NonNull ColorChooserDialog dialog, int selectedColor) {

	}

	@Override
	public void showLoading() {

	}

	@Override
	public void stopLoading() {

	}

	@Override
	public void appUpdate(AppUpdateBean appUpdateBean) {
		AppUpdateUtils.getInstance().appUpdate(this, appUpdateBean);
	}
}
