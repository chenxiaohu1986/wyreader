package com.ihandy.wyreader.view.base;

import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.v4.app.Fragment;

import com.ihandy.wyreader.viewmodel.BaseViewModel;

/**
 * Created by cxh on 18/5/22.
 */

public class BaseFragment extends Fragment {


	protected Context mContext;


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
	 * @param brVariavle BR或者不用绑定
	 * @param mModel     viewmodel
	 */
	public void setBinddingView(@LayoutRes int resId, int brVariavle, BaseViewModel mModel) {

	}


}
