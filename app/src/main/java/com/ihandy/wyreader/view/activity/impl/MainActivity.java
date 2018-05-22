package com.ihandy.wyreader.view.activity.impl;

import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.afollestad.materialdialogs.color.ColorChooserDialog;
import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ihandy.wyreader.R;
import com.ihandy.wyreader.model.AppUpdateBean;
import com.ihandy.wyreader.model.MainMenuBean;
import com.ihandy.wyreader.utils.AppUpdateUtils;
import com.ihandy.wyreader.utils.BaseUtils;
import com.ihandy.wyreader.view.activity.ISetting;
import com.ihandy.wyreader.view.adapter.MainMenuAdapter;
import com.ihandy.wyreader.view.base.BaseActivity;
import com.ihandy.wyreader.viewmodel.activity.VMSettingInfo;
import com.ihandy.wyreader.widget.MarqueTextView;
import com.ihandy.wyreader.widget.ResideLayout;
import com.ihandy.wyreader.widget.theme.ColorRelativeLayout;
import com.ihandy.wyreader.widget.theme.ColorView;

import java.util.ArrayList;
import java.util.List;

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
	private MainMenuAdapter mainMenuAdapter;

	private FragmentManager fragmentManager;
	private String currentFragmentTag;
	private List<MainMenuBean> menuBeans = new ArrayList<>();


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

		fragmentManager = getSupportFragmentManager();
		initMenu();


	}

	private void initMenu() {
		mTvDesc.setSelected(true);
		BaseUtils.setIconDrawable(mTvSetting, R.drawable.ic_setting);
		BaseUtils.setIconDrawable(mTvTheme, R.drawable.ic_theme);

		getMenuData();
		mRvMenu.setLayoutManager(new LinearLayoutManager(mContext));
		mainMenuAdapter = new MainMenuAdapter(menuBeans);
		mRvMenu.setAdapter(mainMenuAdapter);
		mainMenuAdapter.setOnItemClickListener((adapter,view,position)->{
			String name = menuBeans.get(position).getName();
			switch (name) {
				case "扫描书籍":
					break;
				case "分类":
					switchFragment(name);
					mTvToolBarTitle.setText(name);
					mIvToolBarBack.setImageResource(menuBeans.get(position).getIcon());
					mResideLayout.closePane();
			}

		});


	}

	private List<MainMenuBean> getMenuData() {
		menuBeans.clear();
		String[] menuName = getResources().getStringArray(R.array.main_menu_name);
		TypedArray menuIcon	= getResources().obtainTypedArray(R.array.main_menu_icon);

		for (int i = 0; i < menuName.length; i++) {
			MainMenuBean menuBean = new MainMenuBean();
			menuBean.setName(menuName[i]);
			menuBean.setIcon(menuIcon.getResourceId(i, 0));
			menuBeans.add(menuBean);
		}

		return menuBeans;
	}

	public void switchFragment(String name) {
		if (currentFragmentTag != null && currentFragmentTag.equals(name)){
			return;
		}

		FragmentTransaction ft = fragmentManager.beginTransaction();
		ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
		Fragment currentFragment = fragmentManager.findFragmentByTag(currentFragmentTag);
		if (currentFragment != null){
			ft.hide(currentFragment);
		}

		Fragment foundFragment = fragmentManager.findFragmentByTag(name);

		if (foundFragment == null){
			switch (name){
				case "分类":

					break;
				default:
					break;
			}
		}

		if (foundFragment == null){

		} else if (foundFragment.isAdded()){
			ft.show(foundFragment);
		} else {
			ft.add(R.id.container,foundFragment,name);
		}
		ft.commit();
		currentFragmentTag = name;
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
