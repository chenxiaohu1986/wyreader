package com.ihandy.wyreader.view.fragment.impl;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.ihandy.wyreader.R;
import com.ihandy.wyreader.model.BookClassifyBean;
import com.ihandy.wyreader.view.adapter.ClassifyAdapter;
import com.ihandy.wyreader.view.base.BaseFragment;
import com.ihandy.wyreader.view.fragment.IClassifyBook;
import com.ihandy.wyreader.viewmodel.fragment.VMBookClassify;
import com.weavey.loading.lib.LoadingLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

/**
 * Created by cxh on 18/5/23.
 */

public class ClassifyFragment extends BaseFragment implements IClassifyBook {


	@BindView(R.id.rv_classify)
	RecyclerView mRvClassify;
	@BindView(R.id.loadinglayout)
	LoadingLayout mLoadinglayout;

	String tabName;
	ClassifyAdapter mClassifyAdapter;
	private VMBookClassify mModel;
	List<BookClassifyBean.ClassifyBean> mClassifyBeans = new ArrayList<>();
	String getder = "male";

	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		mModel = new VMBookClassify(mContext,this);
		View view = setContentView(container,R.layout.fragment_classify,mModel);
		return view;
	}

	public static ClassifyFragment newInstance(String tabName) {
		ClassifyFragment classifyFragment = new ClassifyFragment();
		Bundle args = new Bundle();
		args.putString("tabName",tabName);
		classifyFragment.setArguments(args);
		return classifyFragment;
	}

	@Override
	public void initView() {
		super.initView();
		tabName = getArguments().getString("tabName");
		mModel.bookClassify();

		mClassifyAdapter = new ClassifyAdapter(mClassifyBeans);
		mRvClassify.setLayoutManager(new LinearLayoutManager(mContext));
		mClassifyAdapter.openLoadAnimation(BaseQuickAdapter.SLIDEIN_LEFT);
		mRvClassify.setAdapter(mClassifyAdapter);

	}

	@Override
	public void getBookClassify(BookClassifyBean bookClassifyBean) {
		mLoadinglayout.setStatus(LoadingLayout.Success);
		mClassifyBeans.clear();
		switch (tabName) {
			case "男生":
				getder = "male";
				mClassifyBeans.addAll(bookClassifyBean.getMale());
				break;
			case "女生":
				getder = "female";
				mClassifyBeans.addAll(bookClassifyBean.getFemale());
				break;
			case "出版":
				getder = "press";
				mClassifyBeans.addAll(bookClassifyBean.getPress());
				break;
		}
		mClassifyAdapter.notifyDataSetChanged();
	}

	@Override
	public void showLoading() {

	}

	@Override
	public void stopLoading() {

	}

	@Override
	public void emptyData() {
		mLoadinglayout.setStatus(LoadingLayout.Empty);
	}

	@Override
	public void errorData(String error) {
		mLoadinglayout.setEmptyText(error).setStatus(LoadingLayout.Error);
	}

	@Override
	public void NetWorkError() {
		mLoadinglayout.setStatus(LoadingLayout.No_Network);
	}


}
