package com.ihandy.wyreader.view.activity.impl;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.RecyclerView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.ihandy.wyreader.R;
import com.ihandy.wyreader.model.AppUpdateBean;
import com.ihandy.wyreader.utils.AppUpdateUtils;
import com.ihandy.wyreader.view.activity.ISetting;
import com.ihandy.wyreader.view.base.BaseActivity;
import com.ihandy.wyreader.viewmodel.activity.VMSettingInfo;
import com.ihandy.wyreader.widget.MarqueTextView;
import com.ihandy.wyreader.widget.ResideLayout;
import com.ihandy.wyreader.widget.theme.ColorRelativeLayout;
import com.ihandy.wyreader.widget.theme.ColorView;

import butterknife.BindView;

public class MainActivity extends BaseActivity implements ColorChooserDialog.ColorCallback, ISetting {


	@BindView(R.id.iv_avatar)
	ImageView mIvAvatar;
	@BindView(R.id.tv_desc)
	TextView mTvDesc;
	@BindView(R.id.top_menu)
	LinearLayout mTopMenu;
	@BindView(R.id.rv_menu)
	RecyclerView mRvMenu;
	@BindView(R.id.tv_theme)
	TextView mTvTheme;
	@BindView(R.id.tv_setting)
	TextView mTvSetting;
	@BindView(R.id.bottom_menu)
	LinearLayout mBottomMenu;
	@BindView(R.id.menu)
	ColorRelativeLayout mMenu;
	@BindView(R.id.container)
	FrameLayout mContainer;
	@BindView(R.id.resideLayout)
	ResideLayout mResideLayout;
	@BindView(R.id.iv_toolbar_more)
	AppCompatImageView mIvToolBarMore;
	@BindView(R.id.iv_toolbar_back)
	AppCompatImageView mIvToolBarBack;
	@BindView(R.id.tv_toolbar_title)
	TextView mTvToolBarTitle;

	private VMSettingInfo mModel;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		mModel = new VMSettingInfo(this, this);
		setBinddingView(R.layout.activity_main, NO_BINDDING, mModel);
		initThemeToolBar("分类", R.drawable.ic_classify, R.drawable.ic_search, v -> {
			mResideLayout.openPane();
		}, v -> {

		});
		mModel.appUpdate(false);

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
