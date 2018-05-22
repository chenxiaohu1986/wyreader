package com.ihandy.wyreader.view.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ihandy.wyreader.viewmodel.BaseViewModel;

import butterknife.ButterKnife;

/**
 * Created by cxh on 18/5/22.
 */

public class BaseFragment extends Fragment {

	protected BaseViewModel mModel;
	protected Context mContext;
	private View mBindView;

	/**
	 * 获得全局的，防止使用getActivity()为空
	 *
	 * @param context
	 */
	@Override
	public void onAttach(Context context) {
		super.onAttach(context);
		mContext = context;
	}

	/**
	 * Databinding设置布局绑定
	 *
	 * @param resId      布局layout
	 * @param brVariavle BR
	 * @param mModel     viewmodel
	 */
	public View setBinddingView(LayoutInflater inflater, ViewGroup container, @LayoutRes int resId, int brVariavle, BaseViewModel mModel) {
		if (mBindView == null){
			ViewDataBinding dataBinding = DataBindingUtil.inflate(inflater,resId,container,false);
			dataBinding.setVariable(brVariavle,mModel);
			mBindView = dataBinding.getRoot();
			ButterKnife.bind(this,mBindView);
			this.mModel = mModel;
		}
		return mBindView;
	}


}
