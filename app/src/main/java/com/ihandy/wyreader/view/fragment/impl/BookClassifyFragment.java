package com.ihandy.wyreader.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.gigamole.navigationtabstrip.NavigationTabStrip;
import com.ihandy.wyreader.R;
import com.ihandy.wyreader.view.base.BaseFragment;
import com.ihandy.wyreader.viewmodel.BaseViewModel;

import butterknife.BindView;

/**
 * Created by cxh on 18/5/22.
 */

public class BookClassifyFragment extends BaseFragment {

	@BindView(R.id.nts_classify)
	NavigationTabStrip mNtsClassify;
	@BindView(R.id.vp_classify)
	ViewPager mVpClassify;



	String[] titles = {"男生", "女生", "出版"};

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		View view = setContentView(container, R.layout.fragment_book_classify,new BaseViewModel(mContext));
		return view;
	}

	public static BookClassifyFragment newInstance(){
		BookClassifyFragment fragment = new BookClassifyFragment();
		return fragment;
	}

	@Override
	public void initView() {
		super.initView();

	}
}
